package br.com.javaspeed.telas;

import br.com.javaspeed.classes.Cliente;
import br.com.javaspeed.classes.Moto;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class TelaMotos extends javax.swing.JInternalFrame {

    public ArrayList<Moto> motos = new ArrayList<>();
    public ArrayList<Cliente> clientes = new ArrayList<>();
    
    private Cliente proprietario;
        
    private String coluna[] = {"Moto", "Proprietario"};
    private DefaultTableModel modeloTabela = new DefaultTableModel(coluna, 0);

    public TelaMotos(ArrayList<Moto> motos, ArrayList<Cliente> clientes) {
        this.motos = motos;
        this.clientes = clientes;
        
        initComponents();

        ((DefaultTableCellRenderer) tblMotos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        tblMotos.setModel(modeloTabela);

        TableColumnModel modeloColuna = tblMotos.getColumnModel();
        modeloColuna.getColumn(0).setPreferredWidth(100);
        modeloColuna.getColumn(1).setPreferredWidth(180);
        tblMotos.setRowHeight(20);

        atualizarTabela();
    }

    public void atualizarTabela() {
        modeloTabela.setRowCount(0);

        for (int i = 0; i < motos.size(); i++) {
            String moto = motos.get(i).modelo;
            String proprietario = motos.get(i).proprietario.nome;

            Object[] data = {moto, proprietario};

            modeloTabela.addRow(data);
            
            System.out.println(motos.get(i).imagem);
        }
        txtMotoId.setText(null);
        txtMotoModelo.setText(null);
        txtMotoTipo.setText(null);
        txtMotoAno.setText(null);
        txtMotoCilindrada.setText(null);
        txtMotoCilindros.setText(null);
        txtMotoCombustivel.setText(null);
        txtMotoPreco.setText(null);
        txtMotoProprietario.setText(null);
        txtMotoImagem.setIcon(null);

    }

    public void setarCampos() {
        int index = tblMotos.getSelectedRow();
        txtMotoId.setText(Integer.toString(index));
        txtMotoModelo.setText(motos.get(index).modelo);
        txtMotoTipo.setText(motos.get(index).tipo);
        txtMotoAno.setText(Integer.toString(motos.get(index).ano));
        txtMotoCilindrada.setText(Float.toString(motos.get(index).cilindrada));
        txtMotoCilindros.setText(Integer.toString(motos.get(index).cilindros));
        txtMotoCombustivel.setText(Float.toString(motos.get(index).capCombustivel));
        txtMotoPreco.setText(Float.toString(motos.get(index).precoDia));
        setarImagem(motos.get(index).imagem);
        txtMotoProprietario.setText(motos.get(index).proprietario.nome);

    }

    public void setarImagem(String imagem) {
        txtMotoImagem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(imagem)).getImage().getScaledInstance(350, 220, Image.SCALE_DEFAULT)));
    }

    //CRUD
    public void adicionarMoto() {
        clientes.forEach((n) ->{
            if(n.nome.equals(txtMotoProprietario.getText())){
                proprietario = n;
            }
        });
        
        txtMotoId.getText();
        String modelo = txtMotoModelo.getText();
        String tipo = txtMotoTipo.getText();
        String imagem = "/br/com/javaspeed/icones/" + txtMotoModelo.getText() + ".jpg";
        int    ano = Integer.parseInt(txtMotoAno.getText());
        int    cilindros = Integer.parseInt(txtMotoCilindros.getText());
        float  cilindrada = Float.parseFloat(txtMotoCilindrada.getText());
        float  combustivel = Float.parseFloat(txtMotoCombustivel.getText());
        float  preco = Float.parseFloat(txtMotoPreco.getText());
        txtMotoProprietario.getText();
        
        motos.add(new Moto(tipo, modelo, ano, cilindros, cilindrada, combustivel, preco, imagem, proprietario));
        
        atualizarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMotos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMotoModelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMotoTipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMotoAno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMotoCilindrada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMotoCilindros = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMotoCombustivel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMotoPreco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMotoProprietario = new javax.swing.JTextField();
        txtMotoImagem = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMotoId = new javax.swing.JTextField();
        btnMotoAdd = new javax.swing.JButton();
        btnMotoEdit = new javax.swing.JButton();
        btnMotoSearch = new javax.swing.JButton();
        btnMotoDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Motos");
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 500));

        tblMotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Título 1", "Título 2"
            }
        ));
        tblMotos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMotosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMotos);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Modelo");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Tipo");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Ano");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Cilindrada");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Cilindros");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Combustível");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Preço por dia");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Proprietário");

        txtMotoImagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("ID");

        btnMotoAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/add.png"))); // NOI18N
        btnMotoAdd.setToolTipText("Adicionar");
        btnMotoAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMotoAdd.setMaximumSize(new java.awt.Dimension(75, 75));
        btnMotoAdd.setMinimumSize(new java.awt.Dimension(75, 75));
        btnMotoAdd.setPreferredSize(new java.awt.Dimension(75, 75));
        btnMotoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotoAddActionPerformed(evt);
            }
        });

        btnMotoEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/edit.png"))); // NOI18N
        btnMotoEdit.setToolTipText("Editar");
        btnMotoEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMotoEdit.setMaximumSize(new java.awt.Dimension(75, 75));
        btnMotoEdit.setMinimumSize(new java.awt.Dimension(75, 75));
        btnMotoEdit.setPreferredSize(new java.awt.Dimension(75, 75));
        btnMotoEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotoEditActionPerformed(evt);
            }
        });

        btnMotoSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/search.png"))); // NOI18N
        btnMotoSearch.setToolTipText("Procurar");
        btnMotoSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMotoSearch.setMaximumSize(new java.awt.Dimension(75, 75));
        btnMotoSearch.setMinimumSize(new java.awt.Dimension(75, 75));
        btnMotoSearch.setPreferredSize(new java.awt.Dimension(75, 75));
        btnMotoSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotoSearchActionPerformed(evt);
            }
        });

        btnMotoDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/delete.png"))); // NOI18N
        btnMotoDelete.setToolTipText("Excluir");
        btnMotoDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMotoDelete.setMaximumSize(new java.awt.Dimension(75, 75));
        btnMotoDelete.setMinimumSize(new java.awt.Dimension(75, 75));
        btnMotoDelete.setPreferredSize(new java.awt.Dimension(75, 75));
        btnMotoDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotoDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMotoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMotoId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtMotoProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMotoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMotoAno)
                    .addComponent(txtMotoCilindrada)
                    .addComponent(txtMotoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtMotoCilindros, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMotoCombustivel)
                            .addComponent(txtMotoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMotoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnMotoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMotoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnMotoDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMotoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtMotoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtMotoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtMotoProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMotoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(txtMotoCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMotoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(txtMotoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMotoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMotoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMotoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMotoDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMotoCilindrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMotoCilindros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMotosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMotosMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblMotosMouseClicked

    private void btnMotoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotoAddActionPerformed
        adicionarMoto();
    }//GEN-LAST:event_btnMotoAddActionPerformed

    private void btnMotoEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotoEditActionPerformed

    }//GEN-LAST:event_btnMotoEditActionPerformed

    private void btnMotoSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotoSearchActionPerformed

    }//GEN-LAST:event_btnMotoSearchActionPerformed

    private void btnMotoDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotoDeleteActionPerformed

    }//GEN-LAST:event_btnMotoDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMotoAdd;
    private javax.swing.JButton btnMotoDelete;
    private javax.swing.JButton btnMotoEdit;
    private javax.swing.JButton btnMotoSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMotos;
    private javax.swing.JTextField txtMotoAno;
    private javax.swing.JTextField txtMotoCilindrada;
    private javax.swing.JTextField txtMotoCilindros;
    private javax.swing.JTextField txtMotoCombustivel;
    private javax.swing.JTextField txtMotoId;
    private javax.swing.JLabel txtMotoImagem;
    private javax.swing.JTextField txtMotoModelo;
    private javax.swing.JTextField txtMotoPreco;
    private javax.swing.JTextField txtMotoProprietario;
    private javax.swing.JTextField txtMotoTipo;
    // End of variables declaration//GEN-END:variables

//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(new File("/br/com/javaspeed/icones/zx10.jpg"));
//        } catch (IOException e) {
//        }
//
//        Image dimg = img.getScaledInstance(txtMotoImagem.getWidth(), txtMotoImagem.getHeight(), Image.SCALE_SMOOTH);
//        
//        ImageIcon imageIcon = new ImageIcon(dimg);
//        
//        txtMotoImagem.setIcon(imageIcon);
//        try {
//            URL url = new URL("https://img.olx.com.br/images/15/154811099907584.jpg");
//            image = ImageIO.read(url.openStream());
//            System.out.println(image);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
}

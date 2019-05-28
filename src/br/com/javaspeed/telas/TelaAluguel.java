package br.com.javaspeed.telas;

import br.com.javaspeed.classes.Cliente;
import br.com.javaspeed.classes.Moto;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TelaAluguel extends javax.swing.JInternalFrame {

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Moto> motos = new ArrayList<>();

    private String headerMotos[] = {"Moto", "Proprietário", "Dias"};
    private DefaultTableModel tabelaMotos = new DefaultTableModel(headerMotos, 0);

    private String headerClientes[] = {"Id", "Nome"};
    private DefaultTableModel tabelaClientes = new DefaultTableModel(headerClientes, 0);

    public TelaAluguel(ArrayList<Moto> motos, ArrayList<Cliente> clientes) {
        this.clientes = clientes;
        this.motos = motos;

        initComponents();

        ((DefaultTableCellRenderer) tblMotos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        tblMotos.setModel(tabelaMotos);

        ((DefaultTableCellRenderer) tblClientes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        tblClientes.setModel(tabelaClientes);

        TableColumnModel tblModeloClientes = tblClientes.getColumnModel();
        tblModeloClientes.getColumn(0).setPreferredWidth(30);
        tblModeloClientes.getColumn(1).setPreferredWidth(270);
        tblClientes.setRowHeight(20);

        TableColumnModel tblModeloMotos = tblMotos.getColumnModel();
        tblModeloMotos.getColumn(0).setPreferredWidth(70);
        tblModeloMotos.getColumn(1).setPreferredWidth(180);
        tblModeloMotos.getColumn(2).setPreferredWidth(50);
        tblClientes.setRowHeight(20);

        atualizarTabelas();

    }

    public void atualizarTabelas() {
        tabelaClientes.setRowCount(0);
        tabelaMotos.setRowCount(0);

        for (int i = 0; i < clientes.size(); i++) {
            String id = Integer.toString(i);
            String nome = clientes.get(i).nome;

            Object[] data = {id, nome};

            tabelaClientes.addRow(data);
        }

        for (int i = 0; i < motos.size(); i++) {
            String moto = motos.get(i).modelo;
            String proprietario;
            int dias = motos.get(i).getAluguel();

            if (motos.get(i).proprietario != null) {
                proprietario = motos.get(i).proprietario.nome;
            } else {
                proprietario = "Sem proprietario";
                dias = 0;
            }

            Object[] data = {moto, proprietario, dias};

            tabelaMotos.addRow(data);
        }

        txtClienteId.setText(null);
        txtClienteNome.setText(null);
        txtClienteTempo.setText(null);
        txtMotoId.setText(null);
        txtMotoAlugar.setText(null);
        txtMotoRetirar.setText(null);
    }

    public void setarCampoCliente() {
        int index = tblClientes.getSelectedRow();
        txtClienteNome.setText(clientes.get(index).nome);
        txtClienteId.setText(Integer.toString(index));
    }

    public void setarCampoMoto() {
        int index = tblMotos.getSelectedRow();
        txtMotoAlugar.setText(motos.get(index).modelo);
        txtMotoRetirar.setText(motos.get(index).modelo);
        txtMotoId.setText(Integer.toString(index));
    }

    public void alugar() {
        int idMoto = Integer.parseInt(txtMotoId.getText());
        int idCliente = Integer.parseInt(txtClienteId.getText());
        int tempoAluguel = Integer.parseInt(txtClienteTempo.getText());

        motos.get(idMoto).proprietario = clientes.get(idCliente);
        if(tempoAluguel <= 0) tempoAluguel = 1;
        
        motos.get(idMoto).alterarAluguel(tempoAluguel);

        atualizarTabelas();

        JOptionPane.showMessageDialog(null, "Aluguel realizado com sucesso");
    }

    public void retirarAluguel() {
        int opcao = JOptionPane.showConfirmDialog(null, "Retirar Aluguel?", "Aluguel", JOptionPane.YES_NO_OPTION);

        if (opcao == 0) {
            int idMoto = Integer.parseInt(txtMotoId.getText());

            if (motos.get(idMoto).proprietario != null) {

                clientes.forEach((cliente) -> {
                    if (cliente.nome.equals(motos.get(idMoto).proprietario.nome)) {
                        motos.get(idMoto).alterarAluguel();;
                    }
                });
                motos.get(idMoto).proprietario = null;
                atualizarTabelas();

                JOptionPane.showMessageDialog(null, "Aluguel retirado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Moto já está sem proprietário");
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMotos = new javax.swing.JTable();
        txtClienteNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtClienteTempo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAlugar = new javax.swing.JButton();
        txtMotoAlugar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMotoRetirar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtClienteId = new javax.swing.JTextField();
        txtMotoId = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Aluguel de Motos");
        setPreferredSize(new java.awt.Dimension(800, 500));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameDeiconified(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        tblMotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        jScrollPane2.setViewportView(tblMotos);

        txtClienteNome.setFocusable(false);

        jLabel1.setText("Alugar");

        jLabel2.setText("Dias");

        btnAlugar.setText("Alugar");
        btnAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarActionPerformed(evt);
            }
        });

        txtMotoAlugar.setFocusable(false);

        jLabel3.setText("por");

        txtMotoRetirar.setFocusable(false);

        jButton2.setText("Retirar aluguel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14)
                        .addComponent(txtMotoId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMotoAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtClienteTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlugar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtMotoRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtClienteTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtMotoAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnAlugar)
                    .addComponent(txtClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMotoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMotoRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        setBounds(0, 0, 800, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarActionPerformed
        alugar();
    }//GEN-LAST:event_btnAlugarActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        setarCampoCliente();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void tblMotosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMotosMouseClicked
        setarCampoMoto();
    }//GEN-LAST:event_tblMotosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        retirarAluguel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
        atualizarTabelas();
    }//GEN-LAST:event_formInternalFrameDeiconified


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlugar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblMotos;
    private javax.swing.JTextField txtClienteId;
    private javax.swing.JTextField txtClienteNome;
    private javax.swing.JTextField txtClienteTempo;
    private javax.swing.JTextField txtMotoAlugar;
    private javax.swing.JTextField txtMotoId;
    private javax.swing.JTextField txtMotoRetirar;
    // End of variables declaration//GEN-END:variables
}

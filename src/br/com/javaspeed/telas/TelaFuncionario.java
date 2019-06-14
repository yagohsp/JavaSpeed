package br.com.javaspeed.telas;

import br.com.javaspeed.classes.Funcionario;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class TelaFuncionario extends javax.swing.JInternalFrame {

    ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private int funcionarioExistente = 0;

    String coluna[] = {"Id", "Nome"};
    DefaultTableModel modeloTabela = new DefaultTableModel(coluna, 0);

    public TelaFuncionario(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;

        initComponents();
        JTableHeader Theader = tblClientes.getTableHeader();
        ((DefaultTableCellRenderer) Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        TableColumnModel columnModel = tblClientes.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(170);
        tblClientes.setRowHeight(20);
    }

    public void atualizarTabela() {
        modeloTabela.setRowCount(0);

        for (int i = 0; i < funcionarios.size(); i++) {
            String id = Integer.toString(i);
            String nome = funcionarios.get(i).nome;

            Object[] data = {id, nome};

            modeloTabela.addRow(data);
        }
        txtFunId.setText(null);
        txtFunNome.setText(null);
        txtFunCpf.setText(null);
        txtFunData.setText(null);
        txtFunTelefone.setText(null);
        txtFunEndereco.setText(null);
        txtFunUsuario.setText(null);
        txtFunSenha.setText(null);
    }

    public void setarCampos() {
        int index = tblClientes.getSelectedRow();
        txtFunId.setText(Integer.toString(index));
        txtFunNome.setText(funcionarios.get(index).nome);
        txtFunCpf.setText(funcionarios.get(index).cpf);
        txtFunData.setText(funcionarios.get(index).dataContratacao);
        txtFunTelefone.setText(funcionarios.get(index).telefone);
        txtFunEndereco.setText(funcionarios.get(index).endereco);
        txtFunUsuario.setText(funcionarios.get(index).getUsuario());
        txtFunSenha.setText(funcionarios.get(index).getSenha());

        if (funcionarios.get(index).getPerfil().equals("Gestor")) {
            btnFunGestor.setSelected(true);
        } else {
            btnFunFuncionario.setSelected(true);
        }

        funcionarios.get(index).dados();
    }

    //CRUD
    public void adicionarFuncionario() {
        funcionarios.forEach((Funcionario funcionario) -> {
            if (funcionario.cpf.equals(txtFunCpf.getText())) {
                funcionarioExistente = 1;
            }
        });
        if (funcionarioExistente == 1) {
            JOptionPane.showMessageDialog(null, "Funcionario já existente");
            funcionarioExistente = 0;
        } else {
            String usuario = txtFunUsuario.getText();
            String senha = txtFunSenha.getText();
            String nome = txtFunNome.getText();
            String cpf = txtFunCpf.getText();
            String endereco = txtFunEndereco.getText();
            String telefone = txtFunTelefone.getText();
            String data = txtFunData.getText();

            if (btnFunGestor.isSelected()) {
                funcionarios.add(new Funcionario(usuario, senha, nome, cpf, endereco, telefone, data, "Gestor"));
            } else {
                funcionarios.add(new Funcionario(usuario, senha, nome, cpf, endereco, telefone, data, "Funcionario"));
            }
            JOptionPane.showMessageDialog(null, "Funcionario adicionado com sucesso");
        }

        atualizarTabela();
    }

    public void editarFuncionario() {
        int id = Integer.parseInt(txtFunId.getText());
        String usuario = txtFunUsuario.getText();
        String senha = txtFunSenha.getText();
        String nome = txtFunNome.getText();
        String cpf = txtFunCpf.getText();
        String endereco = txtFunEndereco.getText();
        String telefone = txtFunTelefone.getText();
        String data = txtFunData.getText();

        if (btnFunGestor.isSelected()) {
            Funcionario editFuncionario = new Funcionario(usuario, senha, nome, cpf, endereco, telefone, data, "Gestor");

            funcionarios.set(id, editFuncionario);

            JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso");
        } else {
            Funcionario editFuncionario = new Funcionario(usuario, senha, nome, cpf, endereco, telefone, data, "Funcionario");

            funcionarios.set(id, editFuncionario);

            JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso");
        }
        atualizarTabela();
    }

    public void removerFuncionario() {
        funcionarios.remove(Integer.parseInt(txtFunId.getText()));

        atualizarTabela();
        JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso");
    }

    public void buscarFuncionario() {
        Funcionario index = funcionarios.get(Integer.parseInt(txtFunId.getText()));
        txtFunNome.setText(index.nome);
        txtFunCpf.setText(index.cpf);
        txtFunData.setText(index.dataContratacao);
        txtFunTelefone.setText(index.telefone);
        txtFunEndereco.setText(index.endereco);
        txtFunUsuario.setText(index.getUsuario());
        txtFunSenha.setText(index.getSenha());
        if (index.getPerfil().equals("Gestor")) {
            btnFunGestor.setSelected(true);
        } else {
            btnFunFuncionario.setSelected(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel11 = new javax.swing.JLabel();
        txtFunNome = new javax.swing.JTextField();
        txtFunUsuario = new javax.swing.JTextField();
        txtFunTelefone = new javax.swing.JTextField();
        txtFunCpf = new javax.swing.JTextField();
        txtFunEndereco = new javax.swing.JTextField();
        txtFunData = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFunId = new javax.swing.JTextField();
        txtFunSenha = new javax.swing.JTextField();
        btnFunFuncionario = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnAddFuncionario = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnEditFuncionario = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnSearchFuncionario = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnDelFuncionario = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnFunGestor = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Funcionários");
        setPreferredSize(new java.awt.Dimension(800, 480));
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

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Senha");

        txtFunNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtFunUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtFunTelefone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtFunCpf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtFunEndereco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtFunData.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("ID");

        buttonGroup1.add(btnFunFuncionario);
        btnFunFuncionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFunFuncionario.setSelected(true);
        btnFunFuncionario.setText("Funcionario");
        btnFunFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFunFuncionarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Cpf");

        tblClientes.setModel(modeloTabela);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Telefone");

        btnAddFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/add.png"))); // NOI18N
        btnAddFuncionario.setToolTipText("Adicionar");
        btnAddFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddFuncionario.setMaximumSize(new java.awt.Dimension(75, 75));
        btnAddFuncionario.setMinimumSize(new java.awt.Dimension(75, 75));
        btnAddFuncionario.setPreferredSize(new java.awt.Dimension(75, 75));
        btnAddFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFuncionarioActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Endereço");

        btnEditFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/edit.png"))); // NOI18N
        btnEditFuncionario.setToolTipText("Editar");
        btnEditFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditFuncionario.setMaximumSize(new java.awt.Dimension(75, 75));
        btnEditFuncionario.setMinimumSize(new java.awt.Dimension(75, 75));
        btnEditFuncionario.setPreferredSize(new java.awt.Dimension(75, 75));
        btnEditFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditFuncionarioActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Data de contratação");

        btnSearchFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/search.png"))); // NOI18N
        btnSearchFuncionario.setToolTipText("Pesquisar");
        btnSearchFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchFuncionario.setMaximumSize(new java.awt.Dimension(75, 75));
        btnSearchFuncionario.setMinimumSize(new java.awt.Dimension(75, 75));
        btnSearchFuncionario.setPreferredSize(new java.awt.Dimension(75, 75));
        btnSearchFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchFuncionarioActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Usuario");

        btnDelFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/delete.png"))); // NOI18N
        btnDelFuncionario.setToolTipText("Excluir");
        btnDelFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelFuncionario.setMaximumSize(new java.awt.Dimension(75, 75));
        btnDelFuncionario.setMinimumSize(new java.awt.Dimension(75, 75));
        btnDelFuncionario.setPreferredSize(new java.awt.Dimension(75, 75));
        btnDelFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelFuncionarioActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Perfil");

        buttonGroup1.add(btnFunGestor);
        btnFunGestor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFunGestor.setText("Gestor");
        btnFunGestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFunGestorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnEditFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnSearchFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(btnDelFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFunNome)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtFunCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtFunTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel11))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtFunSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                                .addComponent(txtFunUsuario)))
                                        .addComponent(txtFunEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtFunData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)
                                        .addComponent(btnFunGestor)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnFunFuncionario)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(10, 10, 10)
                                .addComponent(txtFunId, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtFunId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFunNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFunCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtFunTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtFunEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtFunUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtFunSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFunData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnFunGestor)
                    .addComponent(btnFunFuncionario))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        setBounds(0, 0, 800, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFunFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunFuncionarioActionPerformed
    }//GEN-LAST:event_btnFunFuncionarioActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnAddFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFuncionarioActionPerformed
        adicionarFuncionario();
    }//GEN-LAST:event_btnAddFuncionarioActionPerformed

    private void btnEditFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditFuncionarioActionPerformed
        editarFuncionario();
    }//GEN-LAST:event_btnEditFuncionarioActionPerformed

    private void btnSearchFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchFuncionarioActionPerformed
        buscarFuncionario();
    }//GEN-LAST:event_btnSearchFuncionarioActionPerformed

    private void btnDelFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelFuncionarioActionPerformed
        removerFuncionario();
    }//GEN-LAST:event_btnDelFuncionarioActionPerformed

    private void btnFunGestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunGestorActionPerformed
    }//GEN-LAST:event_btnFunGestorActionPerformed

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
        atualizarTabela();
    }//GEN-LAST:event_formInternalFrameDeiconified


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFuncionario;
    private javax.swing.JButton btnDelFuncionario;
    private javax.swing.JButton btnEditFuncionario;
    private javax.swing.JRadioButton btnFunFuncionario;
    private javax.swing.JRadioButton btnFunGestor;
    private javax.swing.JButton btnSearchFuncionario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtFunCpf;
    private javax.swing.JTextField txtFunData;
    private javax.swing.JTextField txtFunEndereco;
    private javax.swing.JTextField txtFunId;
    private javax.swing.JTextField txtFunNome;
    private javax.swing.JTextField txtFunSenha;
    private javax.swing.JTextField txtFunTelefone;
    private javax.swing.JTextField txtFunUsuario;
    // End of variables declaration//GEN-END:variables
}

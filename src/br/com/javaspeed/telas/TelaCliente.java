package br.com.javaspeed.telas;

import br.com.javaspeed.classes.Cliente;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class TelaCliente extends javax.swing.JInternalFrame {

    ArrayList<Cliente> clientes = new ArrayList<>();
    private int clienteExistente = 0;

    private String coluna[] = {"Id", "Nome"};
    private DefaultTableModel modeloTabela = new DefaultTableModel(coluna, 0);

    public TelaCliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;

        initComponents();

        ((DefaultTableCellRenderer) tblClientes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        tblClientes.setModel(modeloTabela);

        TableColumnModel modeloColuna = tblClientes.getColumnModel();
        modeloColuna.getColumn(0).setPreferredWidth(30);
        modeloColuna.getColumn(1).setPreferredWidth(170);
        tblClientes.setRowHeight(20);

        atualizarTabela();

    }

    public void atualizarTabela() {
        modeloTabela.setRowCount(0);

        for (int i = 0; i < clientes.size(); i++) {
            String id = Integer.toString(i);
            String nome = clientes.get(i).nome;

            Object[] data = {id, nome};

            modeloTabela.addRow(data);
        }
        txtCliId.setText(null);
        txtCliNome.setText(null);
        txtCliCpf.setText(null);
        txtCliData.setText(null);
        txtCliTempo.setText(null);
        txtCliMoto.setText(null);
        txtCliTelefone.setText(null);
        txtCliEndereco.setText(null);
        txtCliLiga.setText(null);
        txtCliPatrocinador.setText(null);
    }

    public void setarCampos() {
        int index = tblClientes.getSelectedRow();
        txtCliId.setText(Integer.toString(index));
        txtCliNome.setText(clientes.get(index).nome);
        txtCliCpf.setText(clientes.get(index).cpf);
        txtCliData.setText(clientes.get(index).dataCadastro);
        txtCliTempo.setText(Integer.toString(clientes.get(index).getTempoAluguel()));
        txtCliMoto.setText(clientes.get(index).motoPrefencial);
        txtCliTelefone.setText(clientes.get(index).telefone);
        txtCliEndereco.setText(clientes.get(index).endereco);

        if (clientes.get(index).liga != null) {
            txtCliLiga.setEnabled(true);
            txtCliLiga.setText(clientes.get(index).liga);
            txtCliPatrocinador.setEnabled(true);
            txtCliPatrocinador.setText(clientes.get(index).patrocinador);
            btnCliSim.setSelected(true);
        } else {
            txtCliLiga.setEnabled(false);
            txtCliLiga.setText(null);
            txtCliPatrocinador.setEnabled(false);
            txtCliPatrocinador.setText(null);
            btnCliNao.setSelected(true);
        }
    }

    //CRUD
    public void adicionarCliente() {
        clientes.forEach((Cliente cliente) -> {
            if (cliente.cpf.equals(txtCliCpf.getText())) {
                clienteExistente = 1;
            }
        });
        if (clienteExistente == 1) {
            JOptionPane.showMessageDialog(null, "Cliente já existente");
            clienteExistente = 0;
        } else {
            String nome = txtCliNome.getText();
            String cpf = txtCliCpf.getText();
            String endereco = txtCliEndereco.getText();
            String telefone = txtCliTelefone.getText();
            String data = txtCliData.getText();
            String liga = txtCliLiga.getText();
            String patrocinador = txtCliPatrocinador.getText();
            String moto = txtCliMoto.getText();
            int tempo = Integer.parseInt(txtCliTempo.getText());

            if (btnCliSim.isSelected()) {
                clientes.add(new Cliente(nome, cpf, endereco, telefone, data, liga, patrocinador, moto, tempo));
            } else {
                clientes.add(new Cliente(nome, cpf, endereco, telefone, data, moto, tempo));
            }
            JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
        }

        atualizarTabela();
    }

    public void editarCliente() {
        String nome = txtCliNome.getText();
        String cpf = txtCliCpf.getText();
        String endereco = txtCliEndereco.getText();
        String telefone = txtCliTelefone.getText();
        String data = txtCliData.getText();
        String liga = txtCliLiga.getText();
        String patrocinador = txtCliPatrocinador.getText();
        String moto = txtCliMoto.getText();
        int tempo = Integer.parseInt(txtCliTempo.getText());
        int id = Integer.parseInt(txtCliId.getText());

        if (tempo != 0) {
            clientes.get(id).alterarAluguel(tempo);
        } else {
            clientes.get(id).alterarAluguel();
        }
        if (btnCliSim.isSelected()) {
            Cliente editCliente = new Cliente(nome, cpf, endereco, telefone, data, liga, patrocinador, moto, tempo);

            clientes.set(id, editCliente);

            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } else {
            Cliente editCliente = new Cliente(nome, cpf, endereco, telefone, data, moto, tempo);

            clientes.set(id, editCliente);

            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        }
        atualizarTabela();
    }

    public void removerCliente() {
        clientes.remove(Integer.parseInt(txtCliId.getText()));

        atualizarTabela();
        JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
    }

    public void buscarCliente() {
        Cliente index;
        try {
            index = clientes.get(Integer.parseInt(txtCliId.getText()));

            txtCliNome.setText(index.nome);
            txtCliCpf.setText(index.cpf);
            txtCliData.setText(index.dataCadastro);
            txtCliTempo.setText(Integer.toString(index.getTempoAluguel()));
            txtCliMoto.setText(index.motoPrefencial);
            txtCliTelefone.setText(index.telefone);
            txtCliEndereco.setText(index.endereco);

            if (index.liga != null) {
                txtCliLiga.setEnabled(true);
                txtCliLiga.setText(index.liga);
                txtCliPatrocinador.setEnabled(true);
                txtCliPatrocinador.setText(index.patrocinador);
                btnCliSim.setSelected(true);
            } else {
                txtCliLiga.setEnabled(false);
                txtCliLiga.setText(null);
                txtCliPatrocinador.setEnabled(false);
                txtCliPatrocinador.setText(null);
                btnCliNao.setSelected(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente inexistente");
            txtCliId.setText(null);
            txtCliNome.setText(null);
            txtCliCpf.setText(null);
            txtCliData.setText(null);
            txtCliTempo.setText(null);
            txtCliMoto.setText(null);
            txtCliTelefone.setText(null);
            txtCliEndereco.setText(null);
            txtCliLiga.setText(null);
            txtCliPatrocinador.setText(null);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCliSim = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCliNome = new javax.swing.JTextField();
        txtCliTempo = new javax.swing.JTextField();
        txtCliTelefone = new javax.swing.JTextField();
        txtCliCpf = new javax.swing.JTextField();
        txtCliEndereco = new javax.swing.JTextField();
        txtCliData = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCliId = new javax.swing.JTextField();
        txtCliMoto = new javax.swing.JTextField();
        txtCliPatrocinador = new javax.swing.JTextField();
        btnCliNao = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnAddCliente = new javax.swing.JButton();
        btnEditCliente = new javax.swing.JButton();
        btnSearchCliente = new javax.swing.JButton();
        btnDelCliente = new javax.swing.JButton();
        txtCliLiga = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Clientes");
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(800, 500));
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Cpf");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Telefone");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Endereço");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Data de cadastro");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Tempo de aluguel");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Competidor");

        buttonGroup1.add(btnCliSim);
        btnCliSim.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCliSim.setText("Sim");
        btnCliSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliSimActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Liga");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Patrocinador");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Moto preferencial");

        txtCliNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtCliTempo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtCliTelefone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtCliCpf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCliCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliCpfActionPerformed(evt);
            }
        });

        txtCliEndereco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtCliData.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("ID");

        txtCliPatrocinador.setEnabled(false);

        buttonGroup1.add(btnCliNao);
        btnCliNao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCliNao.setSelected(true);
        btnCliNao.setText("Não");
        btnCliNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliNaoActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
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
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        btnAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/add.png"))); // NOI18N
        btnAddCliente.setToolTipText("Adicionar");
        btnAddCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCliente.setMaximumSize(new java.awt.Dimension(75, 75));
        btnAddCliente.setMinimumSize(new java.awt.Dimension(75, 75));
        btnAddCliente.setPreferredSize(new java.awt.Dimension(75, 75));
        btnAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClienteActionPerformed(evt);
            }
        });

        btnEditCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/edit.png"))); // NOI18N
        btnEditCliente.setToolTipText("Editar");
        btnEditCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditCliente.setMaximumSize(new java.awt.Dimension(75, 75));
        btnEditCliente.setMinimumSize(new java.awt.Dimension(75, 75));
        btnEditCliente.setPreferredSize(new java.awt.Dimension(75, 75));
        btnEditCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditClienteActionPerformed(evt);
            }
        });

        btnSearchCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/search.png"))); // NOI18N
        btnSearchCliente.setToolTipText("Procurar");
        btnSearchCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchCliente.setMaximumSize(new java.awt.Dimension(75, 75));
        btnSearchCliente.setMinimumSize(new java.awt.Dimension(75, 75));
        btnSearchCliente.setPreferredSize(new java.awt.Dimension(75, 75));
        btnSearchCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchClienteActionPerformed(evt);
            }
        });

        btnDelCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/delete.png"))); // NOI18N
        btnDelCliente.setToolTipText("Excluir");
        btnDelCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelCliente.setMaximumSize(new java.awt.Dimension(75, 75));
        btnDelCliente.setMinimumSize(new java.awt.Dimension(75, 75));
        btnDelCliente.setPreferredSize(new java.awt.Dimension(75, 75));
        btnDelCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelClienteActionPerformed(evt);
            }
        });

        txtCliLiga.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(10, 10, 10)
                            .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(183, 183, 183))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCliNome)
                                .addComponent(txtCliData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCliTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCliMoto, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                        .addComponent(txtCliTempo)))
                                .addComponent(txtCliEndereco))
                            .addGap(50, 50, 50)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnEditCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnSearchCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnDelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCliPatrocinador, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(txtCliLiga)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCliSim)
                                .addGap(18, 18, 18)
                                .addComponent(btnCliNao)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCliSim)
                            .addComponent(btnCliNao))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCliLiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCliPatrocinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtCliTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtCliEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCliTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtCliMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCliData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        setBounds(0, 0, 800, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void btnCliSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliSimActionPerformed
        txtCliLiga.setEnabled(true);
        txtCliPatrocinador.setEnabled(true);
    }//GEN-LAST:event_btnCliSimActionPerformed

    private void btnCliNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliNaoActionPerformed
        txtCliLiga.setEnabled(false);
        txtCliLiga.setText(null);

        txtCliPatrocinador.setEnabled(false);
        txtCliPatrocinador.setText(null);
    }//GEN-LAST:event_btnCliNaoActionPerformed

    private void btnAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClienteActionPerformed
        adicionarCliente();
    }//GEN-LAST:event_btnAddClienteActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnDelClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelClienteActionPerformed
        removerCliente();
    }//GEN-LAST:event_btnDelClienteActionPerformed

    private void btnEditClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditClienteActionPerformed
        editarCliente();
    }//GEN-LAST:event_btnEditClienteActionPerformed

    private void btnSearchClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchClienteActionPerformed
        buscarCliente();
    }//GEN-LAST:event_btnSearchClienteActionPerformed

    private void txtCliCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliCpfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCliente;
    private javax.swing.JRadioButton btnCliNao;
    private javax.swing.JRadioButton btnCliSim;
    private javax.swing.JButton btnDelCliente;
    private javax.swing.JButton btnEditCliente;
    private javax.swing.JButton btnSearchCliente;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCliCpf;
    private javax.swing.JTextField txtCliData;
    private javax.swing.JTextField txtCliEndereco;
    private javax.swing.JTextField txtCliId;
    private javax.swing.JTextField txtCliLiga;
    private javax.swing.JTextField txtCliMoto;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtCliPatrocinador;
    private javax.swing.JTextField txtCliTelefone;
    private javax.swing.JTextField txtCliTempo;
    // End of variables declaration//GEN-END:variables
}

package br.com.javaspeed.telas;

import br.com.javaspeed.classes.Cliente;
import br.com.javaspeed.classes.Funcionario;
import br.com.javaspeed.classes.Moto;
import br.com.javaspeed.classes.Nomes;
import java.awt.Color;

import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TelaPrincipal extends javax.swing.JFrame implements Nomes {

    private TelaLogin telaLogin;
    private TelaCliente telaCliente;
    private TelaFuncionario telaFuncionario;
    private TelaMotos telaMoto;
    private TelaAluguel telaAluguel;

    ArrayList<Funcionario> funcionarios = new ArrayList<>();
    ArrayList<Moto> motos = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();

    public TelaPrincipal() {
        initComponents();

        dados();
        logar();
        nomes();
        
        telaCliente = new TelaCliente(clientes, motos);
        telaFuncionario = new TelaFuncionario(funcionarios);
        telaMoto = new TelaMotos(motos, clientes);
        telaAluguel = new TelaAluguel(motos, clientes);

        lblLogadoNome1.setText(telaLogin.logado.nome);
        lblLogadoPerfil.setText(telaLogin.logado.getPerfil());

        Date data = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        lblData.setText(dateFormat.format(data));

        if (telaLogin.logado.getPerfil().equals("Gestor")) {
            menuCadFuncionario.setEnabled(true);
        }
    }

    @Override
    public void nomes() {
        System.out.println("Funcionarios:");
        this.funcionarios.forEach((a)-> {
            System.out.println(a.nome);
        });
        System.out.println("\nClientes:");
        this.clientes.forEach((a)-> {
            System.out.println(a.nome);
        });
        System.out.println("\n");
    }

    ;

    public void logar() {
        telaLogin = new TelaLogin(this, true, funcionarios);
        telaLogin.setVisible(true);

        if (telaLogin.login == 1) {
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        painelFuncionario = new javax.swing.JPanel();
        lblLogadoPerfil = new javax.swing.JLabel();
        lblLogadoNome1 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCad = new javax.swing.JMenu();
        menuCadCliente = new javax.swing.JMenuItem();
        menuCadFuncionario = new javax.swing.JMenuItem();
        menuCadMoto = new javax.swing.JMenuItem();
        menuCadAluguel = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuAjuSobre = new javax.swing.JMenuItem();
        menuOpcoes = new javax.swing.JMenu();
        menuOpcSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaSpeed");
        setMinimumSize(new java.awt.Dimension(600, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        desktop.setBackground(new Color(255, 255, 255, 100));
        desktop.setEnabled(false);
        desktop.setOpaque(false);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(desktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        painelFuncionario.setBackground(new Color(255,255,255,100));

        lblLogadoPerfil.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblLogadoPerfil.setText("Perfil");

        lblLogadoNome1.setBackground(new java.awt.Color(255, 255, 255));
        lblLogadoNome1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblLogadoNome1.setText("Nome");

        lblData.setBackground(new Color(0,0,0,0));
        lblData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblData.setText("Data");

        javax.swing.GroupLayout painelFuncionarioLayout = new javax.swing.GroupLayout(painelFuncionario);
        painelFuncionario.setLayout(painelFuncionarioLayout);
        painelFuncionarioLayout.setHorizontalGroup(
            painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncionarioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogadoNome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelFuncionarioLayout.createSequentialGroup()
                        .addGroup(painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblData)
                            .addComponent(lblLogadoPerfil))
                        .addGap(0, 189, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelFuncionarioLayout.setVerticalGroup(
            painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogadoPerfil)
                .addGap(18, 18, 18)
                .addComponent(lblLogadoNome1)
                .addGap(39, 39, 39)
                .addComponent(lblData)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(painelFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/javaspeed/icones/wallpaper.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuCad.setText("Cadastro");

        menuCadCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuCadCliente.setText("Cliente");
        menuCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadClienteActionPerformed(evt);
            }
        });
        menuCad.add(menuCadCliente);

        menuCadFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        menuCadFuncionario.setText("Funcionário");
        menuCadFuncionario.setEnabled(false);
        menuCadFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadFuncionarioActionPerformed(evt);
            }
        });
        menuCad.add(menuCadFuncionario);

        menuCadMoto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        menuCadMoto.setText("Moto");
        menuCadMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadMotoActionPerformed(evt);
            }
        });
        menuCad.add(menuCadMoto);

        menuCadAluguel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuCadAluguel.setText("Aluguel");
        menuCadAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadAluguelActionPerformed(evt);
            }
        });
        menuCad.add(menuCadAluguel);

        jMenuBar1.add(menuCad);

        menuAjuda.setText("Ajuda");

        menuAjuSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuAjuSobre.setText("Sobre");
        menuAjuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAjuSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(menuAjuSobre);

        jMenuBar1.add(menuAjuda);

        menuOpcoes.setText("Opções");

        menuOpcSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menuOpcSair.setText("Sair");
        menuOpcSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcSairActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuOpcSair);

        jMenuBar1.add(menuOpcoes);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuOpcSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuOpcSairActionPerformed

    private void menuAjuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjuSobreActionPerformed
        TelaSobre telaSobre = new TelaSobre();
        telaSobre.setVisible(true);
    }//GEN-LAST:event_menuAjuSobreActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

    private void menuCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadClienteActionPerformed
        telaCliente.setVisible(true);
        desktop.add(telaCliente);
        telaCliente.atualizarTabela();
    }//GEN-LAST:event_menuCadClienteActionPerformed

    private void menuCadMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadMotoActionPerformed
        telaMoto.setVisible(true);
        desktop.add(telaMoto);
        telaMoto.atualizarTabela();
    }//GEN-LAST:event_menuCadMotoActionPerformed

    private void menuCadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadFuncionarioActionPerformed
        telaFuncionario.setVisible(true);
        desktop.add(telaFuncionario);
        telaFuncionario.atualizarTabela();
    }//GEN-LAST:event_menuCadFuncionarioActionPerformed

    private void menuCadAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadAluguelActionPerformed
        telaAluguel.setVisible(true);
        desktop.add(telaAluguel);
        telaAluguel.atualizarTabelas();
    }//GEN-LAST:event_menuCadAluguelActionPerformed

    private void dados() {

        Funcionario yago = new Funcionario("admin", "admin", "Yago Henrique dos Santos", "123.548.120.22", "Presidente Olegario", "997987452", "09/04/2018", "Gestor");
        Funcionario junior = new Funcionario("user", "user", "Junior Amorim Gonçalves", "528.193.042.53", "Patos de Minas", "954723481", "21/09/2018", "Funcionario");
        funcionarios.add(junior);
        funcionarios.add(yago);

        clientes.add(new Cliente("Yago Henrique dos Santos", "123.548.120.22", "Presidente Olegario", "997987452", "09/04/2018", "MotoGP", "RedBull", "ZX10"));
        clientes.add(new Cliente("Junior Amorim Gonçalves", "528.193.042.53", "Patos de Minas", "954723481", "21/09/2018", "600CC SP", "Guaraná", "SS1000RR"));
        clientes.add(new Cliente("João Matias Loredo", "647.249.716.40", "Patos de Minas", "997246128", "14/03/2019", "YZF-R1"));
        clientes.add(new Cliente("Michel Augusto Almeida", "416.746.257.10", "Rio de Janeiro", "994712158", "30/01/2019", "Fat Boy"));

        motos.add(new Moto("Esportiva", "ZX10", 2017, 4, 999, 17, 450, "/br/com/javaspeed/icones/ZX10.jpg", clientes.get(0), 8));
        motos.add(new Moto("Esportiva", "S1000RR", 2016, 4, 999, (float) 17.5, 435, "/br/com/javaspeed/icones/S1000RR.jpg", clientes.get(1), 12));
        motos.add(new Moto("Custom", "Fat Boy", 2018, 2, 1584, 18, 330, "/br/com/javaspeed/icones/Fat Boy.jpg", clientes.get(2), 6));
        motos.add(new Moto("Esportiva", "R1", 2016, 4, 998, 17, 440, "/br/com/javaspeed/icones/R1.jpg", null, 0));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblLogadoNome1;
    private javax.swing.JLabel lblLogadoPerfil;
    private javax.swing.JMenuItem menuAjuSobre;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuCad;
    private javax.swing.JMenuItem menuCadAluguel;
    private javax.swing.JMenuItem menuCadCliente;
    private javax.swing.JMenuItem menuCadFuncionario;
    private javax.swing.JMenuItem menuCadMoto;
    private javax.swing.JMenuItem menuOpcSair;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JPanel painelFuncionario;
    // End of variables declaration//GEN-END:variables
}

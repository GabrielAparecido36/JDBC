package pacote;

import com.sun.org.apache.xml.internal.serializer.utils.MsgKey;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Janela extends javax.swing.JFrame {

    public boolean continua;
    public boolean newRGM;

    public Janela() {
        initComponents();
        listar();
    }

    public Aluno montaAluno() {
        Aluno a = new Aluno();
        a.setRgm(txtRGM.getText());
        a.setNome(txtNome.getText());
        a.setN1(Float.parseFloat(txtNota1.getText()));
        a.setN2(Float.parseFloat(txtNota2.getText()));
        return a;
    }

    public void limpar() {
        txtRGM.setText("");
        txtNome.setText("");
        txtNota1.setText("");
        txtNota2.setText("");
    }

    public void verifica() {
        if (this.txtRGM.getText().isEmpty()) {
            lblMsg.setText("Preencha o campo do RGM!");
            this.txtRGM.grabFocus();
            continua = false;
        } else if (this.txtNome.getText().isEmpty()) {
            lblMsg.setText("Preencha o campo do Nome!");
            this.txtNome.grabFocus();
            continua = false;
        } else if (this.txtNota1.getText().isEmpty()) {
            lblMsg.setText("Preencha o campo da primeira nota!");
            this.txtNota1.grabFocus();
            continua = false;
        } else if (this.txtNota2.getText().isEmpty()) {
            lblMsg.setText("Preencha o campo da segunda nota!");
            this.txtNota2.grabFocus();
            continua = false;
        } else {
            continua = true;
        }
    }

    public void pesquisar() {
        AlunoDAO aDao = new AlunoDAO();
        if (aDao.verificaCadastro(Integer.parseInt(this.txtRGM.getText()))) {
            lblMsg.setText("Não existe um cadastro com esse RGM!");
            txtRGM.grabFocus();
        } else {
            Aluno a;
            a = aDao.selecionarAluno(Integer.parseInt(txtRGM.getText()));
            txtNome.setText(a.getNome());
            txtRGM.setText(a.getRgm());
            txtNota1.setText(String.valueOf(a.getN1()));
            txtNota2.setText(String.valueOf(a.getN2()));
            lblMsg.setText("Busca realizada, informações preenchidas!");
        }
    }

    public void listar() {
        ArrayList<Aluno> lista = new AlunoDAO().selecionarTodos();
        if (lista == null) {
            JOptionPane.showMessageDialog(this, "Não existem cadastros no sistema");
        } else {
            DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
            modelo.setNumRows(0);
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new String[]{
                    lista.get(i).getRgm(),
                    lista.get(i).getNome(),
                    lista.get(i).getN1() + "",
                    lista.get(i).getN2() + ""

                });
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRGM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNota1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNota2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblMsg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnMedia = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnConsultaGeral = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbConsulta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("RGM:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(16, 24, 40, 16);
        getContentPane().add(txtRGM);
        txtRGM.setBounds(57, 20, 310, 24);

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(16, 60, 50, 16);
        getContentPane().add(txtNome);
        txtNome.setBounds(58, 56, 310, 24);

        jLabel3.setText("Nota 1:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(16, 106, 50, 16);
        getContentPane().add(txtNota1);
        txtNota1.setBounds(60, 102, 118, 24);

        jLabel4.setText("Nota 2:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 106, 50, 16);
        getContentPane().add(txtNota2);
        txtNota2.setBounds(250, 100, 118, 24);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Mensagem"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 140, 300, 100);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Comandos"));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnMedia.setText("Média");
        btnMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMediaActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnConsultaGeral.setText("Listar");
        btnConsultaGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaGeralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar)
                    .addComponent(btnMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConsultaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnPesquisar)
                    .addComponent(btnAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnMedia)
                    .addComponent(btnSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultaGeral)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(50, 250, 300, 150);

        tbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RGM", "Nome", "Nota 1", "Nota 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbConsulta.setEditingRow(0);
        tbConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbConsulta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(380, 10, 400, 380);

        setSize(new java.awt.Dimension(803, 452));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        AlunoDAO aDao = new AlunoDAO();
        verifica();
        if (continua) {
            if (aDao.verificaCadastro(Integer.parseInt(this.txtRGM.getText()))) {
                this.lblMsg.setText(aDao.gravarAluno(montaAluno()));
                limpar();
            } else {
                lblMsg.setText("Já existe um cadastro com esse RGM!");
                txtRGM.grabFocus();
            }
        }
        listar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        verifica();
        if (continua) {
            Object[] opcoes = {"Sim", "Não"};
            int n = JOptionPane.showOptionDialog(null, "Deseja alterar o RGM?", "Alteração de Cadastro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes);
            if (n == 0) {
                newRGM = true;
                int novoRgm = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo RGM:"));
                AlunoDAO aDao = new AlunoDAO();
                verifica();
                if (continua) {
                    if (aDao.verificaCadastro(novoRgm)) {
                        this.lblMsg.setText(aDao.alterarAluno(montaAluno(), newRGM, novoRgm));
                        limpar();
                    } else {
                        lblMsg.setText("Já existe um cadastro com esse RGM!");
                        txtRGM.grabFocus();
                    }
                }
            } else {
                AlunoDAO aDao = new AlunoDAO();
                newRGM = false;
                verifica();
                if (continua) {
                    if (aDao.verificaCadastroUpdate(Integer.parseInt(this.txtRGM.getText()))) {
                        this.lblMsg.setText(aDao.alterarAluno(montaAluno(), newRGM, 0));
                        limpar();
                    } else {
                        lblMsg.setText("Já existe um cadastro com esse RGM!");
                        txtRGM.grabFocus();
                    }
                }
            }
        }

        listar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        verifica();
        if (continua) {
            Object[] opcoes = {"Sim", "Não"};
            int n = JOptionPane.showOptionDialog(null, "Deseja DELETAR as informações desse RGM?", "Exclusão de cadastro", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes);
            if (n == 0) {
                AlunoDAO aDao = new AlunoDAO();
                if (aDao.verificaCadastro(Integer.parseInt(this.txtRGM.getText()))) {
                    lblMsg.setText("Não existe um cadastro com esse RGM!");
                    txtRGM.grabFocus();
                } else {
                    this.lblMsg.setText(aDao.deletarAluno(Integer.parseInt(txtRGM.getText())));
                    limpar();
                }
            } else {
                lblMsg.setText("Operação Cancelada!");
            }
        }

        listar();

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMediaActionPerformed
        if (this.txtNota1.getText().isEmpty()) {
            lblMsg.setText("Preencha o campo da primeira nota!");
            this.txtNota1.grabFocus();
        } else if (this.txtNota2.getText().isEmpty()) {
            lblMsg.setText("Preencha o campo da segunda nota!");
            this.txtNota2.grabFocus();
        } else {
            float n1 = Float.parseFloat(txtNota1.getText());
            float n2 = Float.parseFloat(txtNota2.getText());
            lblMsg.setText("A média do aluno é :" + ((n1 + n2) / 2));
        }
    }//GEN-LAST:event_btnMediaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnConsultaGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaGeralActionPerformed

        listar();
    }//GEN-LAST:event_btnConsultaGeralActionPerformed

    private void tbConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbConsultaMouseClicked
        if (tbConsulta.getSelectionModel().isSelectionEmpty()) {
            lblMsg.setText("Nenhum registro selecionado!");
        } else {
            int item = tbConsulta.getSelectionModel().getMinSelectionIndex();
            txtRGM.setText(String.valueOf(tbConsulta.getModel().getValueAt(item, 0)));
            pesquisar();
        }
    }//GEN-LAST:event_tbConsultaMouseClicked

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
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsultaGeral;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnMedia;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JTable tbConsulta;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNota1;
    private javax.swing.JTextField txtNota2;
    private javax.swing.JTextField txtRGM;
    // End of variables declaration//GEN-END:variables
}
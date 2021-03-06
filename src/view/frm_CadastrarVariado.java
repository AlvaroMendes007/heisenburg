/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Produto;
import connection.ConnectionFactory;
import dao.ProdutoDAO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Mendes
 */
public class frm_CadastrarVariado extends javax.swing.JFrame {

    /**
     * Creates new form frm_CadastrarVariado
     */
    
     Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public frm_CadastrarVariado() {
        initComponents();
        combobox();
    }
    
    private void combobox()
    {
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from tb_produto where fk_cd_categoria = 3";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                String name = rs.getString("nm_produto");
              
                cmb_variado.addItem(name);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex);
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

        lbl_logo = new javax.swing.JLabel();
        btn_cadastrarvariado = new javax.swing.JButton();
        cmb_variado = new javax.swing.JComboBox<>();
        btn_menuprincipal = new javax.swing.JButton();
        lbl_nomevariado = new javax.swing.JLabel();
        btn_editarvariado = new javax.swing.JButton();
        lbl_valorvariado = new javax.swing.JLabel();
        btn_removervariado = new javax.swing.JButton();
        txt_nomevariado = new javax.swing.JTextField();
        txt_ID = new javax.swing.JTextField();
        lbl_ID = new javax.swing.JLabel();
        btn_atualizar = new javax.swing.JButton();
        txt_valorVariado = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Variados");
        setUndecorated(true);
        setResizable(false);

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        btn_cadastrarvariado.setText("Cadastrar");
        btn_cadastrarvariado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarvariadoActionPerformed(evt);
            }
        });

        cmb_variado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_variadoActionPerformed(evt);
            }
        });

        btn_menuprincipal.setText("Menu Principal");
        btn_menuprincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuprincipalActionPerformed(evt);
            }
        });

        lbl_nomevariado.setText("Variado:");

        btn_editarvariado.setText("Editar");

        lbl_valorvariado.setText("Valor:");

        btn_removervariado.setText("Remover");

        txt_ID.setEditable(false);
        txt_ID.setText("3");
        txt_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDActionPerformed(evt);
            }
        });

        lbl_ID.setText("ID");

        btn_atualizar.setText("Atualizar");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });

        try {
            txt_valorVariado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nomevariado)
                                    .addComponent(lbl_valorvariado)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_ID)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btn_cadastrarvariado)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_atualizar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_nomevariado, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cmb_variado, javax.swing.GroupLayout.Alignment.TRAILING, 0, 383, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_editarvariado)
                                .addGap(42, 42, 42)
                                .addComponent(btn_removervariado)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbl_logo)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(btn_menuprincipal)
                                .addGap(92, 92, 92))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_valorVariado, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ID))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_variado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_atualizar))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nomevariado)
                            .addComponent(txt_nomevariado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_logo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_valorvariado)
                    .addComponent(txt_valorVariado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cadastrarvariado)
                            .addComponent(btn_editarvariado)
                            .addComponent(btn_removervariado))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_menuprincipal)
                        .addContainerGap())))
        );

        setBounds(600, 200, 728, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarvariadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarvariadoActionPerformed
try{
        Produto p = new Produto();
                    ProdutoDAO dao = new ProdutoDAO();
                    p.setCategoria(Integer.parseInt(txt_ID.getText()));
                     p.setNome(txt_nomevariado.getText());
                     p.setValor(Float.parseFloat(txt_valorVariado.getText()));
                     dao.create(p);    
}
catch(RuntimeException ex)
{
    JOptionPane.showMessageDialog(null, "Sem conex??o!", "Falta de conex??o", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_cadastrarvariadoActionPerformed

    private void btn_menuprincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuprincipalActionPerformed

       this.dispose();
 
    }//GEN-LAST:event_btn_menuprincipalActionPerformed

    private void txt_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDActionPerformed

    private void cmb_variadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_variadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_variadoActionPerformed

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
     cmb_variado.removeAllItems();
     combobox();
    }//GEN-LAST:event_btn_atualizarActionPerformed

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
            java.util.logging.Logger.getLogger(frm_CadastrarVariado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_CadastrarVariado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_CadastrarVariado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_CadastrarVariado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_CadastrarVariado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_cadastrarvariado;
    private javax.swing.JButton btn_editarvariado;
    private javax.swing.JButton btn_menuprincipal;
    private javax.swing.JButton btn_removervariado;
    private javax.swing.JComboBox<String> cmb_variado;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_nomevariado;
    private javax.swing.JLabel lbl_valorvariado;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_nomevariado;
    private javax.swing.JFormattedTextField txt_valorVariado;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Produto;
import com.sun.media.sound.ModelOscillator;
import connection.ConnectionFactory;
import dao.ProdutoDAO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Mendes
 */
public class frm_CadastrarLanche extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public frm_CadastrarLanche() {
   initComponents();
    //combobox();
     //this.setFocusableWindowState(true);
    }
    
    private void combobox()
    {
        try {
            con = ConnectionFactory.getConnection();
            rs = stmt.executeQuery();
            while (rs.next())
            {
                String name = rs.getString("nm_produto");
                cmb_lanche.addItem(name);
                   
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex);
        }
    }
       

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        buttonGroup1 = new javax.swing.ButtonGroup();
        lbl_logo = new javax.swing.JLabel();
        btn_cadastrarlanche = new javax.swing.JButton();
        btn_menuprincipal = new javax.swing.JButton();
        btn_editarlanche = new javax.swing.JButton();
        btn_removerlanche = new javax.swing.JButton();
        lbl_nomelanche = new javax.swing.JLabel();
        lbl_descricaolanche = new javax.swing.JLabel();
        lbl_valorlanche = new javax.swing.JLabel();
        txt_nomelanche = new javax.swing.JTextField();
        txt_descricaolanche = new javax.swing.JTextField();
        cmb_lanche = new javax.swing.JComboBox<>();
        txt_ID = new javax.swing.JTextField();
        lbl_ID = new javax.swing.JLabel();
        txt_valorLanche = new javax.swing.JFormattedTextField();
        btn_atualizar = new javax.swing.JButton();

        jButton4.setText("jButton4");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastro Lanche");
        setUndecorated(true);
        setResizable(false);

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        btn_cadastrarlanche.setText("Cadastrar");
        btn_cadastrarlanche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarlancheActionPerformed(evt);
            }
        });

        btn_menuprincipal.setText("Menu Principal");
        btn_menuprincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuprincipalActionPerformed(evt);
            }
        });

        btn_editarlanche.setText("Editar");

        btn_removerlanche.setText("Remover");

        lbl_nomelanche.setText(" Lanche:");

        lbl_descricaolanche.setText("Descrição:");

        lbl_valorlanche.setText("Valor:");

        txt_nomelanche.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nomelancheFocusGained(evt);
            }
        });

        cmb_lanche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb_lancheMouseClicked(evt);
            }
        });
        cmb_lanche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_lancheActionPerformed(evt);
            }
        });

        txt_ID.setEditable(false);
        txt_ID.setText("1");
        txt_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDActionPerformed(evt);
            }
        });

        lbl_ID.setText("ID");

        try {
            txt_valorLanche.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("R$###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_valorLanche.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorLancheFocusGained(evt);
            }
        });

        btn_atualizar.setText("Atualizar");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_valorlanche)
                            .addComponent(lbl_descricaolanche)
                            .addComponent(lbl_nomelanche))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_atualizar)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_descricaolanche, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_nomelanche, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmb_lanche, javax.swing.GroupLayout.Alignment.TRAILING, 0, 383, Short.MAX_VALUE)
                    .addComponent(txt_valorLanche))
                .addGap(18, 18, 18)
                .addComponent(lbl_logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cadastrarlanche)
                .addGap(18, 18, 18)
                .addComponent(btn_editarlanche)
                .addGap(30, 30, 30)
                .addComponent(btn_removerlanche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addComponent(btn_menuprincipal)
                .addGap(86, 86, 86))
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
                            .addComponent(cmb_lanche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_atualizar))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nomelanche)
                            .addComponent(txt_nomelanche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_descricaolanche)
                            .addComponent(txt_descricaolanche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_valorlanche)
                            .addComponent(txt_valorLanche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_logo))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cadastrarlanche)
                    .addComponent(btn_editarlanche)
                    .addComponent(btn_removerlanche)
                    .addComponent(btn_menuprincipal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(600, 200, 744, 348);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarlancheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarlancheActionPerformed
try{
        Produto p = new Produto();
                    ProdutoDAO dao = new ProdutoDAO();
                    p.setCategoria(Integer.parseInt(txt_ID.getText()));
                     p.setNome(txt_nomelanche.getText());
                     p.setDescricao(txt_descricaolanche.getText());
                     p.setValor(Float.parseFloat(txt_valorLanche.getText()));
                     dao.create(p);    
}catch(RuntimeException ex)
{
    JOptionPane.showMessageDialog(null, "Sem conexão!", "Falta de conexão", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_cadastrarlancheActionPerformed

    private void btn_menuprincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuprincipalActionPerformed

       this.dispose();
   
    }//GEN-LAST:event_btn_menuprincipalActionPerformed

    private void txt_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDActionPerformed

    private void cmb_lancheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_lancheActionPerformed
   
    }//GEN-LAST:event_cmb_lancheActionPerformed

    private void cmb_lancheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_lancheMouseClicked

    }//GEN-LAST:event_cmb_lancheMouseClicked

    private void txt_nomelancheFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nomelancheFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomelancheFocusGained

    private void txt_valorLancheFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorLancheFocusGained

        
         DecimalFormat decimal = new DecimalFormat("###.##");
         NumberFormatter numFormatter = new NumberFormatter(decimal);
         numFormatter.setFormat(decimal);
         numFormatter.setAllowsInvalid(false);
         DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatter);
         txt_valorLanche.setFormatterFactory(dfFactory);
        
        txt_valorLanche.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {	
            String caracteres=("1234567890.");        
         if(!caracteres.contains(e.getKeyChar()+"")){
             getToolkit().beep();
            e.consume();
        }
        }
      });           
    }//GEN-LAST:event_txt_valorLancheFocusGained

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        cmb_lanche.removeAllItems();
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
            java.util.logging.Logger.getLogger(frm_CadastrarLanche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_CadastrarLanche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_CadastrarLanche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_CadastrarLanche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_CadastrarLanche().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_cadastrarlanche;
    private javax.swing.JButton btn_editarlanche;
    private javax.swing.JButton btn_menuprincipal;
    private javax.swing.JButton btn_removerlanche;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Object> cmb_lanche;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JLabel lbl_descricaolanche;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_nomelanche;
    private javax.swing.JLabel lbl_valorlanche;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_descricaolanche;
    private javax.swing.JTextField txt_nomelanche;
    private javax.swing.JFormattedTextField txt_valorLanche;
    // End of variables declaration//GEN-END:variables

    boolean isVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

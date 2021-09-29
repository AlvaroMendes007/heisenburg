/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Usuario;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static view.frm_CadastroLogin.usuario;
import view.frm_Login;

/**
 *
 * @author Mendes
 */
public class UsuarioDAO {
    
    public void create(Usuario u)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into tb_usuario (nm_usuario, cd_senha)values(?, ?)");
            stmt.setString(1, u.getNome());
            stmt.setInt(2, u.getSenha());
            
            stmt.executeUpdate();
         
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        }finally{ConnectionFactory.closeConnection(con, stmt);}
    }
    
    
    
    
    
}

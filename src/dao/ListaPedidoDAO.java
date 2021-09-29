/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ListaPedido;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mendes
 */
public class ListaPedidoDAO {
      public void create(ListaPedido lp)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into tb_itempedido (nm_produto,nr_pedido)values(?,?)");
            stmt.setString(1, lp.getNomeproduto());
            stmt.setInt(2, lp.getNumeropedido());


      
            stmt.executeUpdate();
         
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
        }finally{ConnectionFactory.closeConnection(con, stmt);}
    }
}

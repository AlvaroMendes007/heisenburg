/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Produto;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mendes
 */
public class ProdutoDAO {
     public void create(Produto p)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into tb_produto (nm_produto, ds_produto, vl_produto, fk_cd_categoria)values(?, ?, ?, ?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setFloat(3, p.getValor());
            stmt.setInt(4, p.getCategoria());
            
     
            
            stmt.executeUpdate();
         
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
        }finally{ConnectionFactory.closeConnection(con, stmt);}
    }
     
     public List<Produto>read()
     {
     Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
         ResultSet rs = null;
         
         List<Produto> produtos = new ArrayList<>();
         
         try {
             stmt = con.prepareStatement("select * from tb_produto");
             rs = stmt.executeQuery();
             
             while (rs.next()) {                 
                 Produto produto = new Produto();
                 
                 produto.setId(rs.getInt("pk_cd_produto"));
                 produto.setNome(rs.getString("nm_produto"));
                 produto.setDescricao(rs.getString("ds_produto"));
                 produto.setValor(rs.getFloat("vl_produto"));
                 produtos.add(produto);
             }
         } catch (SQLException ex) {

         }finally{
             ConnectionFactory.closeConnection(con, stmt, rs);
         }
         return produtos;
     }
}
     
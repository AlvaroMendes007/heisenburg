/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mendes
 */
public class ClienteDAO {
      public void create(Cliente c)
    {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into tb_cliente (nm_cliente, nm_cidade, nm_bairro, ds_rua, nr_casa, ds_complemento, nr_cep, nr_telefone)values(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCidade());
            stmt.setString(3, c.getBairro());
            stmt.setString(4, c.getRua());
            stmt.setInt(5, c.getCasa());
            stmt.setString(6, c.getComplemento());
            stmt.setInt(7, c.getCep());
            stmt.setInt(8, c.getTelefone());
         
        
            stmt.executeUpdate();
         
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
        }finally{ConnectionFactory.closeConnection(con, stmt);}
    }
      
        public List<Cliente>read()
     {
     Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
         ResultSet rs = null;
         
         List<Cliente> clientes = new ArrayList<>();
         
         try {
             stmt = con.prepareStatement("select * from tb_cliente");
             rs = stmt.executeQuery();
             
             while (rs.next()) {                 
                 Cliente cliente = new Cliente();
                 
                 cliente.setId(rs.getInt("pk_cd_cliente"));
                 cliente.setNome(rs.getString("nm_cliente"));
                 cliente.setBairro(rs.getString("nm_bairro"));
                 cliente.setRua(rs.getString("ds_rua"));
                 cliente.setCasa(rs.getInt("nr_casa"));
                 cliente.setComplemento(rs.getString("ds_complemento"));
                 cliente.setCep(rs.getInt("nr_cep"));
                 cliente.setTelefone(rs.getInt("nr_telefone"));
                 cliente.setCidade(rs.getString("nm_cidade"));
                 clientes.add(cliente);
             }
         } catch (SQLException ex) {

         }finally{
             ConnectionFactory.closeConnection(con, stmt, rs);
         }
         return clientes;
     }
}

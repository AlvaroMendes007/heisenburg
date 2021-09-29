/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Pedido;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mendes
 */
public class PedidoDAO {
     public void create(Pedido pe)
    {
    
      Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into tb_pedido (nr_pedido, nr_mesa, vl_total, ds_observacao, dt_pedido, hr_pedido,fk_cd_produto)values(?, ?, ?, ?, ?, ?, ?");
            stmt.setInt(1, pe.getNumero_pedido());
            stmt.setInt(2, pe.getNumero_mesa());
            stmt.setFloat(3, pe.getValor_total());
            stmt.setString(4, pe.getObservacao());
            stmt.setString(5, pe.getData_pedido());
            stmt.setString(6, pe.getHora_pedido());
            stmt.setInt(7, pe.getId_produto());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
       
           
        }finally{ConnectionFactory.closeConnection(con, stmt);}
    }
     
   
        public List<Pedido>read()
     {
     Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
         ResultSet rs = null;
         
         List<Pedido> pedidos = new ArrayList<>();
         
         try {
             stmt = con.prepareStatement("select * from tb_pedido");
             rs = stmt.executeQuery();
             
             while (rs.next()) {                 
                 Pedido pedido = new Pedido();
                 
                 pedido.setId(rs.getInt("pk_cd_pedido"));   
                 pedido.setNumero_pedido(rs.getInt("nr_pedido"));
                 pedido.setNumero_mesa(rs.getInt("nr_mesa"));
                 pedido.setValor_total(rs.getFloat("vl_total"));
                 pedido.setData_pedido(rs.getString("dt_pedido"));
                 pedido.setHora_pedido(rs.getString("hr_pedido"));
                 pedido.setObservacao(rs.getString("ds_observacao"));
                 pedido.setId_produto(rs.getInt("fk_cd_produto"));
                 pedidos.add(pedido);
             }
         } catch (SQLException ex) {

         }finally{
             ConnectionFactory.closeConnection(con, stmt, rs);
         }
         return pedidos;
     }
}
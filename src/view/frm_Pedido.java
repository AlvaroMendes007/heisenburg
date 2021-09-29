/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Cliente;
import bean.Pedido;
import connection.ConnectionFactory;
import dao.ClienteDAO;
import dao.PedidoDAO;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import static javax.management.Query.lt;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Mendes
 */
public class frm_Pedido extends javax.swing.JFrame {

    /**
     * Creates new form frm_Pedido
     */
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
     Object[] linha = new Object[4];
     
    public frm_Pedido() {
        initComponents();
        lbl_lanche.setVisible(false);
        lbl_bebida.setVisible(false);
        lbl_variado.setVisible(false);
        cmb_lanche.setVisible(false);
        cmb_bebida.setVisible(false);
        cmb_variado.setVisible(false);  
        btn_adicionarlanche.setVisible(false);
        btn_adicionarbebida.setVisible(false);
        btn_adicionarvariado.setVisible(false);
        btn_voltar.setVisible(false);
         lbl_obs.setVisible(false);
        txt_obs.setVisible(false);
        atualizartabela();
        
         cmb_lanche.removeAllItems();
        comboboxlanche();
        cmb_bebida.removeAllItems();
        comboboxbebida();
        cmb_variado.removeAllItems();
        comboboxvariado();
        
        cmb_cliente.removeAllItems();
        comboboxcli();
        
        dataatual();
    }

    public frm_Pedido(ButtonGroup buttonGroup1, JComboBox<String> cmb_cli_mes, JComboBox<String> cmb_mesa, JTextField jTextField1, JLabel lbl_bairrocliente, JLabel lbl_cepcliente, JLabel lbl_clientemesa, JLabel lbl_mesapedido, JLabel lbl_nomeclienteviagem, JLabel lbl_ruacliente, JPanel pb_mesa, JPanel pn_viagem, JRadioButton rdb_mesa, JRadioButton rdb_viagem) throws HeadlessException {
        this.buttonGroup1 = buttonGroup1;
        this.cmb_cli_mes = cmb_cli_mes;
        this.txt_cliente = jTextField1;
        this.lbl_bairrocliente = lbl_bairrocliente;
        this.lbl_cepcliente = lbl_cepcliente;
        this.lbl_clientemesa = lbl_clientemesa;
        this.lbl_nomeclienteviagem = lbl_nomeclienteviagem;
        this.lbl_ruacliente = lbl_ruacliente;
        this.cmb_cli = pb_mesa;
        this.pn_viagem = pn_viagem;
        this.rdb_mesa = rdb_mesa;
        this.rdb_viagem = rdb_viagem;
    }
    
    private void dataatual()
    {
         Date data = new Date();
       SimpleDateFormat formatar = new SimpleDateFormat("YYYY-MM-dd");
       SimpleDateFormat formatar_hora = new SimpleDateFormat("HH:mm:ss");
       
       String dataformatada =  formatar.format(data);
       String horaformatada =  formatar_hora.format(data);
       txt_data.setText(dataformatada);
       txt_hora.setText(horaformatada);
      
    }
    
     private void atualizartabela()
    {
    DefaultTableModel modelo1 = (DefaultTableModel) jtb_Itens.getModel(); //Primeira linha 
        jtb_Itens.setModel(modelo1);
       modelo1.setNumRows(0);
    }
    
  private void comboboxlanche()
    {
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from tb_produto where fk_cd_categoria = 1";
            stmt = con.prepareStatement(sql);
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
  
    private void comboboxbebida()
    {
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from tb_produto where fk_cd_categoria = 2";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                String name = rs.getString("nm_produto");
                cmb_bebida.addItem(name);                     
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex);
        }
    }
    
      private void comboboxvariado()
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
     
    
     private void comboboxcli()
    {
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from tb_cliente";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) 
            {
                int id = rs.getInt("pk_cd_cliente");
                String name = rs.getString("nm_cliente");
                cmb_cliente.addItem(id + "-" + name);              
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex);
        }
    }
     
      private void comboboxpedido()
    {
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from tb_pedido \n" +
"inner join tb_produto on pk_cd_produto = fk_cd_produto where fk_cd_cliente =";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                String name = rs.getString("nm_produto");
                cmb_pedido.addItem(name);                             
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex);
        }
    }
    
       private void combobox()
    {
        try {
            PedidoDAO pe = new PedidoDAO();
            con = ConnectionFactory.getConnection();
            String sql = "";
            stmt = con.prepareStatement(String.valueOf(pe.read()));
            rs = stmt.executeQuery();
            while (rs.next())
            {
//                String name = rs.getString("nr_pedido");
  //              cmb_pedido.addItem(name); 
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex);
        }
    }
      
     public void checar()
    {
        if(rdb_mesa.isSelected())
        {
            pn_viagem.setVisible(false);
            cmb_cli.setVisible(true);
            
        }else if (rdb_viagem.isSelected())
        {
            cmb_cli.setVisible(false);
            pn_viagem.setVisible(true);
        }
    }
     
     
    /**
     * This method is called from within the constructorto initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rdb_viagem = new javax.swing.JRadioButton();
        rdb_mesa = new javax.swing.JRadioButton();
        pn_viagem = new javax.swing.JPanel();
        lbl_nomeclienteviagem = new javax.swing.JLabel();
        lbl_cepcliente = new javax.swing.JLabel();
        lbl_ruacliente = new javax.swing.JLabel();
        lbl_bairrocliente = new javax.swing.JLabel();
        cmb_cli = new javax.swing.JPanel();
        lbl_clientemesa = new javax.swing.JLabel();
        cmb_cli_mes = new javax.swing.JComboBox<>();
        txt_cliente = new javax.swing.JTextField();
        lbl_pedido = new javax.swing.JLabel();
        cmb_pedido = new javax.swing.JComboBox<>();
        btn_concluir = new javax.swing.JButton();
        btn_adicionar = new javax.swing.JButton();
        lbl_NumeroPedido = new javax.swing.JLabel();
        lbl_mesa = new javax.swing.JLabel();
        cmb_mesa = new javax.swing.JComboBox<>();
        cmb_cliente = new javax.swing.JComboBox<>();
        txt_data = new javax.swing.JFormattedTextField();
        txt_hora = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtb_Itens = new javax.swing.JTable();
        lbl_bebida = new javax.swing.JLabel();
        lbl_lanche = new javax.swing.JLabel();
        cmb_lanche = new javax.swing.JComboBox<>();
        cmb_bebida = new javax.swing.JComboBox<>();
        cmb_variado = new javax.swing.JComboBox<>();
        btn_adicionarvariado = new javax.swing.JButton();
        btn_adicionarlanche = new javax.swing.JButton();
        btn_adicionarbebida = new javax.swing.JButton();
        lbl_variado = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        lbl_obs = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_obs = new javax.swing.JTextArea();
        btn_exclui = new javax.swing.JButton();
        lbl_inv = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rdb_viagem);
        rdb_viagem.setText("Pedido para viagem");
        rdb_viagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_viagemActionPerformed(evt);
            }
        });
        getContentPane().add(rdb_viagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        buttonGroup1.add(rdb_mesa);
        rdb_mesa.setText("Pedido para mesa");
        rdb_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_mesaActionPerformed(evt);
            }
        });
        getContentPane().add(rdb_mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        pn_viagem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pn_viagem.setVisible(false);

        lbl_nomeclienteviagem.setText("Nome do Cliente");

        lbl_cepcliente.setText("CEP");

        lbl_ruacliente.setText("Rua");

        lbl_bairrocliente.setText("Bairro");

        javax.swing.GroupLayout pn_viagemLayout = new javax.swing.GroupLayout(pn_viagem);
        pn_viagem.setLayout(pn_viagemLayout);
        pn_viagemLayout.setHorizontalGroup(
            pn_viagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_viagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_viagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nomeclienteviagem)
                    .addComponent(lbl_cepcliente)
                    .addComponent(lbl_ruacliente)
                    .addComponent(lbl_bairrocliente))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        pn_viagemLayout.setVerticalGroup(
            pn_viagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_viagemLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbl_nomeclienteviagem)
                .addGap(18, 18, 18)
                .addComponent(lbl_cepcliente)
                .addGap(21, 21, 21)
                .addComponent(lbl_ruacliente)
                .addGap(18, 18, 18)
                .addComponent(lbl_bairrocliente)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        getContentPane().add(pn_viagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 49, -1, -1));

        cmb_cli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cmb_cli.setEnabled(false);
        cmb_cli.setVisible(false);

        lbl_clientemesa.setText("Nome do Cliente");

        cmb_cli_mes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmb_cli_mesFocusGained(evt);
            }
        });
        cmb_cli_mes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb_cli_mesMouseClicked(evt);
            }
        });
        cmb_cli_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_cli_mesActionPerformed(evt);
            }
        });

        txt_cliente.setEditable(false);
        txt_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clienteActionPerformed(evt);
            }
        });

        lbl_pedido.setText("Pedido");

        cmb_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_pedidoActionPerformed(evt);
            }
        });

        btn_concluir.setText("Concluir");
        btn_concluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_concluirActionPerformed(evt);
            }
        });

        btn_adicionar.setText("+");
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        lbl_NumeroPedido.setText("Nr_Pedido");

        lbl_mesa.setText("Mesa");

        cmb_mesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));

        cmb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cmb_cliLayout = new javax.swing.GroupLayout(cmb_cli);
        cmb_cli.setLayout(cmb_cliLayout);
        cmb_cliLayout.setHorizontalGroup(
            cmb_cliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmb_cliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cmb_cliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cmb_cliLayout.createSequentialGroup()
                        .addGroup(cmb_cliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cmb_cliLayout.createSequentialGroup()
                                .addComponent(lbl_NumeroPedido)
                                .addGap(60, 60, 60)
                                .addComponent(btn_concluir))
                            .addGroup(cmb_cliLayout.createSequentialGroup()
                                .addGroup(cmb_cliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_pedido)
                                    .addComponent(lbl_mesa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cmb_cliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(cmb_cliLayout.createSequentialGroup()
                                        .addComponent(cmb_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_adicionar)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cmb_cliLayout.createSequentialGroup()
                        .addGroup(cmb_cliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmb_cliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_cliente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cmb_cliLayout.createSequentialGroup()
                                .addComponent(lbl_clientemesa)
                                .addGap(78, 78, 78)
                                .addComponent(cmb_cli_mes, 0, 0, Short.MAX_VALUE)))
                        .addGap(506, 506, 506))))
        );
        cmb_cliLayout.setVerticalGroup(
            cmb_cliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmb_cliLayout.createSequentialGroup()
                .addGroup(cmb_cliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cmb_cliLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lbl_clientemesa))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cmb_cliLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmb_cli_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(cmb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(cmb_cliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmb_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_mesa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cmb_cliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_pedido)
                    .addComponent(cmb_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_adicionar))
                .addGroup(cmb_cliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cmb_cliLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btn_concluir))
                    .addGroup(cmb_cliLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_NumeroPedido)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(cmb_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 240, 230));

        txt_data.setEditable(false);
        txt_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        getContentPane().add(txt_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 120, -1));

        txt_hora.setEditable(false);
        txt_hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        getContentPane().add(txt_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 110, -1));

        jtb_Itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Produto", "Produto", "ID Categoria", "Categoria", "Valor", "Obs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtb_Itens.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtb_Itens);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 520, 350));

        lbl_bebida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/drink.png"))); // NOI18N
        getContentPane().add(lbl_bebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        lbl_lanche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/burguer1.png"))); // NOI18N
        getContentPane().add(lbl_lanche, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        getContentPane().add(cmb_lanche, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 110, -1));

        getContentPane().add(cmb_bebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 110, -1));

        getContentPane().add(cmb_variado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 100, -1));

        btn_adicionarvariado.setText("+");
        btn_adicionarvariado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarvariadoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_adicionarvariado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 50, 30));

        btn_adicionarlanche.setText("+");
        btn_adicionarlanche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarlancheActionPerformed(evt);
            }
        });
        getContentPane().add(btn_adicionarlanche, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 357, 50, 30));

        btn_adicionarbebida.setText("+");
        btn_adicionarbebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarbebidaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_adicionarbebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 50, 30));

        lbl_variado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fries.png"))); // NOI18N
        getContentPane().add(lbl_variado, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        btn_voltar.setText("<<");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, -1, -1));

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 300, -1, -1));

        lbl_obs.setText("OBSERVAÇÃO");
        getContentPane().add(lbl_obs, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 80, -1));

        txt_obs.setColumns(20);
        txt_obs.setRows(5);
        jScrollPane1.setViewportView(txt_obs);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 190, 100));

        btn_exclui.setVisible(false);
        btn_exclui.setText("-");
        btn_exclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_exclui, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 310, 50, -1));

        lbl_inv.setText("jLabel1");
        getContentPane().add(lbl_inv, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_cli_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_cli_mesActionPerformed
         
        String nome = String.valueOf(cmb_cliente.getSelectedItem());
       // String nome;
       //nome = (String) cmb_cli_mes.getSelectedItem();
      //  JOptionPane.showMessageDialog(null, nome);
       txt_cliente.setText(nome); // TODO add your handling code here:  
        
       
    }//GEN-LAST:event_cmb_cli_mesActionPerformed

    private void cmb_cli_mesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb_cli_mesFocusGained
     
    }//GEN-LAST:event_cmb_cli_mesFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
           cmb_cli_mes.removeAllItems();
           
        comboboxcli();
     
       // comboboxpedido();
   
    }//GEN-LAST:event_formWindowActivated

    private void rdb_viagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_viagemActionPerformed
    checar();
    }//GEN-LAST:event_rdb_viagemActionPerformed

    private void rdb_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_mesaActionPerformed
checar();        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_mesaActionPerformed

    private void txt_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_clienteActionPerformed

    private void cmb_cli_mesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_cli_mesMouseClicked
          
    }//GEN-LAST:event_cmb_cli_mesMouseClicked

    private void cmb_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_pedidoActionPerformed
            
    }//GEN-LAST:event_cmb_pedidoActionPerformed

    private void btn_concluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_concluirActionPerformed

      //Date now = new Date(System.currentTimeMillis());
       String cliente = String.valueOf(cmb_cliente.getSelectedItem());
       Date data = new Date();
       SimpleDateFormat formatar = new SimpleDateFormat("YYYY-MM-dd");
       String dataformatada =  formatar.format(data);
       // combobox();
        System.out.println(dataformatada);
        
     
       /*
       Y - year
       M - Month in year
       D - Day in year
       d - Day in month
       H - Hour in day
       h - hour in am/pm
       m - minute in hour
       s - Second in minute
       S - milisecond number
       */
       
       
       Random gerador = new Random(); 
         
       
         int n = gerador.nextInt(5000);
          
        lbl_NumeroPedido.setText(Integer.toString(n));

       // lbl_inv.setText((Integer.parseInt(String.valueOf(cmb_pedido.getSelectedItem()))));
       // String numeropedido = lbl_NumeroPedido.getText();
        int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja concluir o pedido?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if(confirmacao == JOptionPane.YES_OPTION)
        { 
      
            for (int i = 0; i < 5; i++)
            {
                JOptionPane.showMessageDialog(null, i);
            }
            
          Pedido p = new Pedido();
            PedidoDAO dao = new PedidoDAO();  
            

            p.setNumero_mesa(Integer.parseInt(String.valueOf(cmb_mesa.getSelectedItem())));
            p.setNumero_pedido(Integer.parseInt(lbl_NumeroPedido.getText()));
            //p.setId_produto(Integer.parseInt(String.valueOf(cmb_pedido.getSelectedItem())));
           
            //System.out.println(numero_pedido);
            //txt_data.setText(dataformatada)
           // p.setData_pedido(x.getDate());
         //  dao.create(p);
        }             
//lbl_NumeroPedido.setText(Integer.toString(gera);
    }//GEN-LAST:event_btn_concluirActionPerformed

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
      lbl_lanche.setVisible(true);
        lbl_bebida.setVisible(true);
        lbl_variado.setVisible(true);
        cmb_lanche.setVisible(true);
        cmb_bebida.setVisible(true);
        cmb_variado.setVisible(true);  
        btn_adicionarlanche.setVisible(true);
        btn_adicionarbebida.setVisible(true);
        btn_adicionarvariado.setVisible(true);
        btn_voltar.setVisible(true);
        jtb_Itens.setVisible(true);
         lbl_obs.setVisible(true);
        txt_obs.setVisible(true);
        jtb_Itens.setVisible(true);
        jtb_Itens.setEnabled(true);
        btn_exclui.setVisible(true);

        rdb_mesa.setVisible(false);
        rdb_viagem.setVisible(false);
        cmb_cli.setVisible(false);
        
        String nomecliente =String.valueOf(cmb_cliente.getSelectedItem()) ;
        
        lbl_inv.setText(nomecliente);
    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void btn_adicionarvariadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarvariadoActionPerformed
        String nome3 = String.valueOf(cmb_variado.getSelectedItem());
        DefaultTableModel modelo1 = (DefaultTableModel) jtb_Itens.getModel(); //Primeira linha
        jtb_Itens.setModel(modelo1);
        //  modelo1.setNumRows(10);
        
        String obse = txt_obs.getText();
        try{

            try{if (cmb_variado.getSelectedItem().toString().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "");
                } else{
                    //   modelo1.setNumRows(0);
                    try {
                        con = ConnectionFactory.getConnection();
                        String sql2 = "select * from tb_produto\n" +
                        "inner join tb_categoria on fk_cd_categoria = pk_cd_categoria where fk_cd_categoria = 3 and nm_produto like '"+nome3+"'";
                        stmt = con.prepareStatement(sql2);
                        rs = stmt.executeQuery();
                        while (rs.next())
                        {
                            String idp = rs.getString("pk_cd_produto");
                            String cat = rs.getString("nm_categoria");
                            Float valor = rs.getFloat("vl_produto");
                            String idc = rs.getString("fk_cd_categoria");
                            String obs = obse;
                            modelo1.addRow(new Object[]
                                {
                                    linha[0] = idp, nome3, idc, cat, valor, obs
                                });
                            }

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "ERROR" + ex);
                        }
                    }
                }catch(NullPointerException np)
                {
                    JOptionPane.showMessageDialog(null, "Não foi possível inserir, verifique o item selecionado");
                }
            }catch(NullPointerException np)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível inserir, verifique o item selecionado");
            }

            /*ListaPedido lp = new ListaPedido();
            ListaPedidoDAO dao = new ListaPedidoDAO();
            lp.setNomeproduto((txt_bebida.getText()));
            dao.create(lp);*/
            // TODO add your handling code here:
    }//GEN-LAST:event_btn_adicionarvariadoActionPerformed

    private void btn_adicionarlancheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarlancheActionPerformed
        String nome1 = String.valueOf(cmb_lanche.getSelectedItem());
        String obse = txt_obs.getText();
        DefaultTableModel modelo1 = (DefaultTableModel) jtb_Itens.getModel(); //Primeira linha
        jtb_Itens.setModel(modelo1);

        Pedido p = new Pedido();
        PedidoDAO dao = new PedidoDAO();
        
        //p.setObservacao(obse);
        
        
        try{if (cmb_lanche.getSelectedItem().toString().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "");
            } else{
                //   modelo1.setNumRows(0);
                try {
                    con = ConnectionFactory.getConnection();
                    String sql2 = "select * from tb_produto\n" +
                    "inner join tb_categoria on fk_cd_categoria = pk_cd_categoria where fk_cd_categoria = 1 and nm_produto like '"+nome1+"'";
                    stmt = con.prepareStatement(sql2);
                    rs = stmt.executeQuery();
                    
                    while (rs.next())
                    {
                        String idp = rs.getString("pk_cd_produto");
                        String cat = rs.getString("nm_categoria");
                        Float valor = rs.getFloat("vl_produto");
                         String idc = rs.getString("fk_cd_categoria");
                        String obs = obse;
                        modelo1.addRow(new Object[]
                            {
                                linha[0] = idp, nome1, idc, cat, valor, obs

                            });
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "ERROR" + ex);
                    }
                }
            }catch(NullPointerException np)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível inserir, verifique o item selecionado");
            }
            // cmb_pedidos.addItem(nome);
            //cmb_pedidos.getItemCount();
            //String pedidolanche = String.valueOf(cmb_lanche.getSelectedItem());
            // cmb_pedidos.addItem(pedidolanche);

    }//GEN-LAST:event_btn_adicionarlancheActionPerformed

    private void btn_adicionarbebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarbebidaActionPerformed
       String nome2 = String.valueOf(cmb_bebida.getSelectedItem()); 
        DefaultTableModel modelo1 = (DefaultTableModel) jtb_Itens.getModel(); //Primeira linha 
        jtb_Itens.setModel(modelo1);
        
     String obse = txt_obs.getText();
      //  modelo1.setNumRows(10);
   try{

        try{if (cmb_bebida.getSelectedItem().toString().isEmpty())
{
    JOptionPane.showMessageDialog(null, "");
} else{
    //   modelo1.setNumRows(0);
         try {
            con = ConnectionFactory.getConnection();
            String sql2 = "select * from tb_produto\n" +
"inner join tb_categoria on fk_cd_categoria = pk_cd_categoria where fk_cd_categoria = 2 and nm_produto like '"+nome2+"'";
            stmt = con.prepareStatement(sql2);
            rs = stmt.executeQuery();   
            while (rs.next())
            {
             String idp = rs.getString("pk_cd_produto");    
             String cat = rs.getString("nm_categoria");
             String idc = rs.getString("fk_cd_categoria");      
             Float valor = rs.getFloat("vl_produto");             
              String obs = obse;
               
                
              modelo1.addRow(new Object[]
          {
            linha[0] = idp, nome2, idc, cat, valor, obs
 
            }); 
            }
                     
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex);
        }   
   }
   }catch(NullPointerException np)
   {
       JOptionPane.showMessageDialog(null, "Não foi possível inserir, verifique o item selecionado");
   } 
   }catch(NullPointerException np)
   {
       JOptionPane.showMessageDialog(null, "Não foi possível inserir, verifique o item selecionado");
   }
    
     
 /*ListaPedido lp = new ListaPedido();
                    ListaPedidoDAO dao = new ListaPedidoDAO();
                    lp.setNomeproduto((txt_bebida.getText()));
                    dao.create(lp);*/   
 // TODO add your handling code here:
    
    

  
               
   /*     ListaPedido lp = new ListaPedido();
                    ListaPedidoDAO dao = new ListaPedidoDAO();
                    lp.setNomeproduto((txt_variado.getText()));
                    dao.create(lp);*/   
// TODO add your handling code here:}
    }//GEN-LAST:event_btn_adicionarbebidaActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        Pedido p = new Pedido();
        PedidoDAO dao = new PedidoDAO();
        int x = jtb_Itens.getRowCount();
        ListSelectionModel selectionmodel = jtb_Itens.getSelectionModel();
        DefaultTableModel modelo1 = (DefaultTableModel) jtb_Itens.getModel();
        String nomecliente = lbl_nomeclienteviagem.getText();
        
        int confirmacao_pedido = JOptionPane.showConfirmDialog(null, "Confirma o Pedido?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirmacao_pedido == JOptionPane.YES_OPTION)
            for(int i=0;i<x;i++)
            {
              String pega =  String.valueOf(modelo1.getValueAt(i, 1));
              String pegaID =  String.valueOf(modelo1.getValueAt(i, 0));
                cmb_pedido.addItem(pegaID +"-"+ pega);           
                lbl_lanche.setVisible(false);
                lbl_bebida.setVisible(false);
                lbl_variado.setVisible(false);
                cmb_lanche.setVisible(false);
                cmb_bebida.setVisible(false);
                cmb_variado.setVisible(false);  
                 btn_adicionarlanche.setVisible(false);
        btn_adicionarbebida.setVisible(false);
               btn_adicionarvariado.setVisible(false);
        btn_voltar.setVisible(false);
         lbl_obs.setVisible(false);
        txt_obs.setVisible(false);
      cmb_cli.setVisible(true);
       cmb_cli.setEnabled(true);
      rdb_mesa.setVisible(true);
    rdb_viagem.setVisible(true);
    btn_exclui.setVisible(false);

            }  
           
        
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void cmb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_clienteActionPerformed
         String nome = String.valueOf(cmb_cliente.getSelectedItem());
       // String nome;
       //nome = (String) cmb_cli_mes.getSelectedItem();
      //  JOptionPane.showMessageDialog(null, nome);
       txt_cliente.setText(nome); // TODO add your handling code here: 
    }//GEN-LAST:event_cmb_clienteActionPerformed

    private void btn_excluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluiActionPerformed
        DefaultTableModel modelo1 = (DefaultTableModel) jtb_Itens.getModel();
        if (jtb_Itens.getSelectedRow() >= 0){
            modelo1.removeRow(jtb_Itens.getSelectedRow());
            jtb_Itens.setModel(modelo1);
        }else{
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }
    }//GEN-LAST:event_btn_excluiActionPerformed

    

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
            java.util.logging.Logger.getLogger(frm_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Pedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_adicionarbebida;
    private javax.swing.JButton btn_adicionarlanche;
    private javax.swing.JButton btn_adicionarvariado;
    private javax.swing.JButton btn_concluir;
    private javax.swing.JButton btn_exclui;
    private javax.swing.JButton btn_voltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmb_bebida;
    private javax.swing.JPanel cmb_cli;
    private javax.swing.JComboBox<String> cmb_cli_mes;
    private javax.swing.JComboBox<String> cmb_cliente;
    private javax.swing.JComboBox<String> cmb_lanche;
    private javax.swing.JComboBox<String> cmb_mesa;
    private javax.swing.JComboBox<String> cmb_pedido;
    private javax.swing.JComboBox<String> cmb_variado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable jtb_Itens;
    private javax.swing.JLabel lbl_NumeroPedido;
    private javax.swing.JLabel lbl_bairrocliente;
    private javax.swing.JLabel lbl_bebida;
    private javax.swing.JLabel lbl_cepcliente;
    private javax.swing.JLabel lbl_clientemesa;
    private javax.swing.JLabel lbl_inv;
    private javax.swing.JLabel lbl_lanche;
    private javax.swing.JLabel lbl_mesa;
    private javax.swing.JLabel lbl_nomeclienteviagem;
    private javax.swing.JLabel lbl_obs;
    private javax.swing.JLabel lbl_pedido;
    private javax.swing.JLabel lbl_ruacliente;
    private javax.swing.JLabel lbl_variado;
    private javax.swing.JPanel pn_viagem;
    private javax.swing.JRadioButton rdb_mesa;
    private javax.swing.JRadioButton rdb_viagem;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JFormattedTextField txt_data;
    private javax.swing.JFormattedTextField txt_hora;
    private javax.swing.JTextArea txt_obs;
    // End of variables declaration//GEN-END:variables

    
}

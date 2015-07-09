/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import org.jvnet.substance.SubstanceLookAndFeel;

import Clases.Consultas;
import Clases.Metodos_Tipos;
import Clases.conexion;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static Administrador.Departamentos.tabla5;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import ptc.Login;


/**
 *
 * @author Eduardo López
 */
public class control_usuarios extends javax.swing.JFrame {
    private Connection cn;

    public void Sletras(JTextField a){
        a.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e){
            char c=e.getKeyChar();
            if(Character.isDigit(c)){
                getToolkit().beep();
                e.consume();
            }
        }
      
        });
    }
    public control_usuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Usuario");
        this.setResizable(false);
        cerrar();
        this.getContentPane().setBackground(new java.awt.Color(0, 0, 102));
        
        Consultas frm4 = new Consultas();
        frm4.Tabla6U();
        frm4.Tabla7U();
        Sletras(txtNombre);
        Sletras(txtNombre2);
        txtContra2.setVisible(false); 
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pst3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla6 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnConsultar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla7 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtContra = new javax.swing.JTextField();
        txtContra2 = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        txtCodigo2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtApellidos1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtCargos1 = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pst3.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        pst3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        pst3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pst3StateChanged(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre ", "Apellidos", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla6MouseClicked(evt);
            }
        });
        tabla6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla6KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla6);
        if (tabla6.getColumnModel().getColumnCount() > 0) {
            tabla6.getColumnModel().getColumn(0).setMinWidth(0);
            tabla6.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla6.getColumnModel().getColumn(1).setResizable(false);
            tabla6.getColumnModel().getColumn(2).setResizable(false);
            tabla6.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 26, 910, 390));

        pst3.addTab("Empleados", jPanel2);

        btnConsultar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434664469_edit-clear.png"))); // NOI18N
        btnConsultar.setText("Limpiar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434608001_save_as-2.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tabla7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Apellidos", "Cargo", "Usuario", "Contrasena"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla7MouseClicked(evt);
            }
        });
        tabla7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla7KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla7);
        if (tabla7.getColumnModel().getColumnCount() > 0) {
            tabla7.getColumnModel().getColumn(0).setMinWidth(0);
            tabla7.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla7.getColumnModel().getColumn(1).setResizable(false);
            tabla7.getColumnModel().getColumn(2).setResizable(false);
            tabla7.getColumnModel().getColumn(3).setResizable(false);
            tabla7.getColumnModel().getColumn(4).setResizable(false);
            tabla7.getColumnModel().getColumn(5).setMinWidth(0);
            tabla7.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Contraseña:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 103, -1, -1));

        txtNombre.setEditable(false);
        jPanel4.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 72, 124, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Usuario:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 71, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Codigo:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        txtCodigo.setEditable(false);
        jPanel4.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 38, -1));

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 20, -1, -1));

        txtContra.setEditable(false);
        jPanel4.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 130, -1));

        txtContra2.setEditable(false);
        jPanel4.add(txtContra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 130, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(102, 102, 102));
        jPanel5.setOpaque(false);

        txtCodigo2.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setText("Codigo:");

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setText("Nombre:");

        txtNombre2.setEditable(false);
        txtNombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setText("Apellidos:");

        txtApellidos1.setEditable(false);

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel17.setText("Cargos:");

        txtCargos1.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCargos1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel14))
                    .addComponent(txtCodigo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtApellidos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtCargos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConsultar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnConsultar))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pst3.addTab("Usuarios", jPanel1);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434854150_exit.png"))); // NOI18N
        jMenu1.setText("Cerrar sesion");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar2.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434853539_go-back.png"))); // NOI18N
        jMenu3.setText("Regresar");
        jMenu3.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pst3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pst3, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cerrar(){
        try{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    confirmarSalida();
                }
            });
            this.setVisible(true); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void confirmarSalida(){
        int valor = JOptionPane.showConfirmDialog(this, "Esta seguro de cerrar el sistema?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            System.exit(0);            
        }
    }
    
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        limpiar();                     
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void llenarComboBox() {
        try {
    conexion con = new conexion();
    cn = con.conexion();
    DefaultComboBoxModel dcm = new DefaultComboBoxModel();
    String sql = "select * from tipo_usuario";
    dcm.addElement("Seleccione un tipo");
    PreparedStatement cmd = cn.prepareStatement(sql);
    ResultSet rs = cmd.executeQuery();
    while(rs.next()){
        dcm.addElement(rs.getString("nombre_tipoU"));
    }
    cmd.close();
    cn.close();
    
    } catch (Exception ex) {}
    }
    
    private void limpiar_tipos(){

    }
    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        llenarComboBox();
    }//GEN-LAST:event_formWindowOpened
    
    
    private void limpiar() {
        txtCodigo.setText(null);
        txtNombre.setText(null);
        txtContra.setText(null);
        txtApellidos1.setText(null); 
        txtCargos1.setText(null); 
        txtCodigo2.setText(null); 
        txtNombre2.setText(null);
        txtContra.setVisible(true); 
        txtContra2.setVisible(false); 
        txtContra2.setText(null); 
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
      if(!txtCodigo2.getText().isEmpty() && !txtNombre.getText().isEmpty())
      {
        Metodos_Tipos obj = new Metodos_Tipos();
        obj.setTipo(Integer.parseInt(txtCodigo2.getText())); 
        obj.setNombre(txtNombre.getText().toLowerCase());
        obj.setContra(txtContra.getText().toLowerCase());
        obj.setCodigo(Integer.parseInt(txtCodigo2.getText())); 
       if(obj.guardar_uuario() && obj.modificar_empleado())
        {
            DefaultTableModel modelo=(DefaultTableModel) tabla7.getModel();
                    int filas=tabla7.getRowCount();
                    for (int i = 0;filas>i; i++) {
                        modelo.removeRow(0);
                    }
                    DefaultTableModel modelo2=(DefaultTableModel) tabla6.getModel();
                    int filas2=tabla6.getRowCount();
                    for (int i = 0;filas2>i; i++) {
                        modelo2.removeRow(0);
                    }
                    Consultas frm4 = new Consultas();
                    frm4.Tabla6U();
                    frm4.Tabla7U();
                    limpiar();
        JOptionPane.showMessageDialog(this,"Datos guardados con exito");
            try {
                cn.close();
            } catch (SQLException ex) {
                
            }
    }
    else
        {
        JOptionPane.showMessageDialog(this, "Error al intentar guardar datos");
    }
    limpiar();
    obj.setSql(null);
        }
      else{
          JOptionPane.showMessageDialog(null, "Necesita seleccionar el empleado o generar el usuario");
      }        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void pst3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pst3StateChanged
        // TODO add your handling code here:
        llenarComboBox();
    }//GEN-LAST:event_pst3StateChanged

    private void tabla7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla7MouseClicked
        txtContra.setVisible(false); 
        txtContra2.setVisible(true); 
        Integer id = (Integer) tabla7.getValueAt(tabla7.getSelectedRow(), 0);
        String id3 = (String) tabla7.getValueAt(tabla7.getSelectedRow(),1);
        String id4 = (String) tabla7.getValueAt(tabla7.getSelectedRow(),2);
        String id5 = (String) tabla7.getValueAt(tabla7.getSelectedRow(),3);
        String id6 = (String) tabla7.getValueAt(tabla7.getSelectedRow(),4);
        String id7 = (String) tabla7.getValueAt(tabla7.getSelectedRow(),5);
        txtCodigo.setText(Integer.toString(id));
        txtNombre.setText((id6));
        txtContra2.setText(id7);
        txtNombre2.setText(id3); 
        txtApellidos1.setText(id4);
        txtCargos1.setText(id5);
    }//GEN-LAST:event_tabla7MouseClicked

    private void tabla7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla7KeyPressed
        
    }//GEN-LAST:event_tabla7KeyPressed

    private void tabla6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla6MouseClicked
        Integer id = (Integer) tabla6.getValueAt(tabla6.getSelectedRow(), 0);
        String id2 = (String) tabla6.getValueAt(tabla6.getSelectedRow(),1);
        String id3 = (String) tabla6.getValueAt(tabla6.getSelectedRow(),2);
        String id4 = (String) tabla6.getValueAt(tabla6.getSelectedRow(),3);
        txtCodigo2.setText(Integer.toString(id));
        txtNombre2.setText((id2));
        txtApellidos1.setText(id3); 
        txtCargos1.setText(id4);
        pst3.setSelectedIndex(1); 
    }//GEN-LAST:event_tabla6MouseClicked

    private void tabla6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla6KeyPressed
        txtContra2.setVisible(false);
        txtContra.setVisible(true); 
    }//GEN-LAST:event_tabla6KeyPressed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        Login frm = new Login();
        frm.show();
        this.hide();
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        PrincipalAdministrador frm = new PrincipalAdministrador();
        frm.show();
        this.hide();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void txtNombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre2ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtNombre.setText(txtNombre2.getText().trim().toLowerCase() + txtCodigo2.getText().trim().toLowerCase());
        txtContra.setText(txtApellidos1.getText().trim().toLowerCase() + txtCodigo2.getText().trim().toLowerCase());      
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(control_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(control_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(control_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(control_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistAquaSkin");    //seaplica la libreria de look and feel
                new control_usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane pst3;
    public static javax.swing.JTable tabla6;
    public static javax.swing.JTable tabla7;
    private javax.swing.JTextField txtApellidos1;
    private javax.swing.JTextField txtCargos1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigo2;
    private javax.swing.JTextField txtContra;
    private javax.swing.JPasswordField txtContra2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre2;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Clases.Consultas;
import Clases.Metodos_Tipos;
import org.jvnet.substance.SubstanceLookAndFeel;

import Clases.consultas1;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import ptc.Login;


/**
 *
 * @author oscar
 */
public class areas_trabajo extends javax.swing.JFrame {

    /**
     * Creates new form departamentos2
     */
    
    public void Sletras(JTextField a){
        a.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e){
            char c=e.getKeyChar();
            if(Character.isDigit(c) || !Character.isLetter(c)){
                getToolkit().beep();
                e.consume();
            }
        }
      
        });
    }

//Validacion de solo numeros, quitar espacios en blanco y simbolos    
public void Snumeros(JTextField a){
        a.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e){
            char c=e.getKeyChar();
            if(Character.isLetter(c)){
                getToolkit().beep();
                e.consume();
            }
        }
      
        });
    }

public void limpiar_tipos(){
    txtcodigo.setText(null); 
    txtdepto.setText(null); 
}

    public areas_trabajo() {
        initComponents();          
        this.setLocationRelativeTo(null);
        this.setTitle("Areas Empresariales");
        this.setResizable(false);
        this.getContentPane().setBackground(new java.awt.Color(0, 0, 102));        
        Metodos_Tipos frm2 = new Metodos_Tipos();
        frm2.Tabla4();        
        Sletras(txtdepto);     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla6 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtcodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtdepto = new javax.swing.JTextField();
        btnEliminar3 = new javax.swing.JButton();
        btnGuardar3 = new javax.swing.JButton();
        btnModificar3 = new javax.swing.JButton();
        btnConsultar3 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre del departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla6.setRowSelectionAllowed(false);
        tabla6.getTableHeader().setReorderingAllowed(false);
        tabla6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla6MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla6);
        if (tabla6.getColumnModel().getColumnCount() > 0) {
            tabla6.getColumnModel().getColumn(0).setMinWidth(0);
            tabla6.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla6.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Areas Empresariales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        txtcodigo.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Codigo:");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Departamento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdepto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtdepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        btnEliminar3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEliminar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434841655_f-cross_256.png"))); // NOI18N
        btnEliminar3.setText("Eliminar");
        btnEliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar3ActionPerformed(evt);
            }
        });

        btnGuardar3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnGuardar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434608001_save_as-2.png"))); // NOI18N
        btnGuardar3.setText("Guardar");
        btnGuardar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar3ActionPerformed(evt);
            }
        });

        btnModificar3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnModificar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434857547_001_45.png"))); // NOI18N
        btnModificar3.setText("Modificar");
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });

        btnConsultar3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnConsultar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434664469_edit-clear.png"))); // NOI18N
        btnConsultar3.setText("Nuevo");
        btnConsultar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar3ActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnModificar3)
                        .addComponent(btnEliminar3)
                        .addComponent(btnGuardar3, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnConsultar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar3)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addComponent(btnConsultar3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla6MouseClicked
        Integer id = (Integer) tabla6.getValueAt(tabla6.getSelectedRow(), 0);
        String id2 = (String) tabla6.getValueAt(tabla6.getSelectedRow(),1);       
        
        txtcodigo.setText(Integer.toString(id));
        txtdepto.setText(id2);
    }//GEN-LAST:event_tabla6MouseClicked

    private void btnEliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar3ActionPerformed
        // TODO add your handling code here:
            Metodos_Tipos obj = new Metodos_Tipos();
            obj.setSql("DELETE FROM tipo_usuario where id_tipousuario = ?");
            int eliminar = JOptionPane.showConfirmDialog(this, "Esta seguro que desea eliminar?", "Atencion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(eliminar == 0){
                if(obj.eliminar_Tipos()){
                    DefaultTableModel modelo=(DefaultTableModel) tabla6.getModel();
                    int filas=tabla6.getRowCount();
                    for (int i = 0;filas>i; i++) {
                        modelo.removeRow(0);
                    }
                    Consultas frm4 = new Consultas();
                    frm4.Tabla6U();
                    JOptionPane.showMessageDialog(this, "Datos elminados con exito");
                }
                else{
                    JOptionPane.showMessageDialog(this,"Error al intentar elminiar datos");
                }
                limpiar_tipos();
                obj.setSql(null);
            }
    }//GEN-LAST:event_btnEliminar3ActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed
        // TODO add your handling code here:
        Metodos_Tipos obj = new Metodos_Tipos();
        obj.setSql("UPDATE tipo_usuario SET nombre_TipoU = ? where id_tipousuario = ?");
        if(obj.modificar_Tipos()){
            DefaultTableModel modelo=(DefaultTableModel) tabla6.getModel();
            int filas=tabla6.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
            Consultas frm4 = new Consultas();
            frm4.Tabla6U();
            JOptionPane.showMessageDialog(this,"Datos modificados con exito");
        }
        else{
            JOptionPane.showMessageDialog(this, "Error al intentar modificar datos");
        }
        limpiar_tipos();
        obj.setSql(null);
    }//GEN-LAST:event_btnModificar3ActionPerformed

    private void btnConsultar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar3ActionPerformed
        limpiar_tipos();
    }//GEN-LAST:event_btnConsultar3ActionPerformed

    private void btnGuardar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar3ActionPerformed

        Metodos_Tipos obj = new Metodos_Tipos();
        obj.setSql("INSERT INTO tipo_usuario(nombre_TipoU) values(?)");
        if(obj.guardar_Tipos()){
            DefaultTableModel modelo=(DefaultTableModel) tabla6.getModel();
            int filas=tabla6.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
            Consultas frm4 = new Consultas();
            frm4.Tabla6U();
            JOptionPane.showMessageDialog(this,"Datos guardados con exito");
        }
        else{
            JOptionPane.showMessageDialog(this, "Error al intentar guardar datos");
        }
        limpiar_tipos();
        obj.setSql(null);
    }//GEN-LAST:event_btnGuardar3ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        PrincipalAdministrador frm = new PrincipalAdministrador();
        frm.show();
        this.hide();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        Login frm = new Login();
        frm.show();
        this.hide();
    }//GEN-LAST:event_jMenu1ActionPerformed

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
//            java.util.logging.Logger.getLogger(areas_trabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(areas_trabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(areas_trabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(areas_trabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {  
                JFrame.setDefaultLookAndFeelDecorated(true);
                new areas_trabajo().setVisible(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistAquaSkin"); 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar3;
    private javax.swing.JButton btnEliminar3;
    private javax.swing.JButton btnGuardar3;
    private javax.swing.JButton btnModificar3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tabla6;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdepto;
    // End of variables declaration//GEN-END:variables
}
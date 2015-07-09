/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;
import Clases.mthestados2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jvnet.substance.SubstanceLookAndFeel;
import ptc.Login;

/**
 *
 * @author oscar
 */
public class estadopropiedad extends javax.swing.JFrame {

    /**
     * Creates new form estadopropiedad
     */
    public estadopropiedad() {
        initComponents();
        mthestados2 para_actualizar = new mthestados2();
        para_actualizar.tabla_estadopropi();
        Sletras(txtestadopropi);
        this.setLocationRelativeTo(null);
        this.setTitle("Estados de propiedad");//titulo 
        this.setResizable(false);
        this.getContentPane().setBackground(new java.awt.Color(0,0,102));//color dee fondo 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnEliminar_TU = new javax.swing.JButton();
        btnLimpiar_TU = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigopropi = new javax.swing.JTextField();
        txtestadopropi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaestadopropi = new javax.swing.JTable();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGuardar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434608001_save_as-2.png"))); // NOI18N
        btnGuardar.setText("guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434857547_001_45.png"))); // NOI18N
        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnEliminar_TU.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEliminar_TU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434841655_f-cross_256.png"))); // NOI18N
        btnEliminar_TU.setText("Eliminar");
        btnEliminar_TU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_TUActionPerformed(evt);
            }
        });

        btnLimpiar_TU.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpiar_TU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434664469_edit-clear.png"))); // NOI18N
        btnLimpiar_TU.setText("Nuevo");
        btnLimpiar_TU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar_TUActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado de propiedad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");

        txtcodigopropi.setEditable(false);
        txtcodigopropi.setEnabled(false);

        txtestadopropi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtestadopropiKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtestadopropiKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcodigopropi, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtestadopropi, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcodigopropi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtestadopropi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(36, 36, 36))
        );

        tablaestadopropi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaestadopropi.getTableHeader().setReorderingAllowed(false);
        tablaestadopropi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaestadopropiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaestadopropi);
        if (tablaestadopropi.getColumnModel().getColumnCount() > 0) {
            tablaestadopropi.getColumnModel().getColumn(0).setMinWidth(0);
            tablaestadopropi.getColumnModel().getColumn(0).setMaxWidth(0);
            tablaestadopropi.getColumnModel().getColumn(1).setResizable(false);
        }

        jMenuBar2.setBackground(new java.awt.Color(9, 61, 163));

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434854150_exit.png"))); // NOI18N
        jMenu4.setText("Cerrar sesion");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenuBar2.add(jMenu4);

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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar_TU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar_TU, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(btnEliminar_TU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar_TU))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //metodo para validar solo letras
    public void Sletras(JTextField a){
        a.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e){
            char c=e.getKeyChar();
            if(!Character.isLetter(c) && !Character.isWhitespace(c)){
                getToolkit().beep();
                e.consume();
            }
        }
      
        });
    }
    
    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        Login frm = new Login();
        frm.show();
        this.hide();
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        PrincipalAdministrador frm = new PrincipalAdministrador();
        frm.show();
        this.hide();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(!txtestadopropi.getText().isEmpty())
        {

            mthestados2 obj = new mthestados2();

            obj.setNombre(txtestadopropi.getText());
            obj.setConsulta("insert into estado_propi(nombre_estadopropi) values(?)");
            if(obj.guardar_estado())
            {
                //Este metodo es para volver el modelo de la tabla a como era al inicio, entonces la clase toma el modelo y vuelve a cargar los datos ya actualizados
                try {
                    DefaultTableModel modelo=(DefaultTableModel) tablaestadopropi.getModel();
                    int filas=tablaestadopropi.getRowCount();
                    for (int i = 0;filas>i; i++) {
                        modelo.removeRow(0);
                    }
                    mthestados2 para_actualizar = new mthestados2();
                    para_actualizar.tabla_estadopropi();
                    limpiar();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
                }
                JOptionPane.showMessageDialog(this, "Datos guardados");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error al guardar datos");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        //boton para modificar
        if(!txtcodigopropi.getText().isEmpty())
        {
            if(!txtestadopropi.getText().isEmpty())
            {

                //Se selecciona el dato del comobobox que tiene el id segun el indice del combobox que se puede ver

                mthestados2 obj = new mthestados2();
                obj.setCodigo(Integer.parseInt(txtcodigopropi.getText()));
                obj.setNombre(txtestadopropi.getText());
                obj.setConsulta("update estado_propi set nombre_estadopropi=? where id_estadopropi=?");
                if(obj.modify_estado())
                {
                    try {
                        DefaultTableModel modelo=(DefaultTableModel) tablaestadopropi.getModel();
                        int filas=tablaestadopropi.getRowCount();
                        for (int i = 0;filas>i; i++) {
                            modelo.removeRow(0);
                        }
                        mthestados2 para_actualizar = new mthestados2();
                        para_actualizar.tabla_estadopropi();
                        limpiar();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
                    }
                    JOptionPane.showMessageDialog(this, "Datos Modificados");

                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Error al modificar datos");
                }

            }
            else
            {
                JOptionPane.showMessageDialog(this, "Por favor asegurese de llenar todos los campos");
            }

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un usuario a modificar");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnEliminar_TUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_TUActionPerformed
        // TODO add your handling code here:

        //Boton eliminar
        if(!txtcodigopropi.getText().isEmpty())
        {
            mthestados2 obj = new mthestados2();
            obj.setCodigo(Integer.parseInt(txtcodigopropi.getText()));
            obj.setConsulta("delete from estado_propi where id_estadopropi = ?");
            int eliminar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(eliminar == 0) {
                if(obj.delete_estado())
                {
                    try {
                        DefaultTableModel modelo=(DefaultTableModel) tablaestadopropi.getModel();
                        int filas=tablaestadopropi.getRowCount();
                        for (int i = 0;filas>i; i++) {
                            modelo.removeRow(0);
                        }
                        mthestados2 para_actualizar = new mthestados2();
                        para_actualizar.tabla_estadopropi();
                        limpiar();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
                    }
                    JOptionPane.showMessageDialog(this, "Datos Eliminados");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Error al eliminar datos");
                }
            }

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un usuario para eliminar");
        }
    }//GEN-LAST:event_btnEliminar_TUActionPerformed

    private void btnLimpiar_TUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar_TUActionPerformed
        // TODO add your handling code here:
        limpiar();//se realiza el metodo limpiar
    }//GEN-LAST:event_btnLimpiar_TUActionPerformed

    private void txtestadopropiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtestadopropiKeyPressed

    }//GEN-LAST:event_txtestadopropiKeyPressed

    private void txtestadopropiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtestadopropiKeyTyped

    }//GEN-LAST:event_txtestadopropiKeyTyped

    private void tablaestadopropiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaestadopropiMouseClicked
        Integer ID = (Integer) tablaestadopropi.getValueAt(tablaestadopropi.getSelectedRow(), 0);
        String Nombre = (String) tablaestadopropi.getValueAt(tablaestadopropi.getSelectedRow(), 1);

        txtcodigopropi.setText(ID.toString());
        txtestadopropi.setText(Nombre);
    }//GEN-LAST:event_tablaestadopropiMouseClicked

    private void limpiar(){
        txtcodigopropi.setText(null);
        txtestadopropi.setText(null);
    }
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
//            java.util.logging.Logger.getLogger(estadopropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(estadopropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(estadopropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(estadopropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new estadopropiedad().setVisible(true);
                JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistAquaSkin");    //seaplica la libreria de look and feel
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar_TU;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar_TU;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaestadopropi;
    private javax.swing.JTextField txtcodigopropi;
    private javax.swing.JTextField txtestadopropi;
    // End of variables declaration//GEN-END:variables
}

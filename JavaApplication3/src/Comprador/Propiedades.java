/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comprador;

import org.jvnet.substance.SubstanceLookAndFeel;


import Vendedor.PrincipalVendedor;
import Clases.Consultas;
import static Clases.Consultas.cn;
import Clases.Galeria;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.nio.channels.FileChannel;
import javax.swing.table.TableColumn;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Date;
import ptc.Login;

/**
 *
 * @author Eduardo López
 */
public class Propiedades extends javax.swing.JFrame {

    
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de imagen", "jpg", "png");
    String rutaimagen;
    
    double valor, valor2, valor3;
    int contador = -1;
    
     Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("MM/"+ "dd"+ "/yyyy");
        String fecha3 = formato.format(fecha);
        
    
    //Validacion de solo letras, quitar espacios en blanco y simbolos 
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


//Validacion de solo numeros, quitar espacios en blanco y simbolos    
public void Snumeros(JTextField a){
        a.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e){
            char c=e.getKeyChar();
            if(Character.isLetter(c)){
                getToolkit().beep();
                e.consume();
            }
            if(Character.isWhitespace(c)){
                getToolkit().beep();
                e.consume();
            }
        }
      
        });
    }

public void Snumeros4(JTextField a){
        a.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e){
            char c=e.getKeyChar();
            if(!Character.isDigit(c) || Character.isLetter(c)){
                getToolkit().beep();
                e.consume();
            }
        }
      
        });
                }            

private Timer t;//clase timer q permite controlar los tiempos de una accion
    private ActionListener al;//permite controlar los eventes q se realizaran en las seccines de tiempo de timer

//Metodo para limpiar los campos
private void limpiar(){
            txtcodigo.setText(null);
            cmbdepa.setSelectedIndex(0);
            cmbmuni.setSelectedIndex(0);
            cmbtipo.setSelectedIndex(0);
        cmbestado.setSelectedIndex(0);
        txtdimensiones.setText("");
        txtubicacion.setText("");
        txtdescripcion.setText("");
        txtprecio.setText("");
        txtprima.setText("");    
        txtruta2.setText("");
        txtruta.setText(null); 
        txtfoto.setIcon(null);
        progreso.setValue(0);
        txtesta.setText(null);
        txtfecha.setText(null);
        if(Consultas.tipoU == 2){
                btnconsultar.setVisible(false);  
        btnguardar.setVisible(true);
        } //Condicion para el cargo del vendedor
        else if(Consultas.tipoU == 1){
            
        }
        else if(Consultas.tipoU == 0){
             
        }
        cmbunidad.setSelectedIndex(0);
        btncambiar1.setVisible(false);
        btncambiar2.setVisible(false);
        btncambiar3.setVisible(false);
        btncambiar4.setVisible(false);
        btncambiar5.setVisible(false);
        btncammbiar6.setVisible(false); 
        
        Galeria frm6 = new Galeria();
        frm6.limpiar();
        t.stop();
        Consultas obj = new Consultas();
        //Se guarda el URL en caso de no estar disponible la imagen.
            String path = "/imagenes/no_disponible.jpg";
            //En el url se obtiene lo que esta en el paquete.
            URL url = this.getClass().getResource(path);
            //Se transforma el URL en una imagen de icono.
            ImageIcon icon = new ImageIcon(url);
            //Modificamos la imagen.
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(350, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            txtfoto.setIcon(newIcon);
}

Consultas frm = new Consultas();

    public Propiedades() {
        initComponents();
        this.setSize(875, 710);        
      
        //Condicion que sirve para habilitar o desabilitar opciones de usuarios.
        try{
            //Condicion para el cargo de Comprador.
            if(Consultas.tipoU == 2){

        } //Condicion para el cargo del vendedor
        else if(Consultas.tipoU == 1){
            btnguardar.setVisible(false);
            btneliminar.setVisible(false);
            btnnuevo.setVisible(false);
            btnconsultar.setVisible(false);
            txtdimensiones.disable();
        txtubicacion.disable();
        txtdescripcion.disable();
        txtprecio.disable();
        txtprima.disable();
        agregarimg.setVisible(false);
        btnmaxi.setText("Visualizar la Galeria"); 
        }
        else if(Consultas.tipoU == 0){
            btnguardar.setVisible(false);
            btneliminar.setVisible(false);
            btnnuevo.setVisible(false);
            btnconsultar.setVisible(false);
            txtdimensiones.disable();
        txtubicacion.disable();
        txtdescripcion.disable();
        txtprecio.disable();
        txtprima.disable();  
        }
        }
        catch(Exception e){
            
        }
        Consultas frm = new Consultas();
        frm.combo11();
        Snumeros4(txtprecio1);
        Snumeros4(txtprecio2); 
        btnconsultar.setVisible(false);  
        btneliminar.setVisible(false);
        btnmini.setVisible(false); 
        al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
            if (progreso.getValue() < 100)//mientras que el valor de la progresbar sea menor a 100 q es su maximo valor, eso lo podes ver en sus propiedades en maximuno algo asi
              {
                    progreso.setValue(progreso.getValue()+3);// se le asigna un valor al progressbar "progreso", se obtine el valor q tiene actualmente y le aumenta 3 cada ves q pasa un segundo
                    //que es el tiempo q se le a puesto al timer
                    
                }else{
                progreso.setValue(0);
                Consultas obj = new Consultas();
                contador++; 
        if(contador == Integer.parseInt(txtruta2.getText())){
            contador = 0;
        }
        obj.tabla6(contador); 
            }
            }
        };
        t = new Timer(50, al);//el timer recibe como parametro dos valores, el tiempo de retraso o tiempo de secuencia , en este caso vamos a hacer q avance cada
        //1000 milisegundos que equivale a 1 segundo, y el siguiente parametro q seria el actionlistener que equivaldria a la accion q se realizara en esos lapsos de tiempo
       
        Galeria frm3 = new Galeria();
        frm3.nodis();
        
        rutaimagen="";
        //Pone el formulario en medio.
        this.setLocationRelativeTo(null);
        //Pone el titulo del formulario
        this.setTitle("Inmuebles");
        //La funcion es queno pueda cambiar el tamaño del formulario.
        this.setResizable(false);
        //Pone el color del formulario llamando al metodo jpColor.
       
        
        //Funcion que hace que los JTextField esten validados con los metodos de validacion de letras o numeros
        Snumeros(txtcodigo);
        Snumeros(txtprecio);
        Snumeros(txtprima);
        //Mando a llamar el metodo para cargar combobox y la tabla en la clase Consultas.
        frm.combo();
        frm.Tabla1();
        
        txtruta.setText("");
        txtruta2.setText("");
        txtruta.setVisible(false);
        txtruta2.setVisible(false);
        txtruta1.setVisible(false); 
        txtruta2.setVisible(false);
        txtruta3.setVisible(false);
        txtruta4.setVisible(false);
        txtruta5.setVisible(false);
        txtruta6.setVisible(false);
        txtnom1.setVisible(false);
        txtnom2.setVisible(false);
        txtnom3.setVisible(false);
        txtnom4.setVisible(false);
        txtnom5.setVisible(false); 
        txtnom6.setVisible(false);
        txtnum1.setVisible(false);
        txtnum2.setVisible(false);
        txtnum3.setVisible(false);
        txtnum4.setVisible(false);
        txtnum5.setVisible(false); 
        txtnum6.setVisible(false);
        txtruta7.setVisible(false);
        
        btncambiar1.setVisible(false);
        btncambiar2.setVisible(false);
        btncambiar3.setVisible(false);
        btncambiar4.setVisible(false);
        btncambiar5.setVisible(false);
        btncammbiar6.setVisible(false);
        Snumeros(txtubicacion);
        
        //Se guarda el URL en caso de no estar disponible la imagen.
        String path = "/imagenes/no_disponible.jpg"; 
        //En el url se obtiene lo que esta en el paquete.
        URL url = this.getClass().getResource(path);
        //Se transforma el URL en una imagen de icono.
        ImageIcon icon = new ImageIcon(url);  
        //Modificamos la imagen.
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(350, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            txtfoto.setIcon(newIcon);
        
        //Se guardo el tipo de usuario en la clase Consulta para obtener el perfil del usuario en sesion.
            
        
 }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        formulario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblfoto1 = new javax.swing.JLabel();
        lblfoto4 = new javax.swing.JLabel();
        lblfoto2 = new javax.swing.JLabel();
        lblfoto5 = new javax.swing.JLabel();
        lblfoto3 = new javax.swing.JLabel();
        lblfoto6 = new javax.swing.JLabel();
        txtruta6 = new javax.swing.JTextField();
        txtnom6 = new javax.swing.JTextField();
        txtnum6 = new javax.swing.JTextField();
        txtnum3 = new javax.swing.JTextField();
        txtnom3 = new javax.swing.JTextField();
        txtruta3 = new javax.swing.JTextField();
        txtruta5 = new javax.swing.JTextField();
        txtnom5 = new javax.swing.JTextField();
        txtnum5 = new javax.swing.JTextField();
        txtruta4 = new javax.swing.JTextField();
        txtnom2 = new javax.swing.JTextField();
        txtnum2 = new javax.swing.JTextField();
        txtruta7 = new javax.swing.JTextField();
        txtnom4 = new javax.swing.JTextField();
        txtnum4 = new javax.swing.JTextField();
        txtruta1 = new javax.swing.JTextField();
        txtnom1 = new javax.swing.JTextField();
        txtnum1 = new javax.swing.JTextField();
        btncambiar1 = new javax.swing.JButton();
        btncambiar2 = new javax.swing.JButton();
        btncambiar3 = new javax.swing.JButton();
        btncambiar4 = new javax.swing.JButton();
        btncambiar5 = new javax.swing.JButton();
        btncammbiar6 = new javax.swing.JButton();
        agregarimg = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtprima = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtdimensiones = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtubicacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbestado = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbtipo = new javax.swing.JComboBox();
        Propiedad = new javax.swing.JLabel();
        cmbmuni = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cmbdepa = new javax.swing.JComboBox();
        Propiedad2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbunidad = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        txtfecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtesta = new javax.swing.JTextField();
        txtruta2 = new javax.swing.JTextField();
        txtfoto = new javax.swing.JLabel();
        btnmini = new javax.swing.JButton();
        btnmaxi = new javax.swing.JButton();
        progreso = new javax.swing.JProgressBar();
        txtruta = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        btnconsultar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnnuevo1 = new javax.swing.JButton();
        pesta1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        tabla5 = new javax.swing.JPanel();
        Propiedad3 = new javax.swing.JLabel();
        cmbdepa1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cmbmuni1 = new javax.swing.JComboBox();
        cmbestado1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cmbtipo1 = new javax.swing.JComboBox();
        Propiedad4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Propiedad5 = new javax.swing.JLabel();
        txtprecio2 = new javax.swing.JTextField();
        Propiedad6 = new javax.swing.JLabel();
        txtprecio1 = new javax.swing.JTextField();
        menu = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        formulario.setBackground(new java.awt.Color(0, 0, 102));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblfoto1.setBackground(new java.awt.Color(102, 0, 204));
        lblfoto1.setForeground(new java.awt.Color(255, 0, 51));
        lblfoto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lblfoto1.setMaximumSize(new java.awt.Dimension(100, 100));
        lblfoto1.setMinimumSize(new java.awt.Dimension(100, 100));
        lblfoto1.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.add(lblfoto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 200, 200));

        lblfoto4.setBackground(new java.awt.Color(102, 0, 204));
        lblfoto4.setForeground(new java.awt.Color(255, 0, 51));
        lblfoto4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lblfoto4.setMaximumSize(new java.awt.Dimension(100, 100));
        lblfoto4.setMinimumSize(new java.awt.Dimension(100, 100));
        lblfoto4.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.add(lblfoto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 200, 200));

        lblfoto2.setBackground(new java.awt.Color(102, 0, 204));
        lblfoto2.setForeground(new java.awt.Color(255, 0, 51));
        lblfoto2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lblfoto2.setMaximumSize(new java.awt.Dimension(100, 100));
        lblfoto2.setMinimumSize(new java.awt.Dimension(100, 100));
        lblfoto2.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.add(lblfoto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 200, 200));

        lblfoto5.setBackground(new java.awt.Color(102, 0, 204));
        lblfoto5.setForeground(new java.awt.Color(255, 0, 51));
        lblfoto5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lblfoto5.setMaximumSize(new java.awt.Dimension(100, 100));
        lblfoto5.setMinimumSize(new java.awt.Dimension(100, 100));
        lblfoto5.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.add(lblfoto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 730, 200, 200));

        lblfoto3.setBackground(new java.awt.Color(102, 0, 204));
        lblfoto3.setForeground(new java.awt.Color(255, 0, 51));
        lblfoto3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lblfoto3.setMaximumSize(new java.awt.Dimension(100, 100));
        lblfoto3.setMinimumSize(new java.awt.Dimension(100, 100));
        lblfoto3.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.add(lblfoto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 970, 200, 200));

        lblfoto6.setBackground(new java.awt.Color(102, 0, 204));
        lblfoto6.setForeground(new java.awt.Color(255, 0, 51));
        lblfoto6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lblfoto6.setMaximumSize(new java.awt.Dimension(100, 100));
        lblfoto6.setMinimumSize(new java.awt.Dimension(100, 100));
        lblfoto6.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.add(lblfoto6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1210, 200, 200));

        txtruta6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtruta6ActionPerformed(evt);
            }
        });
        jPanel1.add(txtruta6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 1218, 40, -1));

        txtnom6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom6ActionPerformed(evt);
            }
        });
        jPanel1.add(txtnom6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 1188, 30, -1));
        jPanel1.add(txtnum6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 1158, 30, -1));
        jPanel1.add(txtnum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 941, 30, -1));

        txtnom3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom3ActionPerformed(evt);
            }
        });
        jPanel1.add(txtnom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 1001, 30, -1));

        txtruta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtruta3ActionPerformed(evt);
            }
        });
        jPanel1.add(txtruta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 971, 30, -1));

        txtruta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtruta5ActionPerformed(evt);
            }
        });
        jPanel1.add(txtruta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 665, 30, -1));

        txtnom5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom5ActionPerformed(evt);
            }
        });
        jPanel1.add(txtnom5, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 725, 30, -1));
        jPanel1.add(txtnum5, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 695, 30, -1));

        txtruta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtruta4ActionPerformed(evt);
            }
        });
        jPanel1.add(txtruta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 517, 30, -1));

        txtnom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom2ActionPerformed(evt);
            }
        });
        jPanel1.add(txtnom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 487, 30, -1));
        jPanel1.add(txtnum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 447, 30, -1));

        txtruta7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtruta7ActionPerformed(evt);
            }
        });
        jPanel1.add(txtruta7, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 299, 30, -1));

        txtnom4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom4ActionPerformed(evt);
            }
        });
        jPanel1.add(txtnom4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 269, 40, -1));
        jPanel1.add(txtnum4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 229, 30, -1));

        txtruta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtruta1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtruta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 71, 30, -1));

        txtnom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtnom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 41, 30, -1));
        jPanel1.add(txtnum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 11, 30, -1));

        btncambiar1.setText("Cambiar");
        btncambiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambiar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btncambiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        btncambiar2.setText("Cambiar");
        btncambiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambiar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btncambiar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, -1, -1));

        btncambiar3.setText("Cambiar");
        btncambiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambiar3ActionPerformed(evt);
            }
        });
        jPanel1.add(btncambiar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 700, -1, -1));

        btncambiar4.setText("Cambiar");
        btncambiar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambiar4ActionPerformed(evt);
            }
        });
        jPanel1.add(btncambiar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 940, -1, -1));

        btncambiar5.setText("Cambiar");
        btncambiar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambiar5ActionPerformed(evt);
            }
        });
        jPanel1.add(btncambiar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1180, -1, -1));

        btncammbiar6.setText("Cambiar");
        btncammbiar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncammbiar6ActionPerformed(evt);
            }
        });
        jPanel1.add(btncammbiar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1420, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        agregarimg.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        agregarimg.setForeground(new java.awt.Color(255, 255, 255));
        agregarimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434610269_old-edit-find.png"))); // NOI18N
        agregarimg.setText("Agregar Imagenes");
        agregarimg.setContentAreaFilled(false);
        agregarimg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarimgActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtprima.setEditable(false);
        jPanel2.add(txtprima, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 600, 82, -1));

        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });
        jPanel2.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 82, -1));

        txtdescripcion.setColumns(2);
        txtdescripcion.setLineWrap(true);
        txtdescripcion.setRows(2);
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtdescripcion);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 210, 122));

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descripcion:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        txtdimensiones.setColumns(5);
        txtdimensiones.setLineWrap(true);
        txtdimensiones.setRows(5);
        txtdimensiones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdimensionesKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txtdimensiones);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 210, 120));

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ubicación:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        txtubicacion.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txtubicacionComponentAdded(evt);
            }
        });
        txtubicacion.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtubicacionAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtubicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtubicacionKeyTyped(evt);
            }
        });
        jPanel2.add(txtubicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 100, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dimensiones:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        cmbestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione estado" }));
        cmbestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbestadoActionPerformed(evt);
            }
        });
        jPanel2.add(cmbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 213, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Estado:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        cmbtipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el Tipo" }));
        cmbtipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbtipoItemStateChanged(evt);
            }
        });
        cmbtipo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                cmbtipoPopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbtipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbtipoMouseClicked(evt);
            }
        });
        cmbtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtipoActionPerformed(evt);
            }
        });
        jPanel2.add(cmbtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 213, -1));

        Propiedad.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        Propiedad.setForeground(new java.awt.Color(255, 255, 255));
        Propiedad.setText("Tipo de propiedad:");
        jPanel2.add(Propiedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        cmbmuni.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione municipio" }));
        cmbmuni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbmuniActionPerformed(evt);
            }
        });
        jPanel2.add(cmbmuni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 213, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Municipios:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        cmbdepa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el departamento" }));
        cmbdepa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbdepaItemStateChanged(evt);
            }
        });
        cmbdepa.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                cmbdepaPopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbdepa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbdepaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmbdepaMouseEntered(evt);
            }
        });
        cmbdepa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdepaActionPerformed(evt);
            }
        });
        jPanel2.add(cmbdepa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 213, -1));

        Propiedad2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        Propiedad2.setForeground(new java.awt.Color(255, 255, 255));
        Propiedad2.setText("Departamentos:");
        jPanel2.add(Propiedad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Precio $:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Prima $:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, -1, -1));

        cmbunidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jPanel2.add(cmbunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 90, -1));

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtfecha.setEditable(false);
        jPanel3.add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 20));

        jLabel6.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha de registro:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));
        jPanel3.add(txtesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 60, -1));
        jPanel3.add(txtruta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 104, -1));

        txtfoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(txtfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 350, 200));

        btnmini.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btnmini.setText("Minimizar la galeria");
        btnmini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnminiActionPerformed(evt);
            }
        });
        jPanel3.add(btnmini, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        btnmaxi.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btnmaxi.setText("Visualizar o agregar imagenes");
        btnmaxi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmaxiActionPerformed(evt);
            }
        });
        jPanel3.add(btnmaxi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));
        jPanel3.add(progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 110, -1));

        txtruta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrutaKeyTyped(evt);
            }
        });
        jPanel3.add(txtruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 65, -1));
        jPanel3.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 41, -1));

        btnconsultar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnconsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434665191_undo.png"))); // NOI18N
        btnconsultar.setText("Modificar");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });
        jPanel3.add(btnconsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 140, 40));

        btnguardar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434608001_save_as-2.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 130, 40));

        btneliminar.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 100, 30));

        btnnuevo.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434664469_edit-clear.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 140, -1));

        btnnuevo1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnnuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434607676_system-software-update.png"))); // NOI18N
        btnnuevo1.setText("Actualizar");
        btnnuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevo1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnnuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 150, 40));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Departamento", "Municipio", "Tipo Propiedad", "Estado", "Dimensiones", "Ubicacion", "Unidad", "Descripcion", "Precio", "Prima", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setOpaque(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(4).setResizable(false);
            tabla.getColumnModel().getColumn(5).setResizable(false);
            tabla.getColumnModel().getColumn(6).setResizable(false);
            tabla.getColumnModel().getColumn(7).setResizable(false);
            tabla.getColumnModel().getColumn(8).setResizable(false);
            tabla.getColumnModel().getColumn(9).setResizable(false);
            tabla.getColumnModel().getColumn(10).setResizable(false);
            tabla.getColumnModel().getColumn(11).setResizable(false);
        }

        pesta1.addTab("Inmuebles", jScrollPane3);

        tabla5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        tabla5.setDoubleBuffered(false);
        tabla5.setOpaque(false);
        tabla5.setRequestFocusEnabled(false);
        tabla5.setVerifyInputWhenFocusTarget(false);
        tabla5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Propiedad3.setForeground(new java.awt.Color(255, 255, 255));
        Propiedad3.setText("Departamentos:");
        tabla5.add(Propiedad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        cmbdepa1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmbdepa1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbdepa1ItemStateChanged(evt);
            }
        });
        cmbdepa1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                cmbdepa1PopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbdepa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbdepa1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmbdepa1MouseEntered(evt);
            }
        });
        cmbdepa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdepa1ActionPerformed(evt);
            }
        });
        tabla5.add(cmbdepa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 150, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Municipios:");
        tabla5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        cmbmuni1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmbmuni1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbmuni1ActionPerformed(evt);
            }
        });
        tabla5.add(cmbmuni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, -1));

        cmbestado1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmbestado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbestado1ActionPerformed(evt);
            }
        });
        tabla5.add(cmbestado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 160, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Estado:");
        tabla5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        cmbtipo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmbtipo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbtipo1ItemStateChanged(evt);
            }
        });
        cmbtipo1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                cmbtipo1PopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbtipo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbtipo1MouseClicked(evt);
            }
        });
        cmbtipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtipo1ActionPerformed(evt);
            }
        });
        tabla5.add(cmbtipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 160, -1));

        Propiedad4.setForeground(new java.awt.Color(255, 255, 255));
        Propiedad4.setText("a");
        tabla5.add(Propiedad4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 20, 20));

        jButton4.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434610269_old-edit-find.png"))); // NOI18N
        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        tabla5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jButton3.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434664469_edit-clear.png"))); // NOI18N
        jButton3.setText("Limpiar Campos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        tabla5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, 40));

        Propiedad5.setForeground(new java.awt.Color(255, 255, 255));
        Propiedad5.setText("Tipo de propiedad:");
        tabla5.add(Propiedad5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));
        tabla5.add(txtprecio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 50, -1));

        Propiedad6.setForeground(new java.awt.Color(255, 255, 255));
        Propiedad6.setText("Rango de Precio");
        tabla5.add(Propiedad6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, 20));
        tabla5.add(txtprecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 50, -1));

        pesta1.addTab("Busquedas Avanzadas", tabla5);

        javax.swing.GroupLayout formularioLayout = new javax.swing.GroupLayout(formulario);
        formulario.setLayout(formularioLayout);
        formularioLayout.setHorizontalGroup(
            formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formularioLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pesta1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formularioLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(agregarimg))))
        );
        formularioLayout.setVerticalGroup(
            formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formularioLayout.createSequentialGroup()
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formularioLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(pesta1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(formularioLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(agregarimg)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        menu.setBackground(new java.awt.Color(153, 0, 153));

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/1434854150_exit.png"))); // NOI18N
        jMenu2.setText("Cerrar sesion");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        menu.add(jMenu2);

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
        menu.add(jMenu3);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formulario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdimensionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdimensionesKeyTyped
        //Se valida que no se ingresen caracteres especiales por medio del numero CODIGO ASCII.
        //Que pueden encontrar el codigo de  cada tecla o caracter en la siguiente URL:
        //http://www.elcodigoascii.com.ar/codigos-ascii/punto-codigo-ascii-46.html.
        char C= evt.getKeyChar();
        if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=43
            ||(int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
            || (int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96
            || (int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=255)
        {
            //Funcion para emitir sonido al ingresar funciones especiales.
            getToolkit().beep();
            //Funcion que borra los caracteres o funciones especiales que se ingresan.
            evt.consume();
        }
    }//GEN-LAST:event_txtdimensionesKeyTyped

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
       
        //Se valida que no se ingresen caracteres especiales por medio del numero CODIGO ASCII.
        //Que pueden encontrar el codigo de  cada tecla o caracter en la siguiente URL:
        //http://www.elcodigoascii.com.ar/codigos-ascii/punto-codigo-ascii-46.html.
        char C= evt.getKeyChar();
        if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
            || (int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96
            || (int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=255)
        {
            //Funcion para emitir sonido al ingresar funciones especiales.
            getToolkit().beep();
            //Funcion que borra los caracteres o funciones especiales que se ingresan.
            evt.consume();
        }
    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtprecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyPressed
        //DecimalFormat siver para validar el numero de decimales que se ingresan u obtienen.
        DecimalFormat decimales = new DecimalFormat("0");
        DecimalFormat decimales2 = new DecimalFormat("0");
        //Se valida que cuando el JTextField precio este vacio se borre automaticamente JTextField prima.
        if(!txtprecio.getText().isEmpty()){
            valor = Double.parseDouble(((txtprecio.getText())));
            //Se hace la operacion para obtener la prima con el dato de precio.
            valor2 = valor * 0.15;
            //Se despliegan automaticamente los valores en el campo precio y prima conforme se escribe una cantidad en el campo precio.
            txtprima.setText(decimales.format(valor2));
            txtprecio.setText(decimales2.format(valor));
        }
        else{
            //Se borra los datos en el campo prima si el campo precio esta vacio.
            txtprima.setText(null);
        }
    }//GEN-LAST:event_txtprecioKeyPressed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        
    }//GEN-LAST:event_txtprecioActionPerformed

    private void txtdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyTyped
        //Se valida que no se ingresen caracteres especiales por medio del numero CODIGO ASCII.
        //Que pueden encontrar el codigo de  cada tecla o caracter en la siguiente URL:
        //http://www.elcodigoascii.com.ar/codigos-ascii/punto-codigo-ascii-46.html.
        char C= evt.getKeyChar();
        if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=43
            ||(int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
            || (int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96
            || (int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=255)
        {
            //Funcion para emitir sonido al ingresar funciones especiales.
            getToolkit().beep();
            //Funcion que borra los caracteres o funciones especiales que se ingresan.
            evt.consume();
        }
    }//GEN-LAST:event_txtdescripcionKeyTyped

    private void txtubicacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtubicacionKeyTyped
        //Se valida que no se ingresen caracteres especiales por medio del numero CODIGO ASCII.
        //Que pueden encontrar el codigo de  cada tecla o caracter en la siguiente URL:
        //http://www.elcodigoascii.com.ar/codigos-ascii/punto-codigo-ascii-46.html.
        char C= evt.getKeyChar();
        if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=45
            ||(int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
            || (int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96
            || (int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=255)
        {
            //Funcion para emitir sonido al ingresar funciones especiales.
            getToolkit().beep();
            //Funcion que borra los caracteres o funciones especiales que se ingresan.
            evt.consume();
        }
    }//GEN-LAST:event_txtubicacionKeyTyped

    private void txtrutaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrutaKeyTyped

    }//GEN-LAST:event_txtrutaKeyTyped

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        
        //Se valida que se haya seleccionado una propiedad o inmueble.
        if(txtcodigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Inmueble");
        }else{
            //Se valida que los campos que se quieren modificar no queden vacios.
            if( cmbdepa.getSelectedIndex() == 0
                || cmbmuni.getSelectedIndex() == 0 || cmbtipo.getSelectedIndex() == 0
                || cmbestado.getSelectedIndex() == 0 || txtdimensiones.getText().isEmpty()
                || txtubicacion.getText().isEmpty() || txtdescripcion.getText().isEmpty()
                || txtprecio.getText().isEmpty() || txtprima.getText().isEmpty() || cmbunidad.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos");
            }
            else{
                //Se manda a llamar a la clase Consultar.
                Consultas obj = new Consultas();
                //Se obtienen todos los valores a ingresar para mandarlos a la clase Consulta y hacer la operacion                obj.setDepartamento((String) cmbdepa.getSelectedItem());
                obj.setTipoP(cmbtipo.getSelectedIndex());
                obj.setEstado(cmbestado.getSelectedIndex());
                obj.setUbicacion(txtubicacion.getText());
                obj.setDimensiones(txtdimensiones.getText());
                obj.setDescripcion(txtdescripcion.getText());
                obj.setPrecio(txtprecio.getText());
                obj.setPrima(txtprima.getText());
                obj.setDepartamento2(cmbunidad.getSelectedIndex()); 
                obj.setCodigo(Integer.parseInt(txtcodigo.getText()));
                if(obj.modificarPropiedades()) {
                    try {
                        //Funcion para borrar los datos de la tabla.
                        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
                        int filas=tabla.getRowCount();
                        for (int i = 0;filas>i; i++) {
                            modelo.removeRow(0);
                        }
                        //Se llama al metodo para actualizar la tabla.
                        frm.Tabla1();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
                    }
                    Galeria frm4 = new Galeria();
                    frm4.btnmodificar();
                            limpiar();
                    txtcodigo.setText(null);
                    JOptionPane.showMessageDialog(this, "Datos modificados");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Error al modificar");
                }
            }
            this.setSize(875, 710);
            this.setLocationRelativeTo(null);
            btnmini.setVisible(false);
        btnmaxi.setVisible(true);
        }
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        //Se valida que no queden espacios vacios.
        if( cmbdepa.getSelectedIndex() == 0
            || cmbmuni.getSelectedIndex() == 0 || cmbtipo.getSelectedIndex() == 0
            || cmbestado.getSelectedIndex() == 0 || txtdimensiones.getText().isEmpty()
            || txtubicacion.getText().isEmpty() || txtdescripcion.getText().isEmpty()
            || txtprecio.getText().isEmpty() || txtprima.getText().isEmpty() || cmbunidad.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos");
        }
        else{
            //Se manda a llamar la clase Consultas para obtener la consulta de guardar.
            Consultas obj = new Consultas();
            if(txtcodigo.getText().isEmpty()){
                obj.setTipoP(cmbtipo.getSelectedIndex());
                obj.setEstado(cmbestado.getSelectedIndex());
                obj.setDepartamento2(cmbunidad.getSelectedIndex());
                obj.setUbicacion(txtubicacion.getText());
                obj.setDimensiones(txtdimensiones.getText());
                obj.setDescripcion(txtdescripcion.getText());
                obj.setPrecio(txtprecio.getText());
                obj.setPrima(txtprima.getText());
                
                if(obj.guardarPropiedades()) {
                    try {
                        //Funcion para borrar los datos de la tabla.
                        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
                        int filas=tabla.getRowCount();
                        for (int i = 0;filas>i; i++) {
                            modelo.removeRow(0);
                        }
                        //Se llama al metodo para actualizar la tabla.
                        if(frm.Tabla1());
                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
                    }
                    Consultas frm2 = new Consultas();
                    if(frm2.fotos4()) { 
                        txtcodigo.setText(String.valueOf(frm2.getDepartamento2()));
                        Galeria frm3 = new Galeria();
                    frm3.btnguardar();
                    } else { 
                        JOptionPane.showMessageDialog(this, "Datos no encontrados"); 
                    }
                    limpiar();
                    txtcodigo.setText(null);
                    JOptionPane.showMessageDialog(this, "Datos guardados");
                }                
                else {
                    JOptionPane.showMessageDialog(this, "Error al guardar datos");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Debe ingresar otra propiedad");
            }
        }
                    this.setSize(875, 710);
                    this.setLocationRelativeTo(null);
                    btnmini.setVisible(false);
        btnmaxi.setVisible(true);
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        limpiar();
        this.setSize(875, 710);
        this.setLocationRelativeTo(null); 
        t.stop();
        btnconsultar.setVisible(false);  
        btnguardar.setVisible(true);
        btnmini.setVisible(false);
        btnmaxi.setVisible(true); 
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        //Condicion para evitar que el campo Codigo quede vacio.
        if(txtcodigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un inmueble");
        }else{
            //Se manda a llamar la clase Consultas para obtener la consulta de eliminar.
            Consultas obj = new Consultas();
            obj.setCodigo(Integer.parseInt(txtcodigo.getText()));
            //Se confirma si se quiere eliminar el dato.
            int eliminar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar?", "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(eliminar == 0) {
                if(obj.eliminarPropiedades()) {
                    try {
                        //Funcion para borrar los datos de la tabla.
                        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
                        int filas=tabla.getRowCount();
                        for (int i = 0;filas>i; i++) {
                            modelo.removeRow(0);
                        }
                        limpiar();
                        //Se actualiza la tabla llamando otra vez al metodo Tabla1 de la clase Consulta.
                        frm.Tabla1();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
                    }

                    JOptionPane.showMessageDialog(this, "Datos eliminados");
                    txtcodigo.setText(null);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar");
                }
            }
            //Funcion para borrar los datos de la tabla.
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
            limpiar();
            //Se actualiza la tabla llamando otra vez al metodo Tabla1 de la clase Consulta.
            frm.Tabla1();
            this.setSize(875, 695);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void cmbdepaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdepaActionPerformed
        //Mando a llamar el metodo para llenar el combobox de la clase Consultas.
        frm.combo2();
    }//GEN-LAST:event_cmbdepaActionPerformed

    private void cmbdepaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbdepaMouseEntered

    }//GEN-LAST:event_cmbdepaMouseEntered

    private void cmbdepaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbdepaMouseClicked

    }//GEN-LAST:event_cmbdepaMouseClicked

    private void cmbdepaPopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbdepaPopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbdepaPopupMenuCanceled

    private void cmbdepaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbdepaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbdepaItemStateChanged

    private void cmbestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbestadoActionPerformed

    private void cmbtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtipoActionPerformed

    }//GEN-LAST:event_cmbtipoActionPerformed

    private void cmbtipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbtipoMouseClicked

    }//GEN-LAST:event_cmbtipoMouseClicked

    private void cmbtipoPopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbtipoPopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtipoPopupMenuCanceled

    private void cmbtipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbtipoItemStateChanged

    }//GEN-LAST:event_cmbtipoItemStateChanged

    private void cmbmuniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbmuniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbmuniActionPerformed

    private void btnminiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnminiActionPerformed
        this.setSize(875, 710);
        btnmini.setVisible(false);
        btnmaxi.setVisible(true); 
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnminiActionPerformed

    private void txtruta6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtruta6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtruta6ActionPerformed

    private void txtnom6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom6ActionPerformed

    private void txtruta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtruta3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtruta3ActionPerformed

    private void txtnom3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom3ActionPerformed

    private void txtnom5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom5ActionPerformed

    private void txtruta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtruta5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtruta5ActionPerformed

    private void txtnom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom2ActionPerformed

    private void txtruta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtruta4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtruta4ActionPerformed

    private void txtnom4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom4ActionPerformed

    private void txtruta7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtruta7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtruta7ActionPerformed

    private void txtnom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom1ActionPerformed

    private void txtruta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtruta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtruta1ActionPerformed

    private void agregarimgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarimgActionPerformed
        Galeria frm = new Galeria();
         
        if(txtnum1.getText().isEmpty() && txtnom1.getText().isEmpty()){
            frm.foto1();
        }else
        if(txtnum4.getText().isEmpty() && txtnom4.getText().isEmpty()){ 
            frm.foto4();
        }else
        if(txtnum2.getText().isEmpty() && txtnom2.getText().isEmpty()){
            frm.foto2();
        }else
        if(txtnum5.getText().isEmpty() && txtnom5.getText().isEmpty()){
            frm.foto5();
        }else
        if(txtnum3.getText().isEmpty() && txtnom3.getText().isEmpty()){
            frm.foto3();
        }else
        if(txtnum6.getText().isEmpty() && txtnom6.getText().isEmpty()){ 
            frm.foto6();
        }
        
    }//GEN-LAST:event_agregarimgActionPerformed

    private void btnmaxiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmaxiActionPerformed
        this.setSize(1250, 710);  
        btnmaxi.setVisible(false);
         btnmini.setVisible(true);
         this.setLocationRelativeTo(null); 
    }//GEN-LAST:event_btnmaxiActionPerformed

    private void btncammbiar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncammbiar6ActionPerformed
        Galeria frm = new Galeria();
          frm.foto6();
    }//GEN-LAST:event_btncammbiar6ActionPerformed

    private void btncambiar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambiar5ActionPerformed
        Galeria frm = new Galeria();
            frm.foto3();        
    }//GEN-LAST:event_btncambiar5ActionPerformed

    private void btncambiar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambiar4ActionPerformed
        Galeria frm = new Galeria();
            frm.foto5();
    }//GEN-LAST:event_btncambiar4ActionPerformed

    private void btncambiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambiar3ActionPerformed
        Galeria frm = new Galeria();
            frm.foto2();        
    }//GEN-LAST:event_btncambiar3ActionPerformed

    private void btncambiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambiar2ActionPerformed
        Galeria frm = new Galeria();
            frm.foto4();        
    }//GEN-LAST:event_btncambiar2ActionPerformed

    private void btncambiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambiar1ActionPerformed
        Galeria frm = new Galeria();
            frm.foto1();
    }//GEN-LAST:event_btncambiar1ActionPerformed

    private void btnnuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevo1ActionPerformed
                        pesta1.setSelectedIndex(0); 
                        btnmaxi.setVisible(true); 
                        btnmini.setVisible(false); 
                        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
                        int filas=tabla.getRowCount();
                        for (int i = 0;filas>i; i++) {
                            modelo.removeRow(0);
                        }
                        limpiar();
                        //Se actualiza la tabla llamando otra vez al metodo Tabla1 de la clase Consulta.
                        frm.Tabla1();
                        limpiar2();
                         this.setSize(875, 710);
                         this.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnnuevo1ActionPerformed

    private void cmbdepa1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbdepa1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbdepa1ItemStateChanged

    private void cmbdepa1PopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbdepa1PopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbdepa1PopupMenuCanceled

    private void cmbdepa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbdepa1MouseClicked

    }//GEN-LAST:event_cmbdepa1MouseClicked

    private void cmbdepa1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbdepa1MouseEntered

    }//GEN-LAST:event_cmbdepa1MouseEntered

    private void cmbdepa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdepa1ActionPerformed
        //Mando a llamar el metodo para llenar el combobox de la clase Consultas.
        Consultas frm = new Consultas();
        if(cmbdepa.getSelectedIndex() == 0){
            frm.combo9();
        }else{
            frm.combo8();
        }
    }//GEN-LAST:event_cmbdepa1ActionPerformed

    private void cmbmuni1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbmuni1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbmuni1ActionPerformed

    private void cmbtipo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbtipo1ItemStateChanged

    }//GEN-LAST:event_cmbtipo1ItemStateChanged

    private void cmbtipo1PopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbtipo1PopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtipo1PopupMenuCanceled

    private void cmbtipo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbtipo1MouseClicked

    }//GEN-LAST:event_cmbtipo1MouseClicked

    private void cmbtipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtipo1ActionPerformed

    }//GEN-LAST:event_cmbtipo1ActionPerformed

    private void cmbestado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbestado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbestado1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!txtprecio1.getText().isEmpty() || !txtprecio2.getText().isEmpty()
           || cmbdepa1.getSelectedIndex() != 0 || cmbestado1.getSelectedIndex() != 0
               || cmbmuni1.getSelectedIndex() != 0 || cmbtipo1.getSelectedIndex() != 0){
        if(!txtprecio1.getText().isEmpty() && !txtprecio2.getText().isEmpty()){
        if(Integer.parseInt(txtprecio1.getText()) <= Integer.parseInt(txtprecio2.getText())){
        pesta1.setSelectedIndex(0); 
        //Funcion para borrar los datos de la tabla.
                        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
                        int filas=tabla.getRowCount();
                        for (int i = 0;filas>i; i++) {
                            modelo.removeRow(0);
                        }
                        System.out.println(cmbdepa1.getSelectedItem());
        Consultas frm = new Consultas();
        frm.Tabla10();
        }
        else{
            JOptionPane.showMessageDialog(this, "El Precio de arriba no puede ser mayor al de abajo");
        }
        }else{
            pesta1.setSelectedIndex(0); 
            if(cmbdepa1.getSelectedIndex() != 0 || cmbestado1.getSelectedIndex() != 0
               || cmbmuni1.getSelectedIndex() != 0 || cmbtipo1.getSelectedIndex() != 0){
        //Funcion para borrar los datos de la tabla.
                        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
                        int filas=tabla.getRowCount();
                        for (int i = 0;filas>i; i++) {
                            modelo.removeRow(0);
                        }
                        System.out.println(cmbdepa1.getSelectedItem());
        Consultas frm = new Consultas();
        frm.Tabla10();
            }
            else{
            pesta1.setSelectedIndex(0); 
            JOptionPane.showMessageDialog(this, "No se pudo realizar la busqueda");
            limpiar2();
        }
        }
        }else{
            pesta1.setSelectedIndex(0); 
            JOptionPane.showMessageDialog(this, "No se pudo realizar la busqueda");
            limpiar2();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    public void limpiar2(){
        cmbdepa1.setSelectedIndex(0);
        cmbestado1.setSelectedIndex(0); 
        cmbmuni1.setSelectedIndex(0); 
        cmbtipo1.setSelectedIndex(0); 
        txtprecio1.setText(null); 
        txtprecio2.setText(null); 
    }
    
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        t.start();
        progreso.setValue(0);
        Galeria frm4 = new Galeria();
        frm4.limpiar();
        //Condicion para el cargo de Comprador.
            if(Consultas.tipoU == 2){
                btnconsultar.setVisible(true);
        btnguardar.setVisible(false);
        } //Condicion para el cargo del vendedor
        else if(Consultas.tipoU == 1){
            
        }
        else if(Consultas.tipoU == 0){
             
        }
        
        //Funciones para poder trasladar la informacion de la tabla
        //a los componentes. (JTextField, ComboBox)
        Integer id = (Integer) tabla.getValueAt(tabla.getSelectedRow(), 0);
        String id2 = (String) tabla.getValueAt(tabla.getSelectedRow(),1);
        String id3 = (String) tabla.getValueAt(tabla.getSelectedRow(),2);
        String id4 = (String) tabla.getValueAt(tabla.getSelectedRow(),3);
        String id5 = (String) tabla.getValueAt(tabla.getSelectedRow(),4);
        String id6 = (String) tabla.getValueAt(tabla.getSelectedRow(),6);
        String id7 = (String) tabla.getValueAt(tabla.getSelectedRow(),5);
        String id8 = (String) tabla.getValueAt(tabla.getSelectedRow(),7);
        String id9 = (String) tabla.getValueAt(tabla.getSelectedRow(),8);
        String id10 = (String) tabla.getValueAt(tabla.getSelectedRow(),9);
        String id11 = (String) tabla.getValueAt(tabla.getSelectedRow(),10);
        Date id12 = (Date) tabla.getValueAt(tabla.getSelectedRow(),11);
        txtcodigo.setText(Integer.toString(id));
        cmbdepa.setSelectedItem((id2));
        cmbmuni.setSelectedItem((id3));
        cmbtipo.setSelectedItem((id4));
        cmbestado.setSelectedItem(id5);
        txtubicacion.setText(id7);
        txtdimensiones.setText(id6);
        cmbunidad.setSelectedItem(id8);
        txtdescripcion.setText(id9);
        txtprecio.setText(id10);
        txtprima.setText(id11);
        txtfecha.setText(id12.toString());
        Consultas obj = new Consultas();
        obj.tabla6(contador);
        if(txtruta.getText().isEmpty()){
            t.stop();
            txtesta.setText(null);
            txtruta2.setText(null);
            progreso.setValue(0);
            //Se guarda el URL en caso de no estar disponible la imagen.
            String path = "/imagenes/no_disponible.jpg";
            //En el url se obtiene lo que esta en el paquete.
            URL url = this.getClass().getResource(path);
            
            //Se transforma el URL en una imagen de icono.
            ImageIcon icon = new ImageIcon(url);
            //Modificamos la imagen.
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(350, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            txtfoto.setIcon(newIcon);
        }
        contador = 0;
        Consultas objt = new Consultas();
        objt.fotos2();
        if(!txtnum1.getText().isEmpty()){
            btncambiar1.setVisible(true);
        }
        if(!txtnum4.getText().isEmpty()){
            btncambiar2.setVisible(true);
        }
        if(!txtnum2.getText().isEmpty()){
            btncambiar3.setVisible(true);
        }
        if(!txtnum5.getText().isEmpty()){
            btncambiar4.setVisible(true);
        }
        if(!txtnum3.getText().isEmpty()){
            btncambiar5.setVisible(true);
        }
        if(!txtnum6.getText().isEmpty()){
            btncammbiar6.setVisible(true);
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limpiar2();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtubicacionAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtubicacionAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtubicacionAncestorAdded

    private void txtubicacionComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtubicacionComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtubicacionComponentAdded

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        Login frm = new Login();
        frm.show();
        this.hide();
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        PrincipalComprador frm = new PrincipalComprador();
        frm.show();
        this.hide();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    
    public void FileCopy(String sourceFile, String destinationFile) {
		System.out.println("Desde: " + sourceFile);
		System.out.println("Hacia: " + destinationFile);

		try {
			File inFile = new File(sourceFile);
			File outFile = new File(destinationFile);

			FileInputStream in = new FileInputStream(inFile);
			FileOutputStream out = new FileOutputStream(outFile);

			int c;
			while( (c = in.read() ) != -1)
				out.write(c);

			in.close();
			out.close();
		} catch(IOException e) {
			System.err.println("Hubo un error de entrada/salida!!!");
		}
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
 
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistAquaSkin");    //seaplica la libreria de look and feel
                new Propiedades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Propiedad;
    private javax.swing.JLabel Propiedad2;
    private javax.swing.JLabel Propiedad3;
    private javax.swing.JLabel Propiedad4;
    private javax.swing.JLabel Propiedad5;
    private javax.swing.JLabel Propiedad6;
    private javax.swing.JButton agregarimg;
    public static javax.swing.JButton btncambiar1;
    public static javax.swing.JButton btncambiar2;
    public static javax.swing.JButton btncambiar3;
    public static javax.swing.JButton btncambiar4;
    public static javax.swing.JButton btncambiar5;
    public static javax.swing.JButton btncammbiar6;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmaxi;
    private javax.swing.JButton btnmini;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnnuevo1;
    public static javax.swing.JComboBox cmbdepa;
    public static javax.swing.JComboBox cmbdepa1;
    public static javax.swing.JComboBox cmbestado;
    public static javax.swing.JComboBox cmbestado1;
    public static javax.swing.JComboBox cmbmuni;
    public static javax.swing.JComboBox cmbmuni1;
    public static javax.swing.JComboBox cmbtipo;
    public static javax.swing.JComboBox cmbtipo1;
    public static javax.swing.JComboBox cmbunidad;
    private javax.swing.JPanel formulario;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel lblfoto1;
    public static javax.swing.JLabel lblfoto2;
    public static javax.swing.JLabel lblfoto3;
    public static javax.swing.JLabel lblfoto4;
    public static javax.swing.JLabel lblfoto5;
    public static javax.swing.JLabel lblfoto6;
    private javax.swing.JMenuBar menu;
    private javax.swing.JTabbedPane pesta1;
    public static javax.swing.JProgressBar progreso;
    public static javax.swing.JTable tabla;
    private javax.swing.JPanel tabla5;
    public static javax.swing.JTextField txtcodigo;
    private javax.swing.JTextArea txtdescripcion;
    private javax.swing.JTextArea txtdimensiones;
    private javax.swing.JTextField txtesta;
    private javax.swing.JTextField txtfecha;
    public static javax.swing.JLabel txtfoto;
    public static javax.swing.JTextField txtnom1;
    public static javax.swing.JTextField txtnom2;
    public static javax.swing.JTextField txtnom3;
    public static javax.swing.JTextField txtnom4;
    public static javax.swing.JTextField txtnom5;
    public static javax.swing.JTextField txtnom6;
    public static javax.swing.JTextField txtnum1;
    public static javax.swing.JTextField txtnum2;
    public static javax.swing.JTextField txtnum3;
    public static javax.swing.JTextField txtnum4;
    public static javax.swing.JTextField txtnum5;
    public static javax.swing.JTextField txtnum6;
    private javax.swing.JTextField txtprecio;
    public static javax.swing.JTextField txtprecio1;
    public static javax.swing.JTextField txtprecio2;
    private javax.swing.JTextField txtprima;
    public static javax.swing.JTextField txtruta;
    public static javax.swing.JTextField txtruta1;
    public static javax.swing.JTextField txtruta2;
    public static javax.swing.JTextField txtruta3;
    public static javax.swing.JTextField txtruta4;
    public static javax.swing.JTextField txtruta5;
    public static javax.swing.JTextField txtruta6;
    public static javax.swing.JTextField txtruta7;
    private javax.swing.JTextField txtubicacion;
    // End of variables declaration//GEN-END:variables
}


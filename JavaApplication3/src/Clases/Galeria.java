/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static Clases.Consultas.cn;
import Comprador.Propiedades;
import static Comprador.Propiedades.btncambiar1;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Galeria {

    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de imagen", "jpg", "png");
    String rutaimagen;    
    double valor, valor2, valor3;
    
   public void foto1(){
       //Creamos un objeto de JFileChooser.
        JFileChooser dlg = new JFileChooser();
        //Del objeto creado vamos a llamar al metodo setFilFilter.
        dlg.setFileFilter(filter);
        //Abrimos la ventana de dialogo para escoger las imagenes.
        int option = dlg.showOpenDialog(dlg);
        //Si hacemos click en el boton Abrir
        if(option==JFileChooser.APPROVE_OPTION){
            Propiedades.btncambiar1.setVisible(true); 
            //Obtener el nombre del harchivo que hemos seleccionado.
            String fil = dlg.getSelectedFile().getPath();
            String fil2 = dlg.getSelectedFile().getName();
            //Obtener la direccion donde se guarda la imagen.
            Propiedades.lblfoto1.setIcon(new ImageIcon(fil));
            Propiedades.txtnom1.setText(fil2);
            //Modificamos la imagen.
            ImageIcon icon = new ImageIcon(fil);
            //Extraer la imagen del icono.
            Image img = icon.getImage();
            //Cambiando el tamaño de la imagen.
            Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto1.setIcon(newIcon);
            Propiedades.lblfoto1.setSize(200, 200);
            Propiedades.txtruta1.setText(fil);
            rutaimagen="";
        }
   }
   
   public void foto2(){
       //Creamos un objeto de JFileChooser.
        JFileChooser dlg = new JFileChooser();
        //Del objeto creado vamos a llamar al metodo setFilFilter.
        dlg.setFileFilter(filter);
        //Abrimos la ventana de dialogo para escoger las imagenes.
        int option = dlg.showOpenDialog(dlg);
        //Si hacemos click en el boton Abrir
        if(option==JFileChooser.APPROVE_OPTION){
             Propiedades.btncambiar3.setVisible(true); 
            //Obtener el nombre del harchivo que hemos seleccionado.
            String fil = dlg.getSelectedFile().getPath();
            String fil2 = dlg.getSelectedFile().getName();
            //Obtener la direccion donde se guarda la imagen.
            Propiedades.lblfoto2.setIcon(new ImageIcon(fil));
            Propiedades.txtnom2.setText(fil2);
            //Modificamos la imagen.
            ImageIcon icon = new ImageIcon(fil);
            //Extraer la imagen del icono.
            Image img = icon.getImage();
            //Cambiando el tamaño de la imagen.
            Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto2.setIcon(newIcon);
            Propiedades.lblfoto2.setSize(200, 200);
            Propiedades.txtruta2.setText(fil);
            rutaimagen="";
        }
   }
   
   public void foto3(){
       //Creamos un objeto de JFileChooser.
        JFileChooser dlg = new JFileChooser();
        //Del objeto creado vamos a llamar al metodo setFilFilter.
        dlg.setFileFilter(filter);
        //Abrimos la ventana de dialogo para escoger las imagenes.
        int option = dlg.showOpenDialog(dlg);
        //Si hacemos click en el boton Abrir
        if(option==JFileChooser.APPROVE_OPTION){
            Propiedades.btncambiar5.setVisible(true); 
            //Obtener el nombre del harchivo que hemos seleccionado.
            String fil = dlg.getSelectedFile().getPath();
            String fil2 = dlg.getSelectedFile().getName();
            //Obtener la direccion donde se guarda la imagen.
            Propiedades.lblfoto3.setIcon(new ImageIcon(fil));
            Propiedades.txtnom3.setText(fil2);
            //Modificamos la imagen.
            ImageIcon icon = new ImageIcon(fil);
            //Extraer la imagen del icono.
            Image img = icon.getImage();
            //Cambiando el tamaño de la imagen.
            Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto3.setIcon(newIcon);
            Propiedades.lblfoto3.setSize(200, 200);
            Propiedades.txtruta3.setText(fil);
            rutaimagen="";
        }
   }
   
   public void foto4(){
        
       //Creamos un objeto de JFileChooser.
        JFileChooser dlg = new JFileChooser();
        //Del objeto creado vamos a llamar al metodo setFilFilter.
        dlg.setFileFilter(filter);
        //Abrimos la ventana de dialogo para escoger las imagenes.
        int option = dlg.showOpenDialog(dlg);
        //Si hacemos click en el boton Abrir
        if(option==JFileChooser.APPROVE_OPTION){
            Propiedades.btncambiar2.setVisible(true);
            //Obtener el nombre del harchivo que hemos seleccionado.
            String fil = dlg.getSelectedFile().getPath();
            String fil2 = dlg.getSelectedFile().getName();
            //Obtener la direccion donde se guarda la imagen.
            Propiedades.lblfoto4.setIcon(new ImageIcon(fil));
            Propiedades.txtnom4.setText(fil2);
            //Modificamos la imagen.
            ImageIcon icon = new ImageIcon(fil);
            //Extraer la imagen del icono.
            Image img = icon.getImage();
            //Cambiando el tamaño de la imagen.
            Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto4.setIcon(newIcon);
            Propiedades.lblfoto4.setSize(200, 200);
            Propiedades.txtruta4.setText(fil);
            rutaimagen="";
        }
   }
   
   public void foto5(){
       
       //Creamos un objeto de JFileChooser.
        JFileChooser dlg = new JFileChooser();
        //Del objeto creado vamos a llamar al metodo setFilFilter.
        dlg.setFileFilter(filter);
        //Abrimos la ventana de dialogo para escoger las imagenes.
        int option = dlg.showOpenDialog(null);
        //Si hacemos click en el boton Abrir
        if(option==JFileChooser.APPROVE_OPTION){
            Propiedades.btncambiar4.setVisible(true); 
            //Obtener el nombre del harchivo que hemos seleccionado.
            String fil = dlg.getSelectedFile().getPath();
            String fil2 = dlg.getSelectedFile().getName();
            //Obtener la direccion donde se guarda la imagen.
            Propiedades.lblfoto5.setIcon(new ImageIcon(fil));
            Propiedades.txtnom5.setText(fil2);
            //Modificamos la imagen.
            ImageIcon icon = new ImageIcon(fil);
            //Extraer la imagen del icono.
            Image img = icon.getImage();
            //Cambiando el tamaño de la imagen.
            Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto5.setIcon(newIcon);
            Propiedades.lblfoto5.setSize(200, 200);
            Propiedades.txtruta5.setText(fil);
            rutaimagen="";
        }
   }
   
   public void foto6(){
       
       //Creamos un objeto de JFileChooser.
        JFileChooser dlg = new JFileChooser();
        //Del objeto creado vamos a llamar al metodo setFilFilter.
        dlg.setFileFilter(filter);
        //Abrimos la ventana de dialogo para escoger las imagenes.
        int option = dlg.showOpenDialog(dlg);
        //Si hacemos click en el boton Abrir
        if(option==JFileChooser.APPROVE_OPTION){
            Propiedades.btncammbiar6.setVisible(true); 
            //Obtener el nombre del harchivo que hemos seleccionado.
            String fil = dlg.getSelectedFile().getPath();
            String fil2 = dlg.getSelectedFile().getName();
            //Obtener la direccion donde se guarda la imagen.
            Propiedades.lblfoto6.setIcon(new ImageIcon(fil));
            Propiedades.txtnom6.setText(fil2);
            //Modificamos la imagen.
            ImageIcon icon = new ImageIcon(fil);
            //Extraer la imagen del icono.
            Image img = icon.getImage();
            //Cambiando el tamaño de la imagen.
            Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto6.setIcon(newIcon);
            Propiedades.lblfoto6.setSize(200, 200);
            Propiedades.txtruta6.setText(fil);
            rutaimagen="";
        }
   }
   
   public void nodis(){
       //Se guarda el URL en caso de no estar disponible la imagen.
        String path = "/imagenes/no_disponible.jpg"; 
        //En el url se obtiene lo que esta en el paquete.
        URL url = this.getClass().getResource(path);  
        //Se transforma el URL en una imagen de icono.
        ImageIcon icon = new ImageIcon(url);  
        //Modificamos la imagen.
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto1.setIcon(newIcon);
            Propiedades.lblfoto4.setIcon(newIcon);
            Propiedades.lblfoto2.setIcon(newIcon);
            Propiedades.lblfoto5.setIcon(newIcon);
            Propiedades.lblfoto3.setIcon(newIcon);
            Propiedades.lblfoto6.setIcon(newIcon);
   }
   
   public void limpiar(){
        Propiedades.txtruta1.setText(null); 
        Propiedades.txtruta2.setText(null);
        Propiedades.txtruta3.setText(null);
        Propiedades.txtruta4.setText(null);
        Propiedades.txtruta5.setText(null);
        Propiedades.txtruta6.setText(null);
        Propiedades.txtnom1.setText(null);
        Propiedades.txtnom2.setText(null);
        Propiedades.txtnom3.setText(null);
        Propiedades.txtnom4.setText(null);
        Propiedades.txtnom5.setText(null);
        Propiedades.txtnom6.setText(null);
        Propiedades.txtnum1.setText(null);
        Propiedades.txtnum2.setText(null);
        Propiedades.txtnum3.setText(null);
        Propiedades.txtnum4.setText(null);
        Propiedades.txtnum5.setText(null);
        Propiedades.txtnum6.setText(null);
        //Se guarda el URL en caso de no estar disponible la imagen.
        String path = "/imagenes/no_disponible.jpg"; 
        //En el url se obtiene lo que esta en el paquete.
        URL url = this.getClass().getResource(path);  
        //Se transforma el URL en una imagen de icono.
        ImageIcon icon = new ImageIcon(url);  
        //Modificamos la imagen.
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto1.setIcon(newIcon);
            Propiedades.lblfoto2.setIcon(newIcon);
            Propiedades.lblfoto3.setIcon(newIcon);
            Propiedades.lblfoto4.setIcon(newIcon);
            Propiedades.lblfoto5.setIcon(newIcon);
            Propiedades.lblfoto6.setIcon(newIcon);
    }
   
   public void btnguardar(){
       //Se manda a llamar la clase Consultas para obtener la consulta de guardar.
            Consultas obj = new Consultas();
                if(!Propiedades.txtruta1.getText().isEmpty() && Propiedades.txtnum1.getText().isEmpty()){                   
                //Aqui obtengo la URL del paquete de imagenes.
                File f = new File("src/imagenes/"+Propiedades.txtnom1.getText()).toPath().toAbsolutePath().toFile();
                String fr = f.getName();
                //Aqui lo mando al metodo copiar archivos
                FileCopy(Propiedades.txtruta1.getText(), (f.toString()));
                obj.setCodigo(Integer.parseInt(Propiedades.txtcodigo.getText()));
                obj.setDepartamento3("/imagenes/"+Propiedades.txtnom1.getText());
                if(obj.fotos()) {
                    
                }
                else {  
                    JOptionPane.showMessageDialog(null, "Error al guardar datos");
                }
                }
                if(!Propiedades.txtruta4.getText().isEmpty() && Propiedades.txtnum4.getText().isEmpty()){
                //Aqui obtengo la URL del paquete de imagenes.
                File f = new File("src/imagenes/"+Propiedades.txtnom4.getText()).toPath().toAbsolutePath().toFile();
                String fr = f.getName();
                //Aqui lo mando al metodo copiar archivos
                FileCopy(Propiedades.txtruta4.getText(), f.toString());
                obj.setCodigo(Integer.parseInt(Propiedades.txtcodigo.getText()));
                obj.setDepartamento3("/imagenes/"+Propiedades.txtnom4.getText());
                if(obj.fotos()) {
                    
                   
                }
                else {  
                    JOptionPane.showMessageDialog(null, "Error al guardar datos");
                }                    
                }
               if(!Propiedades.txtruta2.getText().isEmpty() && Propiedades.txtnum2.getText().isEmpty()){ 
                //Aqui obtengo la URL del paquete de imagenes.
                File f = new File("src/imagenes/"+Propiedades.txtnom2.getText()).toPath().toAbsolutePath().toFile();
                String fr = f.getName();
                //Aqui lo mando al metodo copiar archivos
                FileCopy(Propiedades.txtruta2.getText(), f.toString());
                obj.setCodigo(Integer.parseInt(Propiedades.txtcodigo.getText()));
                obj.setDepartamento3("/imagenes/"+Propiedades.txtnom2.getText());
                if(obj.fotos()) {
                    
                    
                }
                else {  
                    JOptionPane.showMessageDialog(null, "Error al guardar datos");
                }
                } 
                if(!Propiedades.txtruta5.getText().isEmpty() && Propiedades.txtnum5.getText().isEmpty()){
                //Aqui obtengo la URL del paquete de imagenes.
                File f = new File("src/imagenes/"+Propiedades.txtnom5.getText()).toPath().toAbsolutePath().toFile();
                String fr = f.getName();
                //Aqui lo mando al metodo copiar archivos
                FileCopy(Propiedades.txtruta5.getText(), f.toString());
                obj.setCodigo(Integer.parseInt(Propiedades.txtcodigo.getText()));
                obj.setDepartamento3("/imagenes/"+Propiedades.txtnom5.getText());
                if(obj.fotos()) {
                    
                    
                }
                 else{  
                    JOptionPane.showMessageDialog(null, "Error al guardar datos");
                }
                } 
                if(!Propiedades.txtruta3.getText().isEmpty() && Propiedades.txtnum3.getText().isEmpty()){
                //Aqui obtengo la URL del paquete de imagenes.
                File f = new File("src/imagenes/"+Propiedades.txtnom3.getText()).toPath().toAbsolutePath().toFile();
                String fr = f.getName();
                //Aqui lo mando al metodo copiar archivos
                FileCopy(Propiedades.txtruta3.getText(), f.toString());
                obj.setCodigo(Integer.parseInt(Propiedades.txtcodigo.getText()));
                obj.setDepartamento3("/imagenes/"+Propiedades.txtnom3.getText());
                if(obj.fotos()) {
                    
                   
                }
                else {  
                    JOptionPane.showMessageDialog(null, "Error al guardar datos");
                } 
                }
                 if(!Propiedades.txtruta6.getText().isEmpty() && Propiedades.txtnum6.getText().isEmpty()){
                //Aqui obtengo la URL del paquete de imagenes.
                File f = new File("src/imagenes/"+Propiedades.txtnom6.getText()).toPath().toAbsolutePath().toFile();
                String fr = f.getName();
                //Aqui lo mando al metodo copiar archivos
                FileCopy(Propiedades.txtruta6.getText(), f.toString());
                obj.setCodigo(Integer.parseInt(Propiedades.txtcodigo.getText()));
                obj.setDepartamento3("/imagenes/"+Propiedades.txtnom6.getText());
                if(obj.fotos()) {
                    
                    
                }
                else {  
                    JOptionPane.showMessageDialog(null, "Error al guardar datos");
                }
                }
                 
                  limpiar();
                  obj.fotos2();
   }
   
   public void btnmodificar(){
       //Se manda a llamar la clase Consultas para obtener la consulta de guardar.
            Consultas obj = new Consultas();                 
                 //-------------------------------Boton modificar--------------------------------------------------------
                 
                 if(!Propiedades.txtnum1.getText().isEmpty() && !Propiedades.txtruta1.getText().isEmpty()){
                     File f2 = new File("src/imagenes/"+Propiedades.txtnom1.getText()).toPath().toAbsolutePath().toFile();
                String fr2 = f2.getName();
                //Aqui lo mando al metodo copiar archivos
                FileCopy(Propiedades.txtruta1.getText(), f2.toString());
                obj.setEstado(Integer.parseInt(Propiedades.txtnum1.getText()));
                obj.setDepartamento3("/imagenes/"+Propiedades.txtnom1.getText());                
                if(obj.fotos3()) {
                    
                }
                else {  
                    JOptionPane.showMessageDialog(null, "Error al guardar datos");
                }
                 }
                 
                 if(!Propiedades.txtnum4.getText().isEmpty() && !Propiedades.txtruta4.getText().isEmpty()){
                     File f = new File("src/imagenes/"+Propiedades.txtnom4.getText()).toPath().toAbsolutePath().toFile();
                String fr = f.getName();
                //Aqui lo mando al metodo copiar archivos
                FileCopy(Propiedades.txtruta4.getText(), f.toString());
                obj.setEstado(Integer.parseInt(Propiedades.txtnum4.getText()));
                obj.setDepartamento3("/imagenes/"+Propiedades.txtnom4.getText());                
                if(obj.fotos3()) {
                    
                }
                else {  
                    JOptionPane.showMessageDialog(null, "Error al guardar datos");
                }
                 }                          
                 
                 if(!Propiedades.txtnum2.getText().isEmpty() && !Propiedades.txtruta2.getText().isEmpty()){
                     File f2 = new File("src/imagenes/"+Propiedades.txtnom2.getText()).toPath().toAbsolutePath().toFile();
                String fr2 = f2.getName();
                //Aqui lo mando al metodo copiar archivos
                FileCopy(Propiedades.txtruta2.getText(), f2.toString());
                obj.setEstado(Integer.parseInt(Propiedades.txtnum2.getText()));
                obj.setDepartamento3("/imagenes/"+Propiedades.txtnom2.getText());                
                if(obj.fotos3()) {
                    
                }
                else {  
                    JOptionPane.showMessageDialog(null, "Error al guardar datos");
                }
                 }
                 
                 if(!Propiedades.txtnum5.getText().isEmpty() && !Propiedades.txtruta5.getText().isEmpty()){
                     File f = new File("src/imagenes/"+Propiedades.txtnom5.getText()).toPath().toAbsolutePath().toFile();
                String fr = f.getName();
                //Aqui lo mando al metodo copiar archivos
                FileCopy(Propiedades.txtruta5.getText(), f.toString());
                obj.setEstado(Integer.parseInt(Propiedades.txtnum5.getText()));
                obj.setDepartamento3("/imagenes/"+Propiedades.txtnom5.getText());                
                if(obj.fotos3()) {
                    
                }
                else {  
                    JOptionPane.showMessageDialog(null, "Error al guardar datos");
                }
                 }
                 
                 if(!Propiedades.txtnum3.getText().isEmpty() && !Propiedades.txtruta3.getText().isEmpty()){
                      File f2 = new File("src/imagenes/"+Propiedades.txtnom3.getText()).toPath().toAbsolutePath().toFile();
                String fr2 = f2.getName();
                //Aqui lo mando al metodo copiar archivos
                FileCopy(Propiedades.txtruta3.getText(), f2.toString());
                obj.setEstado(Integer.parseInt(Propiedades.txtnum3.getText()));
                obj.setDepartamento3("/imagenes/"+Propiedades.txtnom3.getText());                
                if(obj.fotos3()) {
                    
                }
                else {  
                    JOptionPane.showMessageDialog(null, "Error al guardar datos");
                }
                 }
                 
                 if(!Propiedades.txtnum6.getText().isEmpty() && !Propiedades.txtruta6.getText().isEmpty()){
                     File f = new File("src/imagenes/"+Propiedades.txtnom6.getText()).toPath().toAbsolutePath().toFile();
                String fr = f.getName();
                //Aqui lo mando al metodo copiar archivos
                FileCopy(Propiedades.txtruta6.getText(), f.toString());
                obj.setEstado(Integer.parseInt(Propiedades.txtnum6.getText()));
                obj.setDepartamento3("/imagenes/"+Propiedades.txtnom6.getText());                
                if(obj.fotos3()) {
                    
                }
                else {  
                    JOptionPane.showMessageDialog(null, "Error al guardar datos");
                }
                 }
                  limpiar();
                  obj.fotos2();
   }
   
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
}

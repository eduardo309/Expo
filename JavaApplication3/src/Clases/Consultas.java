/*
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import Administrador.Departamentos;
import Administrador.Municipios;
import Comprador.Propiedades;
import static Comprador.Propiedades.*;
import Administrador.control_usuarios;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.util.Date;
import ptc.cambiar;
import ptc.cambiar3;
import ptc.recuperar_contra;
import ptc.recuperar_contra2;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import ptc.recuperar_contra3;

public class Consultas {

    private Integer Codigo;
    private String usuario;
    private String contraseña;
    private Integer tipo;
    public static Connection cn;
    public static Integer codigoU;
    public static Integer tipoU = 0;
    public static Integer tipoE = 0;
    public static String Usuario2 = "";
    private Integer tipoP;
    private Integer Estado;
    private String Ubicacion;
    private String Dimensiones;
    private String Descripcion;
    private String precio;
    private String prima;
    private String municipio;
    private String departamento;    
    private Integer municipio2;
    private Integer departamento2;   
    private Date fecha;
    public static String correo2 = "";
    
    public static String getCorreo2() {
        return correo2;
    }

    public static void setCorreo2(String correo2) {
        Consultas.correo2 = correo2;
    }
    
    public static String getUsuario2() {
        return Usuario2;
    }

    public static void setUsuario2(String Usuario2) {
        Consultas.Usuario2 = Usuario2;
    }
    
    public static Integer getTipoE() {
        return tipoE;
    }

    public static void setTipoE(Integer tipoE) {
        Consultas.tipoE = tipoE;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Integer getMunicipio2() {
        return municipio2;
    }

    public void setMunicipio2(Integer municipio2) {
        this.municipio2 = municipio2;
    }

    public Integer getDepartamento2() {
        return departamento2;
    }

    public void setDepartamento2(Integer departamento2) {
        this.departamento2 = departamento2;
    }
    
    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public Integer getTipoP() {
        return tipoP;
    }

    public void setTipoP(Integer tipoP) {
        this.tipoP = tipoP;
    }

    public Integer getEstado() {
        return Estado;
    }

    public void setEstado(Integer Estado) {
        this.Estado = Estado;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getDimensiones() {
        return Dimensiones;
    }

    public void setDimensiones(String Dimensiones) {
        this.Dimensiones = Dimensiones;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPrima() {
        return prima;
    }
    public void setPrima(String prima) {
            this.prima = prima;
    }

    public String getDepartamento3() {
        return departamento3;
    }

    public void setDepartamento3(String departamento3) {
        this.departamento3 = departamento3;
    }

    public static Integer getTipoU() {
        return tipoU;
    }

    public static void setTipoU(Integer tipoU) {
        Consultas.tipoU = tipoU;
    }

    public static Integer getCodigoU() {
        return codigoU;
    }

    public static void setCodigoU(Integer codigoU) {
        Consultas.codigoU = codigoU;
    }
    
    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer Codigo) {
        this.Codigo = Codigo;
    }
    
    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    //Metodo de consulta para el login
    public boolean search_Us(){
        boolean resp = false;
      try{
          String sql = "select id_usuario, empleado.id_tipousuario, nombre_usuario, contra, empleado.id_empleado from usuario,empleado, tipo_usuario where usuario.id_empleado = empleado.id_empleado and empleado.id_tipousuario = tipo_usuario.id_tipousuario and id_estadousuario = 1 and nombre_usuario = ? and contra = ?"; 
          PreparedStatement cmd = cn.prepareStatement(sql);
          cmd.setString(1, usuario);
          cmd.setString(2, Encriptacion.encriptar(contraseña));
          ResultSet rs = cmd.executeQuery();
          if(rs.next()){
              resp = true;
              Codigo = rs.getInt(1);
              tipo = rs.getInt(2);
              usuario = rs.getString(3);
              contraseña = rs.getString(4);  
              tipoE = rs.getInt(5);
              Usuario2 = rs.getString(3);
          }
          cmd.close();
          cn.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }  
    
    //Metodo creado para llenar los ComboBox del formulario propiedades.
    public boolean combo(){
        boolean resp = false;
      try{
          String sql = "select nombre_tipoP from tipo_propiedad"; 
          String sql2 = "select nombre_estadopropi from estado_propi";
          String sql3 = "select nombre_depa from departamentoES";
          String sql4 = "select nombre_muni from municipios where id_departamentos="+Propiedades.cmbdepa.getSelectedIndex();
          String sql5 = "select nombre_unidad from unidad_medida";
          PreparedStatement cmd = cn.prepareStatement(sql);
          PreparedStatement cmd2 = cn.prepareStatement(sql2);
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          PreparedStatement cmd4 = cn.prepareStatement(sql4);
          PreparedStatement cmd5 = cn.prepareStatement(sql5);
          ResultSet rs = cmd.executeQuery();
          ResultSet rs2 = cmd2.executeQuery();
          ResultSet rs3 = cmd3.executeQuery();
          ResultSet rs4 = cmd4.executeQuery();
          ResultSet rs5 = cmd5.executeQuery();
          while(rs.next()){
              resp = true;
              usuario = rs.getString(1);
              Propiedades.cmbtipo.addItem(usuario);
          }
          while(rs2.next()){
              contraseña = rs2.getString(1);
              Propiedades.cmbestado.addItem(contraseña);
          }
          while(rs3.next()){
              departamento = rs3.getString(1);
              Propiedades.cmbdepa.addItem(departamento);
          }
          while(rs4.next()){
              municipio = rs4.getString(1);
              Propiedades.cmbmuni.addItem(municipio);
          }
          while(rs5.next()){
              departamento3 = rs5.getString(1);
              Propiedades.cmbunidad.addItem(departamento3);
          }
          cmd.close();
          cmd2.close();
          cmd3.close();
          cmd4.close();
          cmd5.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
    
     public boolean combo11(){
        boolean resp = false;
      try{
          String sql = "select nombre_tipoP from tipo_propiedad"; 
          String sql2 = "select nombre_estadopropi from estado_propi";
          String sql3 = "select nombre_depa from departamentoES";
          String sql4 = "select nombre_muni from municipios";
          PreparedStatement cmd = cn.prepareStatement(sql);
          PreparedStatement cmd2 = cn.prepareStatement(sql2);
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          PreparedStatement cmd4 = cn.prepareStatement(sql4);
          ResultSet rs = cmd.executeQuery();
          ResultSet rs2 = cmd2.executeQuery();
          ResultSet rs3 = cmd3.executeQuery();
          ResultSet rs4 = cmd4.executeQuery();
          while(rs.next()){
              resp = true;
              usuario = rs.getString(1);
              Propiedades.cmbtipo1.addItem(usuario);
          }
          while(rs2.next()){
              contraseña = rs2.getString(1);
              Propiedades.cmbestado1.addItem(contraseña);
          }
          while(rs3.next()){
              departamento = rs3.getString(1);
              Propiedades.cmbdepa1.addItem(departamento);
          }
          while(rs4.next()){
              municipio = rs4.getString(1);
              Propiedades.cmbmuni1.addItem(municipio);
          }
          cmd.close();
          cmd2.close();
          cmd3.close();
          cmd4.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el p problema");
      }
      return resp;
  }
     
     public boolean combo8(){
        boolean resp = false;
      try{
          int itemCount = Propiedades.cmbmuni1.getItemCount();

    for(int i=1;i<itemCount;i++){
        Propiedades.cmbmuni1.removeItemAt(1);
     }
    
          String sql4 = "select id_municipio, nombre_muni, nombre_depa  from municipios, departamentoES where departamentoES.id_departamentos = municipios.id_departamentos and nombre_depa='"+Propiedades.cmbdepa1.getSelectedItem()+"'";
          PreparedStatement cmd4 = cn.prepareStatement(sql4);
          ResultSet rs4 = cmd4.executeQuery();
          while(rs4.next()){
              departamento3 = rs4.getString(2);
              Propiedades.cmbmuni1.addItem(departamento3);
          }
          cmd4.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
     
     public boolean combo9(){
        boolean resp = false;
      try{
          int itemCount = Propiedades.cmbmuni1.getItemCount();

    for(int i=1;i<itemCount;i++){
        Propiedades.cmbmuni1.removeItemAt(1);
     }
    
          String sql4 = "select nombre_muni from municipios";
          PreparedStatement cmd4 = cn.prepareStatement(sql4);
          ResultSet rs4 = cmd4.executeQuery();
          while(rs4.next()){
              municipio = rs4.getString(1);
              Propiedades.cmbmuni1.addItem(municipio);
          }
          cmd4.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
     
     
    public boolean combo2(){
        boolean resp = false;
      try{
          int itemCount = Propiedades.cmbmuni.getItemCount();

    for(int i=1;i<itemCount;i++){
        Propiedades.cmbmuni.removeItemAt(1);
     }
    
          String sql4 = "select id_municipio, nombre_muni, nombre_depa  from municipios, departamentoES where departamentoES.id_departamentos = municipios.id_departamentos and nombre_depa='"+Propiedades.cmbdepa.getSelectedItem()+"'";
          PreparedStatement cmd4 = cn.prepareStatement(sql4);
          ResultSet rs4 = cmd4.executeQuery();
          while(rs4.next()){
              municipio = rs4.getString(2);
              Propiedades.cmbmuni.addItem(municipio);
          }
          cmd4.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
    
    public boolean fotos(){
        boolean resp = false;
        try{
          String sql4 = "insert into fotos values (?, ?)";
          PreparedStatement cmd4 = cn.prepareStatement(sql4);
          cmd4.setInt(1, Codigo);
          cmd4.setString(2, departamento3);

            if(!cmd4.execute()) {  
                resp = true; 
            }
          cmd4.close();
        }
      catch(Exception e){
          
          System.out.println("Aqui el problema");
      }
      return resp;
}
    public int i45 = 0;
    public boolean fotos2(){
        boolean resp = false;
        try{
          String sql4 = "select foto, id_foto from fotos where id_propiedad="+Integer.parseInt(Propiedades.txtcodigo.getText());
          PreparedStatement cmd4 = cn.prepareStatement(sql4);
          ResultSet rs = cmd4.executeQuery();

            while(rs.next()) {  
                //Contador para tomar el numero de fotos existentes
                i45++;
                Ubicacion = rs.getString(1);
                tipo = rs.getInt(2);
                switch(i45){
            case 1:{
                //Se guarda el URL en caso de no estar disponible la imagen.
        //Se guarda el URL en caso de no estar disponible la imagen.
            String path = Ubicacion;
                System.out.println(path);
             
            //En el url se obtiene lo que esta en el paquete.
            URL url = this.getClass().getResource(path);
                System.out.println(url);
            //Se transforma el URL en una imagen de icono.
            ImageIcon icon = new ImageIcon(url);
            //Modificamos la imagen.
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto1.setIcon(newIcon);
            Propiedades.txtnum1.setText(String.valueOf(tipo));
            }
            break;
                case 2:{
                //Se guarda el URL en caso de no estar disponible la imagen.
        //Se guarda el URL en caso de no estar disponible la imagen.
            String path = Ubicacion;
            //En el url se obtiene lo que esta en el paquete.
            URL url = this.getClass().getResource(path);
            //Se transforma el URL en una imagen de icono.
            ImageIcon icon = new ImageIcon(url);
            //Modificamos la imagen.
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto4.setIcon(newIcon);
            Propiedades.txtnum4.setText(String.valueOf(tipo));
            }
            break;
                case 3:{
                //Se guarda el URL en caso de no estar disponible la imagen.
        //Se guarda el URL en caso de no estar disponible la imagen.
            String path = Ubicacion;
            //En el url se obtiene lo que esta en el paquete.
            URL url = this.getClass().getResource(path);
            //Se transforma el URL en una imagen de icono.
            ImageIcon icon = new ImageIcon(url);
            //Modificamos la imagen.
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto2.setIcon(newIcon);
            Propiedades.txtnum2.setText(String.valueOf(tipo));
            }
            break;
                case 4:{
                //Se guarda el URL en caso de no estar disponible la imagen.
        //Se guarda el URL en caso de no estar disponible la imagen.
            String path = Ubicacion;
            //En el url se obtiene lo que esta en el paquete.
            URL url = this.getClass().getResource(path);
            //Se transforma el URL en una imagen de icono.
            ImageIcon icon = new ImageIcon(url);
            //Modificamos la imagen.
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto5.setIcon(newIcon);
            Propiedades.txtnum5.setText(String.valueOf(tipo));
            }
            break;
                case 5:{
                //Se guarda el URL en caso de no estar disponible la imagen.
        //Se guarda el URL en caso de no estar disponible la imagen.
            String path = Ubicacion;
            //En el url se obtiene lo que esta en el paquete.
            URL url = this.getClass().getResource(path);
            //Se transforma el URL en una imagen de icono.
            ImageIcon icon = new ImageIcon(url);
            //Modificamos la imagen.
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto3.setIcon(newIcon);
            Propiedades.txtnum3.setText(String.valueOf(tipo));
            }
            break;
                case 6:{
                //Se guarda el URL en caso de no estar disponible la imagen.
        //Se guarda el URL en caso de no estar disponible la imagen.
            String path = Ubicacion;
            //En el url se obtiene lo que esta en el paquete.
            URL url = this.getClass().getResource(path);
            //Se transforma el URL en una imagen de icono.
            ImageIcon icon = new ImageIcon(url);
            //Modificamos la imagen.
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon = new ImageIcon(newimg);
            Propiedades.lblfoto6.setIcon(newIcon);
            Propiedades.txtnum6.setText(String.valueOf(tipo));
            }
            break;
                }        
            }
          cmd4.close();
        }
      catch(Exception ex){
          System.out.println("Aqui el problema foto 2");
      }
      return resp;
}
    
     public boolean fotos3(){
        boolean resp = false;
        try{
          String sql5 = "update fotos set foto=? where id_foto=?";
          PreparedStatement cmd4 = cn.prepareStatement(sql5);
          cmd4.setInt(2, Estado);
          cmd4.setString(1, departamento3);
          if(!cmd4.execute()) { 
         resp = true; 
     }          
          cmd4.close();
        }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
}
    int i68 = 1;
    int i7;
     private Timer t;//clase timer q permite controlar los tiempos de una accion
    private ActionListener al;//permite controlar los eventes q se realizaran en las seccines de tiempo de timer
    
    
    
     public boolean tabla6(int contador){
        boolean resp = false;
        try{
            String sql4 = "select foto, id_foto from fotos where id_propiedad="+Propiedades.txtcodigo.getText();
          PreparedStatement cmd4 = cn.prepareStatement(sql4);
          ResultSet rs4 = cmd4.executeQuery();
          String datos[] = new String[6];
           int i78 = 0;
                       int i79 = 0;
                 
          while(rs4.next()){
              
            Codigo = rs4.getInt(2);
            departamento = rs4.getString(1);
            datos[i78] = departamento;
            i78++;
            resp = true;
            Propiedades.txtruta2.setText(null); 
              Propiedades.txtruta2.setText(String.valueOf(i78));
          }
          Propiedades.txtruta.setText(null);  
            Propiedades.txtruta.setText(datos[contador]); 
          
          String path2 = datos[contador];
            //En el url se obtiene lo que esta en el paquete.
            URL url2 = this.getClass().getResource(path2);
            //Se transforma el URL en una imagen de icono.
            ImageIcon icon2 = new ImageIcon(url2);
            //Modificamos la imagen.
            Image img2 = icon2.getImage();
            Image newimg2 = img2.getScaledInstance(350, 200, java.awt.Image.SCALE_SMOOTH);
            //Se genera el IMAGEICON con la nueva imagen.
            ImageIcon newIcon2 = new ImageIcon(newimg2);
            Propiedades.txtfoto.setIcon(newIcon2);
         cmd4.close();
        }
        
        catch(Exception e){
            System.out.println(e.toString());
        }
        return resp;
     }
     
    //Metodo para llenar el JTable del formulario Propiedades.
    public boolean Tabla1(){
        boolean resp = false;
      try{
          String sql3 = "select id_propiedad, nombre_depa, nombre_muni, nombre_tipoP, nombre_estadopropi, Direccion, Dimension,nombre_unidad, Descripcion_propiedad,Precio_base, Prima,fecha_ingreso from unidad_medida, propiedad, tipo_propiedad, municipios, estado_propi, departamentoES where tipo_propiedad.id_tipoPropiedad = propiedad.id_tipoPropiedad and municipios.id_municipio = propiedad.id_muni and estado_propi.id_estadopropi = propiedad.id_estadopropi and municipios.id_departamentos = departamentoES.id_departamentos and unidad_medida.id_unidad = propiedad.id_unidad"; 
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)Propiedades.tabla.getModel();
              modelo.addRow(new Object[10]);
              int nuevaFila = modelo.getRowCount()-1;
            Codigo = rs3.getInt(1);
            departamento = rs3.getString(2);
            municipio = rs3.getString(3);
            usuario = rs3.getString(4);
            contraseña = rs3.getString(5);
            Ubicacion = rs3.getString(6);
            Dimensiones = rs3.getString(7);
            departamento3 = rs3.getString(8);
            Descripcion = rs3.getString(9);
            precio = rs3.getString(10);
            prima = rs3.getString(11);
            fecha = rs3.getDate(12);
            
            Propiedades.tabla.setValueAt(Codigo, nuevaFila, 0);
            Propiedades.tabla.setValueAt(departamento, nuevaFila, 1);
            Propiedades.tabla.setValueAt(municipio, nuevaFila, 2);
            Propiedades.tabla.setValueAt(usuario, nuevaFila, 3);
            Propiedades.tabla.setValueAt(contraseña, nuevaFila, 4);
            Propiedades.tabla.setValueAt(Ubicacion, nuevaFila, 6);
            Propiedades.tabla.setValueAt(Dimensiones, nuevaFila, 5);
            Propiedades.tabla.setValueAt(departamento3, nuevaFila, 7);
            Propiedades.tabla.setValueAt(Descripcion, nuevaFila, 8);
            Propiedades.tabla.setValueAt(precio, nuevaFila, 9);
            Propiedades.tabla.setValueAt(prima, nuevaFila, 10);
            Propiedades.tabla.setValueAt(fecha, nuevaFila, 11);
            
            Propiedades.tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            Propiedades.tabla.getColumnModel().getColumn(0).setMinWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
            Propiedades.tabla.getColumnModel().getColumn(6).setMaxWidth(0);
            Propiedades.tabla.getColumnModel().getColumn(6).setMinWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
            
            Propiedades.tabla.getColumnModel().getColumn(8).setMaxWidth(0);
            Propiedades.tabla.getColumnModel().getColumn(8).setMinWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
            
          }
          cmd3.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
    
    public boolean Tabla10(){
        boolean resp = false;
      try{
          if(Propiedades.txtprecio1.getText().isEmpty() && Propiedades.txtprecio2.getText().isEmpty()){
          String sql3 = "select * from filtro where nombre_depa like '"+Propiedades.cmbdepa1.getSelectedItem().toString().trim()+"%' and nombre_muni like '"+Propiedades.cmbmuni1.getSelectedItem().toString().trim()+"%' and nombre_tipoP like '"+Propiedades.cmbtipo1.getSelectedItem().toString().trim()+"%' and nombre_estadopropi like '"+Propiedades.cmbestado1.getSelectedItem().toString().trim()+"%' ";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              DefaultTableModel modelo = (DefaultTableModel)Propiedades.tabla.getModel();
              modelo.addRow(new Object[10]);
              int nuevaFila = modelo.getRowCount()-1;
            Codigo = rs3.getInt(1);
            departamento = rs3.getString(2);
            municipio = rs3.getString(3);
            usuario = rs3.getString(4);
            contraseña = rs3.getString(5);
            Ubicacion = rs3.getString(6);
            Dimensiones = rs3.getString(7);
            departamento3 = rs3.getString(8);
            Descripcion = rs3.getString(9);
            precio = rs3.getString(10);
            prima = rs3.getString(11);
            fecha = rs3.getDate(12);
            
            Propiedades.tabla.setValueAt(Codigo, nuevaFila, 0);
            Propiedades.tabla.setValueAt(departamento, nuevaFila, 1);
            Propiedades.tabla.setValueAt(municipio, nuevaFila, 2);
            Propiedades.tabla.setValueAt(usuario, nuevaFila, 3);
            Propiedades.tabla.setValueAt(contraseña, nuevaFila, 4);
            Propiedades.tabla.setValueAt(Ubicacion, nuevaFila, 6);
            Propiedades.tabla.setValueAt(Dimensiones, nuevaFila, 5);
            Propiedades.tabla.setValueAt(departamento3, nuevaFila, 7);
            Propiedades.tabla.setValueAt(Descripcion, nuevaFila, 8);
            Propiedades.tabla.setValueAt(precio, nuevaFila, 9);
            Propiedades.tabla.setValueAt(prima, nuevaFila, 10);
            Propiedades.tabla.setValueAt(fecha, nuevaFila, 11);
            
            Propiedades.tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            Propiedades.tabla.getColumnModel().getColumn(0).setMinWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
            Propiedades.tabla.getColumnModel().getColumn(6).setMaxWidth(0);
            Propiedades.tabla.getColumnModel().getColumn(6).setMinWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
            
            Propiedades.tabla.getColumnModel().getColumn(8).setMaxWidth(0);
            Propiedades.tabla.getColumnModel().getColumn(8).setMinWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
            
          }
          cmd3.close();
          }
          if(!Propiedades.txtprecio1.getText().isEmpty() && !Propiedades.txtprecio2.getText().isEmpty()){
              String sql3 = "select * from filtro where nombre_depa like '"+Propiedades.cmbdepa1.getSelectedItem().toString().trim()+"%' and nombre_muni like '"+Propiedades.cmbmuni1.getSelectedItem().toString().trim()+"%' and nombre_tipoP like '"+Propiedades.cmbtipo1.getSelectedItem().toString().trim()+"%' and nombre_estadopropi like '"+Propiedades.cmbestado1.getSelectedItem().toString().trim()+"%' and Precio_base between "+Propiedades.txtprecio1.getText()+" and "+Propiedades.txtprecio2.getText();
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              DefaultTableModel modelo = (DefaultTableModel)Propiedades.tabla.getModel();
              modelo.addRow(new Object[10]);
              int nuevaFila = modelo.getRowCount()-1;
            Codigo = rs3.getInt(1);
            departamento = rs3.getString(2);
            municipio = rs3.getString(3);
            usuario = rs3.getString(4);
            contraseña = rs3.getString(5);
            Ubicacion = rs3.getString(6);
            Dimensiones = rs3.getString(7);
            departamento3 = rs3.getString(8);
            Descripcion = rs3.getString(9);
            precio = rs3.getString(10);
            prima = rs3.getString(11);
            fecha = rs3.getDate(12);
            
            Propiedades.tabla.setValueAt(Codigo, nuevaFila, 0);
            Propiedades.tabla.setValueAt(departamento, nuevaFila, 1);
            Propiedades.tabla.setValueAt(municipio, nuevaFila, 2);
            Propiedades.tabla.setValueAt(usuario, nuevaFila, 3);
            Propiedades.tabla.setValueAt(contraseña, nuevaFila, 4);
            Propiedades.tabla.setValueAt(Ubicacion, nuevaFila, 6);
            Propiedades.tabla.setValueAt(Dimensiones, nuevaFila, 5);
            Propiedades.tabla.setValueAt(departamento3, nuevaFila, 7);
            Propiedades.tabla.setValueAt(Descripcion, nuevaFila, 8);
            Propiedades.tabla.setValueAt(precio, nuevaFila, 9);
            Propiedades.tabla.setValueAt(prima, nuevaFila, 10);
            Propiedades.tabla.setValueAt(fecha, nuevaFila, 11);
            
            Propiedades.tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            Propiedades.tabla.getColumnModel().getColumn(0).setMinWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
            Propiedades.tabla.getColumnModel().getColumn(6).setMaxWidth(0);
            Propiedades.tabla.getColumnModel().getColumn(6).setMinWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
            
            Propiedades.tabla.getColumnModel().getColumn(8).setMaxWidth(0);
            Propiedades.tabla.getColumnModel().getColumn(8).setMinWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
            Propiedades.tabla.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
            
          }
          cmd3.close();
          }
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
       
    //Metodo para llamar a la clase conexion
    public Consultas() { 
        conexion con = new conexion(); 
        cn = con.conexion(); 
    }   

    //Formulario propiedades
    //Metodo guardar del formulario propiedades.
    
    
    private String departamento3;
    
    public boolean guardarPropiedades() { 
        boolean resp = false; 
        try {        
            String sql2 = "select id_municipio, nombre_muni from municipios where nombre_muni='"+Propiedades.cmbmuni.getSelectedItem()+"'"; 
            PreparedStatement cmd2 = cn.prepareStatement(sql2);
            ResultSet rs2 = cmd2.executeQuery();
            if(rs2.next()){
              resp = true;
              municipio2 = rs2.getInt(1);        
          }
            String sql = "insert into propiedad values (?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE())"; 
            PreparedStatement cmd = cn.prepareStatement(sql); 
                                
            cmd.setInt(1, municipio2); 
            cmd.setInt(2, tipoP);
            cmd.setInt(3, Estado); 
            cmd.setInt(4, departamento2);
            cmd.setString(6, Ubicacion); 
            cmd.setString(5, Dimensiones); 
            cmd.setString(7, Descripcion);
            cmd.setString(8, precio);
            cmd.setString(9, prima); 
                       

            if(!cmd.execute()) {  
                resp = true; 
            }
            cmd.close(); 
        } 
        catch (Exception e) { 
            System.out.println(e.toString());

    } 
        return resp; 
    }
    
                
    
    public boolean modificarPropiedades() { 
        boolean resp = false;
     try { 
         String sql2 = "select id_municipio, nombre_muni from municipios where nombre_muni='"+Propiedades.cmbmuni.getSelectedItem()+"'"; 
            PreparedStatement cmd2 = cn.prepareStatement(sql2);
            ResultSet rs2 = cmd2.executeQuery();
            if(rs2.next()){
              municipio2 = rs2.getInt(1);        
          }
         String sql = "update propiedad set id_muni=?, id_tipoPropiedad=?, id_estadopropi=?, id_unidad=?, Direccion=?, Dimension=?, Descripcion_propiedad=?, Precio_base=?, Prima=? where id_propiedad=?";
      PreparedStatement cmd = cn.prepareStatement(sql); 
            cmd.setInt(1, municipio2);
            cmd.setInt(2, tipoP); 
            cmd.setInt(3, Estado); 
            cmd.setInt(4, departamento2);
            cmd.setString(6, Ubicacion); 
            cmd.setString(5, Dimensiones); 
            cmd.setString(7, Descripcion);
            cmd.setString(8, precio);
            cmd.setString(9, prima); 
            cmd.setInt(10, Codigo);
     if(!cmd.execute()) { 
         resp = true; 
     } 
     cmd.close(); 
     } 
     catch (Exception e) { 
         System.out.println(e.toString()); 
     } 
     return resp; 
    }
    
    public boolean eliminarPropiedades() {  
        boolean resp = false;
       try { 
           String sql = "DELETE FROM propiedad WHERE id_propiedad = ?;";
           PreparedStatement cmd = cn.prepareStatement(sql); 
           cmd.setInt(1, Codigo); 
           if(!cmd.execute()) { 
               resp = true; 
           } 
           cmd.close(); 
       } 
       catch (Exception e) { 
           System.out.println(e.toString()); 
       } 
       return resp; 
    }
    
    
    //Se Crean los metodos para los municipios
    public boolean guardarmunicipios() { 
        boolean resp = false; 
        try {
            String sql2 = "select id_departamentos, nombre_depa from departamentoES where nombre_depa='"+Municipios.cmbmunicipio.getSelectedItem()+"'"; 
            PreparedStatement cmd2 = cn.prepareStatement(sql2);
            ResultSet rs2 = cmd2.executeQuery();
            if(rs2.next()){
              municipio2 = rs2.getInt(1);        
          }
            String sql = "insert into municipios values ("+municipio2+", ?)"; 
            PreparedStatement cmd = cn.prepareStatement(sql); 
            cmd.setString(1, municipio);
            if(!cmd.execute()) {  
                resp = true; 
            }
            cmd.close(); 
        } 
        catch (Exception e) { 
            System.out.println(e.toString());

    } 
        return resp; 
    }
    
    public boolean modificarmunicipios() { 
        boolean resp = false;
     try { 
        String sql2 = "select id_departamentos, nombre_depa from departamentoES where nombre_depa='"+Municipios.cmbmunicipio.getSelectedItem()+"'"; 
            PreparedStatement cmd2 = cn.prepareStatement(sql2);
            ResultSet rs2 = cmd2.executeQuery();
            if(rs2.next()){
              municipio2 = rs2.getInt(1);        
          }
         String sql = "update municipios set id_departamentos="+municipio2+", nombre_muni=? where id_municipio=?";
      PreparedStatement cmd = cn.prepareStatement(sql); 
            cmd.setString(1, Descripcion); 
            cmd.setInt(2, departamento2);
     if(!cmd.execute()) { 
         resp = true; 
     } 
     cmd.close(); 
     } 
     catch (Exception e) { 
         System.out.println(e.toString()); 
     } 
     return resp; 
    }
    
     public boolean eliminarmunicipios() {  
        boolean resp = false;
       try { 
           String sql = "DELETE FROM municipios WHERE id_municipio = ?;";
           PreparedStatement cmd = cn.prepareStatement(sql); 
           cmd.setInt(1, Codigo); 
           if(!cmd.execute()) { 
               resp = true; 
           } 
           cmd.close();  
       } 
       catch (Exception e) { 
           System.out.println(e.toString()); 
       } 
       return resp; 
    }
     
     public boolean combo3(){
        boolean resp = false;
      try{
          String sql = "select nombre_depa from departamentoES"; 
          PreparedStatement cmd = cn.prepareStatement(sql);
          ResultSet rs = cmd.executeQuery();
          while(rs.next()){
              resp = true;
              usuario = rs.getString(1);
              Municipios.cmbmunicipio.addItem(usuario);
          }
          cmd.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
     
     public boolean Tabla4(){
        boolean resp = false;
      try{
          String sql3 = "select id_municipio, nombre_depa, nombre_muni from municipios, departamentoES where departamentoES.id_departamentos=municipios.id_departamentos";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)Municipios.tabla4.getModel();
              modelo.addRow(new Object[3]);
              int nuevaFila = modelo.getRowCount()-1;
            Codigo = rs3.getInt(1);
            Ubicacion = rs3.getString(2);
            Dimensiones = rs3.getString(3);
            Municipios.tabla4.setValueAt(Codigo, nuevaFila, 0);
            Municipios.tabla4.setValueAt(Ubicacion, nuevaFila, 1);
            Municipios.tabla4.setValueAt(Dimensiones, nuevaFila, 2);
          }
          cmd3.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
     
     //Metodos Creados para el formulario departamentos.
     
     public boolean guardardepartamentos() { 
        boolean resp = false; 
        try {
            String sql = "insert into departamentoES values (?)"; 
            PreparedStatement cmd = cn.prepareStatement(sql); 
            cmd.setString(1, municipio);
            if(!cmd.execute()) {  
                resp = true; 
            }
            cmd.close(); 
        } 
        catch (Exception e) { 
            System.out.println(e.toString());

    } 
        return resp; 
    }
    
     public boolean modificardepartamentos() { 
        boolean resp = false;
     try {
         String sql = "update departamentoES set nombre_depa=? where id_departamentos=?";
      PreparedStatement cmd = cn.prepareStatement(sql); 
            cmd.setString(1, Descripcion); 
            cmd.setInt(2, departamento2);
     if(!cmd.execute()) { 
         resp = true; 
     } 
     cmd.close(); 
     } 
     catch (Exception e) { 
         System.out.println(e.toString()); 
     } 
     return resp; 
    }
     
      public boolean eliminardepartamentos() {  
        boolean resp = false;
       try { 
           String sql = "DELETE FROM departamentoES WHERE id_departamentos = ?;";
           PreparedStatement cmd = cn.prepareStatement(sql); 
           cmd.setInt(1, Codigo); 
           if(!cmd.execute()) { 
               resp = true; 
           } 
           cmd.close();  
       } 
       catch (Exception e) { 
           System.out.println(e.toString()); 
       } 
       return resp; 
    }
      
      public boolean Tabla5(){
        boolean resp = false;
      try{
          String sql3 = "select * from departamentoES";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)Departamentos.tabla5.getModel();
              modelo.addRow(new Object[3]);
              int nuevaFila = modelo.getRowCount()-1;
            Codigo = rs3.getInt(1);
            Ubicacion = rs3.getString(2);
            Departamentos.tabla5.setValueAt(Codigo, nuevaFila, 0);
            Departamentos.tabla5.setValueAt(Ubicacion, nuevaFila, 1);

          }
          cmd3.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
      
      public boolean Tabla6U(){
         boolean resp = false;
      try{
          String sql3 = "select id_empleado, nombres_emp, apellidos_emp, nombre_tipoU from empleado, tipo_usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario and id_estadousuario = 2";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)control_usuarios.tabla6.getModel();
              modelo.addRow(new Object[3]);
              int nuevaFila = modelo.getRowCount()-1;
            Codigo = rs3.getInt(1);
            departamento3 = rs3.getString(2);
            usuario = rs3.getString(3);
            Ubicacion = rs3.getString(4);
            control_usuarios.tabla6.setValueAt(Codigo, nuevaFila, 0);
            control_usuarios.tabla6.setValueAt(departamento3, nuevaFila, 1);
            control_usuarios.tabla6.setValueAt(usuario, nuevaFila, 2);
            control_usuarios.tabla6.setValueAt(Ubicacion, nuevaFila, 3);
          }
          cmd3.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
      
      public boolean Tabla7U(){
        boolean resp = false;
      try{
          String sql3 = "select id_usuario, nombres_emp, apellidos_emp,nombre_tipoU ,nombre_usuario, contra from usuario,empleado, tipo_usuario where usuario.id_empleado = empleado.id_empleado and empleado.id_tipousuario = tipo_usuario.id_tipousuario";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)control_usuarios.tabla7.getModel();
              modelo.addRow(new Object[6]);
              int nuevaFila = modelo.getRowCount()-1;
            Codigo = rs3.getInt(1);
            Dimensiones = rs3.getString(2);
            Ubicacion = rs3.getString(3);
            Descripcion = rs3.getString(4);
            departamento3 = rs3.getString(5);
            prima = rs3.getString(6);
            control_usuarios.tabla7.setValueAt(Codigo, nuevaFila, 0);
            control_usuarios.tabla7.setValueAt(Dimensiones, nuevaFila, 1);
            control_usuarios.tabla7.setValueAt(Ubicacion, nuevaFila, 2);
            control_usuarios.tabla7.setValueAt(Descripcion, nuevaFila, 3);
            control_usuarios.tabla7.setValueAt(departamento3, nuevaFila, 4);
            control_usuarios.tabla7.setValueAt(prima, nuevaFila, 5);
            
            
          }
          cmd3.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
      
      public boolean fotos4(){
        boolean resp = false;
        try{
          String sql5 = "select MAX(id_propiedad) propiedad from propiedad";
          PreparedStatement cmd4 = cn.prepareStatement(sql5);
          ResultSet rs = cmd4.executeQuery();
          if(rs.next()) { 
              resp = true;
             departamento2 = rs.getInt(1);
             Propiedades.txtcodigo.setText(String.valueOf(departamento2)); 
     }          
          cmd4.close();
        }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
}
      
      public void cambiar(){
    try{
          String sql = "select id_empleado, nombres_emp, nombre_tipoU from empleado, tipo_usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario and id_empleado = ?";
          PreparedStatement cmd = cn.prepareStatement(sql);
                    cmd.setInt(1, tipoE);
          ResultSet rs = cmd.executeQuery();
          if(rs.next()) { 
             Codigo = rs.getInt(1);
             Ubicacion = rs.getString(2);
             departamento = rs.getString(3);
     }          
             cambiar.lblnombre.setText(Ubicacion); 
             cambiar.lblcargo.setText(departamento); 
             cambiar3.lblnombre.setText(Ubicacion); 
             cambiar3.lblcargo.setText(departamento); 
          cmd.close();
          cn.close();
        }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
}
      
       public boolean cambiar2(){
        boolean resp = false;
      try{
          String sql = "select id_usuario, empleado.id_tipousuario, nombre_usuario, contra, empleado.id_empleado from usuario,empleado, tipo_usuario where usuario.id_empleado = empleado.id_empleado and empleado.id_tipousuario = tipo_usuario.id_tipousuario and id_estadousuario = 1 and nombre_usuario = ? and contra = ?"; 
          PreparedStatement cmd = cn.prepareStatement(sql);
          cmd.setString(1, Usuario2);
          cmd.setString(2, Encriptacion.encriptar(contraseña));
          ResultSet rs = cmd.executeQuery();
          if(rs.next()){
              resp = true;
              Codigo = rs.getInt(1);
              tipo = rs.getInt(2);
              usuario = rs.getString(3);
              contraseña = rs.getString(4);  
              tipoE = rs.getInt(5);
          }
          cmd.close();
          cn.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }  
       
      public boolean modificar_usuario(){
      boolean resp = false;
      try{
          String sql = "UPDATE usuario Set contra=? where nombre_usuario = ?";
          PreparedStatement cmd = cn.prepareStatement(sql);
            //LLEnamos los parametros de la clase
            cmd.setString(1, Encriptacion.encriptar(contraseña));
            cmd.setString(2, Usuario2);
            if(!cmd.execute()){
                resp= true;
            }
            cmd.close();
            cn.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
      }
      return resp;
  }
      
      public boolean recuperar(){
        boolean resp = false;
      try{
          String sql = "select id_usuario, nombre_tipoU, nombre_usuario, correo_emp from usuario,empleado, tipo_usuario where usuario.id_empleado = empleado.id_empleado and empleado.id_tipousuario = tipo_usuario.id_tipousuario and id_estadousuario = 1 and correo_emp = ?"; 
          PreparedStatement cmd = cn.prepareStatement(sql);
          cmd.setString(1, correo2);
          ResultSet rs = cmd.executeQuery();
          if(rs.next()){
              resp = true;
              Codigo = rs.getInt(1);
              contraseña = rs.getString(2);
              usuario = rs.getString(3);  
          }
          recuperar_contra2.lblnombre.setText(usuario); 
          recuperar_contra2.lblcargo.setText(contraseña); 
          cmd.close();
          cn.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  } 
      
      public boolean recuperar2(){
        boolean resp = false;
      try{
          String sql = "select id_usuario, nombre_tipoU, nombre_usuario, correo_emp from usuario,empleado, tipo_usuario where usuario.id_empleado = empleado.id_empleado and empleado.id_tipousuario = tipo_usuario.id_tipousuario and id_estadousuario = 1 and correo_emp = ?"; 
          PreparedStatement cmd = cn.prepareStatement(sql);
          cmd.setString(1, correo2);
          ResultSet rs = cmd.executeQuery();
          if(rs.next()){
              resp = true;
              Codigo = rs.getInt(1);
              contraseña = rs.getString(2);
              usuario = rs.getString(3); 
              Usuario2 = rs.getString(3);
          }
          recuperar_contra3.lblnombre.setText(usuario); 
          recuperar_contra3.lblcargo.setText(contraseña); 
          cmd.close();
          cn.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  } 
      
      public boolean modificar_usuario2(){
      boolean resp = false;
      try{
          String sql = "UPDATE usuario Set contra=? where nombre_usuario = ?";
          PreparedStatement cmd = cn.prepareStatement(sql);
            //LLEnamos los parametros de la clase
            cmd.setString(1, Encriptacion.encriptar(contraseña));
            cmd.setString(2, Usuario2);
            if(!cmd.execute()){
                resp= true;
            }
            cmd.close();
            cn.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
      }
      return resp;
  }
       
      
}

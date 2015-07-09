/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Recursos_Humanos.Comisiones;
import Secretariado.Agenda_ventas;
import Secretariado.Lista_empleados;
import Vendedor.Agenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author bernardo
 */
public class Secretaria {
    private Connection cn;
    private Integer Codigo;
    private String Nombres;
    private String Apellidos;
    private String Telefono;
    private String Correo;
    private Integer Tipo;
    private String Nombre_tipo;
    private String Ubicacion;
    private String Dimension;
    private String Descripcion;
    private String Precio_base;
    private String Fecha;
    private Date Fecha_sumada;
    private String Hora;
    public static Integer ID_emp = 0;

    public Date getFecha_sumada() {
        return Fecha_sumada;
    }

    public void setFecha_sumada(Date Fecha_sumada) {
        this.Fecha_sumada = Fecha_sumada;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getPrecio_base() {
        return Precio_base;
    }

    public void setPrecio_base(String Precio_base) {
        this.Precio_base = Precio_base;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    private String Precio;

    public String getDimension() {
        return Dimension;
    }

    public void setDimension(String Dimension) {
        this.Dimension = Dimension;
    }

    public String getNombre_tipo() {
        return Nombre_tipo;
    }

    public void setNombre_tipo(String Nombre_tipo) {
        this.Nombre_tipo = Nombre_tipo;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public Integer getTipo() {
        return Tipo;
    }

    public void setTipo(Integer Tipo) {
        this.Tipo = Tipo;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }
    

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer Codigo) {
        this.Codigo = Codigo;
    }
    
    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    public Secretaria()
    {
        conexion con = new conexion();
        cn = con.conexion();
    }
    
    public void Lista_empleados(){
      try{
          String sql3 = "select id_empleado, nombres_emp, apellidos_emp, telefono_emp from empleado, tipo_usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario and empleado.id_tipousuario = 1";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              DefaultTableModel modelo = (DefaultTableModel)Lista_empleados.Tabla_ListEmp.getModel();
              modelo.addRow(new Object[4]);
              int nuevaFila = modelo.getRowCount()-1;
              Codigo = rs3.getInt(1);
              Nombres = rs3.getString(2);
              Apellidos = rs3.getString(3);
              Telefono = rs3.getString(4);
              Lista_empleados.Tabla_ListEmp.setValueAt(Codigo, nuevaFila, 0);
              Lista_empleados.Tabla_ListEmp.setValueAt(Nombres, nuevaFila, 1);
              Lista_empleados.Tabla_ListEmp.setValueAt(Apellidos, nuevaFila, 2);
              Lista_empleados.Tabla_ListEmp.setValueAt(Telefono, nuevaFila, 3);
              
              
            Lista_empleados.Tabla_ListEmp.getColumnModel().getColumn(0).setMaxWidth(0);
            Lista_empleados.Tabla_ListEmp.getColumnModel().getColumn(0).setMinWidth(0);
            Lista_empleados.Tabla_ListEmp.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            Lista_empleados.Tabla_ListEmp.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
          }
          cmd3.close();
          cn.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
  }
    
    public void Lista_clientes(){
      try{
          String sql3 = "Select id_cliente, nombres_cliente, apellidos_cliente, Telefono, Correo from cliente ";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              DefaultTableModel modelo = (DefaultTableModel)Agenda_ventas.tabla_clientes.getModel();
              modelo.addRow(new Object[4]);
              int nuevaFila = modelo.getRowCount()-1;
              Codigo = rs3.getInt(1);
              Nombres = rs3.getString(2);
              Apellidos = rs3.getString(3);
              Telefono = rs3.getString(4);
              Correo = rs3.getString(5);
              Agenda_ventas.tabla_clientes.setValueAt(Codigo, nuevaFila, 0);
              Agenda_ventas.tabla_clientes.setValueAt(Nombres, nuevaFila, 1);
              Agenda_ventas.tabla_clientes.setValueAt(Apellidos, nuevaFila, 2);
              Agenda_ventas.tabla_clientes.setValueAt(Telefono, nuevaFila, 3);
              Agenda_ventas.tabla_clientes.setValueAt(Correo, nuevaFila, 4);
              
              
            Agenda_ventas.tabla_clientes.getColumnModel().getColumn(0).setMaxWidth(0);
            Agenda_ventas.tabla_clientes.getColumnModel().getColumn(0).setMinWidth(0);
            Agenda_ventas.tabla_clientes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            Agenda_ventas.tabla_clientes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
          }
          cmd3.close();
          cn.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
  }
    
    public void Lista_propiedades(){
      try{
          String sql3 = "Select id_propiedad, nombre_tipoP, Direccion, Dimension, Descripcion_propiedad, Precio_base from propiedad,tipo_propiedad where propiedad.id_tipoPropiedad = tipo_propiedad.id_tipoPropiedad and id_estadopropi = 1";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              DefaultTableModel modelo = (DefaultTableModel)Agenda_ventas.tabla_propiedades.getModel();
              modelo.addRow(new Object[4]);
              int nuevaFila = modelo.getRowCount()-1;
              Codigo = rs3.getInt(1);
              Nombre_tipo = rs3.getString(2);
              Ubicacion = rs3.getString(3);
              Dimension = rs3.getString(4);
              Descripcion = rs3.getString(5);
              Precio_base = rs3.getString(6);
              Agenda_ventas.tabla_propiedades.setValueAt(Codigo, nuevaFila, 0);
              Agenda_ventas.tabla_propiedades.setValueAt(Nombre_tipo, nuevaFila, 1);
              Agenda_ventas.tabla_propiedades.setValueAt(Ubicacion, nuevaFila, 2);
              Agenda_ventas.tabla_propiedades.setValueAt(Dimension, nuevaFila, 3);
              Agenda_ventas.tabla_propiedades.setValueAt(Descripcion, nuevaFila, 4);
              Agenda_ventas.tabla_propiedades.setValueAt(Precio_base, nuevaFila, 5);
              
              
            Agenda_ventas.tabla_propiedades.getColumnModel().getColumn(0).setMaxWidth(0);
            Agenda_ventas.tabla_propiedades.getColumnModel().getColumn(0).setMinWidth(0);
            Agenda_ventas.tabla_propiedades.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            Agenda_ventas.tabla_propiedades.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
          }
          cmd3.close();
          cn.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
  }
    
    public void Lista_agenda(){
      try{
          
          //String sql3 = "Select id_agenda, Agenda_ventas.id_cliente,  cliente.apellidos_cliente, Agenda_ventas.id_propiedad, Direccion, Fecha, Hora, Agenda_ventas.id_estadoAV, nombre_estadoAV from Agenda_ventas,empleado,cliente,propiedad,estado_AV where Agenda_ventas.id_cliente = cliente.id_cliente and Agenda_ventas.id_propiedad = propiedad.id_propiedad and Agenda_ventas.id_empleado = " + ID_emp + " and Agenda_ventas.id_estadoAV = estado_AV.id_estadoAV  and Agenda_ventas.id_empleado = empleado.id_empleado and Agenda_ventas.id_estadoAV != 4 and Agenda_ventas.id_estadoAV != 1";
         String sql3 = "Select id_agenda, Agenda_ventas.id_cliente, cliente.apellidos_cliente, Agenda_ventas.id_propiedad, Direccion, Fecha, Hora, Agenda_ventas.id_estadoAV,  estado_AV.nombre_estadoAV from Agenda_ventas,empleado,cliente,propiedad,estado_AV where Agenda_ventas.id_cliente = cliente.id_cliente and Agenda_ventas.id_propiedad = propiedad.id_propiedad and Agenda_ventas.id_empleado = " + ID_emp + "and Agenda_ventas.id_estadoAV = estado_AV.id_estadoAV  and Agenda_ventas.id_empleado = empleado.id_empleado and Agenda_ventas.id_estadoAV != 1 and Agenda_ventas.id_estadoAV != 4"; 
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              DefaultTableModel modelo = (DefaultTableModel)Agenda_ventas.tabla_agenda.getModel();
              modelo.addRow(new Object[4]);
              int nuevaFila = modelo.getRowCount()-1;
              Codigo = rs3.getInt(1);
              Nombres = rs3.getString(2);
              Apellidos = rs3.getString(3);
              Tipo = rs3.getInt(4);
              Ubicacion = rs3.getString(5);
              Fecha_sumada = rs3.getDate(6);
              Fecha_sumada = Fechas.sumarFechasDias(Fecha_sumada, 2);
              Time Ahora = rs3.getTime(7);
              SimpleDateFormat formatoDelTexto = new SimpleDateFormat("hh:mm a");
              Hora = formatoDelTexto.format(Ahora);
              Dimension = rs3.getString(8);
              Nombre_tipo = rs3.getString(9);
              
              Agenda_ventas.tabla_agenda.setValueAt(Codigo, nuevaFila, 0);
              Agenda_ventas.tabla_agenda.setValueAt(Nombres, nuevaFila, 1);
              Agenda_ventas.tabla_agenda.setValueAt(Apellidos, nuevaFila, 2);
              Agenda_ventas.tabla_agenda.setValueAt(Tipo, nuevaFila, 3);
              Agenda_ventas.tabla_agenda.setValueAt(Ubicacion, nuevaFila, 4);
              Agenda_ventas.tabla_agenda.setValueAt(Fecha_sumada, nuevaFila, 5);
              Agenda_ventas.tabla_agenda.setValueAt(Hora, nuevaFila, 6);
              Agenda_ventas.tabla_agenda.setValueAt(Dimension, nuevaFila, 7);
              Agenda_ventas.tabla_agenda.setValueAt(Nombre_tipo, nuevaFila, 8);
              
            Agenda_ventas.tabla_agenda.getColumnModel().getColumn(0).setMaxWidth(0);
            Agenda_ventas.tabla_agenda.getColumnModel().getColumn(0).setMinWidth(0);
            Agenda_ventas.tabla_agenda.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            Agenda_ventas.tabla_agenda.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
            Agenda_ventas.tabla_agenda.getColumnModel().getColumn(1).setMaxWidth(0);
            Agenda_ventas.tabla_agenda.getColumnModel().getColumn(1).setMinWidth(0);
            Agenda_ventas.tabla_agenda.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
            Agenda_ventas.tabla_agenda.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
            
            Agenda_ventas.tabla_agenda.getColumnModel().getColumn(3).setMaxWidth(0);
            Agenda_ventas.tabla_agenda.getColumnModel().getColumn(3).setMinWidth(0);
            Agenda_ventas.tabla_agenda.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
            Agenda_ventas.tabla_agenda.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
            
            Agenda_ventas.tabla_agenda.getColumnModel().getColumn(7).setMaxWidth(0);
            Agenda_ventas.tabla_agenda.getColumnModel().getColumn(7).setMinWidth(0);
            Agenda_ventas.tabla_agenda.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
            Agenda_ventas.tabla_agenda.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
            
          }
          cmd3.close();
          cn.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
  }
    
    
    public boolean Guardar_cita() { 
        boolean resp = false;
     try { 
         String sql2 = "select id_estadoAV from estado_AV where nombre_estadoAV ='"+Agenda_ventas.cmbEstado.getSelectedItem().toString()+"'"; 
            PreparedStatement cmd2 = cn.prepareStatement(sql2);
            ResultSet rs2 = cmd2.executeQuery();
            if(rs2.next()){
               Tipo = rs2.getInt(1);        
          }
         String sql = "Insert into agenda_ventas(id_cliente, id_empleado, id_propiedad, fecha, hora, id_estadoAV) VALUES(?, " + ID_emp + ", ?, ?, ?, ?)";
      PreparedStatement cmd = cn.prepareStatement(sql); 
            cmd.setInt(1, Codigo);
            cmd.setString(2, Ubicacion); 
            cmd.setString(3, Fecha); 
            cmd.setString(4, Hora);
            cmd.setInt(5, Tipo); 
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
    
    
    public boolean Modificar_cita() { 
        boolean resp = false;
     try { 
         String sql2 = "select id_estadoAV from estado_AV where nombre_estadoAV ='"+Agenda_ventas.cmbEstado.getSelectedItem().toString()+"'"; 
            PreparedStatement cmd2 = cn.prepareStatement(sql2);
            ResultSet rs2 = cmd2.executeQuery();
            if(rs2.next()){
               Tipo = rs2.getInt(1);        
          }
         String sql = "Update agenda_ventas set id_cliente = ?, id_empleado = " + ID_emp + ", id_propiedad = ?, fecha = ?, hora = ?, id_estadoAV = ? where id_agenda = ?";
      PreparedStatement cmd = cn.prepareStatement(sql); 
            cmd.setInt(1, Codigo);
            cmd.setString(2, Ubicacion); 
            cmd.setString(3, Fecha); 
            cmd.setString(4, Hora);
            cmd.setInt(5, Tipo); 
            cmd.setString(6, Nombres);
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
    
    public boolean Eliminar_cita() {  
        boolean resp = false;
       try { 
           String sql = "DELETE FROM Agenda_ventas WHERE id_agenda = ?;";
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
    
    
    public void agenda_empleado(){
      try{
          String sql = "Select id_empleado from usuario where id_usuario =" + Consultas.codigoU + "";
          PreparedStatement cmd = cn.prepareStatement(sql);
          ResultSet rs = cmd.executeQuery();
          System.out.println(Consultas.codigoU);
          if(rs.next()){
              ID_emp = rs.getInt(1);
          }
          String sql3 = "Select id_agenda, apellidos_cliente, Direccion, precio_base, Fecha, Hora, nombre_estadoAV from Agenda_ventas,empleado,cliente,propiedad,estado_AV where Agenda_ventas.id_cliente = cliente.id_cliente and Agenda_ventas.id_propiedad = propiedad.id_propiedad and Agenda_ventas.id_empleado = " + ID_emp + " and Agenda_ventas.id_estadoAV = estado_AV.id_estadoAV  and Agenda_ventas.id_empleado = empleado.id_empleado and Agenda_ventas.id_estadoAV != 1 and Agenda_ventas.id_estadoAV != 4";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              DefaultTableModel modelo = (DefaultTableModel)Agenda.tabla_agenda.getModel();
              modelo.addRow(new Object[4]);
              int nuevaFila = modelo.getRowCount()-1;
              Codigo = rs3.getInt(1);
              Apellidos = rs3.getString(2);
              Ubicacion = rs3.getString(3);
              Precio_base = rs3.getString(4);
              Fecha_sumada = rs3.getDate(5);
              Fecha_sumada = Fechas.sumarFechasDias(Fecha_sumada, 2);
              Time Ahora = rs3.getTime(6);
              SimpleDateFormat formatoDelTexto = new SimpleDateFormat("hh:mm a");
              Hora = formatoDelTexto.format(Ahora);
              Nombre_tipo = rs3.getString(7);
              
              Agenda.tabla_agenda.setValueAt(Codigo, nuevaFila, 0);
              Agenda.tabla_agenda.setValueAt(Apellidos, nuevaFila, 1);
              Agenda.tabla_agenda.setValueAt(Ubicacion, nuevaFila, 2);
              Agenda.tabla_agenda.setValueAt(Precio_base, nuevaFila, 3);
              Agenda.tabla_agenda.setValueAt(Fecha_sumada, nuevaFila, 4);
              Agenda.tabla_agenda.setValueAt(Hora, nuevaFila, 5);
              Agenda.tabla_agenda.setValueAt(Nombre_tipo, nuevaFila, 6);
              
            Agenda.tabla_agenda.getColumnModel().getColumn(0).setMaxWidth(0);
            Agenda.tabla_agenda.getColumnModel().getColumn(0).setMinWidth(0);
            Agenda.tabla_agenda.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            Agenda.tabla_agenda.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
            
          }
          cmd3.close();
          cn.close();
          ID_emp = 0;
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println(e.getMessage());
      }
  }
    
    public boolean Modificar_agendaEmpleado() { 
        boolean resp = false;
     try { 
         String sql = "Update agenda_ventas set id_estadoAV = ? where id_agenda = ?";
      PreparedStatement cmd = cn.prepareStatement(sql); 
            cmd.setInt(1, Tipo);
            cmd.setInt(2, Codigo);
     if(!cmd.execute()) {
         resp = true;
     } 
     cmd.close(); 
     cn.close();
     
     } 
     catch (Exception e) { 
         System.out.println(e.toString()); 
     } 
     return resp; 
    }
    
    public static String Cambiado = "Agenda_ventas.id_estadoAV = 3 or Agenda_ventas.id_estadoAV = 4";
    public void Propiedades_vendidas_y_no(){
      try{
          String sql3 = "Select id_agenda, apellidos_cliente, Direccion, Precio_base, Fecha, Hora, nombre_estadoAV from Agenda_ventas,empleado,cliente,propiedad,estado_AV where Agenda_ventas.id_cliente = cliente.id_cliente and Agenda_ventas.id_propiedad = propiedad.id_propiedad and Agenda_ventas.id_empleado = " + ID_emp + " and Agenda_ventas.id_estadoAV = estado_AV.id_estadoAV  and Agenda_ventas.id_empleado = empleado.id_empleado and ("+ Cambiado +")";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              DefaultTableModel modelo = (DefaultTableModel)Comisiones.tabla_comisiones.getModel();
              modelo.addRow(new Object[4]);
              int nuevaFila = modelo.getRowCount()-1;
              Codigo = rs3.getInt(1);
              Apellidos = rs3.getString(2);
              Ubicacion = rs3.getString(3);
              Precio_base = rs3.getString(4);
              Fecha_sumada = rs3.getDate(5);
              Fecha_sumada = Fechas.sumarFechasDias(Fecha_sumada, 2);
              Time Ahora = rs3.getTime(6);
              SimpleDateFormat formatoDelTexto = new SimpleDateFormat("hh:mm a");
              Hora = formatoDelTexto.format(Ahora);
              Nombre_tipo = rs3.getString(7);
              Comisiones.tabla_comisiones.setValueAt(Codigo, nuevaFila, 0);
              Comisiones.tabla_comisiones.setValueAt(Apellidos, nuevaFila, 1);
              Comisiones.tabla_comisiones.setValueAt(Ubicacion, nuevaFila, 2);
              Comisiones.tabla_comisiones.setValueAt(Precio_base, nuevaFila, 3);
              Comisiones.tabla_comisiones.setValueAt(Fecha_sumada, nuevaFila, 4);
              Comisiones.tabla_comisiones.setValueAt(Hora, nuevaFila, 5);
              Comisiones.tabla_comisiones.setValueAt(Nombre_tipo, nuevaFila, 6);
              
              
            Comisiones.tabla_comisiones.getColumnModel().getColumn(0).setMaxWidth(0);
            Comisiones.tabla_comisiones.getColumnModel().getColumn(0).setMinWidth(0);
            Comisiones.tabla_comisiones.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            Comisiones.tabla_comisiones.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
          }
          cmd3.close();
          cn.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
  }
    
}

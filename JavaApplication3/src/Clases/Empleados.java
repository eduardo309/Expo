/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Comprador.Propiedades;
import Recursos_Humanos.empleado;
import java.sql.Connection;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bernardo
 */
public class Empleados {
    private Connection cn;
    private Integer ID;
    private Integer Codigo;
    private String Usuario;
    private String Nombres;
    private String Apellidos;
    private Double Sueldo;
    private Integer ISSS;
    private String AFP;
    private String DUI;
    private String NIT;
    private String Telefono;
    private String Correo;
    private String EstadoCivil;
    private String tipo_usuario;
    private String Estado;
    
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getAFP() {
        return AFP;
    }

    public void setAFP(String AFP) {
        this.AFP = AFP;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer Codigo) {
        this.Codigo = Codigo;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getEstadoCivil() {
            return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getISSS() {
        return ISSS;
    }

    public void setISSS(Integer ISSS) {
        this.ISSS = ISSS;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public Double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(Double Sueldo) {
        this.Sueldo = Sueldo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    public Empleados(){
        conexion con = new conexion();
        cn = con.conexion();
    }
    
    public boolean Empleados(){
        boolean resp = false;
        try{
           String sql = "select id_empleado,nombre_tipoU, nombres_emp, apellidos_emp, sueldo, ISS, AFP, DUI, NIT, telefono_emp, correo_emp, Estado_civil from empleado, tipo_usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario"; 
           PreparedStatement cmd3 = cn.prepareStatement(sql);
          ResultSet rs = cmd3.executeQuery();
          while(rs.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)empleado.tabla_empleados.getModel();
              modelo.addRow(new Object[14]);
              int nuevaFila = modelo.getRowCount()-1;
              ID = rs.getInt(1);
              Usuario = rs.getString(2);
              Nombres = rs.getString(3);
              Apellidos = rs.getString(4);
              Sueldo = rs.getDouble(5);
              ISSS = rs.getInt(6);
              AFP = rs.getString(7);
              DUI = rs.getString(8);
              NIT = rs.getString(9);
              Telefono = rs.getString(10);
              Correo = rs.getString(11);
              EstadoCivil = rs.getString(12);
              
              empleado.tabla_empleados.setValueAt(ID, nuevaFila, 0);
              empleado.tabla_empleados.setValueAt(Usuario, nuevaFila, 1);
              empleado.tabla_empleados.setValueAt(Nombres, nuevaFila, 2);
              empleado.tabla_empleados.setValueAt(Apellidos, nuevaFila, 3);
              empleado.tabla_empleados.setValueAt(Sueldo, nuevaFila, 4);
              empleado.tabla_empleados.setValueAt(ISSS, nuevaFila, 5);
              empleado.tabla_empleados.setValueAt(AFP, nuevaFila, 6);
              empleado.tabla_empleados.setValueAt(DUI, nuevaFila, 7);
              empleado.tabla_empleados.setValueAt(NIT, nuevaFila, 8);
              empleado.tabla_empleados.setValueAt(Telefono, nuevaFila, 9);
              empleado.tabla_empleados.setValueAt(Correo, nuevaFila, 10);
              empleado.tabla_empleados.setValueAt(EstadoCivil, nuevaFila, 11);
              
              
              
              
          }
          cmd3.close();
          cn.close();
            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("Aqui");
        }
        return resp;
    }
    
    public boolean guardar_empleado() { 
        boolean resp = false; 
        try {
        String sql0 = "select * from tipo_usuario where nombre_tipoU = '" + empleado.cmbCargo.getSelectedItem() + "'";
        PreparedStatement cmd0 = cn.prepareStatement(sql0);
        ResultSet rs = cmd0.executeQuery();
        if(rs.next())
        {
            Codigo = rs.getInt(1);
            Estado = rs.getString(2);
        }
            System.out.println(Estado);
        if("Administrador".equals(Estado) || "Recursos Humanos".equals(Estado) || "Vendedor".equals(Estado) || "Comprador".equals(Estado) || "Secretaria".equals(Estado)){
            String sql = "insert into empleado (id_tipousuario, nombres_emp, apellidos_emp, sueldo, id_estadoempleado, id_estadousuario, ISS, AFP, DUI, NIT, telefono_emp, correo_emp, Estado_civil)  values(?, ?, ?, ?, 1, 2,?, ?, ?, ?, ?, ?, ?)"; 
            PreparedStatement cmd = cn.prepareStatement(sql);                   
            cmd.setInt(1, Codigo); 
            cmd.setString(2, Nombres);
            cmd.setString(3, Apellidos); 
            cmd.setDouble(4, Sueldo);
            cmd.setInt(5, ISSS); 
            cmd.setString(6, AFP); 
            cmd.setString(7, DUI);
            cmd.setString(8, NIT);
            cmd.setString(9, Telefono); 
            cmd.setString(10, Correo);
            cmd.setString(11, EstadoCivil);
            System.out.println("Hola");
            if(!cmd.execute()) {  
                resp = true; 
            }
            cmd.close(); 
        }else{
            String sql = "insert into empleado (id_tipousuario, nombres_emp, apellidos_emp, sueldo, id_estadoempleado, ISS, AFP, DUI, NIT, telefono_emp, correo_emp, Estado_civil)  values(?, ?, ?, ?, 1 ,?, ?, ?, ?, ?, ?, ?)"; 
            PreparedStatement cmd = cn.prepareStatement(sql);                   
            cmd.setInt(1, Codigo); 
            cmd.setString(2, Nombres);
            cmd.setString(3, Apellidos); 
            cmd.setDouble(4, Sueldo);
            cmd.setInt(5, ISSS); 
            cmd.setString(6, AFP); 
            cmd.setString(7, DUI);
            cmd.setString(8, NIT);
            cmd.setString(9, Telefono); 
            cmd.setString(10, Correo);
            cmd.setString(11, EstadoCivil);

            if(!cmd.execute()) {  
                resp = true; 
            }
            cmd.close();
        }
        
        }
        catch (Exception e) { 
            System.out.println(e.toString());

    } 
        return resp; 
    }
    
    public boolean modificar_empleado()
    {
        boolean resp = false;
        try{
            String sql = "Update empleado set nombres_emp = ?, apellidos_emp = ?, Sueldo = ?, ISS = ?, AFP = ?, DUI = ?, NIT = ?, telefono_emp = ?, correo_emp = ?, Estado_civil = ?  where id_empleado = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, Nombres);
            cmd.setString(2, Apellidos);
            cmd.setDouble(3, Sueldo);
            cmd.setInt(4, ISSS);
            cmd.setString(5, AFP);
            cmd.setString(6, DUI);
            cmd.setString(7, NIT);
            cmd.setString(8, Telefono);
            cmd.setString(9, Correo);
            cmd.setString(10, EstadoCivil);
            cmd.setInt(11, ID);
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            cn.close();
            }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return resp;
    }
    
    public boolean eliminar_empleado()
    {
        boolean resp = false;
        try
        {
            String sql = "Delete from empleado where id_empleado = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, Codigo);
            if(!cmd.execute())
            {
            resp= true;
            }
            cmd.close();
            cn.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return resp;
    }
    
    
    
    
}

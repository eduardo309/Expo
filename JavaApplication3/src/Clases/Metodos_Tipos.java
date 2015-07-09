/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Comprador.Propiedades;
import Administrador.Tipo_historial;
import Administrador.Tipo_propiedad1;
import Administrador.areas_trabajo;
import Administrador.control_usuarios;
/**
 *
 * @author bernardo
 */
public class Metodos_Tipos {
    public static Connection cn;
    private Integer Codigo;
    private String Nombre;
    private String sql;
    private String Res;
    private String Contra;
    private Integer Tipo;
    private Integer otro_codigo;

    public Integer getOtro_codigo() {
        return otro_codigo;
    }

    public void setOtro_codigo(Integer otro_codigo) {
        this.otro_codigo = otro_codigo;
    }
    
    public Integer getTipo() {
        return Tipo;
    }

    public void setTipo(Integer Tipo) {
        this.Tipo = Tipo;
    }
   
    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }
    
    public String getRes() {
        return Res;
    }

    public void setRes(String Res) {
        this.Res = Res;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public Metodos_Tipos(){
        //Establecemos la conexion
        conexion con = new conexion();
        cn = con.conexion();
    }
    
    public boolean buscar_Tipos(){
        boolean resp = false;
      try{
          if (sql != null){
          PreparedStatement cmd = cn.prepareStatement(sql);
          cmd.setInt(1, Codigo);
          ResultSet rs = cmd.executeQuery();
          if(rs.next()){
              resp = true;
              Codigo = rs.getInt(1);
              Nombre = rs.getString(2);
          }
          cmd.close();
          }
          cn.close();
          
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
    
    public boolean guardar_Tipos(){
        boolean resp = false;
        try{
            //consulta sql insert
            PreparedStatement cmd = cn.prepareStatement(sql);
            //LLEnamos los parametros de la calse
            cmd.setString(1, Nombre);
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
    
    public boolean modificar_Tipos(){
      boolean resp = false;
      try{
          PreparedStatement cmd = cn.prepareStatement(sql);
            //LLEnamos los parametros de la calse
            cmd.setString(1, Nombre);
            cmd.setInt(2, Codigo);
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
    
    public boolean eliminar_Tipos(){
        boolean resp = false;
        try{
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, Codigo);
            if(!cmd.execute()){
                resp = true;
            }
            cmd.close();
            cn.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return resp;
    }
    
    public boolean Tabla2(){
        boolean resp = false;
      try{
          String sql3 = "select id_empleado, nombres_emp, apellidos_emp, nombre_tipoU from empleado, tipo_usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario and estado_usuario = 'Desactivado'";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)Tipo_historial.tabla2.getModel();
              modelo.addRow(new Object[3]);
              int nuevaFila = modelo.getRowCount()-1;
            Codigo = rs3.getInt(1);
            Nombre = rs3.getString(2);
            Res = rs3.getString(3);
            Contra = rs3.getString(4);
            Tipo_historial.tabla2.setValueAt(Codigo, nuevaFila, 0);
            Tipo_historial.tabla2.setValueAt(Nombre, nuevaFila, 1);
            Tipo_historial.tabla2.setValueAt(Res, nuevaFila, 2);
            Tipo_historial.tabla2.setValueAt(Contra, nuevaFila, 3);
          }
          cmd3.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
 
    public boolean Tabla3(){
        boolean resp = false;
      try{
          String sql3 = "Select * From tipo_propiedad";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)Tipo_propiedad1.tabla3.getModel();
              modelo.addRow(new Object[3]);
              int nuevaFila = modelo.getRowCount()-1;
            Codigo = rs3.getInt(1);
            Nombre = rs3.getString(2);
            Tipo_propiedad1.tabla3.setValueAt(Codigo, nuevaFila, 0);
            Tipo_propiedad1.tabla3.setValueAt(Nombre, nuevaFila, 1);
          }
          cmd3.close();
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
          String sql3 = "select * from tipo_usuario";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)areas_trabajo.tabla6.getModel();
              modelo.addRow(new Object[3]);
              int nuevaFila = modelo.getRowCount()-1;
            Codigo = rs3.getInt(1);
            Nombre = rs3.getString(2);
            areas_trabajo.tabla6.setValueAt(Codigo, nuevaFila, 0);
            areas_trabajo.tabla6.setValueAt(Nombre, nuevaFila, 1);
          }
          cmd3.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
    
    
    public boolean buscar_usuario(){
        boolean resp = false;
      try{
          String sql = "SELECT * FROM usuario where id_usuario = ?";
          PreparedStatement cmd = cn.prepareStatement(sql);
          cmd.setInt(1, Codigo);
          ResultSet rs = cmd.executeQuery();
          if(rs.next()){
              resp = true;
              Codigo = rs.getInt(1);
              Tipo = rs.getInt(2);
              Nombre = rs.getString(3);
              Contra = rs.getString(4);
              Res = rs.getString(5);
              otro_codigo = rs.getInt(6);              
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
    
    public boolean guardar_uuario(){
        boolean resp = false;
        try{
            //consulta sql insert
            String sql = "insert into usuario values(?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            //LLEnamos los parametros de la calse
            cmd.setInt(1, Tipo);
            cmd.setString(2, Nombre);
            cmd.setString(3, Encriptacion.encriptar(Contra));
           
            if(!cmd.execute()){
                resp= true;
            }
            cmd.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
            System.out.println("Usuario");
        }
        return resp;
    }
    
    public boolean modificar_empleado(){
        boolean resp = false;
        try{
            
            String sql2 = "update empleado set id_estadousuario = 1 where id_empleado = ?";
            PreparedStatement cmd2 = cn.prepareStatement(sql2);
            cmd2.setInt(1, Codigo);
            if(!cmd2.execute()){
                resp= true;
            }
            cmd2.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
            System.out.println("Empleado");
        }
        return resp;
    }
    
//    public boolean modificar_usuario(){
//      boolean resp = false;
//      try{
//          String sql2 = "SELECT id_tipousuario FROM tipo_usuario where nombre_tipoU = '"+control_usuarios.cmbTipoU.getSelectedItem()+"'";
//          PreparedStatement cmd2 = cn.prepareStatement(sql2);
//          ResultSet rs2 = cmd2.executeQuery();
//            if(rs2.next()){
//              Codigo = rs2.getInt(1);              
//          }
//          String sql = "UPDATE usuario Set id_tipousuario = ?, nombre_usuario = ?, contra=?, Res_pregunta=?, codigo_pregunta = ? where id_usuario = ?";
//          PreparedStatement cmd = cn.prepareStatement(sql);
//            //LLEnamos los parametros de la calse
//            cmd.setInt(1, Codigo);
//            cmd.setString(2, Nombre);
//            cmd.setString(3, Encriptacion.encriptar(Contra));
//            cmd.setString(4, Res);
//            cmd.setInt(5, Tipo);
//            cmd.setInt(6, otro_codigo);
//            if(!cmd.execute()){
//                resp= true;
//            }
//            cmd.close();
//            cn.close();
//      }
//      catch(Exception e){
//          System.out.println(e.toString());
//      }
//      return resp;
//  }
    
    public boolean eliminar_usuario(){
        boolean resp = false;
        try{
            String sql = "DELETE FROM usuario where id_usuario = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, Codigo);
            if(!cmd.execute()){
                resp = true;
            }
            cmd.close();
            cn.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return resp;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Administrador.estadoempleado;
import Administrador.estadopropiedad;
import Administrador.estadousuario;
import Clases.conexion;
import Administrador.unidadesmedidas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author oscar
 */
public class mthestados2 {
    
    public Connection cn;

    
    private String consulta;

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getConsulta() {
        return consulta;
    }
    private String Nombre;
    public static Integer ID_actual = 0; //Variable statica para guardar en memoria el usuario actual, validacion de que no se pueda eliminar a si mismo
    private Integer codigo;

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public static void setID_actual(Integer ID_actual) {
        mthestados2.ID_actual = ID_actual;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Connection getCn() {
        return cn;
    }

    public String getNombre() {
        return Nombre;
    }

    public static Integer getID_actual() {
        return ID_actual;
    }

    public Integer getCodigo() {
        return codigo;
    }
    
    public mthestados2(){
        conexion con = new conexion();
        cn = con.conexion();
        
    }
    
    public boolean guardar_estado(){
        boolean resp = false;
        try{
            //consulta sql insert
           
            PreparedStatement cmd = cn.prepareStatement(consulta);
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
    
    
    
    public boolean delete_estado(){
        boolean resp = true;
        try{
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setInt(1, codigo);
            if(!cmd.execute()){
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
    
    public boolean modify_estado(){
        boolean resp = false;
        try{
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setString(1, Nombre);
            cmd.setInt(2, codigo);
            if(!cmd.execute()){
                resp =true;
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
    
    
    //para actualizar la tabla estado de empleado
    
    public boolean tabla_estadoemp(){
        boolean resp = false;
        
      try{
          String sql = "select * from estado_empleado";
          
          PreparedStatement cmd3 = cn.prepareStatement(sql);
          ResultSet rs = cmd3.executeQuery();
          while(rs.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)estadoempleado.tablaestadoemp.getModel();
              modelo.addRow(new Object[3]);
              int nuevaFila = modelo.getRowCount()-1;
            codigo = rs.getInt(1);
            Nombre = rs.getString(2);
            
            
            
            estadoempleado.tablaestadoemp.setValueAt(codigo, nuevaFila, 0);
            estadoempleado.tablaestadoemp.setValueAt(Nombre, nuevaFila, 1);
          }
          
          
          cmd3.close();
          cn.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Es aqui o no?");
      }
      return resp;
  }
    
    
    //PARA ACTUALIZAR LA TABLA DE LOS ESTADOS DE USUARIOS
    public boolean tabla_estadousu(){
        boolean resp = false;
        try{
            String sql="select * from estado_usuario";
            PreparedStatement cmd3 = cn.prepareStatement(sql);
          ResultSet rs = cmd3.executeQuery();
          while(rs.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)estadousuario.tablaestadousu.getModel();
              modelo.addRow(new Object[3]);
              int nuevaFila = modelo.getRowCount()-1;
            codigo = rs.getInt(1);
            Nombre = rs.getString(2);
            
            
            
            estadousuario.tablaestadousu.setValueAt(codigo, nuevaFila, 0);
            estadousuario.tablaestadousu.setValueAt(Nombre, nuevaFila, 1);
          }
          
          
          cmd3.close();
          cn.close();
            
        }
        catch (Exception e){
            System.out.println(e.toString());
          System.out.println("Es aqui o no?");
        }
        return resp;
    }
    
    //ACTULIZAR TABLA DE ESTADO PROPIEDAD
    
    public boolean tabla_estadopropi(){
        boolean resp = false;
        try{
            String sql="select * from estado_propi";
            PreparedStatement cmd3 = cn.prepareStatement(sql);
            ResultSet rs = cmd3.executeQuery();
            while(rs.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)estadopropiedad.tablaestadopropi.getModel();
              modelo.addRow(new Object[3]);
              int nuevaFila = modelo.getRowCount()-1;
            codigo = rs.getInt(1);
            Nombre = rs.getString(2);
            
            
            
            estadopropiedad.tablaestadopropi.setValueAt(codigo, nuevaFila, 0);
            estadopropiedad.tablaestadopropi.setValueAt(Nombre, nuevaFila, 1);
          }
          
          
          cmd3.close();
          cn.close();
            
        }
        catch(Exception e){
            System.out.println(e.toString());
          System.out.println("Es aqui o no?");
        }
        return resp;
    }
    
    
    
    
    
}

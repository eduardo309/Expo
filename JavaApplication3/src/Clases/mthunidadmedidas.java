/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Administrador.*;
import Clases.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class mthunidadmedidas {
    public Connection cn;
    
    private String Nombre;
    public static Integer ID_actual = 0; //Variable statica para guardar en memoria el usuario actual, validacion de que no se pueda eliminar a si mismo
    private Integer Numero;

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public static void setID_actual(Integer ID_actual) {
        mthunidadmedidas.ID_actual = ID_actual;
    }

    public void setNumero(Integer Numero) {
        this.Numero = Numero;
    }

    public String getNombre() {
        return Nombre;
    }

    public static Integer getID_actual() {
        return ID_actual;
    }

    public Integer getNumero() {
        return Numero;
    }
    
    public mthunidadmedidas() {
        conexion con = new conexion();
        cn = con.conexion();
    }
    
    
    public boolean save_unidad(){
        boolean resp = false;
        try{
            //consulta sql insert
            String sql = "INSERT INTO unidad_medida(nombre_unidad) values(?)";
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
    
    //para actualizar la tabla unidad de medidas
    public boolean tabla_unidad(){
        boolean resp = false;
        
      try{
          String sql = "select id_unidad, nombre_unidad from unidad_medida";
          
          PreparedStatement cmd3 = cn.prepareStatement(sql);
          ResultSet rs = cmd3.executeQuery();
          while(rs.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)unidadesmedidas.tablaunidadmedidas.getModel();
              modelo.addRow(new Object[3]);
              int nuevaFila = modelo.getRowCount()-1;
            Numero = rs.getInt(1);
            Nombre = rs.getString(2);
            
            
            
            unidadesmedidas.tablaunidadmedidas.setValueAt(Numero, nuevaFila, 0);
            unidadesmedidas.tablaunidadmedidas.setValueAt(Nombre, nuevaFila, 1);
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
    
     public boolean modify_unidad(){
      boolean resp = false;
      try{
          String sql = "update unidad_medida set nombre_unidad = ? where id_unidad = ?";
          PreparedStatement cmd = cn.prepareStatement(sql);
            //LLEnamos los parametros de la calse
            cmd.setString(1, Nombre);
            cmd.setInt(2, Numero);
            
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
     public boolean delete_unidad(){
        boolean resp = false;
        try{
            String sql = "Delete from unidad_medida where id_unidad = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, Numero);
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

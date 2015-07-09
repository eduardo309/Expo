/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import Administrador.areas_trabajo;
import Clases.conexion;
import static Administrador.areas_trabajo.tabla6;
/**
 *
 * @author oscar
 */
public class consultas1 {
    
    // setter y getters de departamentos
    private Integer codigo;
    private String depto;
    private Connection cn;

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDepto() {
        return depto;
    }    
    
     public consultas1() { 
        conexion con = new conexion(); 
        cn = con.conexion(); 
    }   
    
    public boolean Tabla1(){
        boolean resp = false;
        
      try{
          String sql3 = "select id_depto, nombre_depto from departamentos"; 
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)areas_trabajo.tabla6.getModel();
              modelo.addRow(new Object[3]);
              int nuevaFila = modelo.getRowCount()-1;
            codigo = rs3.getInt(1);
            depto = rs3.getString(2);
            
            areas_trabajo.tabla6.setValueAt(codigo, nuevaFila, 0);
            areas_trabajo.tabla6.setValueAt(depto, nuevaFila, 1);
            
          }
          
          
          cmd3.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
    
     public boolean guardardep()
    {
        boolean resp = false;
        try
        {
            //se realiza una consulta insert
            String sql="INSERT INTO departamentos(nombre_depto)"+"VALUES(?);";
            PreparedStatement cmd = cn.prepareStatement(sql);
            // se llenan los parametros de la clase 
            
            cmd.setString(1,depto);
            
            //si se da el error devuelve 1 en caso contrario 0
            //tomar en cuenta el "!" de negacion
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
     
     public boolean modificardep()
    {
        boolean resp = false;
        try
        {
            //se hace la consulta update
        String sql = "UPDATE departamentos SET nombre_depto= ? WHERE id_depto=?;";      
        PreparedStatement cmd = cn.prepareStatement(sql);
        // se llenan los parametros 
        cmd.setString(1, depto);
        
        cmd.setInt(2, codigo);
        
        if(!cmd.execute())
        {
            resp = true;
        }
        cmd.close();;
        cn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return resp;
    }
     
     public boolean elmininardep()
    {
        boolean resp = false;
        try
        {
            // se realiza consulta delete 
            String sql ="DELETE FROM departamentos WHERE id_depto=?;";
            PreparedStatement cmd = cn.prepareStatement(sql);
            // se llenan los parametros 
            cmd.setInt(1, codigo);
            
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            cn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return resp;
    }
     
     
    //----------------------------------------tipode usuario
     
     
     
     private String tip;

    public Connection getCn() {
        return cn;
    }

    public String getTip() {
        return tip;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }


    

}







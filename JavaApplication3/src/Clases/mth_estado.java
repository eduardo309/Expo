/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Administrador.control_usuarios;
import Administrador.estado_a;
/**
 *
 * @author kevin Vásquez
 */
public class mth_estado 
{
    
        private Connection cn;
        private Integer id_estadoAV;
        private String nombre_estadoAV;

        public Connection getCn() {
            return cn;
        }

        public void setCn(Connection cn) {
            this.cn = cn;
        }

        public Integer getId_estadoAV() {
            return id_estadoAV;
        }

        public void setId_estadoAV(Integer id_estadoAV) {
            this.id_estadoAV = id_estadoAV;
        }

        public String getNombre_estadoAV() {
            return nombre_estadoAV;
        }

        public void setNombre_estadoAV(String nombre_estadoAV) {
            this.nombre_estadoAV = nombre_estadoAV;
        }

        
        public mth_estado()
        {
            conexion con = new conexion();
            cn= con.conexion();
        }
        //insert
        public boolean guardar()
        {
            boolean resp = false;
            try
            {
                String sql = "insert into estado_AV(nombre_estadoAV) values(?)";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setString(1,nombre_estadoAV);
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
        //consultar
        public boolean consulta()
        {
            boolean resp = false;
            try
            {
                String sql = "select * from estado_AV where id_estadoAV = ?";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setInt(1, id_estadoAV);
                ResultSet rs = cmd.executeQuery();
                if(rs.next())
                {
                    resp = true;
                    id_estadoAV = rs.getInt(1);
                    nombre_estadoAV = rs.getString(2);                    
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
        //update
        public boolean update()
        {
            boolean resp = false;
            try
            {
                String sql = "Update estado_AV set nombre_estadoAV = ? where id_estadoAV = ?;";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setString(1, nombre_estadoAV);
                cmd.setInt(2, id_estadoAV);
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
        //eliminar
        public boolean eliminar()
        {
            boolean resp = false;
            try
            {
                String sql= "Delete from estado_AV where id_estadoAV = ?;";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setInt(1,id_estadoAV);
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
    
        public boolean Tabla7(){
        boolean resp = false;
      try{
          String sql3 = "select * from estado_AV";
          PreparedStatement cmd3 = cn.prepareStatement(sql3);
          ResultSet rs3 = cmd3.executeQuery();
          while(rs3.next()){
              resp = true;
              DefaultTableModel modelo = (DefaultTableModel)estado_a.tabla8.getModel();
              modelo.addRow(new Object[2]);
              int nuevaFila = modelo.getRowCount()-1;
            id_estadoAV = rs3.getInt(1);
            nombre_estadoAV = rs3.getString(2);
            estado_a.tabla8.setValueAt(id_estadoAV, nuevaFila, 0);
            estado_a.tabla8.setValueAt(nombre_estadoAV, nuevaFila, 1);

          }
          cmd3.close();
      }
      catch(Exception e){
          System.out.println(e.toString());
          System.out.println("Aqui el problema");
      }
      return resp;
  }
}

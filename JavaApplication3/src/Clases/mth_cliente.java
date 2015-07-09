/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.Connection;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import Secretariado.Clientes;

/**
 *
 * @author kevin Vásquez
 */
public class mth_cliente 
{
    public Connection cn;
    private Integer Codigo;
    private String Nombre;
    private String Apellido;
    private String DUI;
    private String NIT;
    private String Telefono;
    private String Correo;

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
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

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    

    
    
    public mth_cliente()
    {
        conexion con = new conexion();
        cn = con.conexion();
    }
    
    public boolean guardar()
    {
        boolean resp = false;
        try
        {
            String sql = "Insert into cliente (nombres_cliente, apellidos_cliente, DUI, NIT, Telefono, correo) values (?,?,?,?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, Nombre);
            cmd.setString(2, Apellido);
            cmd.setString(3, DUI);
            cmd.setString(4, NIT);
            cmd.setString(5, Telefono);
            cmd.setString(6, Correo);
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
    
    public boolean consultar()
    {
        boolean resp = false;
        try
        {
            String sql = "Select * from cliente where id_cliente = ?;";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, Codigo);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp = true;
                Codigo = rs.getInt(1);
                Nombre = rs.getString(2);
                Apellido = rs.getString(3);
                DUI = rs.getString(4);
                NIT = rs.getString(5);
                Telefono = rs.getString(6);
                Correo = rs.getString(7);
            }
            cmd.close();;
            cn.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return resp;
    }
    public boolean modificar()
    {
        boolean resp = false;
        try{
            String sql = "Update cliente set nombres_cliente = ?, apellidos_cliente = ?, DUI = ?, NIT = ?, Telefono = ?, correo = ? where id_cliente = ?;";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, Nombre);
            cmd.setString(2, Apellido);
            cmd.setString(3, DUI);
            cmd.setString(4, NIT);
            cmd.setString(5, Telefono);
            cmd.setString(6, Correo);
            cmd.setInt(7, Codigo);
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
    public boolean eliminar()
    {
        boolean resp = false;
        try
        {
            String sql = "Delete from cliente where id_cliente = ?";
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
    public void tabla_clientes()
    {
    try
    {
        String sql = "Select * from cliente";
        PreparedStatement cmd2 = cn.prepareStatement(sql);
        ResultSet rs = cmd2.executeQuery();
        while(rs.next())
        {
        DefaultTableModel modelo = (DefaultTableModel)Clientes.tcliente.getModel();
        modelo.addRow(new Object[3]);
        int newrow = modelo.getRowCount()-1;
        Codigo = rs.getInt(1);
        Nombre = rs.getString(2);
        Apellido = rs.getString(3);
        DUI = rs.getString(4);
        NIT = rs.getString(5);
        Telefono = rs.getString(6);
        Correo = rs.getString(7);
        
        Clientes.tcliente.setValueAt(Codigo, newrow, 0);
        Clientes.tcliente.setValueAt(Nombre, newrow, 1);
        Clientes.tcliente.setValueAt(Apellido, newrow, 2);
        Clientes.tcliente.setValueAt(DUI, newrow, 3);
        Clientes.tcliente.setValueAt(NIT, newrow, 4);
        Clientes.tcliente.setValueAt(Telefono, newrow, 5);
        Clientes.tcliente.setValueAt(Correo, newrow, 6);
        
        Clientes.tcliente.getColumnModel().getColumn(0).setMaxWidth(0);
        Clientes.tcliente.getColumnModel().getColumn(0).setMinWidth(0);
        Clientes.tcliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        Clientes.tcliente.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
        cmd2.close();
        cn.close();
        
    }catch(Exception e){
                
        }
    }
    
}
            

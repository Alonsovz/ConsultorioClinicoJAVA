/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Roles;
import com.vistas.FrmInicio;
import com.vistas.FrmLoginDoctor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Fabio
 */
public class DaoRoles extends Conexion{
    
    public List<Roles> mostrarRoles()
    {
        List<Roles> listaRoles = new ArrayList();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql="Select * from Roles;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
            Roles rol = new Roles();
            rol.setIdRol(res.getInt("idRol"));
            rol.setNombre(res.getString("nombre"));
            rol.setApellido(res.getString("apellido"));
            rol.setTelefono(res.getString("telefono"));
            rol.setUsername(res.getString("username"));
            rol.setPass(res.getString("pass"));
            rol.setNivelAcc(res.getInt("nivelAcc"));
            listaRoles.add(rol);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        finally{
        this.desconectar();
        }
        
        
        return listaRoles;
        
    }
    
    
    
    public void insertar(Roles rol)
    {
        try {
            this.conectar();
            String sql="insert into roles values(?,?,?,?,?,?,?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, 0);
            pre.setString(2, rol.getNombre());
            pre.setString(3, rol.getApellido());
            pre.setString(4, rol.getTelefono());
            pre.setString(5, rol.getUsername());
            pre.setString(6, rol.getPass());
            pre.setInt(7, rol.getNivelAcc());
            pre.executeUpdate();
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error al insertar: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        finally{
        this.desconectar();
        
        }
    
    
    }
    
    public void modificar(Roles rol)
    {
        try {
            this.conectar();
            String sql="Update Roles set nombre=?, apellido=?, telefono=?, username=?, pass=?, nivelAcc=? where IdRol=?;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            
            pre.setString(1, rol.getNombre());
            pre.setString(2, rol.getApellido());
            pre.setString(3, rol.getTelefono());
            pre.setString(4, rol.getUsername());
            pre.setString(5, rol.getPass());
            pre.setInt(6, rol.getNivelAcc());
            pre.setInt(7, rol.getIdRol());
            pre.executeUpdate();
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error al modificar: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        finally{
        this.desconectar();
        
        }
    
    
    }
    
    public void eliminar(Roles rol)
    {
        try 
        {
            this.conectar();
            String sql="delete from Roles where IdRol=?;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            
            pre.setInt(1, rol.getIdRol());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
        finally{
        
        this.desconectar();
        }
    
    
    }
    
    String nom;
    String apel;
    public int ingresar(){
        String usu = FrmLoginDoctor.jTxtUsuario.getText();
        String pass = FrmLoginDoctor.jTxtContra.getText();
        
        this.conectar();
        int resultado =0;
        
        
        try 
        {
            String sql="Select username,pass,nombre,apellido from Roles where username='"+usu+"' and pass='"+pass+"' and nivelAcc=1;";
            PreparedStatement pre= this.getCon().prepareStatement(sql);
            ResultSet st =pre.executeQuery();
            if(st.next())
            {
            
            resultado=1;
            }
            
        } 
        catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
        }
    
    
    return resultado;
    }
    
    String nombre1="";
        String n="";
        String apellido2="";
    
    public String ingresarN()
    {    
        String usu = FrmLoginDoctor.jTxtUsuario.getText();
        String pass = FrmLoginDoctor.jTxtContra.getText();
        
        this.conectar();
        int resultado =0;
        
        try 
        {
            String sql="Select nombre,apellido from Roles where username='"+usu+"' and pass='"+pass+"'";         
            PreparedStatement pre= this.getCon().prepareStatement(sql);
            ResultSet st =pre.executeQuery();
                if(st.next())
                  {
                    resultado=1;
                    nombre1=st.getString("nombre");
                    apellido2=st.getString("apellido");
                    n=apellido2;
                    FrmInicio.jLabel3.setText(nombre1);
                  }
        } 
        catch (Exception e)
        {
           // JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
        }      
    return n;
    }
    
}

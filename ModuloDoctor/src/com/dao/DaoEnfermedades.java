
package com.dao;

import com.conexion.Conexion;
import com.modelo.CitasPendientes;
import com.modelo.Enfermedades;
import com.modelo.Medicamentos;
import com.vistas.FrmDiagnositcos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: DaoEnfermedades
 * Fecha: 1-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */

public class DaoEnfermedades extends Conexion{
    
    public List<Enfermedades> mostrarEnfermedades()
    {
        String expe=FrmDiagnositcos.jLabel10.getText();
        List<Enfermedades> listaEnfermedades = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql = "select b.enfermedadesHere from enfermedades b "
                    + "inner join expaenfer a on b.idEnfermedades = a.idEnfermedades "
                    + "where a.idExp=" + expe + "; ";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
                Enfermedades ci = new Enfermedades();
                ci.setEnfermedadesHere(res.getString("b.enfermedadesHere"));
               
                
                
            
            listaEnfermedades.add(ci);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar enfer "+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaEnfermedades;
    }
    
    
    
    public List<Enfermedades> mostrarEnfermedad()
    {
        List<Enfermedades> listaEnfermedades = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql="select idEnfermedades,enfermedadesHere from Enfermedades";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
                Enfermedades ci = new Enfermedades();
                ci.setIdEnfermedad(res.getInt("idEnfermedades"));
                ci.setEnfermedadesHere(res.getString("enfermedadesHere"));
               
                
                
            
            listaEnfermedades.add(ci);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar"+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaEnfermedades;
    }
    
    
      public Enfermedades getEnfermedades(int enfer)
    {
        Enfermedades car = new Enfermedades();
        ResultSet res = null;
        try {
            this.conectar();
            String sql="Select * from Enfermedades where idEnfermedades=?;";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, enfer);
            res=pre.executeQuery();
            
            while(res.next())
            {
                car.setIdEnfermedad(res.getInt("idEnfermedad"));
                car.setEnfermedadesHere(res.getString("enfermedadesHere"));
            }
            
        } catch (Exception e) 
        {
        JOptionPane.showMessageDialog(null, "Error al mostrar datos");
        }
        finally
        {
        this.desconectar();
        }
         return car;
    }
      
      
      public void insertarEfermedades(Enfermedades med)
    {
        try {
           this.conectar();
           String sql = "insert into Enfermedades values(?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, 0);
           pre.setString(2, med.getEnfermedadesHere());
          
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar enfe"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
    
    
    
    
    }
      
      
      public void insertarEfermedadesExis(Enfermedades med)
    {
        try {
           this.conectar();
           String sql = "insert into expaenfer values(?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, med.getIdExp());
           pre.setInt(2, med.getIdEnfermedad());
          
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar enfe"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
    
    
    
    
    }
}

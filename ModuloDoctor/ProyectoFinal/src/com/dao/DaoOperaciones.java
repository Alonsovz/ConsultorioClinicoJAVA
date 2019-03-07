/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Alergias;
import com.modelo.Enfermedades;
import com.modelo.Operaciones;
import com.modelo.Referencias;
import com.vistas.FrmDiagnositcos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabio
 */
public class DaoOperaciones extends Conexion{
    
    public List<Operaciones> mostrarOperaciones()
    {
        String expe=FrmDiagnositcos.jLabel10.getText();
        List<Operaciones> listaOperaciones = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql="select * from operaciones where idExp="+expe+";";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
                Operaciones ci = new Operaciones();
                ci.setIdOperacion(res.getInt("idOperacion"));
                ci.setOperacion(res.getString("operacion"));
                ci.setFechaOperacion(res.getString("fechaOperacion"));
               
                
                
            
            listaOperaciones.add(ci);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar ope"+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaOperaciones;
    }
    
    
    public List<Operaciones> mostrarOperacion()
    {
        String expe=FrmDiagnositcos.jLabel10.getText();
        List<Operaciones> listaOperaciones = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql="select * from operaciones;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
                Operaciones ci = new Operaciones();
                ci.setIdOperacion(res.getInt("idOperacion"));
                ci.setOperacion(res.getString("operacion"));
                ci.setFechaOperacion(res.getString("fechaOperacion"));
               
                
                
            
            listaOperaciones.add(ci);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar"+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaOperaciones;
    }
    
    
    public Operaciones getOperaciones(int oper)
    {
        Operaciones car = new Operaciones();
        ResultSet res = null;
        try {
            this.conectar();
            String sql="Select * from operaciones where idOperacion=?";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, oper);
            res=pre.executeQuery();
            
            while(res.next())
            {
                car.setIdOperacion(res.getInt("idOperacion"));
                car.setOperacion(res.getString("operacion"));
                car.setFechaOperacion(res.getString("fechaOperacion"));
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
    
    
    public List<Referencias> mostrarReferencias()
    {
        String expe=FrmDiagnositcos.jLabel10.getText();
        List<Referencias> listaReferencias = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql="select distinct referencia from  referencias where idExp="+expe+";";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
                Referencias ci = new Referencias();
                
                ci.setReferencia(res.getString("referencia"));
            listaReferencias.add(ci);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar ref"+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaReferencias;
    }
    
    
    
    public void insertarOperaciones(Operaciones med)
    {
        try {
           this.conectar();
           String sql = "insert into operaciones values(?,?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, 0);
           pre.setString(2, med.getOperacion());
           pre.setString(3, med.getFechaOperacion());
          
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar op"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
    }
    
    
    public void insertarReferencias(Referencias med)
    {
        try {
           this.conectar();
           String sql = "insert into referencias values(?,?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, 0);
           pre.setInt(2, med.getIdExp());
           pre.setString(3, med.getReferencia());
          
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar ref"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
    }
}

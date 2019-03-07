
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
 * Nombre de la clase: DaoOperaciones
 * Fecha: 2-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */

public class DaoOperaciones extends Conexion{
    
    public List<Operaciones> mostrarOperaciones()
    {
        String expe=FrmDiagnositcos.jLabel10.getText();
        List<Operaciones> listaOperaciones = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql="select b.operacion,a.fechaOperacion from operaciones b inner join expaopera a on b.idOperacion = a.idOperacion where a.idExp="+expe+";";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
                Operaciones ci = new Operaciones();
                ci.setOperacion(res.getString("b.operacion"));
                ci.setFechaOperacion(res.getString("a.fechaOperacion"));
               
                
                
            
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
            String sql = "select b.referencia from referencias b\n"
                    + "inner join exparef a on b.idReferencia = a.idReferencia\n"
                    + "where a.idExp=" + expe + ";";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
                Referencias ci = new Referencias();
                
                ci.setReferencia(res.getString("b.referencia"));
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
           String sql = "insert into operaciones values(?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, 0);
           pre.setString(2, med.getOperacion());
          
          
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar op"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
    }
    
    
    public void insertarOperacionesExi(Operaciones med)
    {
        try {
           this.conectar();
           String sql = "insert into ExpaOpera values(?,?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, med.getIdExp());
           pre.setInt(2, med.getIdOperacion());
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
           String sql = "insert into exparef values(?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, med.getIdExp());
           pre.setInt(2, med.getIdReferencia());
           
          
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

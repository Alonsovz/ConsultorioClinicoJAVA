/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.*;
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
public class DaoDiagCorto  extends Conexion{
    public List<DiagnosticosCortos> mostrarDiagCorto()
    {
        String expe=FrmDiagnositcos.jLabel10.getText();
        List<DiagnosticosCortos> listaDiagCorto = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql="select * from DiagCorto;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
              DiagnosticosCortos ci = new DiagnosticosCortos();
                ci.setIdDiagCorto(res.getInt("idDiagCorto"));
                
                ci.setNombreDiag(res.getString("nombreDiag"));
               
                
                
            
            listaDiagCorto.add(ci);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar aler"+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaDiagCorto;
    }
    
    public List<DiagnosticosCortos> mostrarDiagCortoHistorial()
    {
        String expe=FrmDiagnositcos.jLabel10.getText();
        List<DiagnosticosCortos> listaDiagCorto = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql = "select b.nombreDiag from DiagCorto b "
                    + "inner join diagcortorel a on b.idDiagCorto = a.idDiagCorto "
                    + "inner join diagnosticos c on a.idDiagnostico = c.idDiagnostico "
                    + "inner join expediente d on c.idExp = d.idExp where d.idExp=" + expe + ";";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
              DiagnosticosCortos ci = new DiagnosticosCortos();
                ci.setNombreDiag(res.getString("b.nombreDiag"));
               
                
                
            
            listaDiagCorto.add(ci);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar aler"+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaDiagCorto;
    }
    
      public DiagnosticosCortos getDiag(int aler)
    {
        DiagnosticosCortos car = new DiagnosticosCortos();
        ResultSet res = null;
        try {
            this.conectar();
            String sql="Select * from DiagCorto where idDiagCorto=?";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, aler);
            res=pre.executeQuery();
            
            while(res.next())
            {
                car.setIdDiagCorto(res.getInt("idDiagCorto"));
                car.setNombreDiag(res.getString("nombreDiag"));
                
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
      
      
      public void insertarDiagCor(DiagnosticosCortos diag)
      {
          try {
           this.conectar();
           String sql = "insert into DiagCorto values(?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, 0);
           pre.setString(2, diag.getNombreDiag());
           
          
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar al"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
      
      }
      
      
      public void insertarDiagCorExi(DiagnosticosCortos diag)
      {
          try {
           this.conectar();
           String sql = "insert into diagcortorel values(?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, diag.getIdDiagCorto());
           pre.setInt(2, diag.getIdDiagnostico());
           
          
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar al"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
      
      }
      
      
      public String getDescripcion()
    {
    String resultado="";
        try {
            
            this.conectar();
            String sql="select descripcion from diagnosticos where idDiagnostico=(select max(idDiagnostico) from diagnosticos);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            
            
            if(res.next())
            {
            resultado=res.getString("descripcion");
            
            }
            
        } catch (Exception e) {
        }
    
    
    return resultado;
    }
}

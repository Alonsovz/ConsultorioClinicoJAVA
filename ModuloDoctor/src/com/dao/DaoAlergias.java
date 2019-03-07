
package com.dao;

import com.conexion.Conexion;
import com.modelo.Alergias;
import com.modelo.Enfermedades;
import com.vistas.FrmDiagnositcos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: DaoAlergia
 * Fecha: 1-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */

public class DaoAlergias extends Conexion{
    
     public List<Alergias> mostrarAlergias()
    {
          String expe=FrmDiagnositcos.jLabel10.getText();
        List<Alergias> listaAlergias = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql = "select b.alergia from alergias b "
                    + "inner join expaaler a on b.idAlergia = a.idAlergia "
                    + "where a.idExp=" + expe + ";";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
                Alergias ci = new Alergias();                
                ci.setAlergia(res.getString("b.alergia"));
               
                
                
            
            listaAlergias.add(ci);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar ale"+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaAlergias;
    }
     
     
     public List<Alergias> mostrarAlergia()
    {
        String expe=FrmDiagnositcos.jLabel10.getText();
        List<Alergias> listaAlergias = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql="select * from alergias;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
              Alergias ci = new Alergias();
                ci.setIdAlergia(res.getInt("idAlergia"));
                
                ci.setAlergia(res.getString("Alergia"));
               
                
                
            
            listaAlergias.add(ci);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar aler"+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaAlergias;
    }
    
    
      public Alergias getAlergias(int aler)
    {
        Alergias car = new Alergias();
        ResultSet res = null;
        try {
            this.conectar();
            String sql="Select * from alergias where idAlergia=?";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, aler);
            res=pre.executeQuery();
            
            while(res.next())
            {
                car.setIdAlergia(res.getInt("idAlergia"));
                car.setIdExp(res.getInt("idExp"));
                car.setAlergia(res.getString("alergia"));
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
      
      
      
      public void insertarAlergias(Alergias med)
    {
        try {
           this.conectar();
           String sql = "insert into alergias values(?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, 0);
           pre.setString(2, med.getAlergia());
          
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar al"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
    }
    
      
       public void insertarAlergiasExis(Alergias med)
    {
        try {
           this.conectar();
           String sql = "insert into ExpaAler values(?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, med.getIdExp());
           pre.setInt(2, med.getIdAlergia());
          
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar al"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
    }
       
       
       
}

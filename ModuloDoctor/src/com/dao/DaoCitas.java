
package com.dao;

import com.conexion.Conexion;
import com.modelo.Alergias;
import com.modelo.CitasPendientes;
import com.modelo.Historial;
import com.modelo.Enfermedades;
import com.vistas.FrmDiagnositcos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: DaoCitas
 * Fecha: 1-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */

public class DaoCitas extends Conexion{
    
    
    public List<CitasPendientes> mostrarCitas()
    {
        List<CitasPendientes> listaCitas = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql="select c.idExp,a.idPaciente,b.nombre,a.idCita,a.hora,a.fecha from cita a \n" +
                        "inner join paciente b on a.idPaciente=b.idPaciente\n" +
                        "inner join expediente c on b.idPaciente=c.idPaciente\n" +
                        "where a.fecha=(select curdate()) and a.hora>(SELECT DATE_FORMAT(NOW( ), \"%H:%i\" )) and a.estado='Pendiente'"
                    + "order by idCita;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
                CitasPendientes ci = new CitasPendientes();
                ci.setIdExp(res.getInt("idExp"));
                ci.setIdPaciente(res.getInt("idPaciente"));
                ci.setNombre(res.getString("nombre"));
                ci.setIdCita(res.getInt("idCita"));
                ci.setFecha(res.getString("fecha"));
                ci.setHora(res.getString("hora"));
                
                
            
            listaCitas.add(ci);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar"+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaCitas;
    }
    
    
   public List<Historial> mostrarHistorial()
   {
       List<Historial> listaHistorial = new ArrayList();
       ResultSet res;
       int exp = Integer.parseInt(FrmDiagnositcos.jLabel10.getText());
       try 
       {
           this.conectar();
           String sql="Select * from Diagnosticos where idExp="+exp+";";
           PreparedStatement pre = this.getCon().prepareStatement(sql);
           res=pre.executeQuery();
           
           while(res.next())
           {
               Historial his = new Historial();
               his.setIdDiagnostico(res.getInt("idDiagnostico"));
               his.setIdExp(res.getInt("idExp"));
               his.setDescripcion(res.getString("descripcion"));
               his.setPresion(res.getString("presion"));
               his.setAltura(res.getString("altura"));
               his.setPeso(res.getString("peso"));
               his.setFecha(res.getString("fecha_diag"));
               his.setHora(res.getString("hora"));
               listaHistorial.add(his);
           }
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al mostrar his"+e.getMessage());
       }
       
       finally
       {
        this.desconectar();
       }
      return listaHistorial;
   }
   
   
   
   public void modificarDiag(Historial cit)
   {
   try {
           this.conectar();
           String sql = "update diagnosticos set idExp=?, descripcion=?, presion=?, altura=?, peso=?, fecha_Diag=?, hora=? where idDiagnostico=?;";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           
           pre.setInt(1, cit.getIdExp());
           pre.setString(2, cit.getDescripcion());
           pre.setString(3, cit.getPresion());
           pre.setString(4, cit.getAltura());
           pre.setString(5, cit.getPeso());
           pre.setString(6, cit.getFecha());
           pre.setString(7, cit.getHora());
           pre.setInt(8, cit.getIdDiagnostico());
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar dia"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
   
   
   }
   
   
   
   
   public int getCodigoDi() throws Exception
   {
       int codigo=0;
       ResultSet res;
     String sql="";
     PreparedStatement pre;
       try 
       {
           this.conectar();
           sql="select max(idDiagnostico) from diagnosticos;";
            pre = this.getCon().prepareStatement(sql);
           res = pre.executeQuery();
           
           while(res.next())
           {
               codigo=res.getInt("max(idDiagnostico)");
               
               
           }
           res.close();
           
       } catch (Exception e)
       {
           throw e;
       }finally{
      this.desconectar();
       }
               
   
   
       return codigo;
   }
   
   public void insertarDiagnostico(Historial cit)
   {
       
       
       try {
           this.conectar();
           String sql = "insert into diagnosticos values(?,?,?,?,?,?,?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, 0);
           pre.setInt(2, cit.getIdExp());
           pre.setString(3, cit.getDescripcion());
           pre.setString(4, cit.getPresion());
           pre.setString(5, cit.getAltura());
           pre.setString(6, cit.getPeso());
           pre.setString(7, cit.getFecha());
           pre.setString(8, cit.getHora());
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar dia"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
   
   
   }
   
  
   
   
   public void paraCita(CitasPendientes cit)
   {
       try {
           this.conectar();
           String sql ="update cita set  idPaciente=?, fecha=?, hora=?, estado=?, comentarios=? where idCita=?;";
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, cit.getIdPaciente());
           pre.setString(2, cit.getFecha());
           pre.setString(3, cit.getHora());
           pre.setString(4, cit.getEstado());
           pre.setString(5, cit.getComentarios());
           pre.setInt(6, cit.getIdCita());
           pre.executeUpdate();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
       
       
   
   
   }
   
   public List<Historial> mostrarDiag()
    {
        String expe=FrmDiagnositcos.jLabel10.getText();
        List<Historial> listaHistorial = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql="select * from Diagnosticos where idExp="+expe+";";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
             Historial his = new Historial();
               his.setIdDiagnostico(res.getInt("idDiagnostico"));
               his.setIdExp(res.getInt("idExp"));
               his.setDescripcion(res.getString("descripcion"));
               his.setPresion(res.getString("presion"));
               his.setAltura(res.getString("altura"));
               his.setPeso(res.getString("peso"));
               his.setDiagCorto(res.getString("diag_Corto"));
               his.setFecha(res.getString("fecha_diag"));
               his.setHora(res.getString("hora"));
               listaHistorial.add(his);
               
                
                
            
            
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar diag"+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaHistorial;
    }
    
    
      public Historial getHistorial(int diag)
    {
        Historial his = new Historial();
        ResultSet res = null;
        try {
            this.conectar();
            String sql="Select * from alergias";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, diag);
            res=pre.executeQuery();
            
            while(res.next())
            {
                 his.setIdDiagnostico(res.getInt("idDiagnostico"));
               his.setIdExp(res.getInt("idExp"));
               his.setDescripcion(res.getString("descripcion"));
               
               his.setPresion(res.getString("presion"));
               his.setAltura(res.getString("altura"));
               his.setPeso(res.getString("peso"));
               his.setDiagCorto(res.getString("diag_Corto"));
               his.setFecha(res.getString("fecha_diag"));
               his.setHora(res.getString("hora"));
               
            }
            
        } catch (Exception e) 
        {
        JOptionPane.showMessageDialog(null, "Error al mostrar datos");
        }
        finally
        {
        this.desconectar();
        }
         return his;
    }
    
   
    
}

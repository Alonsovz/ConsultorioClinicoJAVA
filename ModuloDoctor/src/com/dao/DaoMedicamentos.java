
package com.dao;

import com.conexion.Conexion;
import com.modelo.Historial;
import com.modelo.Medicamentos;
import com.modelo.Referencias;
import com.vistas.FrmDiagnositcos;
import com.vistas.Medi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: DaoMedicamentos
 * Fecha: 1-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */

public class DaoMedicamentos extends Conexion{
    
    public List<Medicamentos> mostrarMedicamentos()
    {
        List<Medicamentos> listaMedicamentos = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql="select * from medicamentos";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
                Medicamentos ci = new Medicamentos();
                ci.setIdMedicamento(res.getInt("idMedicamento"));
                ci.setMedicamento(res.getString("medicamento"));

            listaMedicamentos.add(ci);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar me  "+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaMedicamentos;
    }
    
    
    public List<Medi> mostrarMedicamentosH()
    {
        String expe=FrmDiagnositcos.jLabel10.getText();
        List<Medi> listaMedicamentos = new ArrayList();
        ResultSet res;
        try {
            this.conectar();
            String sql = "select b.medicamento,a.fecha_inicio from medicamentos b "
                    + "inner join diagmedi a on b.idMedicamento = a.idMedicamento "
                    + "inner join diagnosticos c on a.idDiagnostico = c.idDiagnostico "
                    + "inner join expediente d on c.idExp = d.idExp where d.idExp=" + expe + ";";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next()){
                Medi ci = new Medi();
                ci.setMedicamento(res.getString("medicamento"));
                ci.setFecha_diag(res.getString("fecha_inicio"));
            listaMedicamentos.add(ci);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar me  "+e.getMessage());
        }
        finally
        {
        this.desconectar();
        }
    return listaMedicamentos;
    }
    
    
    
    public Medicamentos getMedicamentos(int medi)
    {
        Medicamentos car = new Medicamentos();
        ResultSet res = null;
        try {
            this.conectar();
            String sql="Select * from medicamento where idMedicamento=?;";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, medi);
            res=pre.executeQuery();
            
            while(res.next())
            {
                car.setIdMedicamento(res.getInt("idMedicamento"));
                car.setMedicamento(res.getString("medicamento"));
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
    
    
    
    
    public void insertarMedicamentos(Medicamentos med)
    {
        try {
           this.conectar();
           String sql = "insert into medicamentos values(?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, 0);
           pre.setString(2, med.getMedicamento());
          
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar me"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
    }
    
    
     public void insertarMedicamentosExi(Medicamentos med)
    {
        try {
           this.conectar();
           String sql = "insert into diagmedi values(?,?,?);";
           
           PreparedStatement pre = this.getCon().prepareCall(sql);
           
           
           pre.setInt(1, med.getIdDiagnostico());
           pre.setInt(2, med.getIdMedicamento());
           pre.setString(3, med.getFechaIncio());
          
           pre.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar me"+e.getMessage());
       }
       finally
       {
       this.desconectar();
       }
    }
    
    public int getDiag()
    {
    int resultado=0;
        try {
            
            this.conectar();
            String sql="select Max(idDiagnostico) from Diagnosticos;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            
            
            if(res.next())
            {
            resultado=res.getInt("Max(idDiagnostico)");
            
            }
            
        } catch (Exception e) {
        }
    
    
    return resultado;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AndresL
 */
public class DaoPaciente extends Conexion{
    
    public List<Paciente>mostrarPaciente()throws Exception
    {
        ResultSet res;
        List<Paciente>listaPac = new ArrayList();
        try
        {
            this.conectar();
            String sql="select * from paciente;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            res=pre.executeQuery();
            
            while(res.next())
            {
                Paciente pa = new Paciente();
                pa.setIdPaciente(res.getInt("idPaciente"));
                pa.setNombre(res.getString("nombre"));
                pa.setDomicilio(res.getString("domicilio"));
                pa.setTelefono(res.getString("telefono"));
                pa.setFechaNac(res.getString("fechaNac"));
                pa.setEstado(res.getString("estado"));
                pa.setUsuario(res.getString("usuario"));
                pa.setContra(res.getString("contra"));
                listaPac.add(pa);
            }
            
        } catch (Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listaPac;
    }
    public List<Paciente>mostrarPaciente1()throws Exception
    {
        ResultSet res;
        List<Paciente>listaPac = new ArrayList();
        try
        {
            this.conectar();
            String sql="select * from paciente where estado='sin';";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            res=pre.executeQuery();
            
            while(res.next())
            {
                Paciente pa = new Paciente();
                pa.setIdPaciente(res.getInt("idPaciente"));
                pa.setNombre(res.getString("nombre"));
                pa.setDomicilio(res.getString("domicilio"));
                pa.setTelefono(res.getString("telefono"));
                pa.setFechaNac(res.getString("fechaNac"));
                pa.setEstado(res.getString("estado"));
                pa.setUsuario(res.getString("usuario"));
                pa.setContra(res.getString("contra"));
                listaPac.add(pa);
            }
            
        } catch (Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listaPac;
    }
    
    
    public void insertarPaciente(Paciente pa)throws Exception
    {
        try
        {
            this.conectar();
            String sql="insert into paciente values(?,?,?,?,?,?,?,?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, pa.getIdPaciente());
            pre.setString(2, pa.getNombre());
            pre.setString(3, pa.getDomicilio());
            pre.setString(4, pa.getTelefono());
            pre.setString(5, pa.getFechaNac());
            pre.setString(6, pa.getEstado());
            pre.setString(7, pa.getUsuario());
            pre.setString(8, pa.getContra());
            pre.executeUpdate();
           
        } catch (Exception e)
        {   
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    
    public void modificarPaciente(Paciente pa)throws Exception
    {
        try
            {
            this.conectar();
            String sql="update paciente set nombre=?, domicilio=?, telefono=?, fechaNac=?, estado=?, usuario=?, contra=? where idPaciente=?;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setString(1, pa.getNombre());
            pre.setString(2, pa.getDomicilio());
            pre.setString(3, pa.getTelefono());
            pre.setString(4, pa.getFechaNac());
            pre.setString(5, pa.getEstado());
            pre.setString(6, pa.getUsuario());
            pre.setString(7, pa.getContra());
            pre.setInt(8, pa.getIdPaciente());
            pre.executeUpdate();
           
        } catch (Exception e)
        {   
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    public void modificarPacienteEstado(Paciente pa)throws Exception
    {
        try
            {
            this.conectar();
            String sql="update paciente set estado='con' where idPaciente=?;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, pa.getIdPaciente());
            pre.executeUpdate();
           
        } catch (Exception e)
        {   
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarPaciente(Paciente pa)throws Exception
    {
        try
            {
            this.conectar();
            String sql="delete from paciente where idPaciente=?;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, pa.getIdPaciente());
            pre.executeUpdate();
           
        } catch (Exception e)
        {   
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
}

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
 * @author User
 */
public class DaoExpediente extends Conexion {
    
    public List<Expediente>mostrarExpediente()throws Exception
    {
        ResultSet res;
        List<Expediente>listaExp = new ArrayList();
        try
        {
            this.conectar();
            String sql="select idExp, ex.idPaciente, ex.tipoSangre, ex.numSeguro , pac.nombre from expediente as ex inner join paciente as pac  on ex.idPaciente =pac.idPaciente order by idExp;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            res=pre.executeQuery();
            
            while(res.next())
            {
                Paciente pac = new Paciente();
                pac.setIdPaciente(res.getInt("idPaciente"));
                pac.setNombre(res.getString("nombre"));
                Expediente ex = new Expediente(res.getInt("idExp"),pac,res.getString("tipoSangre"),res.getString("numSeguro"));
                listaExp.add(ex);
            }
            
        } catch (Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return listaExp;
    }
    
    
    public void insertarExpediente(Expediente ex)throws Exception
    {
        try
        {
            this.conectar();
            String sql="insert into expediente values(?,?,?,?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, ex.getIdExp());
            pre.setInt(2, ex.getPaciente().getIdPaciente());
            pre.setString(3, ex.getTipoSangre());
            pre.setString(4, ex.getNumSeguro());
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
    
    
    public void modificarExpediente(Expediente ex)throws Exception
    {
        try
        {
            this.conectar();
            String sql="update expediente set idPaciente=?, tipoSangre=?, numSeguro=? where idExp=?;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, ex.getPaciente().getIdPaciente());
            pre.setString(2, ex.getTipoSangre());
            pre.setString(3, ex.getNumSeguro());
            pre.setInt(4, ex.getIdExp());
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
    
    
    public void eliminarExpediente(Expediente ex)throws Exception
    {
        try
            {
            this.conectar();
            String sql="delete from expediente where idExp=?;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, ex.getIdExp());
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
    
    
    
    public List<Paciente>listarPacientes() throws Exception
   {
       ResultSet rs;
       List<Paciente> lst = new ArrayList();
       
       try 
       {
           this.conectar();
           String sql="select * from paciente;";
           PreparedStatement pst = this.getCon().prepareStatement(sql);
           rs = pst.executeQuery();
           
           while (rs.next())
           {
               Paciente pac = new Paciente();
               pac.setIdPaciente(rs.getInt("idPaciente"));
               pac.setNombre(rs.getString("nombre"));
               pac.setDomicilio(rs.getString("domicilio"));
               pac.setTelefono(rs.getString("telefono"));
               pac.setFechaNac(rs.getString("fechaNac"));
               pac.setEstado(rs.getString("estado"));
               pac.setUsuario(rs.getString("usuario"));
               pac.setContra(rs.getString("contra"));
               lst.add(pac);
           }
       } 
       catch (Exception e) 
       {
           throw e;
       }
       finally
       {
           this.desconectar();
       }
       return lst;
   }
    
}

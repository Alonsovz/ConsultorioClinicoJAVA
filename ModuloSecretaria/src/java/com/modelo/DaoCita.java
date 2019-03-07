package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase:DaoCitajava
 * Fecha:09-10-18
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Emerson Sibrian
 */
public class DaoCita extends Conexion
{
    public List<Cita> mostrarCita() throws Exception
   {
       ResultSet rs;
       List<Cita>lst=new ArrayList();
       
       try 
       {
           this.conectar();
           String sql="select  c.idcita, c.idPaciente, p.nombre, fecha, hora , c.estado, comentarios from cita as c\n"
                   + "inner join paciente as p on c.idpaciente= p.idpaciente\n"
                   + "where c.fecha=(select curdate()) and c.hora>(SELECT DATE_FORMAT(NOW( ), \"%H:%i\" )) and c.estado='Pendiente'\n"
                   + "order by idCita";
           PreparedStatement pst = this.getCon().prepareStatement(sql);
           Cita cit;
           rs = pst.executeQuery();
           
           while (rs.next())
           {
               Paciente pac = new Paciente();
               pac.setIdPaciente(rs.getInt("idPaciente"));
               pac.setNombre(rs.getString("nombre"));
               cit =new Cita(rs.getInt("idCita"),pac,rs.getString("fecha"),rs.getString("hora"),rs.getString("estado"),rs.getString("comentarios"));
               lst.add(cit);
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
   
   public void insertarCita(Cita cit) throws Exception
   {
       try 
       {
           this.conectar();
           String sql = "insert into cita values(?,?,?,?,?,?);";
           PreparedStatement pst = this.getCon().prepareStatement(sql);
           
           pst.setInt(1, 0);
           pst.setInt(2, cit.getPaciente().getIdPaciente());
           pst.setString(3, cit.getFecha());
           pst.setString(4, cit.getHora());
           pst.setString(5, cit.getEstado());
           pst.setString(6, cit.getComentarios());
           
           
           pst.executeUpdate();

       } 
       catch (Exception e) 
       {
           throw e;
       }
       finally
       {
           this.desconectar();
       }
   }
   
   public void modificarCita(Cita cit) throws Exception
   {
       try 
       {
           this.conectar();
           String sql = "update cita set idPaciente=?, fecha=?, hora=?, estado=?, comentarios=? where idCita=?;";
           PreparedStatement pst = this.getCon().prepareStatement(sql);
           
           
           pst.setInt(1, cit.getPaciente().getIdPaciente());
           pst.setString(2, cit.getFecha());
           pst.setString(3, cit.getHora());
           pst.setString(4, cit.getEstado());
           pst.setString(5, cit.getComentarios());
           pst.setInt(6, cit.getIdCita());
           
           pst.executeUpdate();
       } 
       catch (Exception e) 
       {
           throw e;
       }
       finally
       {
           this.desconectar();
       }
   }
   
   public void eliminarCita(Cita cit) throws Exception
   {
       try 
       {
           this.conectar();
           String sql = "delete from Cita where idCita=?;";
           PreparedStatement pst = this.getCon().prepareStatement(sql);
           
           pst.setInt(1, cit.getIdCita());
           
           pst.executeUpdate();
       } 
       catch (Exception e) 
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
           String sql="select * from paciente where estado = 'con';";
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
   
   
   
   public int fechVal(String fecha, String hor ,String suma ) throws Exception
   {
       int val = 0;
       String fec="";
       ResultSet res;
     String sql="";
     PreparedStatement pre;
       try 
       {
           this.conectar();
           sql="select * from cita where  hora between '"+suma+"' and '"+hor+"' and fecha='"+fecha+"';";
            pre = this.getCon().prepareStatement(sql);
           res = pre.executeQuery();
           
           while(res.next())
           {
               if(res.getString("fecha")!= null)
                       {
                           val=1;
                       }
              
               
           }
           res.close();
           
       }
       finally
       {
           this.desconectar();
       }
   
   return val;
   }
    public int fechVal2(String fecha, String hor ,String suma ) throws Exception
   {
       int val = 0;
       String fec="";
       ResultSet res;
     String sql="";
     PreparedStatement pre;
       try 
       {
           this.conectar();
           sql="select * from cita where  hora between '"+hor+"' and '"+suma+"' and fecha='"+fecha+"';";
            pre = this.getCon().prepareStatement(sql);
           res = pre.executeQuery();
           
           while(res.next())
           {
               if(res.getString("fecha")!= null)
                       {
                           val=1;
                       }
              
               
           }
           res.close();
           
       }
       finally
       {
           this.desconectar();
       }
   
   return val;
   }
    
    //para validar si es a  la misma hora
    public int fechVal3(String fecha, String hor  ) throws Exception
   {
       int val = 0;
       String fec="";
       ResultSet res;
     String sql="";
     PreparedStatement pre;
       try 
       {
           this.conectar();
           sql="select * from cita where  hora='"+hor+"' and fecha='"+fecha+"';;";
            pre = this.getCon().prepareStatement(sql);
           res = pre.executeQuery();
           
           while(res.next())
           {
               if(res.getString("fecha")!= null)
                       {
                           val=1;
                       }
              
               
           }
           res.close();
           
       }
       finally
       {
           this.desconectar();
       }
   
   return val;
   }
}

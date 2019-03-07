package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Geo-Garcia
 */
public class Validar extends Conexion{
    String sql="";
    PreparedStatement pre;
    ResultSet res;
    
    public int validarUsuario(String usuario, String clave) throws Exception
    {
        int nivel=0;
        
        try 
        {
            this.conectar();
            sql="select nivelAcc from roles where username='"+usuario+"'and pass='"+clave+"';";
            pre=this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            
            while(res.next())
            {
                nivel=res.getInt(1);
            }
            res.close();
        } 
        catch (Exception e) 
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return nivel;
        
    }
}

package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Nombre de la clase:Conexion.java
 * Fecha:09-10-18
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Emerson Sibrian
 */
public class Conexion 
{
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
    public void conectar() throws Exception
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio","root","123456");
            
        } catch (ClassNotFoundException | SQLException e)
        {
            throw e;
        }
    }
    
    public void desconectar() throws Exception
    {
        try
        {
            if(con!=null)
            {
                if(con.isClosed()==false)
                {
                    con.close();
                }
            }
        } catch (Exception e)
        {
            throw e;
        }
    }
}

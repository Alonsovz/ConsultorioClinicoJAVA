
package com.conexion;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: Conexion
 * Fecha: 01-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */

public class Conexion {
    private Connection con;

    public Conexion() {
    }

    public Conexion(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
    public void conectar()
    {
        try 
        {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorio","root","123456");
            
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    
    }
    
    
    public void desconectar()
    {
        try 
        {
            if(con!=null)
            {
                if(!con.isClosed()){
                    con.close();
                }
            
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al desconectar "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    
    
}

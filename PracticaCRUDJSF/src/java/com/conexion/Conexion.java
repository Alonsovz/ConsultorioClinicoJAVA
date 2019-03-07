/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import java.sql.*;

/**
 *
 * @author Fabio
 */
public class Conexion {
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public boolean conectar()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empresajsf"
            ,"root","123456");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean desconectar()
    {
        try {
            if(this.con!=null)
            {
            if(!this.con.isClosed())
            {
            this.con.close();
            }
            
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    
    }
}

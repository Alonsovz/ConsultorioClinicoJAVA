/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Departamento;
import com.modelo.Empleado;
import com.utilidades.Utilidades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fabio
 */
public class DaoEmpleado extends Conexion{
    
    public ArrayList<Empleado> mostrarEm()
    {
    ArrayList<Empleado> flag;
        PreparedStatement pre;
        ResultSet rs;
        String sql;
        Departamento depTemp;
    flag=new ArrayList<Empleado>();
        try {
            if(this.conectar()){
             sql = "select codigoEmpleado, emp.nombre, genero, intereses, edad, "
                        + "direccion, cargo, "
                        + "dep.codigoDepartamento, dep.nombre as departamento "
                        + "from empleado as emp "
                        + "inner join departamento as dep on emp.codigoDepartamento = dep.codigoDepartamento "
                        + "order by codigoEmpleado;";
            pre=this.getCon().prepareStatement(sql);
            rs=pre.executeQuery();
            while(rs.next()){
                    depTemp = new Departamento();
                    depTemp.setCodigoDepartamento(rs.getInt("codigoDepartamento"));
                    depTemp.setNombre(rs.getString("departamento"));
                    
                    flag.add(new Empleado(rs.getInt("codigoEmpleado"),
                                            rs.getString("nombre"),
                                            rs.getString("genero"),
                                            Utilidades.separarString(rs.getString("intereses"), ","),
                                            rs.getInt("edad"),
                                            rs.getString("direccion"),
                                            rs.getString("cargo"),
                                            depTemp));
                } 
            rs.close();
            pre.close();
            }
        } catch (Exception e) {
            flag=null;
        }finally
        {
        desconectar();
        }
    
    return flag;
    }
}

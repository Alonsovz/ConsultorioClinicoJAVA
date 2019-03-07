/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class DaoDepartamento extends Conexion{
    
    public List<Departamento> mostrarD()
    {
    List<Departamento> dato = new ArrayList();
        try {
            PreparedStatement pre;
            ResultSet res;
            Departamento dep;
            if(this.conectar())
            {
            pre=this.getCon().prepareCall("select * from departamento;");
            res=pre.executeQuery();
                while (res.next()) {                    
                   dep=new Departamento();
                   dep.setCodigoDepartamento(res.getInt("codigoDepartamento"));
                   dep.setNombre(res.getString("nombre"));
                   dep.setCantidadEmpleado(res.getInt("cantidadEmpleado"));
                   dato.add(dep);
                }
            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
        desconectar();
        }
    
    return dato;
    }
}

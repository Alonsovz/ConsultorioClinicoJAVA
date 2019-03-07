/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.dao.DaoDepartamento;
import com.dao.DaoEmpleado;
import com.modelo.Empleado;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Fabio
 */
@Named(value = "empleadoBean")
@RequestScoped
public class EmpleadoBean implements Serializable{
    public EmpleadoBean() {
    }
    private List<Empleado> listarEmp;
    private Empleado emp;

    public List<Empleado> getListarEmp() {
        return listarEmp;
    }

    public void setListarEmp(List<Empleado> listarEmp) {
        this.listarEmp = listarEmp;
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }
    
    public void mostrar()
    {
        DaoEmpleado daoE;
        
        daoE = new DaoEmpleado();
        this.listarEmp=daoE.mostrarEm();
        this.emp= new Empleado();
    
    }
    
}

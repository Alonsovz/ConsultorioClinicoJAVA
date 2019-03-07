/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.dao.DaoDepartamento;
import com.modelo.Departamento;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author Fabio
 */
@Named(value = "departamentoBean")
@ManagedBean
@ViewScoped
public class DepartamentoBean{

    public DepartamentoBean() {
    }
    
    private Departamento depar= new Departamento();
    private List<Departamento> listarDep;
    DaoDepartamento daoD = new DaoDepartamento();

    public Departamento getDepar() {
        return depar;
    }

    public void setDepar(Departamento depar) {
        this.depar = depar;
    }

    public List<Departamento> getListarDep() {
        return listarDep;
    }

    public void setListarDep(List<Departamento> listarDep) {
        this.listarDep = listarDep;
    }
    
    public void mostrarD()
    {
        try {
            listarDep=daoD.mostrarD();
        } catch (Exception e) {
        }
    
    
    }
    
}

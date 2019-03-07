/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class Empleado {
    private int codigoEmpleado;
    private String nombre;
    private String genero;
    private List<String> intereses;
    private int edad;
    private String direccion;
    private String cargo;
    private Departamento departamento = new Departamento();

    public Empleado() {
        departamento = new Departamento();
        departamento.setCodigoDepartamento(0);
    }

    public Empleado(int codigoEmpleado, String nombre, String genero, List<String> intereses, int edad, String direccion, String cargo,Departamento departamento) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.genero = genero;
        this.intereses = intereses;
        this.edad = edad;
        this.direccion = direccion;
        this.cargo = cargo;
        this.departamento= departamento;
    }
    
    
    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<String> getIntereses() {
        return intereses;
    }

    public void setIntereses(List<String> intereses) {
        this.intereses = intereses;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author Fabio
 */
public class Departamento {
    private int codigoDepartamento;
    private String nombre;
    private int cantidadEmpleado;

    public Departamento(int codigoDepartamento, String nombre, int cantidadEmpleado) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombre = nombre;
        this.cantidadEmpleado = cantidadEmpleado;
    }

    public Departamento() {
    }

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(int codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadEmpleado() {
        return cantidadEmpleado;
    }

    public void setCantidadEmpleado(int cantidadEmpleado) {
        this.cantidadEmpleado = cantidadEmpleado;
    }
    
    
}

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
public class Operaciones {
    
    private int idOperacion;
    private int idExp;
    private String operacion;
    private String fechaOperacion;

    public Operaciones(int idOperacion, int idExp, String operacion, String fechaOperacion) {
        this.idOperacion = idOperacion;
        this.idExp = idExp;
        this.operacion = operacion;
        this.fechaOperacion = fechaOperacion;
    }

    public Operaciones() {
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(String fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

   
    
    
    
}

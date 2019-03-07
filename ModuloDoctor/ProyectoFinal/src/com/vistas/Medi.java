/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vistas;

/**
 *
 * @author Fabio
 */
public class Medi {
    private String medicamento;
    private String fecha_diag;

    public Medi() {
    }

    public Medi(String medicamento, String fecha_diag) {
        this.medicamento = medicamento;
        this.fecha_diag = fecha_diag;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getFecha_diag() {
        return fecha_diag;
    }

    public void setFecha_diag(String fecha_diag) {
        this.fecha_diag = fecha_diag;
    }
    
    
    
}

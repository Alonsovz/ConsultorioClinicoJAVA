
package com.vistas;

/**
 * Nombre de la clase: Mdi
 * Fecha: 1-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
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

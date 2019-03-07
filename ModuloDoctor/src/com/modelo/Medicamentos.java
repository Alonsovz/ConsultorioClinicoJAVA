
package com.modelo;

/**
 * Nombre de la clase: Medicamentos
 * Fecha: 3-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */

public class Medicamentos {
    private int idMedicamento;
    private int idDiagnostico;
    private String medicamento;
    private String fechaIncio;

    public Medicamentos(int idMedicamento, int idDiagnostico, String medicamento, String fechaIncio) {
        this.idMedicamento = idMedicamento;
        this.idDiagnostico = idDiagnostico;
        this.medicamento = medicamento;
        this.fechaIncio = fechaIncio;
    }

    public Medicamentos() {
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getFechaIncio() {
        return fechaIncio;
    }

    public void setFechaIncio(String fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

   
    
}

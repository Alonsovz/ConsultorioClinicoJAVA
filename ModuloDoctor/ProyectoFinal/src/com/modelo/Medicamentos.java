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
public class Medicamentos {
    private int idMedicamento;
    private int idDiagnostico;
    private String medicamento;

    public Medicamentos(int idMedicamento, int idDiagnostico, String medicamento) {
        this.idMedicamento = idMedicamento;
        this.idDiagnostico = idDiagnostico;
        this.medicamento = medicamento;
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
    
    
    
}

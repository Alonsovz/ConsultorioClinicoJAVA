/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author User
 */
public class Expediente {
     private int idExp;
    private Paciente paciente;
    private String tipoSangre;
    private String numSeguro;


    public Expediente() {
    }

    public Expediente(int idExp, Paciente paciente, String tipoSangre, String numSeguro) {
        this.idExp = idExp;
        this.paciente = paciente;
        this.tipoSangre = tipoSangre;
        this.numSeguro = numSeguro;
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getNumSeguro() {
        return numSeguro;
    }

    public void setNumSeguro(String numSeguro) {
        this.numSeguro = numSeguro;
    }

    
        
}

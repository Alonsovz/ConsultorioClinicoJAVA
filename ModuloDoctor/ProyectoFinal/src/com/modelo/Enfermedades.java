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
public class Enfermedades {
    private int idEnfermedad;
    private int idExp;
    private String enfermedadesHere;

    public Enfermedades() {
    }

    public Enfermedades(int idEnfermedad, int idExp, String enfermedadesHere) {
        this.idEnfermedad = idEnfermedad;
        this.idExp = idExp;
        this.enfermedadesHere = enfermedadesHere;
    }

    public int getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public String getEnfermedadesHere() {
        return enfermedadesHere;
    }

    public void setEnfermedadesHere(String enfermedadesHere) {
        this.enfermedadesHere = enfermedadesHere;
    }
    
    
    
    
}


package com.modelo;

/**
 * Nombre de la clase: Enfermedades
 * Fecha: 2-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
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

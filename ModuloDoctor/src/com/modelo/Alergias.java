
package com.modelo;

/**
 * Nombre de la clase: Alergias
 * Fecha: 1-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */

public class Alergias {
    private int idAlergia;
    private int idExp;
    private String alergia;

    public Alergias() {
    }

    public Alergias(int idAlergia, int idExp, String alergia) {
        this.idAlergia = idAlergia;
        this.idExp = idExp;
        this.alergia = alergia;
    }

    public int getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(int idAlergia) {
        this.idAlergia = idAlergia;
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
    
    
}

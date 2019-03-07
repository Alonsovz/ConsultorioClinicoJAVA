
package com.modelo;

/**
 * Nombre de la clase: Referencias
 * Fecha: 3-09-2018
 * Copyright: ITCA-FEPADE
 * Version: 1.0
 * @author equipo3
 */

public class Referencias {
    private int idReferencia;
    private int idExp;
    private String referencia;

    public Referencias(int idReferencia, int idExp, String referencia) {
        this.idReferencia = idReferencia;
        this.idExp = idExp;
        this.referencia = referencia;
    }

    public Referencias() {
    }

    public int getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(int idReferencia) {
        this.idReferencia = idReferencia;
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    
}

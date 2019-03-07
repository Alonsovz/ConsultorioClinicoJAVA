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
public class DiagnosticosCortos {
private int idDiagCorto;
private int idDiagnostico;
private String nombreDiag;

    public DiagnosticosCortos(int idDiagCorto, int idDiagnostico, String nombreDiag) {
        this.idDiagCorto = idDiagCorto;
        this.idDiagnostico = idDiagnostico;
        this.nombreDiag = nombreDiag;
    }

    public DiagnosticosCortos() {
    }

    public int getIdDiagCorto() {
        return idDiagCorto;
    }

    public void setIdDiagCorto(int idDiagCorto) {
        this.idDiagCorto = idDiagCorto;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getNombreDiag() {
        return nombreDiag;
    }

    public void setNombreDiag(String nombreDiag) {
        this.nombreDiag = nombreDiag;
    }

    


        
        }

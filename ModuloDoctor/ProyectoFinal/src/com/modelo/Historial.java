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
public class Historial {
    private int idDiagnostico;
    private int idExp;
    private String descripcion;
    private String medicamentos;
    private String presion;
    private String altura;
    private String peso;
    private String diagCorto;
    private String fecha;
    private String hora;

    public Historial() {
    }

    public Historial(int idDiagnostico, int idExp, String descripcion, String medicamentos, String presion, String altura, String peso, String diagCorto, String fecha, String hora) {
        this.idDiagnostico = idDiagnostico;
        this.idExp = idExp;
        this.descripcion = descripcion;
        this.medicamentos = medicamentos;
        this.presion = presion;
        this.altura = altura;
        this.peso = peso;
        this.diagCorto = diagCorto;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getPresion() {
        return presion;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getDiagCorto() {
        return diagCorto;
    }

    public void setDiagCorto(String diagCorto) {
        this.diagCorto = diagCorto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
    
}

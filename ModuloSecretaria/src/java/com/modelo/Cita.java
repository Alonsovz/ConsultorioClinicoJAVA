package com.modelo;

/**
 * Nombre de la clase:Cita.java
 * Fecha:09-10-18
 * Version:1.0
 * Copyright:ITCA-FEPADE
 * @author Emerson Sibrian
 */
public class Cita 
{
    private int idCita;
    private Paciente paciente;
    private String fecha;
    private String hora;
    private String estado;
    private String comentarios;

    public Cita() {
    }

    public Cita(int idCita, Paciente paciente, String fecha, String hora, String estado, String comentarios) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.comentarios = comentarios;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
}

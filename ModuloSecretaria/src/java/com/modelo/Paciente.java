package com.modelo;

/**
 * Nombre de la clase:Paciente.java
 * Fecha:09-10-18
 * Version:1.0
 * Copyright:ITCA-FEPADE  
 * @author Emerson Sibrian
 */
public class Paciente {
    private int idPaciente;
    private String nombre;
    private String domicilio;
    private String telefono;
    private String fechaNac;
    private String estado;
    private String usuario;
    private String contra;

    public Paciente() {
    }

    public Paciente(int idPaciente, String nombre, String domicilio, String telefono, String fechaNac, String estado, String usuario, String contra) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
        this.estado = estado;
        this.usuario = usuario;
        this.contra = contra;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    
    
}

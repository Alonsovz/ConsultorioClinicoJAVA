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
public class Roles {
    private int idRol;
    private String nombre;
    private String apellido;
    private String telefono;
    private String username;
    private String pass;
    private int nivelAcc;

    public Roles() {
    }

    public Roles(int idRol, String nombre, String apellido, String telefono, String username, String pass, int nivelAcc) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.username = username;
        this.pass = pass;
        this.nivelAcc = nivelAcc;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getNivelAcc() {
        return nivelAcc;
    }

    public void setNivelAcc(int nivelAcc) {
        this.nivelAcc = nivelAcc;
    }
    
    
    
    
    
}

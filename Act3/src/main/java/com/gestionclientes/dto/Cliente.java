/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestionclientes.dto;

import java.util.Date;

/**
 *
 * @author j1
 */
public class Cliente {
    private String nombre;
    private String apellidos;
    private Date fechaAlta;
    private String provincia;
    private int nivelIngles;

    public Cliente(String nombre, String apellidos, Date fechaAlta, String provincia, int nivelIngles) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaAlta = fechaAlta;
        this.provincia = provincia;
        this.nivelIngles = nivelIngles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getNivelIngles() {
        return nivelIngles;
    }

    public void setNivelIngles(int nivelIngles) {
        this.nivelIngles = nivelIngles;
    }
    
    
    public String[] toArrayString(){
        String[] res = new String[5];
        res[0] = nombre;
        res[1] = apellidos;
        res[2] = fechaAlta.toString();
        res[3] = provincia;
        res[4] = nivelIngles+"";
        return res;
    }
}

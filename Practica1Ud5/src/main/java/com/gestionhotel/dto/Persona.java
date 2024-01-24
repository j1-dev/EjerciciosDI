/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestionhotel.dto;

/**
 *
 * @author j1
 */
public class Persona {
    private String nombre;
    private int numTlf;
    private String direccion;

    public Persona(String nombre, int numTlf, String direccion) {
        this.nombre = nombre;
        this.numTlf = numTlf;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumTlf() {
        return numTlf;
    }

    public void setNumTlf(int numTlf) {
        this.numTlf = numTlf;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}

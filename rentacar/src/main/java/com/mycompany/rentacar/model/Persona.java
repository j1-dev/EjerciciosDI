/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentacar.model;

/**
 *
 * @author j1
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private int edad;
    private String tipoCarnet;
    private int antiguedadCarnet;
    
    public Persona() {}

    public Persona(String nombre, String apellidos, String dni, String direccion, int edad, String tipoCarnet, int antiguedadCarnet) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.edad = edad;
        this.tipoCarnet = tipoCarnet;
        this.antiguedadCarnet = antiguedadCarnet;
    }
    
    public Persona(Persona p) {
        this.nombre = p.nombre;
        this.apellidos = p.apellidos;
        this.dni = p.dni;
        this.direccion = p.direccion;
        this.edad = p.edad;
        this.tipoCarnet = p.tipoCarnet;
        this.antiguedadCarnet = p.antiguedadCarnet;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoCarnet() {
        return tipoCarnet;
    }

    public void setTipoCarnet(String tipoCarnet) {
        this.tipoCarnet = tipoCarnet;
    }

    public int getAntiguedadCarnet() {
        return antiguedadCarnet;
    }

    public void setAntiguedadCarnet(int antiguedadCarnet) {
        this.antiguedadCarnet = antiguedadCarnet;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", direccion=" + direccion + ", edad=" + edad + ", tipoCarnet=" + tipoCarnet + ", antiguedadCarnet=" + antiguedadCarnet + '}';
    }
    
    
}

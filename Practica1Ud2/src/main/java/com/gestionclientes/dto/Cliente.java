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
    private String genero;
    private String dni;
    private String correo;

    private String deporte;
    private String tallaRopa;
    private String tallaZapatos;
    private Integer edad;
    private Boolean acepto;
    
    public Cliente(String nombre, String apellidos, String genero, String dni, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.dni = dni;
        this.correo = correo;
    }

    public Cliente(String nombre, String apellidos, String genero, String dni, String correo, String deporte, String tallaRopa, String tallaZapatos, Integer edad, Boolean acepto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.dni = dni;
        this.correo = correo;
        this.deporte = deporte;
        this.tallaRopa = tallaRopa;
        this.tallaZapatos = tallaZapatos;
        this.edad = edad;
        this.acepto = acepto;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getTallaRopa() {
        return tallaRopa;
    }

    public void setTallaRopa(String tallaRopa) {
        this.tallaRopa = tallaRopa;
    }

    public String getTallaZapatos() {
        return tallaZapatos;
    }

    public void setTallaZapatos(String tallaZapatos) {
        this.tallaZapatos = tallaZapatos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getAcepto() {
        return acepto;
    }

    public void setAcepto(Boolean acepto) {
        this.acepto = acepto;
    }
    
    public String[] toArrayString(){
        String[] res = new String[10];
        res[0] = nombre;
        res[1] = apellidos;
        res[2] = genero;
        res[3] = dni;
        res[4] = correo;
        res[5] = deporte;
        res[6] = tallaRopa;
        res[7] = tallaZapatos;
        res[8] = edad.toString();
        res[9] = acepto.toString();
        return res;
    }
}

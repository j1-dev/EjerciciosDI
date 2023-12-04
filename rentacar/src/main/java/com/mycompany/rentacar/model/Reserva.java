/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentacar.model;

/**
 *
 * @author j1
 */
public class Reserva {
    private Persona usuario;
    private Coche coche;
    private String modoCobro;
    private String datosCobro;
    private String tipoSeguro;

    public Reserva(Persona usuario, Coche coche, String modoCobro, String datosCobro, String tipoSeguro) {
        this.usuario = usuario;
        this.coche = coche;
        this.modoCobro = modoCobro;
        this.datosCobro = datosCobro;
        this.tipoSeguro = tipoSeguro;
    }

    public Persona getUsuario() {
        return usuario;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public String getModoCobro() {
        return modoCobro;
    }

    public void setModoCobro(String modoCobro) {
        this.modoCobro = modoCobro;
    }

    public String getDatosCobro() {
        return datosCobro;
    }

    public void setDatosCobro(String datosCobro) {
        this.datosCobro = datosCobro;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }
    
    
}

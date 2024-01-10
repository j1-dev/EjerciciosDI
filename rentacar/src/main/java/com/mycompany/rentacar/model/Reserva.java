/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentacar.model;

import com.mycompany.rentacar.ui.CocheCard;

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
    private String numTarjeta;
    private String fechaVencimiento;
    private String codigoSeguridad;
    private String emailContacto;
    private CocheCard card;

    public Reserva(Persona usuario, Coche coche, String modoCobro, String datosCobro, String tipoSeguro, String numTarjeta, String fechaVencimiento, String codigoSeguridad, String emailContacto, CocheCard card) {
        this.usuario = usuario;
        this.coche = coche;
        this.modoCobro = modoCobro;
        this.datosCobro = datosCobro;
        this.tipoSeguro = tipoSeguro;
        this.numTarjeta = numTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
        this.emailContacto = emailContacto;
        this.card = card;
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

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public CocheCard getCard() {
        return card;
    }

    public void setCard(CocheCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Reserva{" + "usuario=" + usuario + ", coche=" + coche + ", modoCobro=" + modoCobro + ", datosCobro=" + datosCobro + ", tipoSeguro=" + tipoSeguro + ", numTarjeta=" + numTarjeta + ", fechaVencimiento=" + fechaVencimiento + ", codigoSeguridad=" + codigoSeguridad + ", emailContacto=" + emailContacto + ", card=" + card + '}';
    }
}

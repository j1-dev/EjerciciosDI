/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestionhotel.dto;

import java.util.Date;

/**
 *
 * @author j1
 */
public class Evento {
    private Persona persona;
    private String sala;
    private String tipoEvento;
    private Date fechaInicio;
    private Date fechaFin;
    private int numPersonas;
    private int numDias;
    private String tipoCocina;
    private boolean citaConChef;
    private boolean requiereHabitaciones;
    private int numHabitaciones;
    private String tipoHabitacion;
    
    public Evento(){}

    public Evento(Persona persona, String sala, String tipoEvento, Date fechaInicio, Date fechaFin, int numPersonas, int numDias, boolean requiereHabitaciones) {
        this.persona = persona;
        this.sala = sala;
        this.tipoEvento = tipoEvento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numPersonas = numPersonas;
        this.numDias = numDias;
        this.requiereHabitaciones = requiereHabitaciones;
    }

    public Evento(Persona persona, String sala, String tipoEvento, Date fechaInicio, Date fechaFin, int numPersonas, int numDias, String tipoCocina, boolean citaConChef, boolean requiereHabitaciones, int numHabitaciones, String tipoHabitacion) {
        this.persona = persona;
        this.sala = sala;
        this.tipoEvento = tipoEvento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numPersonas = numPersonas;
        this.numDias = numDias;
        this.tipoCocina = tipoCocina;
        this.citaConChef = citaConChef;
        this.requiereHabitaciones = requiereHabitaciones;
        this.numHabitaciones = numHabitaciones;
        this.tipoHabitacion = tipoHabitacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public String getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public boolean isCitaConChef() {
        return citaConChef;
    }

    public void setCitaConChef(boolean citaConChef) {
        this.citaConChef = citaConChef;
    }

    public boolean isRequiereHabitaciones() {
        return requiereHabitaciones;
    }

    public void setRequiereHabitaciones(boolean requiereHabitaciones) {
        this.requiereHabitaciones = requiereHabitaciones;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    
    
}

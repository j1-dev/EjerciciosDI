/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentacar.model;

/**
 *
 * @author j1
 */
public class Coche {
    private String tipoCoche;
    private String modeloCoche;
    private String matricula;
    private int precioDia;
    private int precioSemana;
    private int kilometrosEnPrecio;
    private int precioPorKilometro;
    private String imgPath;
    private String desperfectos;
    
    public Coche() {}

    public Coche(String tipoCoche, String modeloCoche, String matricula, int precioDia, int precioSemana, int kilometrosEnPrecio, int precioPorKilometro, String imgPath, String desperfectos) {
        this.tipoCoche = tipoCoche;
        this.modeloCoche = modeloCoche;
        this.matricula = matricula;
        this.precioDia = precioDia;
        this.precioSemana = precioSemana;
        this.kilometrosEnPrecio = kilometrosEnPrecio;
        this.precioPorKilometro = precioPorKilometro;
        this.imgPath = imgPath;
        this.desperfectos = desperfectos;
    }
    
    public Coche(Coche c) {
        this.tipoCoche = c.tipoCoche;
        this.modeloCoche = c.modeloCoche;
        this.matricula = c.matricula;
        this.precioDia = c.precioDia;
        this.precioSemana = c.precioSemana;
        this.kilometrosEnPrecio = c.kilometrosEnPrecio;
        this.precioPorKilometro = c.precioPorKilometro;
        this.imgPath = c.imgPath;
        this.desperfectos = c.desperfectos;
    }

    public String getTipoCoche() {
        return tipoCoche;
    }

    public void setTipoCoche(String tipoCoche) {
        this.tipoCoche = tipoCoche;
    }

    public String getModeloCoche() {
        return modeloCoche;
    }

    public void setModeloCoche(String modeloCoche) {
        this.modeloCoche = modeloCoche;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(int precioDia) {
        this.precioDia = precioDia;
    }

    public int getPrecioSemana() {
        return precioSemana;
    }

    public void setPrecioSemana(int precioSemana) {
        this.precioSemana = precioSemana;
    }

    public int getKilometrosEnPrecio() {
        return kilometrosEnPrecio;
    }

    public void setKilometrosEnPrecio(int kilometrosEnPrecio) {
        this.kilometrosEnPrecio = kilometrosEnPrecio;
    }

    public int getPrecioPorKilometro() {
        return precioPorKilometro;
    }

    public void setPrecioPorKilometro(int precioPorKilometro) {
        this.precioPorKilometro = precioPorKilometro;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDesperfectos() {
        return desperfectos;
    }

    public void setDesperfectos(String desperfectos) {
        this.desperfectos = desperfectos;
    }

    @Override
    public String toString() {
        return "Coche{" + "tipoCoche=" + tipoCoche + ", modeloCoche=" + modeloCoche + ", precioDia=" + precioDia + ", precioSemana=" + precioSemana + ", kilometrosEnPrecio=" + kilometrosEnPrecio + ", precioPorKilometro=" + precioPorKilometro + ", desperfectos=" + desperfectos + '}';
    }
    
    
}

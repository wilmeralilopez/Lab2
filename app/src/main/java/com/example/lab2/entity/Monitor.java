package com.example.lab2.entity;

import java.io.Serializable;

public class Monitor implements Serializable {
    private String activo;
    private String pcActivo;
    private String marca;
    private String pulgadas;
    private String años;
    private String Modelo;


    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getPcActivo() {
        return pcActivo;
    }

    public void setPcActivo(String pcActivo) {
        this.pcActivo = pcActivo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(String pulgadas) {
        this.pulgadas = pulgadas;
    }

    public String getAños() {
        return años;
    }

    public void setAños(String años) {
        this.años = años;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }
}

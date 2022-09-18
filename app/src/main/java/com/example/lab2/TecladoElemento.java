package com.example.lab2;

public class TecladoElemento {
    private String activo;
    private String pc;
    private String marca;
    private String año;
    private String idioma;
    private String modelo;

    public TecladoElemento(String activo, String pc, String marca, String año, String idioma, String modelo) {
        this.activo = activo;
        this.pc = pc;
        this.marca = marca;
        this.año = año;
        this.idioma = idioma;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "TecladoElemento{" +
                "activo='" + activo + '\'' +
                ", pc='" + pc + '\'' +
                ", marca='" + marca + '\'' +
                ", año='" + año + '\'' +
                ", idioma='" + idioma + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

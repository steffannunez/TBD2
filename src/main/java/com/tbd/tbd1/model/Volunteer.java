package com.tbd.tbd1.model;

public class Volunteer {

    private int id;
    private String name;
    private int digVerificador;

    public Volunteer(){}

    public Volunteer(int id, String name, int digVerificador) {
        this.id = id;
        this.name = name;
        this.digVerificador = digVerificador;
    }

    public Volunteer(String name) {
        this.name = name;
    }

    public int getIdVolunteer() {
        return id;
    }

    public void setIdVolunteer(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDigVerificador() {return digVerificador; }

    public void setDigVerificador(int digVerificador) {
        this.digVerificador = digVerificador;
    }
}

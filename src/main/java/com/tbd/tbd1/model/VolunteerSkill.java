package com.tbd.tbd1.model;

public class VolunteerSkill {




    private int id;
    private int id_volunteer;
    private int id_skill;

    public VolunteerSkill(){}

    public VolunteerSkill(int id, int id_volunteer, int id_skill) {
        this.id=id;
        this.id_skill= id_skill;
        this.id_volunteer = id_volunteer;
    }

    public int getIdVolunteer() {
        return id_volunteer;
    }

    public void setIdVolunteer(int id) {
        this.id_volunteer = id;
    }

    public int getId_skill(){return id_skill;}

    public void setId_skill(int id){ this.id_skill=id;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}

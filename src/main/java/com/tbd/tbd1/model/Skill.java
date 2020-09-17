package com.tbd.tbd1.model;

public class Skill {
    private int id;
    private String description;
    private int priority;

    public Skill() {}

    public Skill(int id_skill, String description, int priority) {
        this.id = id;
        this.description = description;
        this.priority=priority;
    }

    public int getPriority(){ return  priority;}
    public void setPriority(int priority){ this.priority= priority;}

    public int getIdSkill() { return id; }
    public void setIdSkill(int idSkill) { this.id = idSkill; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

package com.tbd.tbd1.model;

public class Ranking {
    private int id;
    private int id_volunteer;
    private int id_task;
    private int score;
    private boolean flg_invited;
    private boolean flg_joins;


    public Ranking(int id, int id_volunteer, int id_task, int score, boolean flg_invited, boolean flg_joins) {
        this.id = id;
        this.id_volunteer = id_volunteer;
        this.id_task = id_task;
        this.score = score;
        this.flg_invited = flg_invited;
        this.flg_joins = flg_joins;
    }


    public void setId_volunteer(int id_volunteer) {
        this.id_volunteer = id_volunteer;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isFlg_invited() {
        return flg_invited;
    }

    public void setFlg_invited(boolean flg_invited) {
        this.flg_invited = flg_invited;
    }

    public boolean isFlg_joins() {
        return flg_joins;
    }

    public void setFlg_joins(boolean flg_joins) {
        this.flg_joins = flg_joins;
    }

    public Ranking() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_volunteer() {
        return id_volunteer;
    }

    public int getId_task() {
        return id_task;
    }

    public int getScore() {
        return score;
    }


}

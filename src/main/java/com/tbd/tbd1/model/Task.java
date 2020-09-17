package com.tbd.tbd1.model;

public class Task {
    private int id;
    private String name;
    private String description;
    private int req_volunteers;
    private int enrolled_volunteers;
    private int id_emergency;
    private String startDate;
    private String endDate;
    private int id_status;

    public Task() {
    }

    public Task(int id, String name, String description, int req_volunteers, int enrolled_volunteers,
                int id_emergency, String startDate, String endDate, int id_status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.req_volunteers = req_volunteers;
        this.enrolled_volunteers = enrolled_volunteers;
        this.id_emergency = id_emergency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id_status = id_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReq_volunteers() {
        return req_volunteers;
    }

    public void setReq_volunteers(int req_volunteers) {
        this.req_volunteers = req_volunteers;
    }

    public int getEnrolled_volunteers() {
        return enrolled_volunteers;
    }

    public void setEnrolled_volunteers(int enrolled_volunteers) {
        this.enrolled_volunteers = enrolled_volunteers;
    }

    public int getId_emergency() {
        return id_emergency;
    }

    public void setId_emergency(int id_emergency) {
        this.id_emergency = id_emergency;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }
}

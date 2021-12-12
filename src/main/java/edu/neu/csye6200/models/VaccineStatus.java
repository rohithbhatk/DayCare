package edu.neu.csye6200.models;

public class VaccineStatus {
    int id;
    int vaccineId;
    int studentId;
    String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public VaccineStatus(){

    }

    public VaccineStatus(int vaccineId, int studentId, String date) {
        this.vaccineId = vaccineId;
        this.studentId = studentId;
        this.date = date;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

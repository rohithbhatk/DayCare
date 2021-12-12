package edu.neu.csye6200.controller;

public class Vaccine {
    private  int id;
    private String Vaccine_name;
    private int dose1;
    private int dose2;
    private int dose3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVaccine_name() {
        return Vaccine_name;
    }

    public void setVaccine_name(String vaccine_name) {
        Vaccine_name = vaccine_name;
    }

    public int getDose1() {
        return dose1;
    }

    public void setDose1(int dose1) {
        this.dose1 = dose1;
    }

    public int getDose2() {
        return dose2;
    }

    public void setDose2(int dose2) {
        this.dose2 = dose2;
    }

    public int getDose3() {
        return dose3;
    }

    public void setDose3(int dose3) {
        this.dose3 = dose3;
    }
}

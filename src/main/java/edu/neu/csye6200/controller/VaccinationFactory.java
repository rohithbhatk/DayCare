package edu.neu.csye6200.controller;

public class VaccinationFactory {

    static Vaccination vaccination = new Vaccination();
    private VaccinationFactory (){

    }
    public static Vaccination getInstance(){
        return vaccination;
    }


}

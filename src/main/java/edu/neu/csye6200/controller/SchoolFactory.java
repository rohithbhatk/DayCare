package edu.neu.csye6200.controller;

public class SchoolFactory {
    // private contructor to implement singleton design pattern (Design patterns)
    static School school = new School();
    private static SchoolFactory instance;
    private SchoolFactory (){
        instance = null;
    }
    public static SchoolFactory getInstance(){
        if (instance == null) {
            //Lazy instantiation
            instance = new SchoolFactory();
        }
        return instance;
    }
    //Define getObject method to return an object of SchoolFactory

    public School getObject() {
        return school;
    }
}


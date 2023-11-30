package com.example.classicalquiz.Models;

// Model class representing a Set with a specific category name
public class SetModel {

    private String setName; // Variable to store the category name of the set

    // Constructor to initialize a SetModel with a given category name
    public SetModel(String setName) {
        this.setName = setName;
    }

    // Default constructor, required for certain functionalities like Firebase
    public SetModel() {
    }

    // Getter method to retrieve the category name of the set
    public String getSetName() {
        return setName;
    }

    // Setter method to update the category name of the set
    public void setSetName(String setName) {
        this.setName = setName;
    }
}


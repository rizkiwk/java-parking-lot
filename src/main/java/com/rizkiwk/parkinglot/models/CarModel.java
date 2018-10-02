package com.rizkiwk.parkinglot.models;

import com.rizkiwk.parkinglot.interfaces.Vehicle;

public class CarModel implements Vehicle {

    private String registrationNo;

    private String color;

    public CarModel(String registrationNo, String color) {
        this.registrationNo = registrationNo;
        this.color = color;
    }

    @Override
    public String getRegistrationNo() {
        return registrationNo;
    }

    @Override
    public String getColor() {
        return color;
    }

}
package com.rizkiwk.parkinglot.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rizkiwk.parkinglot.models.CarModel;

public class ParkingSpaceHelper {

    private static List<CarModel> availableSlotList;

    public static List<CarModel> createSlotList(Integer maxSize) {

        if (availableSlotList == null) {
            synchronized (ParkingSpaceHelper.class) {
                if (availableSlotList == null) {
                    List<CarModel> nCarList = Collections.nCopies(maxSize, null);
                    availableSlotList = new ArrayList<CarModel>(nCarList);
                }
            }
        }
        return availableSlotList;
    }

    public static List<CarModel> getAvailableSlotList() {
        // if (availableSlotList == null) {
        // System.out.println("Initializing..........");
        // return createSlotList(MAX_DEFAULT_SIZE);
        // }
        return availableSlotList;
    }

}
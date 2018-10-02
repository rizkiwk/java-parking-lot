package com.rizkiwk.parkinglot.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSearchMapHelper {

    private static Map<String, Integer> slotRegistrationNoMap;
    private static Map<String, List<Integer>> colorLotMap;

    public static void initializeSearchMap() {

        if (slotRegistrationNoMap == null) {
            synchronized (ParkingSpaceHelper.class) {
                if (slotRegistrationNoMap == null) {
                    slotRegistrationNoMap = new HashMap<String, Integer>();
                    colorLotMap = new HashMap<>();
                }
            }
        }
    }

    public static Map<String, Integer> getSlotRegistrationNoMap() {
        if (slotRegistrationNoMap == null) {
            initializeSearchMap();
        }
        return slotRegistrationNoMap;
    }

    public static Map<String, List<Integer>> getColorLotMap() {
        if (colorLotMap == null) {
            initializeSearchMap();
        }
        return colorLotMap;
    }
    
}
package com.rizkiwk.parkinglot.utils;

import java.util.ArrayList;
import java.util.List;

import com.rizkiwk.parkinglot.helpers.ParkingSearchMapHelper;
import com.rizkiwk.parkinglot.models.CarModel;

public class SearchMapUpdate {

    public static void addCarToParkingLot(CarModel car, Integer firstAvaiableSlot) {
        ParkingSearchMapHelper.getSlotRegistrationNoMap().put(car.getRegistrationNo(), firstAvaiableSlot);

        List<Integer> parkingLots = ParkingSearchMapHelper.getColorLotMap().get(car.getColor());
        if (parkingLots == null) {
            parkingLots = new ArrayList<>();
        }
        parkingLots.add(firstAvaiableSlot);
        ParkingSearchMapHelper.getColorLotMap().put(car.getColor(), parkingLots);
    }

    public static void leaveCarFromParkingLot(CarModel car, Integer slot) {

        ParkingSearchMapHelper.getSlotRegistrationNoMap().remove(car.getRegistrationNo());
        ParkingSearchMapHelper.getColorLotMap().get(car.getColor()).remove(slot);
    }

}
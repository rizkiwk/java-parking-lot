package com.rizkiwk.parkinglot.services;

import java.util.stream.IntStream;

import com.rizkiwk.parkinglot.helpers.ParkingSearchMapHelper;
import com.rizkiwk.parkinglot.helpers.ParkingSpaceHelper;
import com.rizkiwk.parkinglot.interfaces.ParkingService;
import com.rizkiwk.parkinglot.models.CarModel;
import com.rizkiwk.parkinglot.utils.ParkingParam;

public class ParkingStatusService implements ParkingService {

    @Override
    public void doAction(ParkingParam param) {
        if (ParkingSearchMapHelper.getSlotRegistrationNoMap().isEmpty()) {
            System.out.println("Parking lot is empty");
            return;
        }

        System.out.println("Slot No." + "    " + "Registration No" + "    " + "Colour");

        IntStream.range(0, ParkingSpaceHelper.getAvailableSlotList().size()).forEach(i -> {
            CarModel car = ParkingSpaceHelper.getAvailableSlotList().get(i);
            if (car != null) {
                int j = i + 1;
                System.out.println("   " + j + "    " + car.getRegistrationNo() + "    " + car.getColor());
            }
        });
    }

}
package com.rizkiwk.parkinglot.services;

import com.rizkiwk.parkinglot.helpers.ParkingSearchMapHelper;
import com.rizkiwk.parkinglot.interfaces.ParkingService;
import com.rizkiwk.parkinglot.utils.ParkingParam;

public class ParkingLotByColorService implements ParkingService {

    @Override
    public void doAction(ParkingParam param) {
        String color            = param.getValue()[1];
        int lengthListColorLot  = ParkingSearchMapHelper.getColorLotMap().get(color).size();

        // System.out.println("lengthListColorLot: " + String.valueOf(lengthListColorLot));

        ParkingSearchMapHelper.getColorLotMap().get(color).forEach(value -> {
            if (value < lengthListColorLot) {
                System.out.print(value + 1 + ", ");
            }
            else {
                System.out.println(value + 1);
            }
        });
    }

}
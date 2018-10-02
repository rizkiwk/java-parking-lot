package com.rizkiwk.parkinglot.services;

import com.rizkiwk.parkinglot.helpers.ParkingSearchMapHelper;
import com.rizkiwk.parkinglot.helpers.ParkingSpaceHelper;
import com.rizkiwk.parkinglot.interfaces.ParkingService;
import com.rizkiwk.parkinglot.utils.ParkingParam;

public class ParkingNumberByColorService implements ParkingService {

    @Override
    public void doAction(ParkingParam param) {
        String color = param.getValue()[1];
        int lengthListNumber = ParkingSearchMapHelper.getColorLotMap().get(color).size();

        ParkingSearchMapHelper.getColorLotMap().get(color).forEach(slot -> {
            if (slot < lengthListNumber) {
                System.out.print(ParkingSpaceHelper.getAvailableSlotList().get(slot).getRegistrationNo()+", ");
            } 
            else {
                System.out.println(ParkingSpaceHelper.getAvailableSlotList().get(slot).getRegistrationNo());
            }
            
        });
    }

}
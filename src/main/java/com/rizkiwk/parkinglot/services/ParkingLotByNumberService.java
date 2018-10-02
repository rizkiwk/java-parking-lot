package com.rizkiwk.parkinglot.services;

import com.rizkiwk.parkinglot.commons.Constant;
import com.rizkiwk.parkinglot.helpers.ParkingSearchMapHelper;
import com.rizkiwk.parkinglot.interfaces.ParkingService;
import com.rizkiwk.parkinglot.utils.ParkingParam;

public class ParkingLotByNumberService implements ParkingService {

    @Override
    public void doAction(ParkingParam param) {

        String registrationNo = param.getValue()[1];
        Integer result = ParkingSearchMapHelper.getSlotRegistrationNoMap().get(registrationNo);

        if (result == null) {
            System.out.println(Constant.NOT_FOUND);
        } else {
            System.out.println(result + 1);
        }

    }

}
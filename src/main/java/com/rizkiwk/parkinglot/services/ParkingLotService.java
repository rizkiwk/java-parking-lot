package com.rizkiwk.parkinglot.services;

import java.text.MessageFormat;

import com.rizkiwk.parkinglot.commons.Constant;
import com.rizkiwk.parkinglot.helpers.ParkingSearchMapHelper;
import com.rizkiwk.parkinglot.helpers.ParkingSpaceHelper;
import com.rizkiwk.parkinglot.interfaces.ParkingService;
import com.rizkiwk.parkinglot.utils.ParkingParam;

public class ParkingLotService implements ParkingService {

    @Override
    public void doAction(ParkingParam param) throws NumberFormatException {
        try {

            Integer capacity = Integer.valueOf((String) param.getValue()[1]);
            ParkingSpaceHelper.createSlotList(capacity);
            ParkingSearchMapHelper.initializeSearchMap();
            System.out.println(MessageFormat.format(Constant.PARKING_LOT_CREATED, capacity));

        } catch (NumberFormatException e) {
            System.out.println(Constant.ERROR_PARKING_LOT);
        }

    }

}
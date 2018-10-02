package com.rizkiwk.parkinglot.services;

import java.text.MessageFormat;

import com.rizkiwk.parkinglot.commons.Constant;
import com.rizkiwk.parkinglot.helpers.ParkingSpaceHelper;
import com.rizkiwk.parkinglot.interfaces.ParkingService;
import com.rizkiwk.parkinglot.models.CarModel;
import com.rizkiwk.parkinglot.utils.ParkingParam;
import com.rizkiwk.parkinglot.utils.SearchMapUpdate;

public class ParkingLeaveService implements ParkingService {

    @Override
    public void doAction(ParkingParam param) {

        try {
            Integer slot = Integer.parseInt(param.getValue()[1]);
            CarModel car = ParkingSpaceHelper.getAvailableSlotList().get(slot - 1);

            if (car == null) {
                System.out.println(Constant.NOT_FOUND);
                return;
            }

            ParkingSpaceHelper.getAvailableSlotList().set(slot - 1, null);

            SearchMapUpdate.leaveCarFromParkingLot(car, slot);

            System.out.println(MessageFormat.format(Constant.SLOT_FREE, slot));

        } catch (NumberFormatException ex) {
            System.out.println(Constant.ERROR_INVALID_SPACE_NO);
            return;
        }

    }

}
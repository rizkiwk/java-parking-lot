package com.rizkiwk.parkinglot.services;

import com.rizkiwk.parkinglot.commons.Constant;
import com.rizkiwk.parkinglot.helpers.ParkingSpaceHelper;
import com.rizkiwk.parkinglot.interfaces.ParkingService;
import com.rizkiwk.parkinglot.models.CarModel;
import com.rizkiwk.parkinglot.utils.ParkingParam;
import com.rizkiwk.parkinglot.utils.SearchMapUpdate;

public class ParkingEntryService implements ParkingService {

    @Override
    public void doAction(ParkingParam param) {
        Integer firstAvailableSlot = getFirstEmptySlot();

        if (firstAvailableSlot == null) {
            System.out.println(Constant.PARKING_FULL);
            return;
        }

        CarModel car = new CarModel(param.getValue()[1], param.getValue()[2]);
        SearchMapUpdate.addCarToParkingLot(car, firstAvailableSlot);

        ParkingSpaceHelper.getAvailableSlotList().set(firstAvailableSlot, car);
        System.out.println("Allocated slot number: " + (firstAvailableSlot + 1));
        // System.out.println(MessageFormat.format(Constant.PARKING_SPACE_BLOCKED, firstAvailableSlot + 1, car.getRegistrationNo()));
    }

    private Integer getFirstEmptySlot() {
        for (int slot = 0; slot < ParkingSpaceHelper.getAvailableSlotList().size(); slot++) {
            if (ParkingSpaceHelper.getAvailableSlotList().get(slot) == null) {
                return slot;
            }
        }
        return null;
    }

}
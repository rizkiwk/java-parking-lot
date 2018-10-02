package com.rizkiwk.parkinglot;

import java.util.HashMap;
import java.util.Map;

import com.rizkiwk.parkinglot.interfaces.ParkingService;
import com.rizkiwk.parkinglot.services.ParkingEntryService;
import com.rizkiwk.parkinglot.services.ParkingLeaveService;
import com.rizkiwk.parkinglot.services.ParkingLotByColorService;
import com.rizkiwk.parkinglot.services.ParkingLotByNumberService;
import com.rizkiwk.parkinglot.services.ParkingLotService;
import com.rizkiwk.parkinglot.services.ParkingNumberByColorService;
import com.rizkiwk.parkinglot.services.ParkingStatusService;
import com.rizkiwk.parkinglot.utils.ParkingParam;

public class RequestHandler {

    private static Map<String, ParkingService> commandMap;

    public static void handleRequest(String action, String[] values) {
        if (commandMap == null) {
            prepareCommandMap();
        }

        ParkingService service = commandMap.get(action);
        ParkingParam param = new ParkingParam();
        param.setValue(values);
        service.doAction(param);
    }

    public static void prepareCommandMap() {
        commandMap = new HashMap<>();

        commandMap.put("create_parking_lot", new ParkingLotService());
        commandMap.put("park", new ParkingEntryService());
        commandMap.put("leave", new ParkingLeaveService());
        commandMap.put("status", new ParkingStatusService());
        commandMap.put("registration_numbers_for_cars_with_colour", new ParkingNumberByColorService());
        commandMap.put("slot_numbers_for_cars_with_colour", new ParkingLotByColorService());
        commandMap.put("slot_number_for_registration_number", new ParkingLotByNumberService());
    }

}
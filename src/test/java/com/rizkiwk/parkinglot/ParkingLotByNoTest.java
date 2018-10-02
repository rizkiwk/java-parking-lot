package com.rizkiwk.parkinglot;

import com.rizkiwk.parkinglot.services.ParkingEntryService;
import com.rizkiwk.parkinglot.services.ParkingLotByNumberService;
import com.rizkiwk.parkinglot.services.ParkingLotService;
import com.rizkiwk.parkinglot.utils.ParkingParam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotByNoTest {

    private ParkingLotByNumberService parkingLotByNumberService;
    private ParkingEntryService parkingEntryService;
    private ParkingLotService parkingLotService;

    @Before
	public void setUp() throws Exception {
        parkingEntryService         = new ParkingEntryService();
        parkingLotByNumberService   = new ParkingLotByNumberService();
        parkingLotService           = new ParkingLotService();
    }

    @After
    public void tearDown() throws Exception {
    
    }

    @Test
	public void testDoAction() {
        ParkingParam param  = new ParkingParam();

        param.setValue(new String[] {"create_parking_lot", "6"});
        parkingLotService.doAction(param);

        param.setValue(new String[] {"park", "KA-01-HH-1234", "White"});
        parkingEntryService.doAction(param);

        param.setValue(new String[] {"slot_number_for_registration_number", "KA-01-HH-3141"});
        parkingLotByNumberService.doAction(param);

        param.setValue(new String[] {"slot_number_for_registration_number", "KA-01-HH-1234"});
        parkingLotByNumberService.doAction(param);
    }

}
package com.rizkiwk.parkinglot;

import static org.junit.Assert.*;

import java.util.List;

import com.rizkiwk.parkinglot.helpers.ParkingSpaceHelper;
import com.rizkiwk.parkinglot.models.CarModel;
import com.rizkiwk.parkinglot.services.ParkingLotService;
import com.rizkiwk.parkinglot.utils.ParkingParam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

    private ParkingLotService parkingLotService;

    @Before
	public void setUp() throws Exception {
        parkingLotService   = new ParkingLotService();
    }

    @After
    public void tearDown() throws Exception {
    
    }

    @Test
	public void testDoAction() {
        int maxSize = 6;
        ParkingParam param  = new ParkingParam();

        param.setValue(new String[] {"create_parking_lot", "6"});
        parkingLotService.doAction(param);

        List<CarModel> parkingSpace = ParkingSpaceHelper.getAvailableSlotList();
        assertTrue(parkingSpace.size() == maxSize);
    }

}
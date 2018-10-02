package com.rizkiwk.parkinglot;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.rizkiwk.parkinglot.helpers.ParkingSpaceHelper;
import com.rizkiwk.parkinglot.models.CarModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParkingAvailabilityTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
	public void testCreateSlotList() {
        int maxSize = 6;
        List<CarModel> parkingSpace = ParkingSpaceHelper.createSlotList(maxSize);
        assertTrue(parkingSpace.size() == maxSize);
    }

    @Test
	public void testGetAvailableSlotList() {
        int maxSize = 6;
        List<CarModel> parkingSpace = ParkingSpaceHelper.getAvailableSlotList();
        assertTrue(parkingSpace.size() == maxSize);
    }

}
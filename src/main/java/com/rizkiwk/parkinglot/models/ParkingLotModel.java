package com.rizkiwk.parkinglot.models;

import com.rizkiwk.parkinglot.interfaces.ParkingLot;

public class ParkingLotModel implements ParkingLot {

    private long spaceId;

    public ParkingLotModel() {

    }

    @Override
    public Long getSpaceId() {
        return spaceId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + spaceId);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        ParkingLotModel other = (ParkingLotModel) obj;

        if (spaceId != other.spaceId)
            return false;

        return true;
    }

}
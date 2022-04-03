package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exceptions.ParkingLotFullException;

import java.util.ArrayList;

public class ParkingLot {
    private final int capacity;
    private final ArrayList<Parkable> vehicles;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>(capacity);
    }

    public void park(Parkable car) throws ParkingLotFullException {
        if (vehicles.size() == capacity) throw new ParkingLotFullException();
        vehicles.add(car);
    }

    public boolean isParked(Parkable car) {
        return vehicles.contains(car);
    }
}

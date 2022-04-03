package com.thoughtworks.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {
    @Test
    void shouldParkTheCarWhenSlotIsAvailable() {
        int capacity = 10;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Parkable car = new Car();

        parkingLot.park(car);

        assertTrue(parkingLot.isParked(car));
    }
}

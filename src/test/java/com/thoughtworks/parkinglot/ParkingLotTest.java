package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exceptions.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {
    @Test
    void shouldParkTheCarWhenSlotIsAvailable() throws ParkingLotFullException {
        int capacity = 10;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Parkable car = new Car();

        parkingLot.park(car);

        assertTrue(parkingLot.isParked(car));
    }

    @Test
    void shouldNotParkTheCarWhenSlotsAreFilled() throws ParkingLotFullException {
        int capacity = 1;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Car carOne = new Car();
        Car carTwo = new Car();

        parkingLot.park(carOne);

        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(carTwo));
    }
}

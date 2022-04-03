package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exceptions.CarAlreadyParkedException;
import com.thoughtworks.parkinglot.exceptions.CarNotParkedYetException;
import com.thoughtworks.parkinglot.exceptions.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void shouldParkTheCarWhenSlotIsAvailable() throws ParkingLotFullException, CarAlreadyParkedException {
        int capacity = 10;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Parkable car = new Car();

        parkingLot.park(car);

        assertTrue(parkingLot.isParked(car));
    }

    @Test
    void shouldNotParkTheCarWhenSlotsAreFilled() throws ParkingLotFullException, CarAlreadyParkedException {
        int capacity = 1;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Car carOne = new Car();
        Car carTwo = new Car();

        parkingLot.park(carOne);

        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(carTwo));
    }

    @Test
    void shouldNotParkTheCarWhenItIsAlreadyParked() throws ParkingLotFullException, CarAlreadyParkedException {
        int capacity = 2;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Car carOne = new Car();
        Car carTwo = new Car();

        parkingLot.park(carOne);
        parkingLot.park(carTwo);

        assertThrows(CarAlreadyParkedException.class, () -> parkingLot.park(carOne));
    }

    @Test
    void shouldUnparkTheCarWhenTheCarIsParked() throws ParkingLotFullException, CarAlreadyParkedException, CarNotParkedYetException {
        int capacity = 1;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Car car = new Car();

        parkingLot.park(car);
        parkingLot.unpark(car);

        assertFalse(parkingLot.isParked(car));
    }

    @Test
    void shouldNotUnparkTheCarWhenItIsNotParkedYet() {
        int capacity = 1;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Car car = new Car();

        assertThrows(CarNotParkedYetException.class, () -> parkingLot.unpark(car));
    }
}

package ParkingLot.Strategy;

import ParkingLot.Model.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findParkingSpace(List<ParkingSpot> spots);
}


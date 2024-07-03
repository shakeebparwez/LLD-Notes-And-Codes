package ParkingLot.Strategy;

import ParkingLot.Model.ParkingSpot;

import java.util.List;

public class DefaultParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpace(List<ParkingSpot> spots) {
        // Default strategy to find the first empty spot
        return spots.stream().filter(ParkingSpot::isEmpty).findFirst().orElse(null);
    }
}


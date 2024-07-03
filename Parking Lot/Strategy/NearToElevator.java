package ParkingLot.Strategy;

import ParkingLot.Model.ParkingSpot;

import java.util.List;

public class NearToElevator implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpace(List<ParkingSpot> spots) {
        // Logic to find the spot nearest to the elevator
        // For simplicity, we return the first empty spot
        return spots.stream().filter(ParkingSpot::isEmpty).findFirst().orElse(null);
    }
}


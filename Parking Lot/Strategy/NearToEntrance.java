package ParkingLot.Strategy;

import ParkingLot.Model.ParkingSpot;

import java.util.List;

public class NearToEntrance implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpace(List<ParkingSpot> spots) {
        // Logic to find the spot nearest to the entrance
        // For simplicity, we return the first empty spot
        return spots.stream().filter(ParkingSpot::isEmpty).findFirst().orElse(null);
    }
}


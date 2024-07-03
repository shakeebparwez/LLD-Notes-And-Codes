package ParkingLot.Manager;

import ParkingLot.Model.ParkingSpot;
import ParkingLot.Strategy.ParkingStrategy;

import java.util.List;
import java.util.Optional;

public class FourWheelerManager extends ParkingSpotManager {
    public FourWheelerManager(List<ParkingSpot> spots, ParkingStrategy parkingStrategy) {
        super(spots, parkingStrategy);
    }
}


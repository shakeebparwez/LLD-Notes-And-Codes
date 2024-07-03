package ParkingLot.Manager;

import ParkingLot.Model.ParkingSpot;
import ParkingLot.Strategy.ParkingStrategy;

import java.util.List;

public class TwoWheelerManager extends ParkingSpotManager {
    public TwoWheelerManager(List<ParkingSpot> spots, ParkingStrategy parkingStrategy) {
        super(spots, parkingStrategy);
    }
}


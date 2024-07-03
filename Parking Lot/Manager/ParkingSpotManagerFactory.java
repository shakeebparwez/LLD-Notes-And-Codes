package ParkingLot.Manager;

import ParkingLot.Model.ParkingSpot;
import ParkingLot.Model.VehicleType;
import ParkingLot.Strategy.ParkingStrategy;

import java.util.List;

public class ParkingSpotManagerFactory {
    public ParkingSpotManager getParkingSpotManager(VehicleType vehicleType, List<ParkingSpot> spots, ParkingStrategy parkingStrategy) {
        if (vehicleType == VehicleType.TwoWheeler)
            return new TwoWheelerManager(spots, parkingStrategy);
        else if (vehicleType == VehicleType.FourWheeler)
            return new FourWheelerManager(spots, parkingStrategy);
        else
            return null;
    }
}
package ParkingLot.Manager;

import ParkingLot.Model.ParkingSpot;
import ParkingLot.Model.Vehicle;
import ParkingLot.Strategy.ParkingStrategy;

import java.util.List;

public abstract class ParkingSpotManager {
    protected List<ParkingSpot> spots;
    protected ParkingStrategy parkingStrategy;

    public ParkingSpotManager(List<ParkingSpot> spots, ParkingStrategy parkingStrategy) {
        this.spots = spots;
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingSpot findParkingSpace() {
        return parkingStrategy.findParkingSpace(spots);
    }

    public void parkVehicle(Vehicle v) {
        ParkingSpot spot = findParkingSpace();
        if (spot != null) {
            spot.parkVehicle(v);
        }
    }

    public void removeVehicle(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (!spot.isEmpty() && spot.getVehicle().equals(v)) {
                spot.removeVehicle();
                break;
            }
        }
    }
}


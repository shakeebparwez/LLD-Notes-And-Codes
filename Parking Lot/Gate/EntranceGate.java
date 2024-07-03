package ParkingLot.Gate;


import ParkingLot.Manager.ParkingSpotManager;
import ParkingLot.Manager.ParkingSpotManagerFactory;
import ParkingLot.Model.ParkingSpot;
import ParkingLot.Model.Ticket;
import ParkingLot.Model.Vehicle;
import ParkingLot.Model.VehicleType;
import ParkingLot.Strategy.ParkingStrategy;

import java.util.List;

public class EntranceGate {
    ParkingSpotManagerFactory factory;

    public EntranceGate(ParkingSpotManagerFactory factory) {
        this.factory = factory;
    }

    public ParkingSpot findParkingSpace(VehicleType vehicleType, List<ParkingSpot> spots, ParkingStrategy parkingStrategy) {
        ParkingSpotManager manager = factory.getParkingSpotManager(vehicleType, spots, parkingStrategy);
        return manager.findParkingSpace();
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        long entryTime = System.currentTimeMillis();
        parkingSpot.parkVehicle(vehicle);
        return new Ticket(entryTime, parkingSpot, vehicle);
    }
}



package ParkingLot;

import ParkingLot.Cost.CostComputationFactory;
import ParkingLot.Gate.EntranceGate;
import ParkingLot.Gate.ExitGate;
import ParkingLot.Manager.ParkingSpotManagerFactory;
import ParkingLot.Model.*;
import ParkingLot.Pricing.DefaultPricingStrategy;
import ParkingLot.Pricing.HourlyPricingStrategy;
import ParkingLot.Strategy.NearToElevator;
import ParkingLot.Strategy.NearToEntrance;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize parking spots
        List<ParkingSpot> twoWheelerSpots = new ArrayList<>();
        List<ParkingSpot> fourWheelerSpots = new ArrayList<>();

        for (int i = 1; i <= 60; ++i) {
            twoWheelerSpots.add(new TwoWheelerSpot(i));
        }

        for (int i = 61; i <= 100; ++i) {
            fourWheelerSpots.add(new FourWheelerSpot(i));
        }

        // Create strategies
        NearToEntrance nearToEntrance = new NearToEntrance();
        NearToElevator nearToElevator = new NearToElevator();

        // Create factory
        ParkingSpotManagerFactory parkingFactory = new ParkingSpotManagerFactory();
        CostComputationFactory costFactory = new CostComputationFactory();

        // Create EntranceGate and ExitGate objects
        EntranceGate entranceGate = new EntranceGate(parkingFactory);
        ExitGate exitGate = new ExitGate(parkingFactory, costFactory);

        // Example usage for Two Wheeler
        Vehicle twoWheeler = new Vehicle(123, VehicleType.TwoWheeler);
        ParkingSpot twoWheelerSpot = entranceGate.findParkingSpace(twoWheeler.getVehicleType(), twoWheelerSpots, nearToEntrance);
        Ticket twoWheelerTicket = entranceGate.generateTicket(twoWheeler, twoWheelerSpot);

        // Example usage for Four Wheeler
        Vehicle fourWheeler = new Vehicle(456, VehicleType.FourWheeler);
        ParkingSpot fourWheelerSpot = entranceGate.findParkingSpace(fourWheeler.getVehicleType(), fourWheelerSpots, nearToElevator);
        Ticket fourWheelerTicket = entranceGate.generateTicket(fourWheeler, fourWheelerSpot);

        // Simulate vehicle exit with pricing strategy
        exitGate.removeVehicle(twoWheelerTicket, twoWheelerSpots, new DefaultPricingStrategy());
        exitGate.removeVehicle(fourWheelerTicket, fourWheelerSpots, new HourlyPricingStrategy());
    }
}

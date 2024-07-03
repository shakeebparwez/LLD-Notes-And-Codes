package ParkingLot.Gate;

import ParkingLot.Cost.CostComputation;
import ParkingLot.Cost.CostComputationFactory;
import ParkingLot.Manager.ParkingSpotManager;
import ParkingLot.Manager.ParkingSpotManagerFactory;
import ParkingLot.Model.ParkingSpot;
import ParkingLot.Model.Ticket;
import ParkingLot.Model.VehicleType;
import ParkingLot.Pricing.PricingStrategy;
import ParkingLot.Strategy.DefaultParkingStrategy;

import java.util.List;

public class ExitGate {
    private ParkingSpotManagerFactory parkingFactory;
    private CostComputationFactory costFactory;


    public ExitGate(ParkingSpotManagerFactory parkingFactory, CostComputationFactory costFactory) {
        this.parkingFactory = parkingFactory;
        this.costFactory = costFactory;
    }

    public void removeVehicle(Ticket ticket, List<ParkingSpot> spots, PricingStrategy pricingStrategy) {
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        ParkingSpotManager manager = parkingFactory.getParkingSpotManager(vehicleType, spots, new DefaultParkingStrategy());
        manager.removeVehicle(ticket.getVehicle());

        CostComputation costComputation = costFactory.getCostComputation(vehicleType, pricingStrategy);
        double cost = costComputation.computeCost(ticket);
        System.out.println("Total Cost For Parking: " + cost);
    }
}

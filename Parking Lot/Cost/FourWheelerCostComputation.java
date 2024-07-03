package ParkingLot.Cost;

import ParkingLot.Model.Ticket;

public class FourWheelerCostComputation extends CostComputation {
    @Override
    public double computeCost(Ticket ticket) {
        return pricingStrategy.calculateCost(ticket);
    }
}

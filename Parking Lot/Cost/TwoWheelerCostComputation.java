package ParkingLot.Cost;

import ParkingLot.Model.Ticket;

public class TwoWheelerCostComputation extends CostComputation {
    @Override
    public double computeCost(Ticket ticket) {
        return pricingStrategy.calculateCost(ticket);
    }
}

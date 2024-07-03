package ParkingLot.Cost;

import ParkingLot.Model.Ticket;
import ParkingLot.Pricing.PricingStrategy;

public abstract class CostComputation {
    protected PricingStrategy pricingStrategy;

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public abstract double computeCost(Ticket ticket);
}
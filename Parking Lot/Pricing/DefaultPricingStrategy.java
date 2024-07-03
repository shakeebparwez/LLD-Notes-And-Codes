package ParkingLot.Pricing;

import ParkingLot.Model.Ticket;

public class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double calculateCost(Ticket ticket) {
        return ticket.getParkingSpot().getPrice();
    }
}

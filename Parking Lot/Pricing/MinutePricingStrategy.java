package ParkingLot.Pricing;

import ParkingLot.Model.Ticket;

public class MinutePricingStrategy implements PricingStrategy {
    @Override
    public double calculateCost(Ticket ticket) {
        long currentTime = System.currentTimeMillis();
        long duration = currentTime - ticket.getEntryTime();
        double minutes = duration / (1000 * 60);
        return minutes * 0.5;
    }
}

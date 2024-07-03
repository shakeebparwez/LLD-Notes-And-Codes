package ParkingLot.Pricing;

import ParkingLot.Model.Ticket;

public class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculateCost(Ticket ticket) {
        long currentTime = System.currentTimeMillis();
        long duration = currentTime - ticket.getEntryTime();
        double hours = duration / (1000 * 60 * 60);
        return hours * ticket.getParkingSpot().getPrice();
    }
}
package ParkingLot.Pricing;

import ParkingLot.Model.Ticket;

public interface PricingStrategy {
    double calculateCost(Ticket ticket);
}
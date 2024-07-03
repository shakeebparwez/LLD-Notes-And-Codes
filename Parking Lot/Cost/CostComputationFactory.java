package ParkingLot.Cost;

import ParkingLot.Model.VehicleType;
import ParkingLot.Pricing.PricingStrategy;

public class CostComputationFactory {
    public CostComputation getCostComputation(VehicleType vehicleType, PricingStrategy pricingStrategy) {
        CostComputation costComputation;
        if (vehicleType == VehicleType.TwoWheeler) {
            costComputation = new TwoWheelerCostComputation();
        } else {
            costComputation = new FourWheelerCostComputation();
        }
        costComputation.setPricingStrategy(pricingStrategy);
        return costComputation;
    }
}

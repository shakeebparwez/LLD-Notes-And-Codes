package ParkingLot.Model;

public class TwoWheelerSpot extends ParkingSpot {
    public TwoWheelerSpot(int id) {
        super(id);
    }

    @Override
    public int getPrice() {
        return 10;
    }
}


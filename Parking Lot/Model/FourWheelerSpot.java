package ParkingLot.Model;

public class FourWheelerSpot extends ParkingSpot {
    public FourWheelerSpot(int id) {
        super(id);
    }

    @Override
    public int getPrice() {
        return 20;
    }
}


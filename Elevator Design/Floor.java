package ElevatorDesign;

public class Floor {
    int floor;
    ExternalButton externalButton;


    public Floor(int floor){
        this.floor = floor;
        externalButton = new ExternalButton(floor);
    }
    public void pressButton(Direction direction) {

        externalButton.pressButton(direction);
    }
}

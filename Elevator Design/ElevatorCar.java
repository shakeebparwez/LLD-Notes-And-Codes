package ElevatorDesign;

public class ElevatorCar {

    int id;
    ElevatorDisplay display;
    InternalButtons internalButtons;

    int currentFloor;
    Direction elevatorDirection;
    ElevatorDoor elevatorDoor;

    public ElevatorCar(){
        display = new ElevatorDisplay();
        internalButtons = new InternalButtons();
        currentFloor = 0;
        elevatorDirection = Direction.IDLE;
        elevatorDoor = new ElevatorDoor();

    }
    public void showDisplay() {
        display.showDisplay();
    }

    public void pressButton(int destination) {
        internalButtons.pressButton(destination, this);
    }

    public void setDisplay() {
        this.display.setDisplay(currentFloor, elevatorDirection);
    }

    public boolean moveElevator(Direction dir, int destinationFloor) {
        if (dir == Direction.UP) {
            for (int i = currentFloor; i <= destinationFloor; i++) {
                this.currentFloor = i;
                this.elevatorDirection = (i == destinationFloor) ? Direction.IDLE : Direction.UP;
                setDisplay();
                showDisplay();
                if (i == destinationFloor) {
                    return true;
                }
            }
        }

        if (dir == Direction.DOWN) {
            for (int i = currentFloor; i >= destinationFloor; i--) {
                this.currentFloor = i;
                this.elevatorDirection = (i == destinationFloor) ? Direction.IDLE : Direction.DOWN;
                setDisplay();
                showDisplay();
                if (i == destinationFloor) {
                    return true;
                }
            }
        }
        return false;
    }
}


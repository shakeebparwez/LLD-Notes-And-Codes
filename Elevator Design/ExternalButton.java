package ElevatorDesign;


public class ExternalButton {

    ExternalDispatcher dispatcher = new ExternalDispatcher();
    int floor;

    public ExternalButton(int floor) {
        this.floor = floor;
    }

    void pressButton(Direction direction) {

        // Submit the request to the jobDispatcher
        dispatcher.submitExternalRequest(floor, direction);
    }

}

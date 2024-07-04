package ElevatorDesign;

import java.util.List;

public class InternalDispatcher {

    List<ElevatorController>  elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitInternalRequest(int floor, ElevatorCar elevatorCar){
        // Find the controller for the given elevator car and submit the internal request
        for (ElevatorController elevatorController : elevatorControllerList) {
            if (elevatorController.elevatorCar.equals(elevatorCar)) {
                elevatorController.submitInternalRequest(floor);
                break;
            }
        }
    }
}


package ElevatorDesign;

import java.util.List;

public class ExternalDispatcher {

    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitExternalRequest(int floor, Direction direction) {
        ElevatorController bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorController elevatorController : elevatorControllerList) {
            int distance = Math.abs(elevatorController.elevatorCar.currentFloor - floor);

            if (elevatorController.elevatorCar.elevatorDirection == direction || elevatorController.elevatorCar.elevatorDirection == Direction.IDLE) {
                if ((direction == Direction.UP && elevatorController.elevatorCar.currentFloor <= floor) ||
                        (direction == Direction.DOWN && elevatorController.elevatorCar.currentFloor >= floor) ||
                        elevatorController.elevatorCar.elevatorDirection == Direction.IDLE) {

                    if (distance < minDistance) {
                        minDistance = distance;
                        bestElevator = elevatorController;
                    }
                }
            }
        }

        // If no suitable elevator found moving in the desired direction, just find the nearest elevator
        if (bestElevator == null) {
            for (ElevatorController elevatorController : elevatorControllerList) {
                int distance = Math.abs(elevatorController.elevatorCar.currentFloor - floor);
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevatorController;
                }
            }
        }

        if (bestElevator != null) {
            bestElevator.submitExternalRequest(floor, direction);
        }
    }
}



package ElevatorDesign;

import java.util.PriorityQueue;

public class ElevatorController {

    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;
    ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar) {

        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a, b) -> b - a);

    }

    public void submitExternalRequest(int floor, Direction direction) {

        if (direction == Direction.DOWN) {
            downMaxPQ.offer(floor);
        } else {
            upMinPQ.offer(floor);
        }
    }

    public void submitInternalRequest(int floor) {
        if (floor > elevatorCar.currentFloor) {
            upMinPQ.offer(floor);
        } else {
            downMaxPQ.offer(floor);
        }
    }

    public void controlElevator() {
        while (!upMinPQ.isEmpty() || !downMaxPQ.isEmpty()) {
            if (elevatorCar.elevatorDirection == Direction.UP || elevatorCar.elevatorDirection == Direction.IDLE) {
                while (!upMinPQ.isEmpty()) {
                    int nextFloor = upMinPQ.poll();
                    elevatorCar.moveElevator(Direction.UP, nextFloor);
                }
                if (!downMaxPQ.isEmpty()) {
                    elevatorCar.elevatorDirection = Direction.DOWN;
                }
            }

            if (elevatorCar.elevatorDirection == Direction.DOWN || elevatorCar.elevatorDirection == Direction.IDLE) {
                while (!downMaxPQ.isEmpty()) {
                    int nextFloor = downMaxPQ.poll();
                    elevatorCar.moveElevator(Direction.DOWN, nextFloor);
                }
                if (!upMinPQ.isEmpty()) {
                    elevatorCar.elevatorDirection = Direction.UP;
                }
            }

            if (upMinPQ.isEmpty() && downMaxPQ.isEmpty()) {
                elevatorCar.elevatorDirection = Direction.IDLE;
            }
        }
    }

}


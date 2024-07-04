package ElevatorDesign;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Create floors
        Floor floor0 = new Floor(0);
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);

        // Create a building and add floors to it
        Building building = new Building(Arrays.asList(floor0, floor1, floor2, floor3));

        // External requests
        floor0.pressButton(Direction.UP);
        floor3.pressButton(Direction.DOWN);

        // Internal requests
        ElevatorController controller1 = ElevatorCreator.elevatorControllerList.get(0);
        controller1.elevatorCar.pressButton(2);
        controller1.elevatorCar.pressButton(3);

        ElevatorController controller2 = ElevatorCreator.elevatorControllerList.get(1);
        controller2.elevatorCar.pressButton(1);

        // Start the controllers
        Thread controller1Thread = new Thread(() -> controller1.controlElevator());
        Thread controller2Thread = new Thread(() -> controller2.controlElevator());

        controller1Thread.start();
        controller2Thread.start();

        // Wait for threads to finish (for simplicity, in a real-world scenario we would need proper synchronization)
        try {
            controller1Thread.join();
            controller2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


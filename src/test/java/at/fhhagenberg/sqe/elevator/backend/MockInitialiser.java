package at.fhhagenberg.sqe.elevator.backend;

import java.rmi.RemoteException;

import at.fhhagenberg.sqe.elevator.model.Elevator;

public class MockInitialiser {

    private final ElevatorMock elevatorMock;

    public MockInitialiser(ElevatorMock  mockedIElevator)
    {
        elevatorMock = mockedIElevator;
    }

    public void initMockNums(int elevators, int floors) {
    //    when(elevatorMock.getElevatorNum()).thenReturn(elevators);
    //    when(elevatorMock.getFloorNum()).thenReturn(floors);
    }

    public void initMockElevator(int elevator, int direction, int accel, int capacity, int doorStatus,
                                  int floor, int pos, int speed, int weight,
                                  int target, boolean[] buttons) {
    	//  when(elevatorMock.getCommittedDirection(elevator)).thenReturn(direction); erstetzen durch ->
    	elevatorMock.setCommittedDirection(elevator, direction);
        // elevatorMock.getElevatorAccel(elevator)	
        elevatorMock.setElevatorAccel(elevator, accel);
        elevatorMock.setElevatorCapacity(elevator, capacity);
        elevatorMock.setElevatorDoorStatus(elevator, doorStatus);
        elevatorMock.setElevatorFloor(elevator, floor);
        elevatorMock.setElevatorPosition(elevator, pos);
        elevatorMock.setElevatorSpeed(elevator, speed);
        elevatorMock.setElevatorWeight(elevator, weight);
        elevatorMock.setTarget(elevator, target);
        elevatorMock.setElevatorButton(elevator, buttons );
    }

    public void initMockFloor(int floor, boolean buttonUp, boolean buttonDown) {
        elevatorMock.setFloorButtonDown(floor, buttonUp);
        elevatorMock.setFloorButtonUp(floor, buttonDown);
    }

    public void defaultMockSetup() {
    	int elevators;
    	int floors;

		try {
			elevators = elevatorMock.getElevatorNum();
			floors = elevatorMock.getFloorNum();
	        for(int i = 0; i < elevators; i++)
	            initMockElevator(i, Elevator.UP, 5, 101, Elevator.CLOSED, 1, 102,
	                    10, 103, 4, new boolean[floors]);
	        for(int i = 0; i < floors; i++)
	            initMockFloor(i, false, false);
		} catch (RemoteException e) {
			e.printStackTrace();
		}  

    }
    
    public void exceptionMockSetup( boolean error )
    {
        elevatorMock.setErrorStatus(error);
        
    }


}
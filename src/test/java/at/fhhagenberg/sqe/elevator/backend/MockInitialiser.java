package at.fhhagenberg.sqe.elevator.backend;

import at.fhhagenberg.sqe.elevator.model.Elevator;
import at.fhhagenberg.sqe.elevator.model.Floor;
import sqelevator.IElevator;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.IntArrayAssert;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

public class MockInitialiser {

    private final ElevatorMock elevatorMock;

    public MockInitialiser(ElevatorMock  mockedIElevator)
    {
        elevatorMock = mockedIElevator;
    }

    public void initMockNums(int elevators, int floors) throws RemoteException {
    //    when(elevatorMock.getElevatorNum()).thenReturn(elevators);
    //    when(elevatorMock.getFloorNum()).thenReturn(floors);
    }

    public void initMockElevator(int elevator, int direction, int accel, int capacity, int doorStatus,
                                  int floor, int pos, int speed, int weight,
                                  int target, boolean[] buttons) throws RemoteException {
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

    public void initMockFloor(int floor, boolean buttonUp, boolean buttonDown) throws RemoteException {
        elevatorMock.setFloorButtonDown(floor, buttonUp);
        elevatorMock.setFloorButtonUp(floor, buttonDown);
    }


    // public void defaultMockSetup() throws RemoteException {
    //     defaultMockSetup(5,8);
    // }

    public void defaultMockSetup(/* int elevators, int floors */ ) throws RemoteException {
    	int elevators =elevatorMock.getElevatorNum();  
    	int floors = elevatorMock.getFloorNum() ;
    	initMockNums(elevators, floors);
        // elevatorMock.setFloorNum(floors);
        // elevatorMock.setElevatorNum(elevators);
        for(int i = 0; i < elevators; i++)
            initMockElevator(i, Elevator.UP, 5, 101, Elevator.CLOSED, 1, 102,
                    10, 103, 4, new boolean[] {true, false, false, true, true});
        for(int i = 0; i < floors; i++)
            initMockFloor(i, false, false);
    }
    
    public void exceptionMockSetup( boolean error ) throws RemoteException
    {
        elevatorMock.setErrorStatus(error);
        
    }


}
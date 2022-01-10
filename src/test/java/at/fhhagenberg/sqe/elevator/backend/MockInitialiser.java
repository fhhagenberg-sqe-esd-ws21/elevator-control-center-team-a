package at.fhhagenberg.sqe.elevator.backend;

import at.fhhagenberg.sqe.elevator.model.Elevator;
import at.fhhagenberg.sqe.elevator.model.Floor;
import sqelevator.IElevator;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

public class MockInitialiser {

    private final IElevator elevatorMock;

    public MockInitialiser(IElevator mockedIElevator)
    {
        elevatorMock = mockedIElevator;
    }

    public void initMockNums(int elevators, int floors) throws RemoteException {
        when(elevatorMock.getElevatorNum()).thenReturn(elevators);
        when(elevatorMock.getFloorNum()).thenReturn(floors);
    }

    public void initMockElevator(int elevator, int direction, int accel, int capacity, int doorStatus,
                                  int floor, int pos, int speed, int weight,
                                  int target, List<Integer> buttons) throws RemoteException {
        when(elevatorMock.getCommittedDirection(elevator)).thenReturn(direction);
        when(elevatorMock.getElevatorAccel(elevator)).thenReturn(accel);
        when(elevatorMock.getElevatorCapacity(elevator)).thenReturn(capacity);
        when(elevatorMock.getElevatorDoorStatus(elevator)).thenReturn(doorStatus);
        when(elevatorMock.getElevatorFloor(elevator)).thenReturn(floor);
        when(elevatorMock.getElevatorPosition(elevator)).thenReturn(pos);
        when(elevatorMock.getElevatorSpeed(elevator)).thenReturn(speed);
        when(elevatorMock.getElevatorWeight(elevator)).thenReturn(weight);
        when(elevatorMock.getTarget(elevator)).thenReturn(target);
        for(var button : buttons ) {
            lenient().when(elevatorMock.getElevatorButton(elevator, button)).thenReturn(Floor.ON);
        }
    }

    public void initMockFloor(int floor, boolean buttonUp, boolean buttonDown, int height) throws RemoteException {
        when(elevatorMock.getFloorButtonDown(floor)).thenReturn(buttonUp);
        when(elevatorMock.getFloorButtonUp(floor)).thenReturn(buttonDown);
        when(elevatorMock.getFloorHeight()).thenReturn(height);
    }

    public List<Integer> setButton(int min, int max) {
        ArrayList<Integer> buttons = new ArrayList<>();
        for(int i = min; i <= max; i++)
            buttons.add(i);
        return buttons;
    }

    public void defaultMockSetup() throws RemoteException {
        defaultMockSetup(5,8);
    }

    public void defaultMockSetup(int elevators, int floors) throws RemoteException {
        initMockNums(elevators, floors);
        for(int i = 0; i < elevators; i++)
            initMockElevator(i, Elevator.UP, 5, 101, Elevator.CLOSED, 1, 102,
                    10, 103, 4, setButton(3, 6));
        for(int i = 0; i < floors; i++)
            initMockFloor(i, false, false, 100);
    }
    
    public void exceptionMockSetup() throws RemoteException
    {
        when(elevatorMock.getElevatorAccel(0)).thenThrow(new RemoteException("Remote Error"));
        when(elevatorMock.getElevatorNum()).thenThrow(new RemoteException("Remote Error"));
    }

}

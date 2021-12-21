package at.fhhagenberg.sqe.elevator.backend;

import at.fhhagenberg.sqe.elevator.model.Elevator;
import at.fhhagenberg.sqe.elevator.model.Floor;
import org.mockito.Mock;
import sqelevator.IElevator;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class MockInitialiser {

    private final IElevator _mockedIElevator;

    public MockInitialiser(IElevator mockedIElevator)
    {
        _mockedIElevator = mockedIElevator;
    }

    private void initMockNums(int elevators, int floors) throws RemoteException {
        when(_mockedIElevator.getElevatorNum()).thenReturn(elevators);
        when(_mockedIElevator.getFloorNum()).thenReturn(floors);
    }

    private void initMockElevator(int elevator, int direction, int accel, int capacity, int doorStatus,
                                  int floor, int pos, int speed, int weight,
                                  int target, List<Integer> buttons) throws RemoteException {
        when(_mockedIElevator.getCommittedDirection(elevator)).thenReturn(direction);
        when(_mockedIElevator.getElevatorAccel(elevator)).thenReturn(accel);
        when(_mockedIElevator.getElevatorCapacity(elevator)).thenReturn(capacity);
        when(_mockedIElevator.getElevatorDoorStatus(elevator)).thenReturn(doorStatus);
        when(_mockedIElevator.getElevatorFloor(elevator)).thenReturn(floor);
        when(_mockedIElevator.getElevatorPosition(elevator)).thenReturn(pos);
        when(_mockedIElevator.getElevatorSpeed(elevator)).thenReturn(speed);
        when(_mockedIElevator.getElevatorWeight(elevator)).thenReturn(weight);
        when(_mockedIElevator.getTarget(elevator)).thenReturn(target);
        for(var button : buttons ) {
            when(_mockedIElevator.getElevatorButton(elevator, button)).thenReturn(Floor.ON);
        }
    }

    private void initMockFloor(int floor, boolean buttonUp, boolean buttonDown, int height) throws RemoteException {
        when(_mockedIElevator.getFloorButtonDown(floor)).thenReturn(buttonUp);
        when(_mockedIElevator.getFloorButtonUp(floor)).thenReturn(buttonDown);
        when(_mockedIElevator.getFloorHeight()).thenReturn(height);
    }

    private List<Integer> setButton(int min, int max) {
        ArrayList<Integer> buttons = new ArrayList();
        for(int i = min; i <= max; i++)
            buttons.add(i);
        return buttons;
    }

    public void defaultMockSetup() throws RemoteException {
        defaultMockSetup(3,8);
    }

    private void defaultMockSetup(int elevators, int floors) throws RemoteException {
        initMockNums(elevators, floors);
        for(int i = 0; i < elevators; i++)
            initMockElevator(i, Elevator.UP, 5, 100, Elevator.CLOSED, 1, 100,
                    10, 100, 5, setButton(3, 4));
        for(int i = 0; i < floors; i++)
            initMockFloor(i, false, false, 100);
    }

}

package at.fhhagenberg.sqe.elevator.backend;

import sqelevator.IElevator;
import java.rmi.RemoteException;


public class ElevatorWrapper {

    private final IElevator elevatorRemote;

    public ElevatorWrapper(IElevator elevatorInterface)
    {
        elevatorRemote = elevatorInterface;
    }

    public int getCommittedDirection(int elevatorNumber) {
        try {
            return elevatorRemote.getCommittedDirection(elevatorNumber);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getCommitedDirection: " + ex.getMessage()));
        }
    }

    public int getElevatorAccel(int elevatorNumber) {
        try {
           return elevatorRemote.getElevatorAccel(elevatorNumber);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getElevatorAccel: " + ex.getMessage()));
        }
    }

    public int getElevatorButton(int elevatorNumber, int floor) {
        try {
            return elevatorRemote.getElevatorButton(elevatorNumber, floor)?1:0;
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getElevatorButton: " + ex.getMessage()));
        }
    }

    public int getElevatorDoorStatus(int elevatorNumber) {
        try {
            return elevatorRemote.getElevatorDoorStatus(elevatorNumber);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getElevatorDoorStatus: " + ex.getMessage()));
        }
    }

    public int getElevatorFloor(int elevatorNumber) {
        try {
            return elevatorRemote.getElevatorFloor(elevatorNumber);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getElevatorFloor: " + ex.getMessage()));
        }
    }

    public int getElevatorNum() {
        try {
            return elevatorRemote.getElevatorNum();
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getElevatorNum: " + ex.getMessage()));
        }
    }

    public int getElevatorPosition(int elevatorNumber) {
        try {
            return elevatorRemote.getElevatorPosition(elevatorNumber);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getElevatorPosition: " + ex.getMessage()));
        }

    }

    public int getElevatorSpeed(int elevatorNumber) {
        try {
            return elevatorRemote.getElevatorSpeed(elevatorNumber);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getElevatorSpeed: " + ex.getMessage()));
        }

    }

    public int getElevatorWeight(int elevatorNumber) {
        try {
            return elevatorRemote.getElevatorWeight(elevatorNumber);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getElevatorWeigth: " + ex.getMessage()));
        }
    }

    public int getElevatorCapacity(int elevatorNumber) {
        try {
            return elevatorRemote.getElevatorCapacity(elevatorNumber);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getElevatorCapacity: " + ex.getMessage()));
        }
    }

    public boolean getFloorButtonDown(int floor) {
        try {
            return elevatorRemote.getFloorButtonDown(floor);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getFloorButtonDown: " + ex.getMessage()));
        }

    }

    public boolean getFloorButtonUp(int floor) {
        try {
            return elevatorRemote.getFloorButtonUp(floor);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getFloorButtonUp: " + ex.getMessage()));
        }

    }

    public int getFloorHeight() {
        try {
            return elevatorRemote.getFloorHeight();
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getFloorHeight: " + ex.getMessage()));
        }

    }

    public int getFloorNum() {
        try {
            return elevatorRemote.getFloorNum();
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getFloorNum: " + ex.getMessage()));
        }

    }

    public boolean getServicesFloors(int elevatorNumber, int floor) {
        try {
            return elevatorRemote.getServicesFloors(elevatorNumber, floor);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getServicesFloors: " + ex.getMessage()));
        }

    }

    public int getTarget(int elevatorNumber) {
        try {
            return elevatorRemote.getTarget(elevatorNumber);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getTarget: " + ex.getMessage()));
        }

    }

    public void setCommittedDirection(int elevatorNumber, int direction) {
        try {
            elevatorRemote.setCommittedDirection(elevatorNumber, direction);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in setComittedDirection: " + ex.getMessage()));
        }
    }

    public void setServicesFloors(int elevatorNumber, int floor, boolean service) {
        try {
            elevatorRemote.setServicesFloors(elevatorNumber, floor, service);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in setServicesFloors: " + ex.getMessage()));
        }
    }

    public void setTarget(int elevatorNumber, int target) {
        try {
            elevatorRemote.setTarget(elevatorNumber, target);
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in setTarget: " + ex.getMessage()));
        }
    }

    public long getClockTick() {
        try {
            return elevatorRemote.getClockTick();
        }
        catch (RemoteException ex) {
            throw(new RuntimeException("Error in getClockTick: " + ex.getMessage()));
        }
    }
}

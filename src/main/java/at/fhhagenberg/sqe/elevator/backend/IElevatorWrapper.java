package at.fhhagenberg.sqe.elevator.backend;

import sqelevator.IElevator;
import java.rmi.RemoteException;

import at.fhhagenberg.sqe.elevator.model.Elevator;

public class IElevatorWrapper{

    private IElevator elevatorRemote;
    
    public static int CONNECTION_ERROR = -1;

    // TODO: uncomment code after IElevator implementation exists

    public int getCommittedDirection(int elevatorNumber) {
// TODO:
//        try {
//            return elevatorRemote.getCommittedDirection(elevatorNumber);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }
        return 0;
    }

    public int getElevatorAccel(int elevatorNumber) {
// TODO:
//        try {
//           return elevatorRemote.getElevatorAccel(elevatorNumber);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }

    public int getElevatorButton(int elevatorNumber, int floor) {
// TODO:
//        try {
//            return elevatorRemote.getElevatorButton(elevatorNumber, floor)?1:0;
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }

    public int getElevatorDoorStatus(int elevatorNumber) {
// TODO:
//        try {
//            return elevatorRemote.getElevatorDoorStatus(elevatorNumber);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }

    public int getElevatorFloor(int elevatorNumber) {
// TODO:
//        try {
//            return elevatorRemote.getElevatorFloor(elevatorNumber);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }

    public int getElevatorNum() {
// TODO:
//        try {
//            return elevatorRemote.getElevatorNum();
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }

    public int getElevatorPosition(int elevatorNumber) {
// TODO:
//        try {
//            return elevatorRemote.getElevatorPosition(elevatorNumber);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }

    public int getElevatorSpeed(int elevatorNumber) {
// TODO:
//        try {
//            return elevatorRemote.getElevatorSpeed(elevatorNumber);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }

    public int getElevatorWeight(int elevatorNumber) {
// TODO:
//        try {
//            return elevatorRemote.getElevatorWeight(elevatorNumber);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }

    public int getElevatorCapacity(int elevatorNumber) {
// TODO:
//        try {
//            return elevatorRemote.getElevatorCapacity(elevatorNumber);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }

    public boolean getFloorButtonDown(int floor) {
// TODO:
//        try {
//            return elevatorRemote.getFloorButtonDown(floor);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return false;
    }

    public boolean getFloorButtonUp(int floor) {
// TODO:
//        try {
//            return elevatorRemote.getFloorButtonUp(floor);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return false;
    }

    public int getFloorHeight() {
// TODO:
//        try {
//            return elevatorRemote.getFloorHeight();
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }

    public int getFloorNum() {
// TODO:
//        try {
//            return elevatorRemote.getFloorNum();
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }

    public boolean getServicesFloors(int elevatorNumber, int floor) {
// TODO:
//        try {
//            return elevatorRemote.getServicesFloors(elevatorNumber, floor);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return false;
    }

    public int getTarget(int elevatorNumber) {
// TODO:
//        try {
//            return elevatorRemote.getTarget(elevatorNumber);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }

    public void setCommittedDirection(int elevatorNumber, int direction) {
// TODO:
//        try {
//            return elevatorRemote.setCommittedDirection(elevatorNumber, direction);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }
    }

    public void setServicesFloors(int elevatorNumber, int floor, boolean service) {
// TODO:
//        try {
//            return elevatorRemote.setServicesFloors(elevatorNumber, floor, service);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }
    }

    public void setTarget(int elevatorNumber, int target) {
// TODO:
//        try {
//            return elevatorRemote.setTarget(elevatorNumber, target);
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }
    }

    public long getClockTick() {
// TODO:
//        try {
//            return elevatorRemote.getClockTick();
//        }
//        catch (RemoteException ex) {
//            System.out.println(ex.getMessage());
//            return CONNECTION_ERROR;
//        }

        return 0;
    }
}

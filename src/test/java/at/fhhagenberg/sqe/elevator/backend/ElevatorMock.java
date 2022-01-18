package at.fhhagenberg.sqe.elevator.backend;

import java.rmi.RemoteException;

import sqelevator.IElevator;

public class ElevatorMock implements IElevator
{
	
	// TODO setElevatorAccel und alle, die noch keine setter haben, ALLE synchronized 
	
	private int nElevs;
	private int nFloors;
	private int height;
	private boolean error;
	private int[] committedDirection;
	private int[] acceleration;
	private int[] position;
	private int[] weight;
	private int[] speed;
	private int[] doorStatus;
	private boolean[][] button;
	private int[] floor;
	private int[] capacity;
	private int[] target;
	private boolean[] buttonUp;
	private boolean[] buttonDown;
	
	
	public ElevatorMock(int nElevs, int nFloors) 
	{	this.nElevs = nElevs;
		this.nFloors = nFloors;
		committedDirection = new int[nElevs];
		height = 3;
		error = false;
		acceleration = new int[nElevs];
		position = new int[nElevs];
		weight = new int[nElevs];
		speed = new int[nElevs];
		doorStatus = new int[nElevs];
		floor = new int[nElevs];
		capacity = new int[nElevs];
		target = new int[nElevs];
		button  = new boolean[nElevs][nFloors];
		buttonUp  = new boolean[nFloors];
		buttonDown  = new boolean[nFloors];

	}
	
	@Override
	public synchronized int getCommittedDirection(int elevatorNumber) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return committedDirection[elevatorNumber] ;
	}

	@Override
	public synchronized int getElevatorAccel(int elevatorNumber) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return acceleration[elevatorNumber];
	}
	
	public synchronized void setElevatorAccel(int elevatorNumber, int acceleration) throws RemoteException {
		this.acceleration[elevatorNumber] = acceleration;
	}
	
	@Override
	public synchronized boolean getElevatorButton(int elevatorNumber, int floor) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return button[elevatorNumber][floor];
	}

	public synchronized void setElevatorButton(int elevatorNumber, boolean[] button) throws RemoteException {
		this.button[elevatorNumber] = button;
	}

	@Override
	public synchronized int getElevatorDoorStatus(int elevatorNumber) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return this.doorStatus[elevatorNumber];
	}

	public synchronized void setElevatorDoorStatus(int elevatorNumber, int doorStatus) throws RemoteException {
		this.doorStatus[elevatorNumber] = doorStatus;
	}
	
	@Override
	public synchronized int getElevatorFloor(int elevatorNumber) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return floor[elevatorNumber];
	}

	public synchronized void setElevatorFloor(int elevatorNumber, int floor ) throws RemoteException {
		this.floor[elevatorNumber] = floor;
	}

	@Override
	public synchronized int getElevatorNum() throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return this.nElevs;
	}
	public synchronized void setElevatorNum(int nElevs) throws RemoteException {
		this.nElevs = nElevs;
	}

	@Override
	public synchronized int getElevatorPosition(int elevatorNumber) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return position[elevatorNumber];
	}

	public synchronized void setElevatorPosition(int elevatorNumber, int position) throws RemoteException {
		this.position[elevatorNumber] = position;
	}

	@Override
	public synchronized int getElevatorSpeed(int elevatorNumber) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return speed[elevatorNumber];
	}

	public synchronized void setElevatorSpeed(int elevatorNumber, int speed) throws RemoteException {
		this.speed[elevatorNumber] = speed;
	}

	@Override
	public synchronized int getElevatorWeight(int elevatorNumber) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return weight[elevatorNumber];
	}
	public synchronized void setElevatorWeight(int elevatorNumber, int weight) throws RemoteException {
		this.weight[elevatorNumber] = weight;
	}

	@Override
	public synchronized int getElevatorCapacity(int elevatorNumber) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return capacity[elevatorNumber];
	}

	public synchronized void setElevatorCapacity(int elevatorNumber, int capacity) throws RemoteException {
		this.capacity[elevatorNumber] = capacity;
	}

	@Override
	public synchronized boolean getFloorButtonDown(int floor) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return this.buttonDown[floor];
	}

	public synchronized void setFloorButtonDown(int floor, boolean down) throws RemoteException {
		this.buttonDown[floor] =down;
	}

	@Override
	public synchronized boolean getFloorButtonUp(int floor) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return this.buttonUp[floor];
	}

	public synchronized void setFloorButtonUp(int floor, boolean up) throws RemoteException {
		this.buttonUp[floor] = up;
	}

	@Override
	public synchronized int getFloorHeight() throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return this.height;
	}
	
	@Override
	public synchronized int getFloorNum() throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return this.nFloors;
	}

	public synchronized void setFloorNum(int nFloors) throws RemoteException {
		this.nFloors = nFloors;
	}

	@Override
	public synchronized boolean getServicesFloors(int elevatorNumber, int floor) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return true;
	}
	
	@Override
	public synchronized int getTarget(int elevatorNumber) throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return this.target[elevatorNumber];
	}

	@Override
	public synchronized void setTarget(int elevatorNumber, int target) throws RemoteException {
		this.target[elevatorNumber] = target;
	}

	@Override
	public synchronized void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException {
		committedDirection[elevatorNumber] = direction;		
	}

	@Override
	public synchronized void setServicesFloors(int elevatorNumber, int floor, boolean service) throws RemoteException {
	}

	@Override
	public synchronized long getClockTick() throws RemoteException {
		if(error) throw new RemoteException("Connection failed");
		return -99;
	}

	
	public synchronized void setErrorStatus(boolean error) 
	{
		
		this.error = error;
	}
	
}

package at.fhhagenberg.sqe.elevator.model;

import java.util.Collections;
import java.util.List;

import at.fhhagenberg.sqe.elevator.model.Elevator;
import at.fhhagenberg.sqe.elevator.model.Floor;
import at.fhhagenberg.sqe.elevator.backend.IElevatorWrapper;

public class ElevatorControlCenter {
	private IElevatorWrapper elevatorServer;
	private List<Elevator> elevators;
	private List<Floor> floors;
	private boolean autoMode;
	
	public static boolean AUTO = true;
	public static boolean MANUEL = false;

	/**
     * Constructor - creates new ElevatorControlCenter
     *
     * @param server - server interface of the elevator system
     */
	public ElevatorControlCenter(IElevatorWrapper server)
	{
		elevatorServer = server;
		autoMode = AUTO;
		elevators = Collections.<Elevator>emptyList();
		floors = Collections.<Floor>emptyList();
		InitElevatorAndFloors();
	}
	
	private void InitElevatorAndFloors()
	{
		int size = elevatorServer.getElevatorNum();
		
		for(int i = 0; i < size; i++)
		{
			elevators.add(new Elevator(i));
		}
		size = elevatorServer.getFloorNum();
		for(int i = 0; i < size; i++)
		{
			floors.add(new Floor(elevatorServer.getFloorHeight(), i));
		}
	}
	
	/**
     * getElevators - Provides a list of all elevators of the building
     *
     * @return List<Elevator> - list of all elevators
     */
	public List<Elevator> getElevators()
	{
		return elevators;
	}
	
	/**
     * getFloors - Provides a list of all floors of the building
     *
     * @return List<Floor> - list of all floors
     */
	public List<Floor> getFloors()
	{
		return floors;
	}
	
	/**
     * setNext - Sets next floor of specified Elevator if in MANUEL mode
     *
     * @param elevator - number of the elevator
     * @param next     - floor to be next
     */
	public void setNext(int elevator, int next)
	{
		if(autoMode == MANUEL)
			if(elevator < elevators.size())
				elevators.get(elevator).setCommittedDirection(next);
	}
	
	/**
     * getAuto - Provides status of the actual mode (auto/manuel)
     *
     * @return boolean - auto = ElevatorControlCenter.AUTO, manuel = ElevatorControlCenter.MANUEL
     */
	public boolean getAuto()
	{
		return autoMode;
	}
	
	/**
     * setAuto - Sets status of the actual mode (auto/manuel)
     *
     * @param auto - auto = ElevatorControlCenter.AUTO, manuel = ElevatorControlCenter.MANUEL
     */
	public void setAuto(boolean auto)
	{
		autoMode = auto;
	}
	
	/**
     * update - updates all values
     *
     */
	public void update()
	{
		if(elevators.size() == 0)
			InitElevatorAndFloors();
		for(var elevator : elevators)
		{
			int num = elevator.getElevatorNum();
			elevator.setCommittedDirection(elevatorServer.getCommittedDirection(num));
			elevator.setElevatorAccel(elevatorServer.getElevatorAccel(num));
			elevator.setElevatorDoorStatus(elevatorServer.getElevatorDoorStatus(num));
			elevator.setElevatorFloor(elevatorServer.getElevatorFloor(num));
			elevator.setElevatorPosition(elevatorServer.getElevatorPosition(num));
			elevator.setElevatorSpeed(elevatorServer.getElevatorPosition(num));
			for(int i = 0; i < floors.size(); i++)
				elevator.addElevatorButton(elevatorServer.getElevatorButton(num, i));
		}
		for(var floor : floors)
		{
			int num = floor.getNum();
			floor.setButtonDown(elevatorServer.getFloorButtonDown(num));
			floor.setButtonUp(elevatorServer.getFloorButtonUp(num));
		}

	}
}

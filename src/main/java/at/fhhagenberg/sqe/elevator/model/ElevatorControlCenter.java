package at.fhhagenberg.sqe.elevator.model;

import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;

import java.util.ArrayList;

public class ElevatorControlCenter {
	private ElevatorWrapper elevatorServer;
	private ArrayList<Elevator> elevators;
	private ArrayList<Floor> floors;
	private boolean operatingMode;
	
	public static boolean AUTO = true;
	public static boolean MANUAL = false;

	/**
     * Constructor - creates new ElevatorControlCenter
     *
     * @param server - server interface of the elevator system
     */
	public ElevatorControlCenter(ElevatorWrapper server)
	{
		elevatorServer = server;
		operatingMode = AUTO;
		int size = elevatorServer.getElevatorNum();
		elevators = new ArrayList<>();
		floors = new ArrayList<>();
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
	public ArrayList<Elevator> getElevators()
	{
		return elevators;
	}

	/**
     * getFloors - Provides a list of all floors of the building
     *
     * @return List<Floor> - list of all floors
     */
	public ArrayList<Floor> getFloors()
	{
		return floors;
	}

	/**
     * setNext - Sets next floor of specified Elevator if in MANUAL mode
     *
     * @param elevator - number of the elevator
     * @param next     - floor to be next
     */
	public void setNext(int elevator, int next)
	{
		if(operatingMode == MANUAL && elevator < elevators.size())
				elevators.get(elevator).setCommittedDirection(next);
	}

	/**
     * getAuto - Provides status of the actual mode (auto/MANUAL)
     *
     * @return boolean - auto = ElevatorControlCenter.AUTO, MANUAL = ElevatorControlCenter.MANUAL
     */
	public boolean getOpMode()
	{
		return operatingMode;
	}

	/**
     * setAuto - Sets status of the actual mode (auto/MANUAL)
     *
     * @param auto - auto = ElevatorControlCenter.AUTO, MANUAL = ElevatorControlCenter.MANUAL
     */
	public void setAuto(boolean auto)
	{
		operatingMode = auto;
	}

	/**
     * update - updates all values
     *
     */
	public void update()
	{
		if(elevators.size() == 0)
			return;
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

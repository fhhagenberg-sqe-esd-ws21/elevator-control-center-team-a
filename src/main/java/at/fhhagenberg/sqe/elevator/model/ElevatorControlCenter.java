package at.fhhagenberg.sqe.elevator.model;

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
		// TODO connect and prepare data
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
		// TODO update values
	}
}

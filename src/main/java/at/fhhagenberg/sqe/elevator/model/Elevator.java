package at.fhhagenberg.sqe.elevator.model;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
	private int commitedDirection;
	private int elevatorAccel;
	private ArrayList<Integer> elevatorButtons;
	private int elevatorDoorStatus;
	private int elevatorFloor;
	private int elevatorNum;
	private int elevatorPos;
	private int elevatorSpeed;
	private int elevatorWeight;
	private int elevatorTarget;

	public static final int OPEN = 1;
	public static final int CLOSED = 0;
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int UNCOMMITTED = 3;
	
	/**
     * Constructor - creates new Elevator
     *
     * @param num    - number of the elevator.
     */
	public Elevator(int num)
	{
		elevatorNum = num;
		elevatorButtons = new ArrayList<>();
	}
	
	/**
     * getCommittedDirection - Retrieves the committed direction of the elevator (up / down / uncommitted)
     *
     * @return int - UP = Elevator.UP, DOWN = Elevator.DOWN, UNCOMMITED = Elevator.UNCOMMITTED
     */
	public int getCommittedDirection()
	{
		return commitedDirection;
	}
	
	/**
     * getElevatorAccel - Provides the current acceleration of the elevator in feet per sec^2
     *
     * @return int - acceleration in feet per sec^2
     */
	public int getElevatorAccel()
	{
		return elevatorAccel;
	}
	
	/**
     * getElevatorButton - Provides the current pressed Buttons of the elevator as list
     *
     * @return List<Integer> - list of all pressed Buttons; empty List when no Button pressed
     */
	public List<Integer> getElevatorButton()
	{
		return elevatorButtons;
	}
	
	/**
     * getElevatorDoorStatus - Provides the current status of the doors of the specified elevator (open/closed)
     *
     * @return int - open = Elevator.OPEN, closed = Elevator.CLOSED
     */
	public int getElevatorDoorStatus()
	{
		return elevatorDoorStatus;
	}
	
	/**
     * getElevatorFloor - Provides the current location of the elevator to the nearest floor
     *
     * @return int - nearest floor of the elevator
     */
	public int getElevatorFloor()
	{
		return elevatorFloor;
	}
	
	/**
     * getElevatorNum - Retrieves the number of the elevator
     *
     * @return int - number of the elevator
     */
	public int getElevatorNum()
	{
		return elevatorNum;
	}
	
	/**
     * getElevatorPosition - Provides the current location of the elevator in feet from the bottom of the building
     *
     * @return int - location in feet from the bottom of the building
     */
	public int getElevatorPosition()
	{
		return elevatorPos;
	}
	
	/**
     * getElevatorSpeed - Provides the current speed of the elevator in feet per sec
     *
     * @return int - speed in feet per sec
     */
	public int getElevatorSpeed()
	{
		return elevatorSpeed;
	}
	
	/**
     * getElevatorWeight - Retrieves the weight of passengers on the elevator
     *
     * @return int - weight of passengers
     */
	public int getElevatorWeight()
	{
		return elevatorWeight;
	}
	
	/**
     * getElevatorTarget - Retrieves the next target of the elevator
     *
     * @return int - weight of passengers
     */
	public int getElevatorTarget()
	{
		return elevatorTarget;
	}
	
	/**
     * setElevatorTarget - Sets the next target of the elevator
     *
     * @param direction - UP = Elevator.UP, DOWN = Elevator.DOWN, UNCOMMITED = Elevator.UNCOMMITTED
     */
	public void setElevatorTarget(int target)
	{
		elevatorTarget = target;
	}
	
	/**
     * setCommittedDirection - Sets the committed direction of the elevator (up / down / uncommitted)
     *
     * @param direction - UP = Elevator.UP, DOWN = Elevator.DOWN, UNCOMMITED = Elevator.UNCOMMITTED
     */
	public void setCommittedDirection(int direction)
	{
		commitedDirection = direction;
	}
	
	/**
     * setElevatorAccel - Sets the current acceleration of the elevator in feet per sec^2
     *
     * @param accel - acceleration in feet per sec^2
     */
	public void setElevatorAccel(int accel)
	{
		elevatorAccel = accel;
	}
	
	/**
     * addElevatorButton - Adds a button to list of current pressed Buttons of the elevator
     *
     * @param button - pressed Button
     */
	public void addElevatorButton(int button)
	{
		if (!elevatorButtons.contains(button))
			elevatorButtons.add(button);
	}
	
	void clearElevatorButton()
	{
		elevatorButtons.clear();
	}
	
	/**
     * setElevatorDoorStatus - Sets the current status of the doors of the specified elevator (open/closed)
     *
     * @param status - open = Elevator.OPEN, closed = Elevator.CLOSED
     */
	public void setElevatorDoorStatus(int status)
	{
		elevatorDoorStatus = status;
	}
	
	/**
     * setElevatorFloor - Sets the current location of the elevator to the nearest floor
     *
     * @param floor - nearest floor of the elevator
     */
	public void setElevatorFloor(int floor)
	{
		elevatorFloor = floor;
	}
	
	/**
     * setElevatorPosition - Sets the current location of the elevator in feet from the bottom of the building
     *
     * @param pos - location in feet from the bottom of the building
     */
	public void setElevatorPosition(int pos)
	{
		elevatorPos = pos;
	}
	
	/**
     * setElevatorSpeed - Sets the current speed of the elevator in feet per sec
     *
     * @param speed - speed in feet per sec
     */
	public void setElevatorSpeed(int speed)
	{
		elevatorSpeed = speed;
	}
	
	/**
     * setElevatorWeight - Sets the weight of passengers on the elevator
     *
     * @param weight - weight of passengers
     */
	public void setElevatorWeight(int weight)
	{
		elevatorWeight = weight;
	}
}

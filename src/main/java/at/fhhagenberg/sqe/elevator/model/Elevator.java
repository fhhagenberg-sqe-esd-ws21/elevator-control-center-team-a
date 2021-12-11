package at.fhhagenberg.sqe.elevator.model;

import java.util.List;

public class Elevator {
	private int commitedDirection;
	private int elevatorAccel;
	private List<Integer> elevatorButtons;
	private int elevatorDoorStatus;
	private int elevatorFloor;
	private int elevatorNum;
	private int elevatorPos;
	private int elevatorSpeed;
	private int elevatorWeigth;

	public static int OPEN = 1;
	public static int CLOSED = 0;
	public static int UP = 1;
	public static int DOWN = 2;
	public static int UNCOMMITTED = 3;
	
	/**
     * Constructor - creates new Elevator
     *
     * @param num    - number of the elevator.
     * @param weight - weight of the floor.
     */
	public Elevator(int num, int weight)
	{
		elevatorNum = num;
		elevatorWeigth = weight;
	}
	
	/**
     * getCommittedDirection - Retrieves the committed direction of the elevator (up / down / uncommitted)
     *
     * @return int - UP = Elevator.UP, DOWN = Elevator.DOWN, UNCOMMITED = Elevator.UNCOMMITTED
     */
	int getCommittedDirection()
	{
		return commitedDirection;
	}
	
	/**
     * getElevatorAccel - Provides the current acceleration of the elevator in feet per sec^2
     *
     * @return int - acceleration in feet per sec^2
     */
	int getElevatorAccel()
	{
		return elevatorAccel;
	}
	
	/**
     * getElevatorButton - Provides the current pressed Buttons of the elevator as list
     *
     * @return List<Integer> - list of all pressed Buttons; empty List when no Button pressed
     */
	List<Integer> getElevatorButton()
	{
		return elevatorButtons;
	}
	
	/**
     * getElevatorDoorStatus - Provides the current status of the doors of the specified elevator (open/closed)
     *
     * @return int - open = Elevator.OPEN, closed = Elevator.CLOSED
     */
	int getElevatorDoorStatus()
	{
		return elevatorDoorStatus;
	}
	
	/**
     * getElevatorFloor - Provides the current location of the elevator to the nearest floor
     *
     * @return int - nearest floor of the elevator
     */
	int getElevatorFloor()
	{
		return elevatorFloor;
	}
	
	/**
     * getElevatorNum - Retrieves the number of the elevator
     *
     * @return int - number of the elevator
     */
	int getElevatorNum()
	{
		return elevatorNum;
	}
	
	/**
     * getElevatorPosition - Provides the current location of the elevator in feet from the bottom of the building
     *
     * @return int - location in feet from the bottom of the building
     */
	int getElevatorPosition(int elevatorNumber)
	{
		return elevatorPos;
	}
	
	/**
     * getElevatorSpeed - Provides the current speed of the elevator in feet per sec
     *
     * @return int - speed in feet per sec
     */
	int getElevatorSpeed()
	{
		return elevatorSpeed;
	}
	
	/**
     * getElevatorWeight - Retrieves the weight of passengers on the elevator
     *
     * @return int - weight of passengers
     */
	int getElevatorWeight(int elevatorNumber)
	{
		return elevatorWeigth;
	}
	
	/**
     * setCommittedDirection - Sets the committed direction of the elevator (up / down / uncommitted)
     *
     * @param direction - UP = Elevator.UP, DOWN = Elevator.DOWN, UNCOMMITED = Elevator.UNCOMMITTED
     */
	void setCommittedDirection(int direction)
	{
		commitedDirection = direction;
	}
	
	/**
     * setElevatorAccel - Sets the current acceleration of the elevator in feet per sec^2
     *
     * @param accel - acceleration in feet per sec^2
     */
	void setElevatorAccel(int accel)
	{
		elevatorAccel = accel;
	}
	
	/**
     * addElevatorButton - Adds a button to list of current pressed Buttons of the elevator
     *
     * @param button - pressed Button
     */
	void addElevatorButton(int button)
	{
		if (!elevatorButtons.contains(button))
			elevatorButtons.add(button);
	}
	
	/**
     * setElevatorDoorStatus - Sets the current status of the doors of the specified elevator (open/closed)
     *
     * @param status - open = Elevator.OPEN, closed = Elevator.CLOSED
     */
	void setElevatorDoorStatus(int status)
	{
		elevatorDoorStatus = status;
		if(status == OPEN)
			elevatorButtons.remove(elevatorButtons.indexOf(elevatorFloor));
	}
	
	/**
     * setElevatorFloor - Sets the current location of the elevator to the nearest floor
     *
     * @param floor - nearest floor of the elevator
     */
	void setElevatorFloor(int floor)
	{
		elevatorFloor = floor;
	}
	
	/**
     * setElevatorPosition - Sets the current location of the elevator in feet from the bottom of the building
     *
     * @param pos - location in feet from the bottom of the building
     */
	void setElevatorPosition(int pos)
	{
		elevatorPos = pos;
	}
	
	/**
     * setElevatorSpeed - Sets the current speed of the elevator in feet per sec
     *
     * @param speed - speed in feet per sec
     */
	void setElevatorSpeed(int speed)
	{
		elevatorSpeed = speed;
	}
}

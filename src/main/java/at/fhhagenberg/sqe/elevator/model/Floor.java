package at.fhhagenberg.sqe.elevator.model;

public class Floor {
	private boolean buttonUp;
	private boolean buttonDown;
	private int floorHeight;
	private int floorNum;
	
	public static boolean ON = true;
	public static boolean OFF = false;
	
	/**
     * Constructor - creates new Floor
     *
     * @param height - height of the floor.
     * @param num    - number of the floor.
     */
	public Floor(int height, int num)
	{
		floorHeight = height;
		floorNum = num;
	}
	
	/**
     * getButtonDown - Provides the status of the Down button on floor (on/off)
     *
     * @return boolean - On = Floor.ON, Off = Floor.OFF
     */
	public boolean getButtonDown()
	{
		return buttonDown;
	}
	
	/**
     * getButtonUp - Provides the status of the Up button on floor (on/off)
     *
     * @return boolean - On = Floor.ON, Off = Floor.OFF
     */
	public boolean getButtonUp()
	{
		return buttonUp;
	}
	
	/**
     * getHeight - Retrieves the height of the floor
     *
     * @return int - height of the floor
     */
	public int getHeight()
	{
		return floorHeight;
	}
	
	/**
     * getNum - Retrieves the number the floor
     *
     * @return int - number of the floor
     */
	public int getNum()
	{
		return floorNum;
	}
	
	/**
     * setButtonDown - Sets the status of the Down button on the floor (on/off)
     *
     * @param down - status of Down button (On = Floor.ON, Off = Floor.OFF)
     */
	public void setButtonDown(boolean down)
	{
		buttonDown = down;
	}
	
	/**
     * setButtonDown - Sets the status of the Up button on the floor (on/off)
     *
     * @param up - status of Up button (On = Floor.ON, Off = Floor.OFF)
     */
	public void setButtonUp(boolean up)
	{
		buttonUp = up;
	} 
}

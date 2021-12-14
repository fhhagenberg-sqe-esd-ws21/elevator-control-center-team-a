package at.fhhagenberg.sqe.elevator.model;


//import at.fhhagenberg.sqe.elevator.model.Elevator;
//import at.fhhagenberg.sqe.elevator.model.Floor;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import at.fhhagenberg.sqe.elevator.backend.IElevatorWrapper;



public class IElevatorWrapperTest 
{
	/* Standard testing variables */
	int eleTestNum 		= 5;
	int eleTestWeight	= 900;

	// Device under Test:
	
	@Test
	void wrapperCtorTest() 
	{	IElevatorWrapper elevatorServer = new IElevatorWrapper();
		assertNotEquals(null, elevatorServer);
	}
	

    @Test
	void getElevatorAccelTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//  int getElevatorAccel(int elevatorNumber) 
		//	assertEquals(, );
	}
	
    @Test
	void getElevatorButtonTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	boolean getElevatorButton(int elevatorNumber, int floor) 
		//	assertEquals(, );
	}

    @Test
	void getElevatorDoorStatusTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	int getElevatorDoorStatus(int elevatorNumber) 
		//	assertEquals(, );
	}

    @Test
	void getElevatorFloorTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	int getElevatorFloor(int elevatorNumber) 
		//	assertEquals(, );
	}

    @Test
	void getElevatorNumTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	int getElevatorNum() 
		//	assertEquals(, );
	}

    @Test
	void getElevatorPositionTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	int getElevatorPosition(int elevatorNumber) 
		//	assertEquals(, );
	}

    @Test
	void getElevatorSpeedTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	int getElevatorSpeed(int elevatorNumber) 
		//	assertEquals(, );
	}

    @Test
	void getElevatorWeightTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	int getElevatorWeight(int elevatorNumber) 
			//	assertEquals(, );
	}

    @Test
    void getElevatorCapacityTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	int getElevatorCapacity(int elevatorNumber) 
		//	assertEquals(, );
	}

    @Test
	void getFloorButtonDownTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	boolean getFloorButtonDown(int floor) 
		//	assertEquals(, );
	}

    @Test
	void getFloorButtonUpTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	boolean getFloorButtonUp(int floor) 
		//	assertEquals(, );
	}

    @Test
	void getFloorHeightTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	int getFloorHeight() 
		//	assertEquals(, );
	}

    @Test
	void getFloorNumTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	int getFloorNum() 
		//	assertEquals(, );
	}

    @Test
	void getServicesFloorsTest() 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	boolean getServicesFloors(int elevatorNumber, int floor) 
		//	assertEquals(, );
	}

//    @Test
	void getTargetTest(int elevatorNumber) 
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	int getTarget(int elevatorNumber) 
		//	assertEquals(, );
	}

    @Test
	void setCommittedDirectionTest()
	{ 	IElevatorWrapper srv = new IElevatorWrapper();
		//	void setCommittedDirection(int elevatorNumber, int direction) 
		//	assertEquals(, );
	}

    @Test
	void setServicesFloorsTest()
	{ 	IElevatorWrapper srv = new IElevatorWrapper();
		//	void setServicesFloors(int elevatorNumber, int floor, boolean service) 
		//	assertEquals(, );
	}

    @Test
	void setTargetTest()
	{ 	IElevatorWrapper srv = new IElevatorWrapper();
		//	void setTarget(int elevatorNumber, int target) 
		//	assertEquals(, );
	}

    @Test
	void getClockTickTest()
	{	IElevatorWrapper srv = new IElevatorWrapper();
		//	long getClockTick() 
		//	assertEquals(, );
	}

	
	
}

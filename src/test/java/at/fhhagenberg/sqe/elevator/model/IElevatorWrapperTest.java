package at.fhhagenberg.sqe.elevator.model;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;


public class IElevatorWrapperTest 
{
	/* Standard testing variables */
	int eleTestNum 		= 5;
	int eleTestWeight	= 900;

	// Device under Test:
	
	@Test
	void wrapperCtorTest() 
	{	ElevatorWrapper elevatorServer = new ElevatorWrapper();
		assertNotEquals(null, elevatorServer);
	}
	

    @Test
	void getElevatorAccelTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//  int getElevatorAccel(int elevatorNumber) 
		//	assertEquals(, );
	}
	
    @Test
	void getElevatorButtonTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	boolean getElevatorButton(int elevatorNumber, int floor) 
		//	assertEquals(, );
	}

    @Test
	void getElevatorDoorStatusTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	int getElevatorDoorStatus(int elevatorNumber) 
		//	assertEquals(, );
	}

    @Test
	void getElevatorFloorTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	int getElevatorFloor(int elevatorNumber) 
		//	assertEquals(, );
	}

    @Test
	void getElevatorNumTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	int getElevatorNum() 
		//	assertEquals(, );
	}

    @Test
	void getElevatorPositionTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	int getElevatorPosition(int elevatorNumber) 
		//	assertEquals(, );
	}

    @Test
	void getElevatorSpeedTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	int getElevatorSpeed(int elevatorNumber) 
		//	assertEquals(, );
	}

    @Test
	void getElevatorWeightTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	int getElevatorWeight(int elevatorNumber) 
			//	assertEquals(, );
	}

    @Test
    void getElevatorCapacityTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	int getElevatorCapacity(int elevatorNumber) 
		//	assertEquals(, );
	}

    @Test
	void getFloorButtonDownTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	boolean getFloorButtonDown(int floor) 
		//	assertEquals(, );
	}

    @Test
	void getFloorButtonUpTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	boolean getFloorButtonUp(int floor) 
		//	assertEquals(, );
	}

    @Test
	void getFloorHeightTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	int getFloorHeight() 
		//	assertEquals(, );
	}

    @Test
	void getFloorNumTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	int getFloorNum() 
		//	assertEquals(, );
	}

    @Test
	void getServicesFloorsTest() 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	boolean getServicesFloors(int elevatorNumber, int floor) 
		//	assertEquals(, );
	}

//    @Test
	void getTargetTest(int elevatorNumber) 
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	int getTarget(int elevatorNumber) 
		//	assertEquals(, );
	}

    @Test
	void setCommittedDirectionTest()
	{ 	ElevatorWrapper srv = new ElevatorWrapper();
		//	void setCommittedDirection(int elevatorNumber, int direction) 
		//	assertEquals(, );
	}

    @Test
	void setServicesFloorsTest()
	{ 	ElevatorWrapper srv = new ElevatorWrapper();
		//	void setServicesFloors(int elevatorNumber, int floor, boolean service) 
		//	assertEquals(, );
	}

    @Test
	void setTargetTest()
	{ 	ElevatorWrapper srv = new ElevatorWrapper();
		//	void setTarget(int elevatorNumber, int target) 
		//	assertEquals(, );
	}

    @Test
	void getClockTickTest()
	{	ElevatorWrapper srv = new ElevatorWrapper();
		//	long getClockTick() 
		//	assertEquals(, );
	}

	
	
}

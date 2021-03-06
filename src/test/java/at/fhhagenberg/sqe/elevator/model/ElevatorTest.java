package at.fhhagenberg.sqe.elevator.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


public class ElevatorTest 
{
	/* Standard testing variables */
	int eleTestNum 		= 5;
	int eleTestWeight	= 900;
	int eleTestSpeed 	= 5;
	int eleTestFloor	= 12;
	int eleTestAccel	= 23;
	int eleTestPos		= 3;
	int eleTestButton	= 11;
	
	@Test
	void elevatorCtortest() 
	{	Elevator e = new Elevator(eleTestNum);
		assertNotEquals(null, e);
	}

	@Test
	void committedDirectionTest()
	{	Elevator e = new Elevator(eleTestNum);
		e.setCommittedDirection(Elevator.UP);
		assertEquals(Elevator.UP, e.getCommittedDirection());

	}
	@Test

	void getElevatorWeightTest()
	{	Elevator e = new Elevator(eleTestNum);
		e.setElevatorWeight(eleTestWeight);
		assertEquals(eleTestWeight, e.getElevatorWeight());
	}

	@Test
	void elevatorSpeedTest() 
	{	Elevator e = new Elevator(eleTestNum);
		e.setElevatorSpeed(eleTestSpeed);
		assertEquals(eleTestSpeed, e.getElevatorSpeed());
	}

	@Test
	void getElevatorNumTest() 
	{	Elevator e = new Elevator(eleTestNum	);
		assertEquals(eleTestNum, e.getElevatorNum());
	}

	@Test
	void elevatorDoorStatusTest() 
	{	Elevator e = new Elevator(eleTestNum	);
		//		e.setElevatorDoorStatus(Elevator.OPEN);
		//		assertEquals(Elevator.OPEN, e.getElevatorDoorStatus());
		e.setElevatorDoorStatus(Elevator.CLOSED);
		assertEquals(Elevator.CLOSED, e.getElevatorDoorStatus());
	}


	@Test
	void elevatorFloorTest() 
	{	Elevator e = new Elevator(eleTestNum	);
		e.setElevatorFloor(eleTestFloor);
		assertEquals(eleTestFloor, e.getElevatorFloor());
	}

	@Test
	void elevatorAccelTest() 
	{	Elevator e = new Elevator(eleTestNum	);
		e.setElevatorAccel(eleTestAccel);
		assertEquals(eleTestAccel, e.getElevatorAccel());
	}

	@Test
	void elevatorPositionTest()
	{	Elevator e = new Elevator(eleTestNum);
		e.setElevatorPosition(eleTestPos);
		assertEquals(eleTestPos, e.getElevatorPosition());
	}

	@Test
	void elevatorButtonTest() 
	{	Elevator e = new Elevator(eleTestNum	);
			e.addElevatorButton(eleTestButton);
			ArrayList<Integer> btnList = (ArrayList<Integer>) e.getElevatorButton();
			assertEquals(eleTestButton, btnList.get(0)	);
	}
	
}

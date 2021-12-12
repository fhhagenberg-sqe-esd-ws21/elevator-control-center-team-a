package at.fhhagenberg.sqe.elevator.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.CsvSource;
// import org.junit.jupiter.params.provider.ValueSource;
// import static org.junit.jupiter.api.Assertions.*;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import at.fhhagenberg.sqe.elevator.backend.IElevatorWrapper;


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
	{	Elevator e = new Elevator(eleTestNum, eleTestWeight	);
		assertNotEquals(null, e);
	}
	
	
	@Test
	void committedDirectionTest()
	{	Elevator e = new Elevator(eleTestNum, eleTestWeight	);
		e.setCommittedDirection(Elevator.UP);
		assertEquals(Elevator.UP, e.getCommittedDirection());

	}
	@Test

	void getElevatorWeightTest()
	{	Elevator e = new Elevator(eleTestNum, eleTestWeight	);
		assertEquals(eleTestWeight, e.getElevatorWeight(eleTestNum));
	}

	@Test
	void elevatorSpeedTest() 
	{	Elevator e = new Elevator(eleTestNum, eleTestWeight	);
		e.setElevatorSpeed(eleTestSpeed);
		assertEquals(eleTestSpeed, e.getElevatorSpeed());
	}

	@Test
	void getElevatorNumTest() 
	{	Elevator e = new Elevator(eleTestNum, eleTestWeight	);
		assertEquals(eleTestNum, e.getElevatorNum());
	}

	@Test
	void elevatorDoorStatusTest() 
	{	Elevator e = new Elevator(eleTestNum, eleTestWeight	);
		//		e.setElevatorDoorStatus(Elevator.OPEN);
		//		assertEquals(Elevator.OPEN, e.getElevatorDoorStatus());
		e.setElevatorDoorStatus(Elevator.CLOSED);
		assertEquals(Elevator.CLOSED, e.getElevatorDoorStatus());
	}


	@Test
	void elevatorFloorTest() 
	{	Elevator e = new Elevator(eleTestNum, eleTestWeight	);
		e.setElevatorFloor(eleTestFloor);
		assertEquals(eleTestFloor, e.getElevatorFloor());
	}

	@Test
	void elevatorAccelTest() 
	{	Elevator e = new Elevator(eleTestNum, eleTestWeight	);
		e.setElevatorAccel(eleTestAccel);
		assertEquals(eleTestAccel, e.getElevatorAccel());
	}

	@Test
	void elevatorPositionTest()
	{	Elevator e = new Elevator(eleTestNum, eleTestWeight);
		e.setElevatorPosition(eleTestPos);
		assertEquals(eleTestPos, e.getElevatorPosition(eleTestNum));
	}

	@Test
	void elevatorButtonTest() 
	{	Elevator e = new Elevator(eleTestNum, eleTestWeight	);
	//		e.addElevatorButton(eleTestButton);
	//		List<Integer> btnList = e.getElevatorButton();
	//		assertEquals(eleTestButton, btnList.get(0)	);
	}
	
}

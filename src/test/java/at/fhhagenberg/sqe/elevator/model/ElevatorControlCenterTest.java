package at.fhhagenberg.sqe.elevator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;


public class ElevatorControlCenterTest 
{
	int eccTestelevator	= 5;
	int eccTestnext		= 7;
	
	@Test
	void eccCtorTest()
	{	ElevatorWrapper server = new ElevatorWrapper();
		ElevatorControlCenter ecc = new ElevatorControlCenter(server);
		assertNotEquals(null, ecc);
	}
	
	@Test
	void  getElevatorsTest()
	{	ElevatorWrapper server = new ElevatorWrapper();
		ElevatorControlCenter ecc = new ElevatorControlCenter(server);
		List<Elevator> eleList = ecc.getElevators();
	//		assertEquals(, );
	}
	
	@Test
	void  getFloorsTest()
	{	ElevatorWrapper server = new ElevatorWrapper();
		ElevatorControlCenter ecc = new ElevatorControlCenter(server);

		List<Floor> floorList = ecc.getFloors();
	//		assertEquals(, );
	}
	
	@Test
	void  setNextTest()
	{	ElevatorWrapper server = new ElevatorWrapper();
		ElevatorControlCenter ecc = new ElevatorControlCenter(server);
		ecc.setNext(eccTestelevator, eccTestnext);
	//		assertEquals(, );
	}
		
	@Test
	void  autoTest()
	{	ElevatorWrapper server = new ElevatorWrapper();
		ElevatorControlCenter ecc = new ElevatorControlCenter(server);
		ecc.setAuto(ElevatorControlCenter.AUTO);
		assertEquals(ElevatorControlCenter.AUTO, ecc.getAuto());
	}

	@Test
	void  updateTest()
	{	ElevatorWrapper server = new ElevatorWrapper();
		ElevatorControlCenter ecc = new ElevatorControlCenter(server);
		ecc.update();
	//		assertEquals(, );
	}
	
}

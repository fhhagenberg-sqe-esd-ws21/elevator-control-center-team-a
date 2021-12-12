package at.fhhagenberg.sqe.elevator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import at.fhhagenberg.sqe.elevator.backend.IElevatorWrapper;

// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.CsvSource;
// import org.junit.jupiter.params.provider.ValueSource;
// import static org.junit.jupiter.api.Assertions.*;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import java.util.List;
// import at.fhhagenberg.sqe.elevator.backend.IElevatorWrapper;


public class ElevatorControlCenterTest 
{
	int eccTestelevator	= 5;
	int eccTestnext		= 7;
	
	@Test
	void eccCtorTest()
	{	IElevatorWrapper server = new IElevatorWrapper();
		ElevatorControlCenter ecc = new ElevatorControlCenter(server);
		assertNotEquals(null, ecc);
	}
	
	@Test
	void  getElevatorsTest()
	{	IElevatorWrapper server = new IElevatorWrapper();
		ElevatorControlCenter ecc = new ElevatorControlCenter(server);
		List<Elevator> eleList = ecc.getElevators();
	//		assertEquals(, );
	}
	
	@Test
	void  getFloorsTest()
	{	IElevatorWrapper server = new IElevatorWrapper();
		ElevatorControlCenter ecc = new ElevatorControlCenter(server);

		List<Floor> floorList = ecc.getFloors();
	//		assertEquals(, );
	}
	
	@Test
	void  setNextTest()
	{	IElevatorWrapper server = new IElevatorWrapper();
		ElevatorControlCenter ecc = new ElevatorControlCenter(server);
		ecc.setNext(eccTestelevator, eccTestnext);
	//		assertEquals(, );
	}
		
	@Test
	void  autoTest()
	{	IElevatorWrapper server = new IElevatorWrapper();
		ElevatorControlCenter ecc = new ElevatorControlCenter(server);
		ecc.setAuto(ElevatorControlCenter.AUTO);
		assertEquals(ElevatorControlCenter.AUTO, ecc.getAuto());
	}

	@Test
	void  updateTest()
	{	IElevatorWrapper server = new IElevatorWrapper();
		ElevatorControlCenter ecc = new ElevatorControlCenter(server);
		ecc.update();
	//		assertEquals(, );
	}
	
}

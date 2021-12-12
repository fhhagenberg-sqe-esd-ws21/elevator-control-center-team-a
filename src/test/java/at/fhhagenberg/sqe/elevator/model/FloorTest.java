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
// import java.util.List;
// import at.fhhagenberg.sqe.elevator.backend.IElevatorWrapper;



public class FloorTest 
{

	/* Standard testing variables */
	int floorTestHeight	= 12;
	int floorTestNum	= 6;
	
	@Test
	void floorCtorTest()
	{	Floor f = new Floor(floorTestHeight, floorTestNum);
		assertNotEquals(null, f);
	}
	
	
	@Test
	void buttonDownTest() 
	{	Floor f = new Floor(floorTestHeight, floorTestNum);
		f.setButtonDown(Floor.ON);
		assertEquals(Floor.ON, f.getButtonDown());
	}
	
	@Test
	void buttonUpTest() 
	{	Floor f = new Floor(floorTestHeight, floorTestNum);
		f.setButtonUp(Floor.ON);
			assertEquals(Floor.ON, f.getButtonUp());
	}
	
	@Test
	void getHeightTest() 
	{	Floor f = new Floor(floorTestHeight, floorTestNum);
		assertEquals(floorTestHeight, f.getHeight());
	}
	
	@Test
	void getNumTest() 
	{	Floor f = new Floor(floorTestHeight, floorTestNum);
		assertEquals(floorTestNum, f.getNum());
	}
}

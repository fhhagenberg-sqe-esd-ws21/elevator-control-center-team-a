package at.fhhagenberg.sqe.elevator.backend;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sqelevator.IElevator;

@ExtendWith(MockitoExtension.class)
public class ElevatorWrapperTest
{
	private ElevatorWrapper wrappedElevator;

	@Mock
	private IElevator mockedIElevator = mock(IElevator.class);
	
	@Test
	void testElevatorWrapperCtor()
	{	ElevatorWrapper elevatorServer = new ElevatorWrapper(mockedIElevator);
		assertNotEquals(null, elevatorServer);
	}

	@Test
	public void testGetCommitedDirectionException() throws RemoteException {
		when(mockedIElevator.getCommittedDirection(0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getCommittedDirection(0));
	}

	@Test
	public void testGetElevatorNumException() throws RemoteException {
		when(mockedIElevator.getElevatorNum()).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getElevatorNum());
	}

	@Test
	public void testGetElevatorAccelException() throws RemoteException {
		when(mockedIElevator.getElevatorAccel(0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getElevatorAccel(0));
	}

	@Test
	public void testGetElevatorButtonException() throws RemoteException {
		when(mockedIElevator.getElevatorButton(0,0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getElevatorButton(0,0));
	}

	@Test
	public void testGetElevatorDoorStatusException() throws RemoteException {
		when(mockedIElevator.getElevatorDoorStatus(0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getElevatorDoorStatus(0));
	}

	@Test
	public void testGetElevatorFloorException() throws RemoteException {
		when(mockedIElevator.getElevatorFloor(0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getElevatorFloor(0));
	}

	@Test
	public void testGetElevatorPositionException() throws RemoteException {
		when(mockedIElevator.getElevatorPosition(0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getElevatorPosition(0));
	}

	@Test
	public void testGetElevatorSpeedException() throws RemoteException {
		when(mockedIElevator.getElevatorSpeed(0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getElevatorSpeed(0));
	}

	@Test
	public void testGetElevatorWeightException() throws RemoteException {
		when(mockedIElevator.getElevatorWeight(0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getElevatorWeight(0));
	}

	@Test
	public void testGetElevatorCapacityException() throws RemoteException {
		when(mockedIElevator.getElevatorCapacity(0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getElevatorCapacity(0));
	}

	@Test
	public void testGetFloorButtonDownException() throws RemoteException {
		when(mockedIElevator.getFloorButtonDown(0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getFloorButtonDown(0));
	}

	@Test
	public void testGetFloorButtonUpException() throws RemoteException {
		when(mockedIElevator.getFloorButtonUp(0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getFloorButtonUp(0));
	}

	@Test
	public void testGetFloorHeightException() throws RemoteException {
		when(mockedIElevator.getFloorHeight()).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getFloorHeight());
	}

	@Test
	public void testGetFloorNumException() throws RemoteException {
		when(mockedIElevator.getFloorNum()).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getFloorNum());
	}

	@Test
	public void testGetServicesFloorException() throws RemoteException {
		when(mockedIElevator.getServicesFloors(0,0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getServicesFloors(0,0));
	}

	@Test
	public void testGetTargetException() throws RemoteException {
		when(mockedIElevator.getTarget(0)).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getTarget(0));
	}

	@Test
	public void testSetCommitedDirectionException() throws RemoteException {
		doThrow(new RemoteException("Remote Error")).when(mockedIElevator).setCommittedDirection(0,0);
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.setCommittedDirection(0,0));
	}

	@Test
	public void testSetServicesFloorException() throws RemoteException {
		doThrow(new RemoteException("Remote Error")).when(mockedIElevator).setServicesFloors(0,0, false);
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.setServicesFloors(0,0, false));
	}

	@Test
	public void testSetTargetException() throws RemoteException {
		doThrow(new RemoteException("Remote Error")).when(mockedIElevator).setTarget(0,0);
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.setTarget(0,0));
	}

	@Test
	public void testGetClockTickException() throws RemoteException {
		when(mockedIElevator.getClockTick()).thenThrow(new RemoteException("Remote Error"));
		wrappedElevator = new ElevatorWrapper(mockedIElevator);
		assertThrows(RuntimeException.class, () -> wrappedElevator.getClockTick());
	}

}

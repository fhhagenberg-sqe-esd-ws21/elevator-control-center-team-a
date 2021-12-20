package at.fhhagenberg.sqe.elevator.model;

import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sqelevator.IElevator;

import java.rmi.RemoteException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ElevatorControlCenterMockTest {

    private static ElevatorWrapper wrappedElevator;

    @Mock
    private static IElevator mockedIElevator = mock(IElevator.class);

    @Test
    public void testGetElevatorNumEmpty() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(0);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        verify(mockedIElevator).getElevatorNum();
        assertEquals(0, ecc.getElevators().size());
    }

    @Test
    public void testGetElevatorNumOneEntry() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        verify(mockedIElevator).getElevatorNum();
        assertEquals(1, ecc.getElevators().size());
    }

    @Test
    public void testGetElevatorNumTenEntries() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(10);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        verify(mockedIElevator).getElevatorNum();
        assertEquals(10, ecc.getElevators().size());
    }

    @Test
    public void testGetFloorNumEmpty() throws RemoteException {

        when(mockedIElevator.getFloorNum()).thenReturn(0);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        verify(mockedIElevator).getFloorNum();
        assertEquals(0, ecc.getFloors().size());
    }

    @Test
    public void testGetFloorNumOneEntry() throws RemoteException {

        when(mockedIElevator.getFloorNum()).thenReturn(1);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        verify(mockedIElevator).getFloorNum();
        assertEquals(1, ecc.getFloors().size());
    }

    @Test
    public void testGetFloorNumTenEntries() throws RemoteException {

        when(mockedIElevator.getFloorNum()).thenReturn(10);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        verify(mockedIElevator).getFloorNum();
        assertEquals(10, ecc.getFloors().size());
    }

    @Test
    public void testUpdateDirectionElevatorDn() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        when(mockedIElevator.getCommittedDirection(0)).thenReturn(IElevator.ELEVATOR_DIRECTION_DOWN);

        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        ArrayList<Elevator> eleList = ecc.getElevators();
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        verify(mockedIElevator).getCommittedDirection(0);

        assertEquals(IElevator.ELEVATOR_DIRECTION_DOWN, eleList.get(0).getCommittedDirection());
    }

    @Test
    public void testUpdateDirectionElevatorUp() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        when(mockedIElevator.getCommittedDirection(0)).thenReturn(IElevator.ELEVATOR_DIRECTION_UP);

        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        ArrayList<Elevator> eleList = ecc.getElevators();
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        verify(mockedIElevator).getCommittedDirection(0);

        assertEquals(IElevator.ELEVATOR_DIRECTION_UP, eleList.get(0).getCommittedDirection());
    }

    @Test
    public void testUpdateSetAccelElevator() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        when(mockedIElevator.getElevatorAccel(0)).thenReturn(1);

        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        ArrayList<Elevator> eleList = ecc.getElevators();
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        verify(mockedIElevator).getElevatorAccel(0);

        assertEquals(1, eleList.get(0).getElevatorAccel());
    }

    @Test
    public void testUpdateSetAccelElevatorNegative() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        when(mockedIElevator.getElevatorAccel(0)).thenReturn(-1);

        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        ArrayList<Elevator> eleList = ecc.getElevators();
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        verify(mockedIElevator).getElevatorAccel(0);

        assertEquals(-1, eleList.get(0).getElevatorAccel());
    }

    @Test
    @Disabled
    public void testUpdateAddElevatorButton() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getFloorNum()).thenReturn(1);
        when(mockedIElevator.getElevatorButton(0,0)).thenReturn(true);

        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        ArrayList<Elevator> eleList = ecc.getElevators();
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        verify(mockedIElevator).getElevatorButton(0, 0);

        assertEquals(1, eleList.get(0).getElevatorButton().size());
    }

    @Test
    @Disabled
    public void testUpdateFloors() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getFloorNum()).thenReturn(2);

        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        ArrayList<Floor> floorList = ecc.getFloors();
        ecc.update();

        verify(mockedIElevator).getFloorNum();
        assertEquals(2, floorList.size());
    }

    @Test
    public void testOperatingMode(){

        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);

        ecc.setAuto(ElevatorControlCenter.AUTO);
        assertEquals(ElevatorControlCenter.AUTO, ecc.getOpMode());

    }

}

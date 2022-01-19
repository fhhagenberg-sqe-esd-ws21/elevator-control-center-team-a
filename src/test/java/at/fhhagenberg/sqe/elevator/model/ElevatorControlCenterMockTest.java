package at.fhhagenberg.sqe.elevator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;
import sqelevator.IElevator;

@ExtendWith(MockitoExtension.class)
public class ElevatorControlCenterMockTest {

    private static ElevatorWrapper wrappedElevator;

    @Mock
    private static IElevator mockedIElevator = mock(IElevator.class);

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    public void testGetElevatorNum(int num) throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(num);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        assertEquals(num, ecc.getElevators().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    public void testGetFloorNumEmpty(int num) throws RemoteException {

        when(mockedIElevator.getFloorNum()).thenReturn(num);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);
        ecc.InitElevatorAndFloors();

        verify(mockedIElevator).getFloorNum();
        assertEquals(num, ecc.getFloors().size());
    }

    @Test
    public void testUpdateDirectionElevatorDn() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        when(mockedIElevator.getCommittedDirection(0)).thenReturn(IElevator.ELEVATOR_DIRECTION_DOWN);

        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);
        ecc.InitElevatorAndFloors();

        List<Elevator> eleList = ecc.getElevators();
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
        ecc.InitElevatorAndFloors();

        List<Elevator> eleList = ecc.getElevators();
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
        ecc.InitElevatorAndFloors();

        List<Elevator> eleList = ecc.getElevators();
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
        ecc.InitElevatorAndFloors();

        List<Elevator> eleList = ecc.getElevators();
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        verify(mockedIElevator).getElevatorAccel(0);

        assertEquals(-1, eleList.get(0).getElevatorAccel());
    }

    @Test
    public void testUpdateAddElevatorButton() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getFloorNum()).thenReturn(1);
        when(mockedIElevator.getElevatorButton(0,0)).thenReturn(true);

        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);
        ecc.InitElevatorAndFloors();

        List<Elevator> eleList = ecc.getElevators();
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        verify(mockedIElevator).getElevatorButton(0, 0);

        assertEquals(1, eleList.get(0).getElevatorButton().size());
    }

    @Test
    public void testUpdateFloors() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getFloorNum()).thenReturn(2);

        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);
        ecc.InitElevatorAndFloors();

        List<Floor> floorList = ecc.getFloors();
        ecc.update();

        verify(mockedIElevator).getFloorNum();
        assertEquals(2, floorList.size());
    }
    
    @Test
    public void testSetNext() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getFloorNum()).thenReturn(2);

        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);
        ecc.InitElevatorAndFloors();
        ecc.setAuto(ElevatorControlCenter.MANUAL);
        ecc.setNext(0, 2);
        List<Elevator> elevators = ecc.getElevators();
        verify(mockedIElevator).setTarget(0, 2);
        when(mockedIElevator.getTarget(0)).thenReturn(2);
        ecc.update();

        assertEquals(2, elevators.get(0).getElevatorTarget());
    }
    
    @Test
    public void testSetNextAuto() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getFloorNum()).thenReturn(2);

        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);
        ecc.InitElevatorAndFloors();
        ecc.setAuto(ElevatorControlCenter.AUTO);
        ecc.setNext(0, 2);
        verify(mockedIElevator, never()).setTarget(0, 2);
    }
    
    @Test
    public void testSetNextOutMaxElevator() throws RemoteException {

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getFloorNum()).thenReturn(2);

        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);
        ecc.InitElevatorAndFloors();
        ecc.setAuto(ElevatorControlCenter.MANUAL);
        ecc.setNext(1, 2);
        verify(mockedIElevator, never()).setTarget(0, 2);
    }

    @Test
    public void testOperatingMode(){

        wrappedElevator = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter ecc = new ElevatorControlCenter(wrappedElevator);
        ecc.InitElevatorAndFloors();

        ecc.setAuto(ElevatorControlCenter.AUTO);
        assertEquals(ElevatorControlCenter.AUTO, ecc.getOpMode());

    }

}

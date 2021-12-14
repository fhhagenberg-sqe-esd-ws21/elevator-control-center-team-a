package at.fhhagenberg.sqe.elevator.model;

import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IElevatorMockTest {

    /** State variable for elevator doors open.	 */
    public final static int ELEVATOR_DOORS_OPEN = 1;
    /** State variable for elevator doors closed. */
    public final static int ELEVATOR_DOORS_CLOSED = 2;
    /** State variable for elevator doors opening. */
    public final static int ELEVATOR_DOORS_OPENING = 3;
    /** State variable for elevator doors closing. */
    public final static int ELEVATOR_DOORS_CLOSING = 4;

    /** State variable for elevator status when going up */
    public final static int ELEVATOR_DIRECTION_UP = 0;
    /** State variable for elevator status when going down. */
    public final static int ELEVATOR_DIRECTION_DOWN = 1;
    /** State variables for elevator status stopped and uncommitted. */
    public final static int ELEVATOR_DIRECTION_UNCOMMITTED = 2;

    @Mock
    private ElevatorWrapper mockedIElevator = mock(ElevatorWrapper.class);

    @Test
    public void testGetElevatorNumEmpty(){

        when(mockedIElevator.getElevatorNum()).thenReturn(0);
        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        verify(mockedIElevator).getElevatorNum();
        assertEquals(0, ecc.getElevators().size());
    }

    @Test
    public void testGetElevatorNumOneEntry(){

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        verify(mockedIElevator).getElevatorNum();
        assertEquals(1, ecc.getElevators().size());
    }

    @Test
    public void testGetElevatorNumTenEntries(){

        when(mockedIElevator.getElevatorNum()).thenReturn(10);
        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        verify(mockedIElevator).getElevatorNum();
        assertEquals(10, ecc.getElevators().size());
    }

    @Test
    public void testGetFloorNumEmpty(){

        when(mockedIElevator.getFloorNum()).thenReturn(0);
        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        verify(mockedIElevator).getFloorNum();
        assertEquals(0, ecc.getFloors().size());
    }

    @Test
    public void testGetFloorNumOneEntry(){

        when(mockedIElevator.getFloorNum()).thenReturn(1);
        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        verify(mockedIElevator).getFloorNum();
        assertEquals(1, ecc.getFloors().size());
    }

    @Test
    public void testGetFloorNumTenEntries(){

        when(mockedIElevator.getFloorNum()).thenReturn(10);
        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        verify(mockedIElevator).getFloorNum();
        assertEquals(10, ecc.getFloors().size());
    }

    @Test
    public void testUpdateDirectionElevatorDn(){

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getCommittedDirection(0)).thenReturn(ELEVATOR_DIRECTION_DOWN);

        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        ArrayList<Elevator> eleList = ecc.getElevators();
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        verify(mockedIElevator).getCommittedDirection(0);

        assertEquals(ELEVATOR_DIRECTION_DOWN, eleList.get(0).getCommittedDirection());
    }

    @Test
    public void testUpdateDirectionElevatorUp(){

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getCommittedDirection(0)).thenReturn(ELEVATOR_DIRECTION_UP);

        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        ArrayList<Elevator> eleList = ecc.getElevators();
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        verify(mockedIElevator).getCommittedDirection(0);

        assertEquals(ELEVATOR_DIRECTION_UP, eleList.get(0).getCommittedDirection());
    }

    @Test
    public void testUpdateSetAccelElevator(){

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getElevatorAccel(0)).thenReturn(1);

        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        ArrayList<Elevator> eleList = ecc.getElevators();
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        verify(mockedIElevator).getElevatorAccel(0);

        assertEquals(1, eleList.get(0).getElevatorAccel());
    }

    @Test
    public void testUpdateSetAccelElevatorNegative(){

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getElevatorAccel(0)).thenReturn(-1);

        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        ArrayList<Elevator> eleList = ecc.getElevators();
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        verify(mockedIElevator).getElevatorAccel(0);

        assertEquals(-1, eleList.get(0).getElevatorAccel());
    }

    @Disabled
    public void testUpdateAddElevatorButton(){

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getFloorNum()).thenReturn(1);
        when(mockedIElevator.getElevatorButton(0,0)).thenReturn(1);

        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        ArrayList<Elevator> eleList = ecc.getElevators();
        ecc.update();

        verify(mockedIElevator).getElevatorNum();
        verify(mockedIElevator).getElevatorButton(0, 0);

        assertEquals(1, eleList.get(0).getElevatorButton().size());
    }

    @Disabled
    public void testUpdateFloors(){

        when(mockedIElevator.getElevatorNum()).thenReturn(1);
        when(mockedIElevator.getFloorNum()).thenReturn(2);

        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        ArrayList<Floor> floorList = ecc.getFloors();
        ecc.update();

        verify(mockedIElevator).getFloorNum();
        assertEquals(2, floorList.size());
    }

    @Test
    public void testOperatingMode(){

        ElevatorControlCenter ecc = new ElevatorControlCenter(mockedIElevator);

        ecc.setAuto(ElevatorControlCenter.AUTO);
        assertEquals(ElevatorControlCenter.AUTO, ecc.getOpMode());

    }

}

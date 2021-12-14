package at.fhhagenberg.sqe.elevator.model;

import at.fhhagenberg.sqe.elevator.backend.IElevatorWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sqelevator.IElevator;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IElevatorMockTest {

    @Mock
    private IElevatorWrapper mockedIElevator = mock(IElevatorWrapper.class);

    @Test
    public void testGetElevatorNum_noThrow() throws RemoteException {
        when(mockedIElevator.getElevatorNum()).thenReturn(0);
        assertEquals(0, mockedIElevator.getElevatorNum());
    }

}

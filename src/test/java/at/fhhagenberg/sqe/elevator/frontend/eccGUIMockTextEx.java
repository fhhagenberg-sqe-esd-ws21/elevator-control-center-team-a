package at.fhhagenberg.sqe.elevator.frontend;
import at.fhhagenberg.sqe.App;
import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;
import at.fhhagenberg.sqe.elevator.backend.MockInitialiser;
import at.fhhagenberg.sqe.elevator.model.Elevator;
import at.fhhagenberg.sqe.elevator.model.ElevatorControlCenter;
import at.fhhagenberg.sqe.elevator.model.Floor;
import javafx.application.Application;
import javafx.stage.Stage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.TextInputControlMatchers;
import org.testfx.matcher.control.TextMatchers;

import sqelevator.IElevator;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.testfx.api.FxRobot;

@ExtendWith(ApplicationExtension.class)
@ExtendWith(MockitoExtension.class)
public class eccGUIMockTextEx {

    private static ElevatorWrapper wrappedElevator;
    private static ElevatorControlCenter ecc;

    @Mock
    private static IElevator mockedIElevator = mock(IElevator.class);

    //@Mock
    // private static ElevatorControlCenter mockedEcc = mock(ElevatorControlCenter.class);
    private static MockInitialiser mockInit;
    
    @Start
    public void start(Stage stage) throws RemoteException{

        mockInit = new MockInitialiser(mockedIElevator);
        mockInit.defaultMockSetup();

        // doThrow(new RuntimeException("Connection lost")).when(mockedEcc).update();        
        // https://www.baeldung.com/mockito-exceptions

        wrappedElevator = new ElevatorWrapper(mockedIElevator);
    	ecc = new ElevatorControlCenter(wrappedElevator);

        var app = new App() {
        	@Override
        	protected ElevatorWrapper createWrapper() {
        		return wrappedElevator;
        	}
        };

        //App.launch();
        app.start(stage);
        
    }
    
    @Test
    public void testGuiThrowUp(FxRobot robot) throws RemoteException, RuntimeException 
    {
    	mockInit.exceptionMockSetup();

        mockInit.initMockElevator(0, Elevator.UNCOMMITTED, 5, 10, Elevator.OPEN, 3, 3, 5, 16, 8, mockInit.setButton(1, 3));
    	
		assertThrows(RemoteException.class, ()->{ robot.clickOn("#bMode"); 	 });
  	
        mockInit.defaultMockSetup();
    }

}



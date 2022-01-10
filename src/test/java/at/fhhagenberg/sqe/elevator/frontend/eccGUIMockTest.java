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

import static org.mockito.Mockito.*;

import org.testfx.api.FxRobot;

@ExtendWith(ApplicationExtension.class)
@ExtendWith(MockitoExtension.class)
public class eccGUIMockTest {

    private static ElevatorWrapper wrappedElevator;
    private static ElevatorControlCenter ecc;

    @Mock
    private static IElevator mockedIElevator = mock(IElevator.class);

    //@Mock
    // private static ElevatorControlCenter mockedEcc = mock(ElevatorControlCenter.class);
    @Mock
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
        	protected eccGUI createGUI() {

                elContr = ecc;
                elContr.update();
        		return new eccGUI(ecc, 1280, 960);
        	}
        };

        //App.launch();
        app.start(stage);
        
    }
    
    @Test
    public void testDefaultGui(FxRobot robot) throws RemoteException
    {
        mockInit.initMockElevator(0, Elevator.UNCOMMITTED, 5, 10, Elevator.OPEN, 3, 3, 5, 16, 8, mockInit.setButton(1, 3));
    	
    	robot.clickOn("#bMode");
    	robot.clickOn("#bMode");
    	
    	FxAssert.verifyThat("#tMode", TextMatchers.hasText("Operational Mode: Manual"));
    	// https://www.programcreek.com/java-api-examples/?class=org.testfx.api.FxAssert&method=verifyThat
    }

    @Test
    public void testGuiDropDown(FxRobot robot) throws RemoteException
    {
        mockInit.initMockElevator(0, Elevator.UNCOMMITTED, 5, 10, Elevator.OPEN, 3, 3, 5, 16, 8, mockInit.setButton(1, 3));

    	robot.clickOn("#bMode");
    	robot.clickOn("#bMode");

    	robot.clickOn("#cbNextPoses0");
    	robot.clickOn("#cbNextPoses1");

    	FxAssert.verifyThat("#cbNextPoses0",  NodeMatchers.isVisible());
    	FxAssert.verifyThat("#cbNextPoses1",  NodeMatchers.isVisible());
    	
    }


//    @Test
    public void testGuiUpdate(FxRobot robot) throws RemoteException 
    {	mockInit.initMockElevator(0, Elevator.UNCOMMITTED, 5, 10, Elevator.OPEN, 3, 3, 5, 16, 7, mockInit.setButton(1, 3));;
    	// robot.clickOn("#bMode");

    }
    
//    @Test
    public void testGuiFloorUP(FxRobot robot) throws RemoteException, InterruptedException 
    {	mockInit.initMockFloor(0, true, true, 0);
    	robot.clickOn("#cbNextPoses0");
    	robot.clickOn("#cbNextPoses1");
    	
    	Thread.sleep(14);
    	//FxAssert.verifyThat("#tNextPos", TextInputControlMatchers.hasText("next pos."));
    }
    
    //@Test
    public void testGuiThrowUp(FxRobot robot) throws RemoteException 
    {
        when(mockedIElevator.getElevatorAccel(0)).thenThrow(new RemoteException("Remote Error"));
        mockInit.initMockElevator(0, Elevator.UNCOMMITTED, 5, 10, Elevator.OPEN, 3, 3, 5, 16, 8, mockInit.setButton(1, 3));
    	mockInit.initMockFloor(0, true, true, 0);
    	
    	FxAssert.verifyThat("#tConnState", TextMatchers.hasText("•"));
        mockInit.defaultMockSetup();
    }

//    @Test
    public void testGuiManualAuto(FxRobot robot) throws RemoteException 
    {	mockInit.initMockElevator(0, Elevator.UNCOMMITTED, 5, 10, Elevator.OPEN, 3, 3, 5, 16, 8, mockInit.setButton(1, 3));
    	FxAssert.verifyThat("#tMode",  NodeMatchers.isVisible());
    			
    	FxAssert.verifyThat("#tMode", TextMatchers.hasText("Operational Mode: Automatic"));
    	robot.clickOn("#bMode");
    	robot.clickOn("#bMode");

    	FxAssert.verifyThat("#tMode", TextMatchers.hasText("Operational Mode: Manual"));

    }
    
}

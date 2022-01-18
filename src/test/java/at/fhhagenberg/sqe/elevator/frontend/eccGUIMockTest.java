package at.fhhagenberg.sqe.elevator.frontend;

import at.fhhagenberg.sqe.App;
import at.fhhagenberg.sqe.elevator.backend.ElevatorMock;
import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;
import at.fhhagenberg.sqe.elevator.backend.MockInitialiser;
import at.fhhagenberg.sqe.elevator.model.Elevator;
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
import org.testfx.matcher.control.TextMatchers;

import sqelevator.IElevator;

import java.rmi.RemoteException;

import static org.mockito.Mockito.*;

import org.testfx.api.FxRobot;

@ExtendWith(ApplicationExtension.class)
@ExtendWith(MockitoExtension.class)
public class eccGUIMockTest {

	private static ElevatorWrapper wrappedElevator;
	// private static ElevatorControlCenter ecc;

//	@Mock
//	private static IElevator mockedIElevator = mock(IElevator.class);
	private static ElevatorMock mockedIElevator;

	private static MockInitialiser mockInit;

	@Start
	public void start(Stage stage) throws RemoteException {


		// ecc = new ElevatorControlCenter(wrappedElevator);
		mockedIElevator = new ElevatorMock(5, 5);
		
		mockInit = new MockInitialiser(mockedIElevator);
		try {
			mockInit.defaultMockSetup();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wrappedElevator = new ElevatorWrapper(mockedIElevator);

		var app = new App() {
			@Override
			protected ElevatorWrapper createWrapper() {

				return wrappedElevator;
			}
		};

		// App.launch();
		app.start(stage);

	}

	@BeforeEach
	public void beforeEach() {

		try {
			mockInit.defaultMockSetup();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}


	@Test
	public void testDefaultGui(FxRobot robot) throws RemoteException, InterruptedException {
		mockInit.initMockElevator(0, Elevator.UNCOMMITTED, 5, 10, Elevator.OPEN, 3, 3, 5, 16, 8,
				new boolean[] {false, true, true, true, false});

		Thread.sleep(3000);
		robot.clickOn("#bMode");
		robot.clickOn("#bMode");

		FxAssert.verifyThat("#tMode", TextMatchers.hasText("Operational Mode: Manual"));
		// https://www.programcreek.com/java-api-examples/?class=org.testfx.api.FxAssert&method=verifyThat
	}

//	@Test
	public void testGuiDropDown(FxRobot robot) throws RemoteException, InterruptedException {
		mockInit.initMockElevator(0, Elevator.UNCOMMITTED, 5, 10, Elevator.CLOSED, 3, 3, 5, 16, 8,
				new boolean[] {false, true, true, true, false});

		Thread.sleep(3000);
		robot.clickOn("#bMode");
		robot.clickOn("#bMode");

		robot.clickOn("#cbNextPoses1");
		robot.clickOn("#cbNextPoses3");

		FxAssert.verifyThat("#cbNextPoses0", NodeMatchers.isVisible());
		FxAssert.verifyThat("#cbNextPoses1", NodeMatchers.isVisible());

	}

//	@Test
	public void testGuiUpdate(FxRobot robot) throws RemoteException {
		mockInit.initMockElevator(0, Elevator.UNCOMMITTED, 5, 10, Elevator.OPEN, 3, 3, 5, 16, 8,
				new boolean[] {false, true, true, true, false});
		;
		
	}

//	@Test
	public void testGuiFloorUP(FxRobot robot) throws RemoteException, InterruptedException {
		mockInit.initMockFloor(0, true, true);
		robot.clickOn("#bMode");
		robot.clickOn("#bMode");

		robot.clickOn("#cbNextPoses0");
		robot.clickOn("#cbNextPoses1");

		Thread.sleep(100);
		FxAssert.verifyThat("#tNextPos", TextMatchers.hasText("Next Pos."));
		FxAssert.verifyThat("#tNextPoses0", TextMatchers.hasText("3"));
	}

//	@Test
	public void testGuiManualAuto(FxRobot robot) throws RemoteException {
		mockInit.initMockElevator(0, Elevator.UNCOMMITTED, 5, 10, Elevator.OPEN, 3, 3, 5, 16, 8,
				new boolean[] {false, true, true, true, false});
		FxAssert.verifyThat("#tMode", NodeMatchers.isVisible());

		FxAssert.verifyThat("#tMode", TextMatchers.hasText("Operational Mode: Automatic"));
		robot.clickOn("#bMode");
		robot.clickOn("#bMode");

		FxAssert.verifyThat("#tMode", TextMatchers.hasText("Operational Mode: Manual"));

	}
//    @Test
    public void testGuiThrowRemoteEx(FxRobot robot) throws RemoteException, RuntimeException, InterruptedException 
    {

    	FxAssert.verifyThat("#tConnState", TextMatchers.hasText("connected"));
    	
    	mockInit.exceptionMockSetup(true);
    	
    	// wait for disconnect text
		Thread.sleep(100);

    	FxAssert.verifyThat("#tConnState", TextMatchers.hasText("disconnected"));
		
    }
    
    // TODO check values
    //@Test
    //public void testGuiDisplayedValues(FxRobot robot) throws RemoteException, RuntimeException, InterruptedException 
    //{
//    }
}

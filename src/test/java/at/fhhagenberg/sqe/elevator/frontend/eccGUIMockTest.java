package at.fhhagenberg.sqe.elevator.frontend;
import at.fhhagenberg.sqe.App;
import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;
import at.fhhagenberg.sqe.elevator.backend.MockInitialiser;
import at.fhhagenberg.sqe.elevator.model.Elevator;
import at.fhhagenberg.sqe.elevator.model.ElevatorControlCenter;
import at.fhhagenberg.sqe.elevator.model.Floor;
import javafx.stage.Stage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import org.testfx.matcher.control.TextInputControlMatchers;
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

    private static MockInitialiser mockInit;
    
    @Start
    public void start(Stage stage) throws RemoteException{

        mockInit = new MockInitialiser(mockedIElevator);
        mockInit.defaultMockSetup();

    	wrappedElevator = new ElevatorWrapper(mockedIElevator);
    	ecc = new ElevatorControlCenter(wrappedElevator);

        var app = new App();
        app.gui = new eccGUI(ecc, 1280, 960);
        app.start(stage);
    }
    
    @Test
    public void testDefaultGui(FxRobot robot) throws RemoteException {
    	robot.clickOn("#bMode");
        //FxAssert.verifyThat("#bMode", TextInputControlMatchers.hasText("set to Automatic"));
    }

    @Test
    public void testGuiDropDown(FxRobot robot) throws RemoteException 
    {
    	robot.clickOn("#cbNextPoses0");
    	
        //FxAssert.verifyThat("#bMode", TextInputControlMatchers.hasText("set to Automatic"));
    }

}

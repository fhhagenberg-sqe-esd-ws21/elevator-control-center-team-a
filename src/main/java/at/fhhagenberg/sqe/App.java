package at.fhhagenberg.sqe;

import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;
import at.fhhagenberg.sqe.elevator.backend.MockInitialiser;
import at.fhhagenberg.sqe.elevator.frontend.eccGUI;

import at.fhhagenberg.sqe.elevator.model.Elevator;
import at.fhhagenberg.sqe.elevator.model.ElevatorControlCenter;
import at.fhhagenberg.sqe.elevator.model.Floor;
import javafx.application.Application;
import javafx.stage.Stage;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sqelevator.IElevator;
import org.junit.jupiter.api.extension.ExtendWith;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * JavaFX App
 */
@ExtendWith(MockitoExtension.class)
public class App extends Application 
{
    private eccGUI gui;
//    private static ElevatorControlCenter elContr;
//    private static ElevatorWrapper eleWrap;
//
//    private static ElevatorWrapper wrappedElevator;
//    private static ElevatorControlCenter ecc;
//
    @Mock
    private static IElevator mockedIElevator = mock(IElevator.class);
//
//    private static MockInitialiser mockInit;

    protected eccGUI createGUI() throws RemoteException 
    {
    	
        MockInitialiser mockInit = new MockInitialiser(mockedIElevator);
        mockInit.defaultMockSetup();

        ElevatorWrapper eleWrap = new ElevatorWrapper(mockedIElevator);
        ElevatorControlCenter elContr = new ElevatorControlCenter(eleWrap);
    	
    	return new eccGUI(elContr, 1280, 960); 
    	
    }
    
    @Override
    public void start(Stage stage) 
    {	

    	try {
			this.gui = createGUI();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	gui.init();
    	gui.start(stage);
    }

    public static void main(String[] args) throws RemoteException {
//
//        mockInit = new MockInitialiser(mockedIElevator);
//        mockInit.defaultMockSetup();
//
//        eleWrap = new ElevatorWrapper(mockedIElevator);
//        elContr = new ElevatorControlCenter(eleWrap);
//    	gui = new eccGUI(elContr, 1280, 960);
    	
    	
        launch();
    }

}
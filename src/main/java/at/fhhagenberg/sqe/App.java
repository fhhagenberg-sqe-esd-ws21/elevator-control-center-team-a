package at.fhhagenberg.sqe;

import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;
import at.fhhagenberg.sqe.elevator.backend.MockInitialiser;
import at.fhhagenberg.sqe.elevator.frontend.eccGUI;

import at.fhhagenberg.sqe.elevator.model.Elevator;
import at.fhhagenberg.sqe.elevator.model.ElevatorControlCenter;
import at.fhhagenberg.sqe.elevator.model.Floor;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sqelevator.IElevator;
import org.junit.jupiter.api.extension.ExtendWith;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;


//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;

/**
 * JavaFX App
 */
@ExtendWith(MockitoExtension.class)
public class App extends Application 
{
    private eccGUI gui;
    private ElevatorControlCenter elContr;
    private ElevatorWrapper eleWrap;
//    private static ElevatorControlCenter elContr;
//    private static ElevatorWrapper eleWrap;
//
//    private static ElevatorWrapper wrappedElevator;
//    private static ElevatorControlCenter ecc;
//
//    @Mock
    private static IElevator elevator;// = mock(IElevator.class);
//
//    private static MockInitialiser mockInit;

    protected eccGUI createGUI() throws RemoteException
    {
    	try {
			elevator = (IElevator) Naming.lookup("rmi://127.0.0.1/ElevatorSim");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			throw new RemoteException("RemoteException");
		}


        eleWrap = new ElevatorWrapper(elevator);
        elContr = new ElevatorControlCenter(eleWrap);
    	
    	return new eccGUI(elContr, 1280, 960); 
    	
    }
    
    @Override
    public void start(Stage stage)
    {	
		this.gui = createGUI();
		gui.init();
    	// background task
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
            	boolean connected = true;
                while (true) {
                    Thread.sleep(30);
                	try {
                		if(!connected) {
                			Thread.sleep(3000);
                			connected = true;
                			Platform.runLater(() -> {
                				gui = createGUI();
                				gui.init();
                				gui.setConnState(true);
                		    	gui.start(stage);
                            });
                		}
                		elContr.update();
                        Platform.runLater(() -> {
                            gui.update();
                        });
            		} catch (RuntimeException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            			Platform.runLater(() -> {
            				gui.setConnState(false);
                        });
            			connected = false;
            		} catch (Exception e) {
            			System.out.print(e.getMessage());
            		}
                }
            }
        };
        new Thread(task).start();
    	gui.start(stage);
    }

    public static void main(String[] args) {
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

package at.fhhagenberg.sqe;

import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;

import at.fhhagenberg.sqe.elevator.frontend.eccGUI;


import at.fhhagenberg.sqe.elevator.model.ElevatorControlCenter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;

import org.mockito.junit.jupiter.MockitoExtension;
import sqelevator.IElevator;
import org.junit.jupiter.api.extension.ExtendWith;

import java.rmi.RemoteException;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

/**
 * JavaFX App
 */
@ExtendWith(MockitoExtension.class)
public class App extends Application 
{
    private eccGUI gui;
    private ElevatorControlCenter elContr;
    private ElevatorWrapper eleWrap;

    private static IElevator elevator;

    protected eccGUI createGUI()
    {
    	try {
			elevator = (IElevator) Naming.lookup("rmi://127.0.0.1/ElevatorSim");
	        
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	eleWrap = new ElevatorWrapper(elevator);
        elContr = new ElevatorControlCenter(eleWrap);
		try {
        elContr.update();
		} catch(RuntimeException e){ e.printStackTrace(); }

    	return new eccGUI(elContr, 1280, 960);
    	
    }
    
    @Override
    public void start(Stage stage)
    {	
		try{	this.gui = createGUI();
	           }catch (RuntimeException ex) { ex.printStackTrace(); }
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
							elevator = (IElevator) Naming.lookup("rmi://127.0.0.1/ElevatorSim");
							elContr.setServer(new ElevatorWrapper(elevator));
							elContr.InitElevatorAndFloors();
                			Platform.runLater(() -> {
			                				gui.init();
			                				gui.setConnState(true);
			                		    	gui.start(stage);
			                });

                		} else {
                			elContr.update();
                			Platform.runLater(() -> { gui.update(); });
                		}
                		
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
    	
        launch();
    }

}

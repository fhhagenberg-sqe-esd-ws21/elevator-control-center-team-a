package at.fhhagenberg.sqe;

import java.util.ResourceBundle;

import at.fhhagenberg.sqe.elevator.eccGUI;
import at.fhhagenberg.sqe.elevator.model.ElevatorControlCenter;

// import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;
// import at.fhhagenberg.sqe.elevator.model.ElevatorControlCenter;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application 
{

    
    static eccGUI gui;
    
    @Override
    public void start(Stage stage) 
    {	
    	gui.init();
    	gui.start(stage);
    }


    public static void main(String[] args) 
    {
        //	var app = new App();
        //	app.start(stage);

    //  ElevatorControlCenter elContr = new ElevatorControlCenter(new ElevatorWrapper());
        // TODO: GUI kriegt ein ecc übergeben und incepted daraus die GUI, liest im update 
        //			alle Stati aus, ruft setNext und setAuto auf
        
    	gui = new eccGUI(3 , 12, 1280, 960);        
    	// gui = new eccGUI(elContr , 1280, 960);        
        
        
        

        launch();
    }

}
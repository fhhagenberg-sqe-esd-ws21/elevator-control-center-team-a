package at.fhhagenberg.sqe;

import java.util.ResourceBundle;

import at.fhhagenberg.sqe.elevator.eccGUI;

// import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;
// import at.fhhagenberg.sqe.elevator.model.ElevatorControlCenter;

import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.ChoiceBox;

// import javafx.scene.control.TextField;
//import javafx.scene.layout.*;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.Pane;
//import javafx.scene.text.Text;
import javafx.stage.Stage;

//import javafx.scene.paint.Color;
//
//import javafx.scene.shape.Rectangle;
//import javafx.scene.shape.Line;
// import javafx.scene.layout.Region;
// import javafx.stage.Stage;
//import javafx.collections.FXCollections;

/**
 * JavaFX App
 */
public class App extends Application {

    
    eccGUI gui = new eccGUI(4 , 12, 1280, 960);
    
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

        // ElevatorControlCenter elContr = new ElevatorControlCenter(new ElevatorWrapper());
        launch();
    }

}
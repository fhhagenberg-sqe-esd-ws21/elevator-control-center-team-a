package at.fhhagenberg.sqe.elevator.frontend;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import at.fhhagenberg.sqe.elevator.model.ElevatorControlCenter;

import java.util.ArrayList;

import at.fhhagenberg.sqe.elevator.model.Floor;
import at.fhhagenberg.sqe.elevator.model.Elevator;


public class eccGUI {


    private int nElevators;
    private int nFloors;

    private boolean state; // true = Auto, false = manual
    private boolean connected; // true = connected, false = disconnect

    private ElevatorControlCenter elevatorCtrl;

    // geometry data
    private final double hScene;
    private final double wScene;

    private double xElevs;
    private double yElevs;
    private double hElevs;
    private double wElevs;

    
    private double 	hFloor;
    private double 	hOffEelev;
    private double 	hElev;
    
    private double xFloors;
    private double yFloors;
    private double wFloors;
    private double hFloors;

    // General Elements 
    Label label;
    Button bMode;
    Text tMode;
    Text tConn;
    Text tConnState;

    // Elevator-wise Elements 
    Text tElevators;
    Text tNumber;
    Text tPosition;
    Text tNextPos;
    Text tPressed;
    Text tChooseNextPos;
    Text tDirection;
    Text tPayload;
    Text tSpeed;
    Text tDoor;

    Text[] tNumbers;
    Text[] tPositions;
    Text[] tNextPoses;
    Text[] tPresseds;
    ChoiceBox[] cbNextPoses;
    Text[] tDirections;
    Text[] tPayloads;
    Text[] tSpeeds;
    Text[] tDoors;

    // Floor-wise Elements 
    Text tFloors;
    Text[] floorLabels;
    Text[] floorUpArrows;
    Text[] floorDownArrows;

    /**
     * Contstructor of GUI
     *
     * @param ecc    ElevatorControlCenter
     * @param width  width of scene
     * @param heigth height of scene
     */
    public eccGUI(ElevatorControlCenter ecc, int width, int heigth) 
    {    elevatorCtrl = ecc;
	    wScene = width;
	    hScene = heigth;
    }

    public void init() {
        state = true; // true = Auto, false = manual
        connected = false; // true = connected, false = disconnect 
    	if(elevatorCtrl.getElevators() == null)
    		nElevators = 0;
    	else
    		nElevators = elevatorCtrl.getElevators().size();
    	if(elevatorCtrl.getFloors() == null)
    		nFloors = 0;
    	else
    		nFloors = elevatorCtrl.getFloors().size();

        // var tA = new Text(labels.getString("tA") );
        // var tB = new Text(labels.getString("tB"));
        // var tC = new Text(labels.getString("tC"));
        // var tfPeri = new TextField();
        // var tfArea = new TextField();

        // geometry data
        xElevs = 325;
        yElevs = 100;
		hFloor = 25;
		hOffEelev = 30;
		hElev  = 60;
        hElevs = 90 + hElev * (nElevators) + 20;
        wElevs = 875;
        xFloors = 50;
        yFloors = 100;
        wFloors = 250;
        hFloors = 90 + hFloor * (nFloors);

        /* GUI, General Elements */
        label = new Label("Elevator Control Center");
        bMode = new Button("set to Manual");
        tMode = new Text("Operational Mode: Automatic");
        tConn = new Text("Connection Status: ");
        tConnState = new Text("disconnected");    // https://unicode-table.com/de/2022/

        label.setStyle("-fx-font: 28 arial;");
        label.setLayoutX(20);
        label.setLayoutY(20);
        
        /* GUI, Floor-wise Elements */
        tFloors = new Text("Floors");
        floorLabels = new Text[nFloors];
        floorUpArrows = new Text[nFloors];
        floorDownArrows = new Text[nFloors];

        /* GUI, Elevator-wise Elements      */
        tElevators = new Text("Elevators");

        tNumber = new Text("Nr");
        tPosition = new Text("Position");
        tNextPos = new Text("Next Pos.");
        tPressed = new Text("pressed Btns");
        tChooseNextPos = new Text("choose Next Pos.");
        tDirection = new Text("Direction");
        tPayload = new Text("Payload");
        tSpeed = new Text("Speed");
        tDoor = new Text("Door");

        tNumbers = new Text[nElevators];
        tPositions = new Text[nElevators];
        tNextPoses = new Text[nElevators];
        tPresseds = new Text[nElevators];
        cbNextPoses = new ChoiceBox[nElevators];
        tDirections = new Text[nElevators];
        tPayloads = new Text[nElevators];
        tSpeeds = new Text[nElevators];
        tDoors = new Text[nElevators];

    }

    /*
     * Inception of the GUI, by defining geometires, Label-Strings
     * Item-IDs, callbacks and adding them to the layout
     *
     * */
    public void start(Stage stage) 
    {   Pane layout = new Pane();
        layout.setStyle("-fx-border-color: black");
        var scene = new Scene(layout, wScene, hScene);

        // private ResourceBundle labels = ResourceBundle.getBundle("eccBundle");
        // Resource Bundle Manager

        label.setId("label");        // export ID so, controls can be detected by the TestApp

        Line lElevatorsO = new Line(xElevs, yElevs, xElevs + wElevs, yElevs);
        layout.getChildren().add(lElevatorsO);
        Line lElevatorsL = new Line(xElevs, yElevs, xElevs, yElevs + hElevs);
        layout.getChildren().add(lElevatorsL);
        Line lElevatorsR = new Line(xElevs + wElevs, yElevs, xElevs + wElevs, yElevs + hElevs);
        layout.getChildren().add(lElevatorsR);
        Line lElevatorsU = new Line(xElevs, yElevs + hElevs, xElevs + wElevs, yElevs + hElevs);
        layout.getChildren().add(lElevatorsU);

        /*   Elevator-wise Elements      */
        tElevators.setStyle("-fx-font: 28 arial;");
        tElevators.setLayoutX(xElevs + 40);
        tElevators.setLayoutY(yElevs + 40);
        tElevators.setId("tElevators");
        layout.getChildren().add(tElevators);

        yElevs += 80;
        xElevs += 25;

        tNumber.setLayoutX(xElevs);
        tNumber.setLayoutY(yElevs);
        tNumber.setId("tNumber");
        layout.getChildren().add(tNumber);

        tPosition.setLayoutX(xElevs + 100);
        tPosition.setLayoutY(yElevs);
        tPosition.setId("tPosition");
        layout.getChildren().add(tPosition);

        tNextPos.setLayoutX(xElevs + 200);
        tNextPos.setLayoutY(yElevs);
        tNextPos.setId("tNextPos");
        layout.getChildren().add(tNextPos);

        tPressed.setLayoutX(xElevs + 400);
        tPressed.setLayoutY(yElevs);
        tPressed.setId("tPressed");
        layout.getChildren().add(tPressed);

        tChooseNextPos.setLayoutX(xElevs + 300);
        tChooseNextPos.setLayoutY(yElevs);
        layout.getChildren().add(tChooseNextPos);

        tDirection.setLayoutX(xElevs + 500);
        tDirection.setLayoutY(yElevs);
        tDirection.setId("tDirection");
        layout.getChildren().add(tDirection);

        tPayload.setLayoutX(xElevs + 600);
        tPayload.setLayoutY(yElevs);
        tPayload.setId("tPayload");
        layout.getChildren().add(tPayload);

        tSpeed.setLayoutX(xElevs + 700);
        tSpeed.setLayoutY(yElevs);
        tSpeed.setId("tSpeed");
        layout.getChildren().add(tSpeed);

        tDoor.setLayoutX(xElevs + 800);
        tDoor.setLayoutY(yElevs);
        tDoor.setId("tDoor");
        layout.getChildren().add(tDoor);


        for (int idxElevs = 0; idxElevs < nElevators; idxElevs++) {
            tNumbers[idxElevs] = new Text("" + idxElevs);
            tNumbers[idxElevs].setLayoutX(xElevs);
            tNumbers[idxElevs].setLayoutY(yElevs + hElev * (idxElevs ) + hOffEelev);
            tNumbers[idxElevs].setId("tNumbers" + idxElevs);
            layout.getChildren().add(tNumbers[idxElevs]);

            tPositions[idxElevs] = new Text("");
            tPositions[idxElevs].setLayoutX(xElevs + 100);
            tPositions[idxElevs].setLayoutY(yElevs + hElev * (idxElevs ) + hOffEelev);
            tPositions[idxElevs].setId("tPositions" + idxElevs);
            layout.getChildren().add(tPositions[idxElevs]);

            tNextPoses[idxElevs] = new Text("");
            tNextPoses[idxElevs].setLayoutX(xElevs + 200);
            tNextPoses[idxElevs].setLayoutY(yElevs + hElev * (idxElevs ) + hOffEelev);
            tNextPoses[idxElevs].setId("tNextPoses" + idxElevs);
            layout.getChildren().add(tNextPoses[idxElevs]);

            tPresseds[idxElevs] = new Text("");
            tPresseds[idxElevs].setLayoutX(xElevs + 400);
            tPresseds[idxElevs].setLayoutY(yElevs + hElev * (idxElevs + 0.5) + hOffEelev);
            tPresseds[idxElevs].setId("tPresseds" + idxElevs);
            layout.getChildren().add(tPresseds[idxElevs]);

            cbNextPoses[idxElevs] = new ChoiceBox();
            cbNextPoses[idxElevs].setOnAction(action -> actionNextPos(-1));
            for (int idxFloors = 0; idxFloors < nFloors; idxFloors++) {
                cbNextPoses[idxElevs].getItems().add("" + (nFloors-1 - idxFloors));
            }
            cbNextPoses[idxElevs].setLayoutX(xElevs + 300);
            cbNextPoses[idxElevs].setLayoutY(yElevs + 15 + hElev * (idxElevs));
            cbNextPoses[idxElevs].setId("cbNextPoses" + idxElevs);
            cbNextPoses[idxElevs].setDisable(true);
            layout.getChildren().add(cbNextPoses[idxElevs]);

            tDirections[idxElevs] = new Text("up");
            tDirections[idxElevs].setLayoutX(xElevs + 500);
            tDirections[idxElevs].setLayoutY(yElevs + hElev * (idxElevs) + hOffEelev);
            tDirections[idxElevs].setId("tDirections" + idxElevs);
            layout.getChildren().add(tDirections[idxElevs]);

            tPayloads[idxElevs] = new Text("0");
            tPayloads[idxElevs].setLayoutX(xElevs + 600);
            tPayloads[idxElevs].setLayoutY(yElevs + hElev * (idxElevs) + hOffEelev);
            tPayloads[idxElevs].setId("tPayloads" + idxElevs);
            layout.getChildren().add(tPayloads[idxElevs]);

            tSpeeds[idxElevs] = new Text("0");
            tSpeeds[idxElevs].setLayoutX(xElevs + 700);
            tSpeeds[idxElevs].setLayoutY(yElevs + hElev * (idxElevs ) + hOffEelev);
            tSpeeds[idxElevs].setId("tSpeeds" + idxElevs);
            layout.getChildren().add(tSpeeds[idxElevs]);

            tDoors[idxElevs] = new Text("-");
            tDoors[idxElevs].setLayoutX(xElevs + 800);
            tDoors[idxElevs].setLayoutY(yElevs + hElev * (idxElevs) + hOffEelev);
            tDoors[idxElevs].setId("tDoors" + idxElevs);
            layout.getChildren().add(tDoors[idxElevs]);

        }


        Rectangle rFloors = new Rectangle(xFloors, yFloors, wFloors, hFloors);
        rFloors.setFill(Color.TRANSPARENT);
        rFloors.setStroke(Color.BLACK);
        layout.getChildren().add(rFloors);

        xFloors += 50;
        yFloors += 40;
        tFloors.setStyle("-fx-font: 28 arial;");

        tFloors.setLayoutX(xFloors);
        tFloors.setLayoutY(yFloors);
        tFloors.setId("tFloors");
        layout.getChildren().add(tFloors);

        yFloors += 40;

        for (int idxFloors = 0; idxFloors < nFloors; idxFloors++) {
            floorLabels[idxFloors] = new Text("" + (nFloors-1 - idxFloors));
            floorLabels[idxFloors].setLayoutX(xFloors);
            floorLabels[idxFloors].setLayoutY(yFloors + idxFloors * hFloor);
            floorLabels[idxFloors].setId("floorLabels" + idxFloors);
            layout.getChildren().add(floorLabels[idxFloors]);

            floorUpArrows[idxFloors] = new Text("•");
            floorUpArrows[idxFloors].setLayoutX(xFloors + 40);
            floorUpArrows[idxFloors].setLayoutY(yFloors + idxFloors * hFloor + 5);
            floorUpArrows[idxFloors].setStyle("-fx-font: 32 arial;");
            floorUpArrows[idxFloors].setFill(Color.RED);
            floorUpArrows[idxFloors].setId("floorUpArrows+idxFloors");
            layout.getChildren().add(floorUpArrows[idxFloors]);

            floorDownArrows[idxFloors] = new Text("•");
            floorDownArrows[idxFloors].setLayoutX(xFloors + 60);
            floorDownArrows[idxFloors].setLayoutY(yFloors + idxFloors * hFloor + 5);
            floorDownArrows[idxFloors].setStyle("-fx-font: 32 arial;");
            floorDownArrows[idxFloors].setFill(Color.GREEN);
            floorDownArrows[idxFloors].setId("floorDownArrows+idxFloors");
            layout.getChildren().add(floorDownArrows[idxFloors]);
        }

        tMode.setLayoutX(xElevs + wElevs - 250);
        tMode.setLayoutY(yElevs + hElevs);
        tMode.setId("tMode");
        layout.getChildren().add(tMode);

        bMode.setOnAction(action -> actionbMode());
        bMode.setLayoutX(xElevs + wElevs - 250);
        bMode.setLayoutY(yElevs + hElevs - 50);
        bMode.setId("bMode");
        layout.getChildren().add(bMode);

        tConn.setLayoutX(xElevs + wElevs - 250);
        tConn.setLayoutY(yElevs + hElevs + 50);
        tConn.setId("tConn");
        layout.getChildren().add(tConn);

        // tConnState.setStyle("-fx-font: 48 arial;");
        // tConnState.setFill(Color.GREEN);
        tConnState.setId("tConnState");
        tConnState.setLayoutX(xElevs + wElevs - 120);
        tConnState.setLayoutY(yElevs + hElevs + 50);
        layout.getChildren().add(tConnState);

        layout.getChildren().add(label);

        stage.setScene(scene);
        stage.show();

        this.update();
    }

    /*
     * @brief updates all varying GUI elements with valid elevator-data
     * 			from ecc-structure of recent valid states of elevators
     *
     * */
    public void update() 
    {
        /* GUI, General Elements */

    	
    	/* GUI, Floor-wise Elements  */
        for(int idxFloors = 0; idxFloors< nFloors; idxFloors++)
       	{	Floor floor = elevatorCtrl.getFloors().get(idxFloors);
        	if(floor.getButtonDown())
        	{   floorDownArrows[idxFloors].setFill(Color.GREEN);
        	}else {
        		floorDownArrows[idxFloors].setFill(Color.RED);
        	}
        	if(floor.getButtonUp())
        	{   floorUpArrows[idxFloors].setFill(Color.GREEN);
        	}else {
        		floorUpArrows[idxFloors].setFill(Color.RED);
        	}
       	}
    	
        /* GUI, Elevator-wise Elements      */
        for(int idxElevs = 0; idxElevs < nElevators; idxElevs++)
       	{	Elevator elev = elevatorCtrl.getElevators().get(idxElevs);		// Elev-Number
        	
        	tPositions[idxElevs].setText( "" + elev.getElevatorFloor());	// closest Floor
	    
        	tNextPoses[idxElevs].setText("" + elev.getElevatorTarget());	// next target      	
        	
        	ArrayList<Integer> lpressedBts = elev.getElevatorButton();		// next targets
        	String pressedBts = "";
        	for(int idx = 0; idx < lpressedBts.size(); idx++)
        	{
        			pressedBts +=  lpressedBts.get(idx) + ", ";
        	}
   			tPresseds [idxElevs].setText(pressedBts); 
        	
        	if(elev.getCommittedDirection() == Elevator.UP )				// Direction				
	        	tDirections[idxElevs].setText( "up" );  
	        else if(elev.getCommittedDirection() == Elevator.DOWN )
	        	tDirections[idxElevs].setText( "down" );  
	        else if(elev.getCommittedDirection() == Elevator.UNCOMMITTED )
	        	tDirections[idxElevs].setText( "none" );  
	        			
        	tPayloads [idxElevs].setText( "" + elev.getElevatorWeight());	// weight/payload

        	tSpeeds [idxElevs].setText( "" + elev.getElevatorSpeed());		// Speed

        	if(elev.getElevatorDoorStatus() == Elevator.CLOSED)				// Door Status
	        	tDoors [idxElevs].setText( "closed" );
	        else if(elev.getElevatorDoorStatus() == Elevator.OPEN)
	        	tDoors [idxElevs].setText( "open" );
       	}
    }

    /*
     * brief callback for the Mode-Button switching between Auto/Manual
     * 		 sets Dropdown-items for 'next Position' passive/active
     * */
    public void actionbMode() 
    {   this.update();
    	if (state) 
        {   elevatorCtrl.setAuto(true);
        } else {
        	elevatorCtrl.setAuto(false);
        }

        if(elevatorCtrl.getOpMode() == 	ElevatorControlCenter.AUTO)
        {   tMode.setText("Operational Mode: Automatic");
            bMode.setText("set to Manual");
            for (int idxElevs = 0; idxElevs < nElevators; idxElevs++) {
                cbNextPoses[idxElevs].setDisable(true);
            }
        }

        if(elevatorCtrl.getOpMode() == 	ElevatorControlCenter.MANUAL)
        {   tMode.setText("Operational Mode: Manual");
            bMode.setText("set to Automatic");
            for (int idxElevs = 0; idxElevs < nElevators; idxElevs++) {
                cbNextPoses[idxElevs].setDisable(false);
            }
        }
        state = !state;

    }

    /*
     * brief callback for the NextPos-Dropdown
     * reads every elevators chosen next-position and sends it to console/God-Object
     * */
    public void actionNextPos(int cbNextPosID) 
    {   for (int idxElevs = 0; idxElevs < nElevators; idxElevs++) 
    	{   String buff = (String) cbNextPoses[idxElevs].getValue();
            if (cbNextPoses[idxElevs].getValue() != null) 
            {   int next = Integer.parseInt(buff);
                elevatorCtrl.setNext(idxElevs, next);
            }
        }

        this.update();
    }
    
    public void setConnState(boolean connected) {
    	if(connected)
    	{	tConnState.setFill(Color.GREEN);
    		tConnState.setText("connected");
    	}else {
    		tConnState.setFill(Color.RED);
    		tConnState.setText("disconnected");
    	}
    }
}

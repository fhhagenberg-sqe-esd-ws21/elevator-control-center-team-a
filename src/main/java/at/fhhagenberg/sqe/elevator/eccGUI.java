package at.fhhagenberg.sqe.elevator;

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

import java.util.ArrayList;

import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;
import at.fhhagenberg.sqe.elevator.model.ElevatorControlCenter;
import at.fhhagenberg.sqe.elevator.model.Floor;
import at.fhhagenberg.sqe.elevator.model.Elevator;

public class eccGUI 
{

	// TODO: floors und elevetors als Listen aus ECC übernehmen und davon GUI-ekemtne ableiten
	// TODO: GUI Element für jeden Elevator: welche Stockrke wurden innen gedrückt, als ZahleListe oder als beleuchtete Balken (ähnlich Audio-Pegelanzeige) 
	
	
	
	int nElevators;
	int nFloors;

    boolean state; // true = Auto, false = manual 
    boolean connected; // true = connected, false = disconnect 

    ElevatorControlCenter ecc;
    
    // geometry data
    int hScene;
    int wScene;

    int xElevs;
    int yElevs;
    int hElevs;
    int wElevs;

	int xFloors;
    int yFloors;
	int wFloors;
    int hFloors;
    
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


    public eccGUI(int Elevators, int Floors, int wScene, int hScene)
    {	// this.ecc = new ElevatorControlCenter( new ElevatorWrapper(null) );
    	nElevators = Elevators;
    	nFloors = Floors;
        this.wScene = wScene;
        this.hScene = hScene;
    }
    
    public eccGUI(ElevatorControlCenter ecc, int wScene, int hScene)
    {	this.ecc = ecc;
    
	    nElevators =  	this.ecc.getElevators().size();
		nFloors = 		this.ecc.getFloors().size();
    	
        this.wScene = wScene;
        this.hScene = hScene;
    }
    

    public void init() 
    {
        state = true; // true = Auto, false = manual 
        connected = false; // true = connected, false = disconnect 
        
        // var tA = new Text(labels.getString("tA") );
	    // var tB = new Text(labels.getString("tB"));
	    // var tC = new Text(labels.getString("tC"));
        // var tfPeri = new TextField();
        // var tfArea = new TextField();
        
        // geometry data
        xElevs = 325;
        yElevs = 200;
        hElevs = 90 + 30*(nElevators) + 20;
        wElevs = 875;
        xFloors = 50;
        yFloors = 200;
		wFloors = 250;
        hFloors = 90 + 30*(nFloors);
        
        /* GUI, General Elements */
        label = new Label("Elevator Control Center");
        bMode = new Button("set to Auto");
        tMode = new Text("Operational Mode: Manual");
        tConn = new Text("Connected: ");
        tConnState = new Text("•");	// https://unicode-table.com/de/2022/

        /* GUI, Floor-wise Elements */
        tFloors = new Text("Floors");
        floorLabels = new Text[nFloors];              
        floorUpArrows = new Text[nFloors];            
        floorDownArrows = new Text[nFloors];          
        
    	/* GUI, Elevator-wise Elements      */
        tElevators = new Text("Elevators");
    
        tNumber 	= new Text("Nr");
        tPosition 	= new Text("Position");
        tNextPos  	= new Text("Next Pos.");
        tPressed  	= new Text("pressed Btns");
        tChooseNextPos = new Text("choose Next Pos.");
        tDirection = new Text("Direction");
        tPayload	= new Text("Payload");
        tSpeed		= new Text("Speed");
        tDoor 		= new Text("Door");
    
        tNumbers = new Text[nElevators];
        tPositions = new Text[nElevators];
        tNextPoses = new Text[nElevators];
        tPresseds         = new Text[nElevators];
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
    {
    	Pane layout = new Pane();
        layout.setStyle("-fx-border-color: black");
        var scene = new Scene(layout, wScene, hScene);

    	// private ResourceBundle labels = ResourceBundle.getBundle("eccBundle");
    	// Resource Bundle Manager

        label.setId("label");        // export ID so, controls can be detected by the TestApp
        
        Line lElevatorsO = new Line(xElevs, 		yElevs, 		xElevs+wElevs,	yElevs		 );
        layout.getChildren().add(lElevatorsO );
        Line lElevatorsL = new Line(xElevs, 		yElevs, 		xElevs, 		yElevs+hElevs);
        layout.getChildren().add(lElevatorsL );
        Line lElevatorsR = new Line(xElevs+wElevs,	yElevs, 		xElevs+wElevs,	yElevs+hElevs);
        layout.getChildren().add(lElevatorsR );
        Line lElevatorsU = new Line(xElevs,			yElevs+hElevs,	xElevs+ wElevs,	yElevs+hElevs);
        layout.getChildren().add(lElevatorsU );
        
        

    	/*   Elevator-wise Elements      */
        tElevators.setStyle("-fx-font: 28 arial;");
        tElevators.setLayoutX(xElevs+40);			
        tElevators.setLayoutY(yElevs+40);			
        tElevators.setId("tElevators");
        layout.getChildren().add(tElevators);

        yElevs += 80;
        xElevs += 25;

        tNumber.setLayoutX(xElevs + 00);		        
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

        tPressed.setLayoutX(xElevs + 300);	 	 	        
        tPressed.setLayoutY(yElevs);	 	 	        
        tPressed.setId("tPressed");
        layout.getChildren().add(tPressed);

        tChooseNextPos.setLayoutX(xElevs + 400);	 	 	        
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

        		
        for(int idxElevs = 0; idxElevs < nElevators; idxElevs++)
       	{
        	tNumbers[idxElevs] = new Text("" + idxElevs);		
        	tNumbers[idxElevs].setLayoutX(xElevs + 00);
        	tNumbers[idxElevs].setLayoutY(yElevs + 30*(idxElevs+1));  
        	tNumbers      [idxElevs].setId("tNumbers" + idxElevs);
        	layout.getChildren().add( tNumbers[idxElevs]);

        	tPositions[idxElevs] = new Text("99");		
        	tPositions[idxElevs].setLayoutX(xElevs + 100);
        	tPositions[idxElevs].setLayoutY(yElevs + 30*(idxElevs+1));  
        	tPositions    [idxElevs].setId("tPositions" + idxElevs);
        	layout.getChildren().add( tPositions[idxElevs]);
			
        	tNextPoses[idxElevs] = new Text("69");		
        	tNextPoses[idxElevs].setLayoutX(xElevs + 200);
        	tNextPoses[idxElevs].setLayoutY(yElevs + 30*(idxElevs+1));  
        	tNextPoses[idxElevs].setId("cbNextPoses" + idxElevs);
        	layout.getChildren().add( tNextPoses[idxElevs]);

        	tPresseds[idxElevs] = new Text("3,4,5,2,9");		
        	tPresseds[idxElevs].setLayoutX(xElevs + 300);
        	tPresseds[idxElevs].setLayoutY(yElevs + 30*(idxElevs+1));  
        	tPresseds[idxElevs].setId("tPresseds" + idxElevs);
        	layout.getChildren().add( tPresseds[idxElevs]);

        	cbNextPoses[idxElevs] = new ChoiceBox();
        	cbNextPoses[idxElevs].setOnAction(action->actionNextPos(-1));
            for(int idxFloors = 0; idxFloors< nFloors; idxFloors++)
           	{ 	cbNextPoses[idxElevs].getItems().add(""+ (nFloors - idxFloors));	       	}
        	cbNextPoses[idxElevs].setLayoutX(xElevs + 400);
        	cbNextPoses[idxElevs].setLayoutY(yElevs + 12 + 30*(idxElevs));  
        	cbNextPoses[idxElevs].setId("cbNextPoses" + idxElevs);
        	layout.getChildren().add( cbNextPoses[idxElevs]);
			
        	tDirections[idxElevs] = new Text("up");		
        	tDirections[idxElevs].setLayoutX(xElevs + 500);
        	tDirections[idxElevs].setLayoutY(yElevs + 30*(idxElevs+1));  
        	tDirections[idxElevs].setId("tDirections" + idxElevs);
        	layout.getChildren().add( tDirections[idxElevs]);
			
        	tPayloads[idxElevs] = new Text("750");		
        	tPayloads[idxElevs].setLayoutX(xElevs + 600);
        	tPayloads[idxElevs].setLayoutY(yElevs + 30*(idxElevs+1));  
        	tPayloads[idxElevs].setId("tPayloads" + idxElevs);
        	layout.getChildren().add( tPayloads[idxElevs]);
			
        	tSpeeds[idxElevs] = new Text("3.5");		
        	tSpeeds[idxElevs].setLayoutX(xElevs + 700);
        	tSpeeds[idxElevs].setLayoutY(yElevs + 30*(idxElevs+1));  
        	tSpeeds[idxElevs].setId("tSpeeds" + idxElevs);
        	layout.getChildren().add( tSpeeds[idxElevs]);
			
        	tDoors[idxElevs] = new Text("open");		
        	tDoors[idxElevs].setLayoutX(xElevs + 800);
        	tDoors[idxElevs].setLayoutY(yElevs + 30*(idxElevs+1));  
        	tDoors[idxElevs].setId("tDoors" + idxElevs);
        	layout.getChildren().add( tDoors[idxElevs]);
			
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

        for(int idxFloors = 0; idxFloors< nFloors; idxFloors++)
       	{	floorLabels[idxFloors] = new Text(""+ (nFloors - idxFloors));
        	floorLabels[idxFloors].setLayoutX(xFloors);        	
        	floorLabels[idxFloors].setLayoutY(yFloors + idxFloors*30); 
        	floorLabels[idxFloors].setId("floorLabels"+idxFloors);
        	layout.getChildren().add(floorLabels[idxFloors]);

        	floorUpArrows[idxFloors] = new Text("•");        		
        	floorUpArrows[idxFloors].setLayoutX(xFloors+40);        	
        	floorUpArrows[idxFloors].setLayoutY(yFloors + idxFloors*30);        	
        	floorUpArrows[idxFloors].setStyle("-fx-font: 24 arial;");
        	floorUpArrows[idxFloors].setFill(Color.RED);
        	floorUpArrows[idxFloors].setId("floorUpArrows+idxFloors");
        	layout.getChildren().add(floorUpArrows[idxFloors]);

        	floorDownArrows[idxFloors] = new Text("•");        		
        	floorDownArrows[idxFloors].setLayoutX(xFloors+60);        	
        	floorDownArrows[idxFloors].setLayoutY(yFloors + idxFloors*30);     	
	       	floorDownArrows[idxFloors].setStyle("-fx-font: 24 arial;");	       	
        	floorDownArrows[idxFloors].setFill(Color.GREEN);
        	floorDownArrows[idxFloors].setId("floorDownArrows+idxFloors");
        	layout.getChildren().add(floorDownArrows[idxFloors]);        	
       	}
		
        tMode.setLayoutX(xElevs + wElevs - 250 );	 		        
        tMode.setLayoutY(yElevs + hElevs);
        tMode.setId("tMode");
        layout.getChildren().add(tMode);
        
        bMode.setOnAction(	action->actionbMode() );
        bMode.setLayoutX(xElevs + wElevs - 250 );	 		        
        bMode.setLayoutY(yElevs + hElevs - 50);	 		        
        bMode.setId("bMode");
        layout.getChildren().add(bMode);
        
        tConn.setLayoutX(xElevs + wElevs - 250 );	 		        
        tConn.setLayoutY(yElevs + hElevs+50);	 		        
        tConn.setId("tConn");
        layout.getChildren().add(tConn);

        tConnState.setStyle("-fx-font: 48 arial;");	       	
        tConnState.setFill(Color.RED);
        tConnState.setId("tConnState");
        tConnState.setLayoutX(xElevs + wElevs - 120 );	 		        
        tConnState.setLayoutY(yElevs + hElevs + 60 );	 		        
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
    void update()
    {	
        /* GUI, General Elements */

    	// ecc.getOpMode();
    	if (true /*ecc.getconnectd()*/ )		
    	{		tConnState.setFill(Color.GREEN); }
    	else		    						
    	{		tConnState.setFill(Color.RED);    }	

    	
    	/* GUI, Floor-wise Elements 
        for(int idxFloors = 0; idxFloors< nFloors; idxFloors++)
       	{	Floor floor = ecc.getFloors().get(idxFloors);
        	if(floor.getButtonDown())
        	{   floorDownArrows[idxFloors].setFill(Color.GREEN);
        	}else {
        		floorDownArrows[idxFloors].setFill(Color.GREEN);
        	}
        	if(floor.getButtonUp())
        	{   floorUpArrows[idxFloors].setFill(Color.GREEN);
        	}else {
        		floorUpArrows[idxFloors].setFill(Color.GREEN);
        	}
       	}
    	 */
    	
    	
        /* GUI, Elevator-wise Elements      
        for(int idxElevs = 0; idxElevs < nElevators; idxElevs++)
       	{
        	Elevator elev = ecc.getElevators().get(idxElevs);
        	
        	tPositions [idxElevs].setText( "" + elev.getElevatorFloor());
	    
        	ArrayList<Integer> lpressedBts = elev.getElevatorButton();
        	String pressedBts = "";
        	for(int idx = 0; idx < lpressedBts.size(); idx++)
        			pressedBts.concat( lpressedBts.get(idx) + ", ");
        	tNextPoses [idxElevs].setText( "" + pressedBts); 
	
        	if(elev.getElevatorDoorStatus() == Elevator.UP )
	        	tDirections[idxElevs].setText( "up" );  
	        else if(elev.getElevatorDoorStatus() == Elevator.DOWN )
	        	tDirections[idxElevs].setText( "down" );  
	        else if(elev.getElevatorDoorStatus() == Elevator.UNCOMMITTED )
	        	tDirections[idxElevs].setText( "none" );  
	        			
	        tPayloads [idxElevs].setText( "" + elev.getElevatorWeight(idxElevs)); 

        	tSpeeds [idxElevs].setText( "" + elev.getElevatorSpeed());
	        if(elev.getElevatorDoorStatus() == Elevator.CLOSED)
	        	tDoors [idxElevs].setText( "closed" );
	        else if(elev.getElevatorDoorStatus() == Elevator.OPEN)
	        	tDoors [idxElevs].setText( "open" );
	        else
	        	tDoors [idxElevs].setText( "oops" );
       	}
       	*/
    }
    
    
    /*
     * brief callback for the Mode-Button switching between Auto/Manual
     * 		 sets Dropdown-items for 'next Position' passive/active
     * */
    void actionbMode() 
    {	if (state)
    	{	// ecc.setAuto(true);    	
    	}
    	else			 
    	{	// ecc.setAuto(false);		
    	}
		state = !state;
	
	//    if(ecc.getOpMode() == 	ElevatorControlCenter.AUTO)
	    {   tMode.setText("Operational Mode: Automatic");
			bMode.setText("set to Manual");
		    for(int idxElevs = 0; idxElevs < nElevators; idxElevs++)
		     	{	cbNextPoses[idxElevs].setDisable(true);				}
	    }
	
	//    if(ecc.getOpMode() == 	ElevatorControlCenter.MANUAL)
	   	{	tMode.setText("Operational Mode: Manual");
			bMode.setText("set to Automatic");
	        for(int idxElevs = 0; idxElevs < nElevators; idxElevs++)
	        	{	cbNextPoses[idxElevs].setDisable(false);			}   		
	   	}

    }

    /*
     * brief callback for the NextPos-Dropdown
     * reads every elevators chosen next-position and sends it to console/God-Object  
     * */
    void actionNextPos(int cbNextPosID) 
    {	for(int idxElevs = 0; idxElevs<nElevators; idxElevs++) 
    	{	String buff = (String) cbNextPoses[idxElevs].getValue();
    		System.out.println("actionNextPos " + buff);
    		
    		if(cbNextPoses[idxElevs].getValue() != null)
    		{	int next = Integer.parseInt((String) cbNextPoses[idxElevs].getValue());
    		//	ecc.setNext(idxElevs, next);
    		}    		
    	}
		System.out.println(" ");
    }
}

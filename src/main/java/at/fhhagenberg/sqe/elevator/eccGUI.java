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

public class eccGUI 
{

	
	int nElevators;
	int nFloors;

    boolean state; // true = Auto, false = manual 
    boolean connected; // true = connected, false = disconnect 

    
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
    Text tChooseNextPos;
    Text tDirection;
    Text tPayload;
    Text tSpeed;
    Text tDoor;
	
    Text[] tNumbers;
    Text[] tPositions;
    Text[] tNextPoses;
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
    {	nElevators = Elevators;
    	nFloors = Floors;
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
        xElevs = 400;
        yElevs = 200;
        hElevs = 90 + 30*(nElevators) + 20;
        wElevs = 850;
        xFloors = 100;
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
        tChooseNextPos = new Text("choose Next Pos.");
        tDirection = new Text("Direction");
        tPayload	= new Text("Payload");
        tSpeed		= new Text("Speed");
        tDoor 		= new Text("Door");
    
        tNumbers = new Text[nElevators];
        tPositions = new Text[nElevators];
        tNextPoses = new Text[nElevators];
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
        Line lElevatorsL = new Line(xElevs, 		yElevs, 		xElevs, 		yElevs+hElevs);
        Line lElevatorsR = new Line(xElevs+wElevs,	yElevs, 		xElevs+wElevs,	yElevs+hElevs);
        Line lElevatorsU = new Line(xElevs,			yElevs+hElevs,	xElevs+ wElevs,	yElevs+hElevs);
        
        layout.getChildren().add(lElevatorsL );
        layout.getChildren().add(lElevatorsR );
        layout.getChildren().add(lElevatorsO );
        layout.getChildren().add(lElevatorsU );
        
        tElevators.setStyle("-fx-font: 28 arial;");

    	/*   Elevator-wise Elements      */
        tElevators.setLayoutX(xElevs+40);			
        tElevators.setLayoutY(yElevs+40);			
        tElevators.setId("tElevators");
        layout.getChildren().add(tElevators);
        yElevs += 80;

        tNumber.setLayoutX(xElevs + 100);		        
        tNumber.setLayoutY(yElevs);		        
        tNumber.setId("tNumber");
        layout.getChildren().add(tNumber); 	
        tPosition.setLayoutX(xElevs + 200);	 	        
        tPosition.setLayoutY(yElevs);	 	        
        tPosition.setId("tPosition");
        layout.getChildren().add(tPosition);	
        tNextPos.setLayoutX(xElevs + 300);	 	 	        
        tNextPos.setLayoutY(yElevs);	 	 	        
        tNextPos.setId("tNextPos");
        layout.getChildren().add(tNextPos);
        tChooseNextPos.setLayoutX(xElevs + 400);	 	 	        
        tChooseNextPos.setLayoutY(yElevs);	 	 	        
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
        	tNumbers[idxElevs].setLayoutX(xElevs + 100);
        	tNumbers[idxElevs].setLayoutY(yElevs + 30*(idxElevs+1));  
        	tNumbers      [idxElevs].setId("tNumbers" + idxElevs);
        	layout.getChildren().add( tNumbers[idxElevs]);

        	tPositions[idxElevs] = new Text("99");		
        	tPositions[idxElevs].setLayoutX(xElevs + 200);
        	tPositions[idxElevs].setLayoutY(yElevs + 30*(idxElevs+1));  
        	tPositions    [idxElevs].setId("tPositions" + idxElevs);
        	layout.getChildren().add( tPositions[idxElevs]);
			
        	tNextPoses[idxElevs] = new Text("69");		
        	tNextPoses[idxElevs].setLayoutX(xElevs + 300);
        	tNextPoses[idxElevs].setLayoutY(yElevs + 30*(idxElevs+1));  
        	tNextPoses[idxElevs].setId("cbNextPoses" + idxElevs);
        	layout.getChildren().add( tNextPoses[idxElevs]);
        	
        	cbNextPoses[idxElevs] = new ChoiceBox();
        	cbNextPoses[idxElevs].setOnAction(action->actionNextPos(-1));
            for(int idxFloors = 0; idxFloors< nFloors; idxFloors++)
           	{ 	cbNextPoses[idxElevs].getItems().add("Floor "+ (nFloors - idxFloors));	       	}
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
        yFloors += 40;

        for(int idxFloors = 0; idxFloors< nFloors; idxFloors++)
       	{	floorLabels[idxFloors] = new Text(""+ (nFloors - idxFloors));
        	floorLabels[idxFloors].setLayoutX(xFloors);        	
        	floorLabels[idxFloors].setLayoutY(yFloors + idxFloors*30); 
        	floorLabels[idxFloors].setId("floorLabels"+idxFloors);
        	layout.getChildren().add(floorLabels[idxFloors]);

        	floorUpArrows[idxFloors] = new Text("▲");        		
        	floorUpArrows[idxFloors].setLayoutX(xFloors+40);        	
        	floorUpArrows[idxFloors].setLayoutY(yFloors + idxFloors*30);        	
        	floorUpArrows[idxFloors].setStyle("-fx-font: 24 arial;");
        	floorUpArrows[idxFloors].setFill(Color.RED);
        	floorUpArrows[idxFloors].setId("floorUpArrows+idxFloors");
        	layout.getChildren().add(floorUpArrows[idxFloors]);

        	floorDownArrows[idxFloors] = new Text("▼");        		
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
        
        bMode.setOnAction(	action->actionbMode() );
        bMode.setLayoutX(xElevs + wElevs - 250 );	 		        
        bMode.setLayoutY(yElevs + hElevs - 50);	 		        
        bMode.setId("bMode");
        
        tConn.setLayoutX(xElevs + wElevs - 250 );	 		        
        tConn.setLayoutY(yElevs + hElevs+50);	 		        
        tConn.setId("tConn");

        tConnState.setStyle("-fx-font: 48 arial;");	       	
        tConnState.setFill(Color.RED);
        tConnState.setId("tConnState");
        tConnState.setLayoutX(xElevs + wElevs - 120 );	 		        
        tConnState.setLayoutY(yElevs + hElevs + 60 );	 		        


        layout.getChildren().add(tFloors);        
        layout.getChildren().add(label);
        layout.getChildren().add(tMode);
        layout.getChildren().add(bMode);
        layout.getChildren().add(tConn);
        layout.getChildren().add(tConnState);
        layout.getChildren().add(tChooseNextPos);
        
        stage.setScene(scene);
        stage.show();	
    	
    }

    /*
     * @brief updates all varying GUI elements with valid elevator-data 
     * @param godObject: structure of recent valid states of elevators
     * 
     * */
    void update(Object godObject)
    {	
        /* GUI, General Elements */
    	//        tConnState = new Text("•");	// https://unicode-table.com/de/2022/

        /* GUI, Floor-wise Elements */
        for(int idxFloors = 0; idxFloors< nFloors; idxFloors++)
       	{
        //	        floorUpArrows      [idxFloors]      
        //          floorDownArrows    [idxFloors]       
       	}
    	/* GUI, Elevator-wise Elements      */
    
   
        for(int idxElevs = 0; idxElevs < nElevators; idxElevs++)
       	{
	    //    tPositions [idxElevs]
	    //    tNextPoses [idxElevs]
	    //    tDirections[idxElevs]
	    //    tPayloads [idxElevs]
	    //    tSpeeds [idxElevs]
	    //    tDoors [idxElevs]
       	}
    }
    
    
    /*
     * brief callback for the Mode-Button switching between Auto/Manual
     * 		 sets Dropdown-items for 'next Position' passive/active
     * */
    void actionbMode() 
    {	if (state)
    	{	
	        tMode.setText("Operational Mode: Automatic");
   			bMode.setText("set to Manual");
    		tConnState.setFill(Color.GREEN);
	        for(int idxElevs = 0; idxElevs < nElevators; idxElevs++)
	       	{	cbNextPoses[idxElevs].setDisable(true);				}
    	}else			 
    	{	tMode.setText("Operational Mode: Manual");
    		bMode.setText("set to Automatic");
    		tConnState.setFill(Color.RED);
	        for(int idxElevs = 0; idxElevs < nElevators; idxElevs++)
	       	{	cbNextPoses[idxElevs].setDisable(false);				}

    	}
    	state = !state;
    }

    /*
     * brief callback for the NextPos-Dropdown
     * reads every elevators chosen next-position and sends it to console/God-Object  
     * */
    void actionNextPos(int cbNextPosID) 
    {
    	for(int idxElevs = 0; idxElevs<nElevators; idxElevs++) 
    	{
    		String teng = (String) cbNextPoses[idxElevs].getValue();
    		System.out.println("actionNextPos " + teng);
    		
    	}
		System.out.println(" ");
    }
}

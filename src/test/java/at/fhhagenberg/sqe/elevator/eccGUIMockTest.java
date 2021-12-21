package at.fhhagenberg.sqe.elevator;
import at.fhhagenberg.sqe.App;
import at.fhhagenberg.sqe.elevator.backend.ElevatorWrapper;
import at.fhhagenberg.sqe.elevator.model.Elevator;
import at.fhhagenberg.sqe.elevator.model.ElevatorControlCenter;
import at.fhhagenberg.sqe.elevator.model.Floor;
import javafx.stage.Stage;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import sqelevator.IElevator;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;

@ExtendWith(ApplicationExtension.class)
@ExtendWith(MockitoExtension.class)
public class eccGUIMockTest {
	private static int defaultFloors = 8;
	private static int defaultElevators = 3;
    private static ElevatorWrapper wrappedElevator;
    private static ElevatorControlCenter ecc;
    private static eccGUI gui;
    private static App app;

    @Mock
    private static IElevator mockedIElevator = mock(IElevator.class);
    
    private void initMockNums(int elevators, int floors) throws RemoteException {
        when(mockedIElevator.getElevatorNum()).thenReturn(elevators);
        when(mockedIElevator.getFloorNum()).thenReturn(floors);
    }
    
    private void initMockElevator(int elevator, int direction, int accel, int capacity, int doorStatus, int floor, int pos, int speed, int weight, int target, List<Integer> buttons) throws RemoteException {
        when(mockedIElevator.getCommittedDirection(elevator)).thenReturn(direction);
        when(mockedIElevator.getElevatorAccel(elevator)).thenReturn(accel);
        when(mockedIElevator.getElevatorCapacity(elevator)).thenReturn(capacity);
        when(mockedIElevator.getElevatorDoorStatus(elevator)).thenReturn(doorStatus);
        when(mockedIElevator.getElevatorFloor(elevator)).thenReturn(floor);
        when(mockedIElevator.getElevatorPosition(elevator)).thenReturn(pos);
        when(mockedIElevator.getElevatorSpeed(elevator)).thenReturn(speed);
        when(mockedIElevator.getElevatorWeight(elevator)).thenReturn(weight);
        when(mockedIElevator.getTarget(elevator)).thenReturn(target);  
        for(var button : buttons ) {
        	when(mockedIElevator.getElevatorButton(elevator, button)).thenReturn(Floor.ON);
        }
    }
    
    private void initMockFloor(int floor, boolean buttonUp, boolean buttonDown, int height) throws RemoteException {
        when(mockedIElevator.getFloorButtonDown(floor)).thenReturn(buttonUp);
        when(mockedIElevator.getFloorButtonUp(floor)).thenReturn(buttonDown);
        when(mockedIElevator.getFloorHeight()).thenReturn(height);
    }
    
    private List<Integer> setButton(int min, int max) {
    	ArrayList<Integer> buttons = new ArrayList();
    	for(int i = min; i <= max; i++)
    		buttons.add(i);
    	return buttons;
    }
    
    private void defaultMockSetup() throws RemoteException {
    	defaultMockSetup(3,8);
    }
    
    private void defaultMockSetup(int elevators, int floors) throws RemoteException {
    	initMockNums(elevators, floors);
    	for(int i = 0; i < elevators; i++)
    		initMockElevator(i, Elevator.UP, 5, 100, Elevator.CLOSED, 1, 100, 10, 100, 5, setButton(3, 4));
    	for(int i = 0; i < floors; i++)
    		initMockFloor(i, false, false, 100);
    }
    
    @Start
    public void start(Stage stage) throws RemoteException{
    	defaultMockSetup();
    	
    	// ANFANG -- solange main nicht funktionert //
    	wrappedElevator = new ElevatorWrapper(mockedIElevator);
    	ecc = new ElevatorControlCenter(wrappedElevator);
    	// ENDE //
    	
        var app = new App();
        app.gui = new eccGUI(ecc , 1280, 960);
        app.start(stage);
    }
    
    @Test
    public void testDefaultGui(FxRobot robot) throws RemoteException {
    	robot.clickOn("set to Auto");
    }

}

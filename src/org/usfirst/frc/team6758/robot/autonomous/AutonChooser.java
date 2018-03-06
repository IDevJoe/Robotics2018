package org.usfirst.frc.team6758.robot.autonomous;

import org.usfirst.frc.team6758.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 *
 */
public class AutonChooser {

	protected String message, locations;
	protected char switchPosition;
	protected int location = -1, position;
	
	private SendableChooser<Command> m_chooser = new SendableChooser<>();
	private SendableChooser<Integer> locationChooser = new SendableChooser<>();

	public AutonChooser() {
		position = DriverStation.getInstance().getLocation();
	}
	
	public SendableChooser<Command> makeAuton(){
    	DriverStation.getInstance().waitForData();
    	message = DriverStation.getInstance().getGameSpecificMessage();
    	location = Robot.locationChooser.getSelected();
    	if(location == -1) return m_chooser;
    	if(message != null) switchPosition = message.charAt(0);
    	
    	locations = location + (switchPosition + "");
    	
    	m_chooser.addDefault("POSITION " + location + " | SWITCH " + switchPosition, new Nothing());
    	switch(locations) {
    	case "1L":
    		m_chooser.addObject("Position 1 Switch", new Pos1Switch(switchPosition));
    		m_chooser.addObject("Drive Clock" , new DriveClock(10, false));
    		m_chooser.addObject("Drive Counter", new DriveCounter(5, false));
    		m_chooser.addObject("Simple Auton", new SimpleAuton());
    		m_chooser.addObject("Encoders", new EncAutonSwitch());
    		//m_chooser.addObject("", new EncAutonLine());
    		break;
    	case "1R":
    		m_chooser.addObject("Position 1 Switch Time", new Pos1Switch(switchPosition));
    		//m_chooser.addObject("Position 1 Encoder", new EncAutonSwitch(switchPosition));
    		break;
    	case "2L":
    		m_chooser.addObject("Position 2 Switch Time", new Pos2Switch(switchPosition));
    		break;
    	case "2R":
    		m_chooser.addObject("Position 2 Switch Time", new Pos2Switch(switchPosition));
    		break;
    	case "3L":
    		m_chooser.addObject("Position 3 Switch Time", new Pos3Switch(switchPosition));
    		break;
    	case "3R":
    		m_chooser.addObject("Position 3 Switch Time", new Pos3Switch(switchPosition));
    		break;
    	default:
    		m_chooser.addObject("No route: " + location+" , "+switchPosition, new Nothing());
    		break;
    	}
    	
		return m_chooser;
    }
	
	public SendableChooser<Integer> makeLocations(){
		
		locationChooser.addDefault("CURRENT POSITION: " + position + "", position);
		locationChooser.addObject("Position 1", 1);
		locationChooser.addObject("Position 2", 2);
		locationChooser.addObject("Position 3", 3);
		
		
		return locationChooser;
	}
}

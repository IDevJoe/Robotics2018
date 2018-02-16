package org.usfirst.frc.team6758.robot.subsystems;

import org.usfirst.frc.team6758.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {

	public static DoubleSolenoid grabber = new DoubleSolenoid(RobotMap.solenoidPortA, RobotMap.solenoidPortB);
	
    public void initDefaultCommand() {
        
    }
    
    public static void clampBox() {
    	grabber.set(DoubleSolenoid.Value.kForward);
    }
    public static void releaseBox() {
    	grabber.set(DoubleSolenoid.Value.kReverse);
    }
    public static void off() {
    	grabber.set(DoubleSolenoid.Value.kOff);
    }
    
}


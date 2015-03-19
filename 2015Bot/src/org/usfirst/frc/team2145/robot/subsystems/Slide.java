package org.usfirst.frc.team2145.robot.subsystems;

import org.usfirst.frc.team2145.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team2145.robot.commands.ExtendWithController;



public class Slide extends Subsystem{
	Compressor comp = new Compressor(RobotMap.compressor);
	Talon slideMotor = new Talon(RobotMap.slideMotor);
	Solenoid armSolenoid = new Solenoid(0);
	
	//DigitalInput extendSwitch = new DigitalInput(RobotMap.extendSwitch);
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ExtendWithController());
    }
    public void extendWithController(double extendSpeed){
    	slideMotor.set(extendSpeed);
    }
    public void startCompressor(){
    	comp.start();
    	comp.setClosedLoopControl(true);
    }
    public void Shoot(){
    	armSolenoid.set(true);
    }
    public void Stop(){
    	armSolenoid.set(false);
    	
    }
    //public boolean doesExtenderHaveTote(){
    	//return extendSwitch.getChannel() == 1;
    //}
}

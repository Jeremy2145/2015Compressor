package org.usfirst.frc.team2145.robot.subsystems;

import org.usfirst.frc.team2145.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2145.robot.commands.ExtendWithController;


public class Slide extends Subsystem{
	Compressor comp = new Compressor(RobotMap.compressor);
	Talon slideMotor = new Talon(RobotMap.slideMotor);
	Solenoid armSolenoid = new Solenoid(0);
	DigitalInput liftBottom = new DigitalInput(9);
	AnalogInput lightSensor = new AnalogInput(2);
	Encoder liftEncoder = new Encoder(4, 5);
	
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
    public boolean liftStop(){
    	return liftBottom.get();
    }
    public double lightValue(){
    	return lightSensor.getVoltage();
    }
    public void log(){
    	SmartDashboard.putNumber("LightValue", lightValue());
    	SmartDashboard.putBoolean("liftSwitch", liftStop());
    }
	public void liftEncoderReset(){
		liftEncoder.reset();
	}
	public double liftEncoder(){
		double liftEncoderAverage = liftEncoder.getDistance();
		liftEncoderAverage = (liftEncoderAverage / 53.700085025134623129819955548263);
		return (liftEncoderAverage);
	}
    //public boolean doesExtenderHaveTote(){
    	//return extendSwitch.getChannel() == 1;
    //}
}

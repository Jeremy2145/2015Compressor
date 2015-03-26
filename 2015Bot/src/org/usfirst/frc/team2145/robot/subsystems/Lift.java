package org.usfirst.frc.team2145.robot.subsystems;


import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TalonSRX;

import org.usfirst.frc.team2145.robot.RobotMap;

public class Lift extends PIDSubsystem {
	
	TalonSRX liftMotor = new TalonSRX(RobotMap.liftMotor);
	
	

	@Override
	protected void initDefaultCommand() {
		
	}
	public Lift() {
		super(2, 0.07, 0);
		setAbsoluteTolerance(0.05);
		getPIDController().setContinuous(false);
	}
	
	public void liftDrive(double liftSpeed) {
		liftMotor.set(liftSpeed);
	
	}
	
	protected void usePIDOutput(double output) {
		liftMotor.set(output);
	}
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
}

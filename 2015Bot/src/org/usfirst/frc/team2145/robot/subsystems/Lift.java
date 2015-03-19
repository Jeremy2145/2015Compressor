package org.usfirst.frc.team2145.robot.subsystems;


import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TalonSRX;

import org.usfirst.frc.team2145.robot.RobotMap;

public class Lift extends PIDSubsystem {
	
	TalonSRX liftMotor = new TalonSRX(RobotMap.liftMotor);
	Encoder liftEncoder = new Encoder(RobotMap.liftEncoder1, RobotMap.liftEncoder2);
	DigitalInput homeSwitch = new DigitalInput(RobotMap.liftHomeSwitch1);

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
	@Override
	protected double returnPIDInput() {
		return liftEncoder.getDistance();
	}
	@Override
	protected void usePIDOutput(double output) {
		liftMotor.set(output);
	}
	public double liftEncoder(){
		double liftEncoderAverage = liftEncoder.getDistance();
		liftEncoderAverage = (liftEncoderAverage / 53.700085025134623129819955548263);
		return (liftEncoderAverage);
	}
	public void liftEncoderReset(){
		liftEncoder.reset();
	} 
	
	public boolean homeSwitchValue(){
		return homeSwitch.get();
	}
	public boolean isLiftAtHome(){
		return homeSwitch.get() == true;
	}
	
}

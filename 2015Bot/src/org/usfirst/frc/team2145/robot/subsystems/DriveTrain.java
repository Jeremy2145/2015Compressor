package org.usfirst.frc.team2145.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;


import org.usfirst.frc.team2145.robot.RobotMap;
import org.usfirst.frc.team2145.robot.commands.DriveWithController;
import edu.wpi.first.wpilibj.smartdashboard.*;



public class DriveTrain extends PIDSubsystem{
	
	TalonSRX frontRightWheel = new TalonSRX(RobotMap.frontRightWheel);
	TalonSRX frontLeftWheel = new TalonSRX(RobotMap.frontLeftWheel);
	TalonSRX backRightWheel = new TalonSRX(RobotMap.backRightWheel);
	TalonSRX backLeftWheel = new TalonSRX(RobotMap.backLeftWheel);
	
	Encoder backRightEncoder = new Encoder(RobotMap.backRightEncoder1,RobotMap.backRightEncoder2);
	Encoder backLeftEncoder= new Encoder(RobotMap.backLeftEncoder1,RobotMap.backLeftEncoder2);
	
	
	Gyro gyro = new Gyro(RobotMap.driveGyro);
	
	PIDController encoderPID;
	PIDSource ePIDSource;
	PIDOutput ePIDOutput;
	
	
	
	
	
	public DriveTrain() {
		super("DriveTrain", 2, 0, 0);
		setAbsoluteTolerance(0.05);
		getPIDController().setContinuous(false);
		
	}
	
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
       setDefaultCommand(new DriveWithController());
    }
	

	
	protected double returnPIDInput(){
		return (backRightEncoder.getDistance() + backLeftEncoder.getDistance() / 2);
	} 
	
	protected void usePIDOutput(double output){
		
		frontRightWheel.pidWrite(output);
		frontLeftWheel.pidWrite(output);
		backRightWheel.pidWrite(output);
		backLeftWheel.pidWrite(output);
	}
	
	public void MecanumDrive (double X,double Y,double Z) {
	   
		double forward= Y;
		double right= X;
		double clockwise= Z;
		//frontLeftWheel.enableControl();
		
		//Gets Directions like from Joy Sticks.
		
		double front_left = forward + clockwise + right;
		double front_right = forward - clockwise- right;
		double rear_left = forward + clockwise - right;
		double rear_right = forward - clockwise + right;
		//Kinetic Data for Mech Wheels
		
		double max = Math.abs(front_left);
		if (Math.abs(front_right)>max) max=Math.abs(front_right);
		if (Math.abs(rear_left)>max) max= Math.abs(rear_left);
		if (Math.abs(rear_right)>max) max= Math.abs(rear_right);
		//Determines highest going Motor
		
		if (max>1)
		{front_left/=max; front_right/=max; rear_left/=max; rear_right/=max;}
		//Makes it so none can be above 1
		
		frontRightWheel.set(front_right);
		frontLeftWheel.set(-front_left);
		backRightWheel.set(rear_right);
		backLeftWheel.set(-rear_left);
		//Sends Data to Talons
	}
	
	
	public double logDrive(){
		double encoderAverage = backLeftEncoder.getDistance();
		encoderAverage= (encoderAverage /14.331210191082802547770700636943);
		return encoderAverage;
		
	}
	
	public void log(){
		SmartDashboard.putNumber("Encoder", encoderValue());
		
		//SmartDashboard.putNumber("Lift Encoder", liftEncoder.getDistance());
	}

	public void encoderReset(){
		backRightEncoder.reset();
		backLeftEncoder.reset();
	}
	
	public double gyroValue(){
		return (gyro.getAngle() * 2);
	}
	
	public void gyroReset(){
		gyro.reset();
	}
	
	public double encoderValue(){
		double encoderAverage = ((backRightEncoder.getDistance() + backLeftEncoder.getDistance()) /2);
		encoderAverage= (encoderAverage /14.331210191082802547770700636943);
		return encoderAverage;
	}
	

	
	public double leftEncoderValue(){
		return backLeftEncoder.getDistance() / 14.331210191082802547770700636943;
	}
	
	public double rightEncoderValue(){
		return backRightEncoder.getDistance() / 14.331210191082802547770700636943;
	}
	
}
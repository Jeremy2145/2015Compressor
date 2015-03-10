package org.usfirst.frc.team2145.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2145.robot.Robot;

public class DriveStraight extends Command {
	private double distance;
	public DriveStraight(double carp) {
		this.distance = carp;
        requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
		Robot.driveTrain.encoderReset();
		Robot.driveTrain.gyroReset();
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Target Distance", distance);
		SmartDashboard.putNumber("Gyro", Robot.driveTrain.gyroValue());
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.rightEncoderValue());
		if(Robot.driveTrain.rightEncoderValue() > distance){
			Robot.driveTrain.MecanumDrive(0, -0.3, 0);
		}
		else{
			Robot.driveTrain.MecanumDrive(0, 0, 0);
		}
		}
		/*if(Robot.driveTrain.gyroValue() != 0){
				
				if(Robot.driveTrain.gyroValue() < 0){
					Robot.driveTrain.MecanumDrive(0, 0, -0.3);
				}
				
				if(Robot.driveTrain.gyroValue() > 0){
					Robot.driveTrain.MecanumDrive(0, 0, 0.3);
				}
				
			}
			else{
				Robot.driveTrain.MecanumDrive(0, 0, 0);
			}*/
	

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
        Robot.driveTrain.MecanumDrive(0, 0, 0);
	}

	@Override
	protected void interrupted() {
		
	}

}

package org.usfirst.frc.team2145.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2145.robot.Robot;

public class DriveStraight extends Command {
	
	Timer time = new Timer();
	public DriveStraight() {
        requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
		Robot.driveTrain.encoderReset();
		Robot.driveTrain.gyroReset();
		time.start();
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Timer", time.get());
		SmartDashboard.putNumber("Gyro", Robot.driveTrain.gyroValue());
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.rightEncoderValue());
		if(time.get() < 20){
			Robot.driveTrain.MecanumDrive(0, 0.5, 0);
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
        
	}

	@Override
	protected void interrupted() {
		
	}

}

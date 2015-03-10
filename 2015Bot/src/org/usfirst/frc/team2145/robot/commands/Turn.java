package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Turn extends Command{
	
	private double angle;

	public Turn(double fish){
		this.angle = fish;
		requires(Robot.driveTrain);
		

	}	
	@Override
	protected void initialize() {
		Robot.driveTrain.gyroReset();
	}
	
	@Override
	protected void execute() {
		SmartDashboard.putNumber("Target Angle", angle);
		SmartDashboard.putNumber("Gyro", Robot.driveTrain.gyroValue());
		
		if(Robot.driveTrain.gyroValue()< (angle - 5) || Robot.driveTrain.gyroValue() > (angle + 5)){
			if( Robot.driveTrain.gyroValue() > angle  ){
				Robot.driveTrain.MecanumDrive(0, 0, 0.25);	
			}
			if(Robot.driveTrain.gyroValue() < angle){
				Robot.driveTrain.MecanumDrive(0, 0, -0.25);
			}
		}
		else{
			Robot.driveTrain.MecanumDrive(0, 0, 0);
		}
	}

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

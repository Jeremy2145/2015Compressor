package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous extends Command {
	Timer time = new Timer();
	public Autonomous() {
		requires(Robot.driveTrain);
		requires(Robot.slide);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		time.start();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		SmartDashboard.putNumber("Timer", time.get());
		if(time.get() < 3){
			Robot.slide.extendWithController(-0.5);
		}
		else{
			Robot.slide.extendWithController(0);
		}
		if(time.get()< 4.5 && time.get() > 3){
			Robot.driveTrain.MecanumDrive(0.1, 0.5, 0);
		}
		else{
			Robot.driveTrain.MecanumDrive(0, 0, 0);
		}
		if(time.get() < 7.5 && time.get() > 4.5){
			Robot.slide.extendWithController(0.5);
		}
		if(time.get() < 8 && time.get() > 7.5){
			Robot.driveTrain.MecanumDrive(0.1, 0.5, 0);
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}	
}
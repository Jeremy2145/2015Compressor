package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command{

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.slide.Shoot();
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.slide.Stop();
	}
	
	@Override
	protected void interrupted() {
		
	}

}

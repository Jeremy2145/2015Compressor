package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.command.Command;

public class LiftToTop extends Command{
	Timer time = new Timer();
	public LiftToTop() {
        requires(Robot.slide);
    }
	@Override
	protected void initialize() {
		time.start();
	}

	@Override
	protected void execute() {
		if(time.get() < 3){
			Robot.slide.extendWithController(-0.5);
		}
		else{
			Robot.slide.extendWithController(0);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {	
		time.reset();
	}

	@Override
	protected void interrupted() {
		
	}

}

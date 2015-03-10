package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftToHome extends Command{
	public LiftToHome() {
        
        requires(Robot.lift);
    }
	@Override
	protected void initialize() {
		Robot.lift.liftEncoderReset();
	}

	@Override
	protected void execute() {
		if(Robot.lift.homeSwitchValue()){
			Robot.lift.liftDrive(-0.7);
		}
		else{
			Robot.lift.liftDrive(0);
		}
	}

	@Override
	protected boolean isFinished() {
		return Robot.lift.isLiftAtHome();
	}

	@Override
	protected void end() {
		
		
	}

	@Override
	protected void interrupted() {
		
		
	}

}

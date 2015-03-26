package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftToHome extends Command{
	public LiftToHome() {
        
        requires(Robot.slide);
    }
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Lift Encoder", Robot.slide.liftEncoder());
		if(Robot.slide.liftStop() == false){
			Robot.slide.extendWithController(0.5);
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
		
		
	}

	@Override
	protected void interrupted() {
		
		
	}

}

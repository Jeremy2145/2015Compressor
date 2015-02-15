package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;

public class Turn extends Command{
	private PIDController pid;
	public Turn(double angle){
		requires(Robot.driveTrain);
        pid = new PIDController(0.666, 0, 0,
                new PIDSource() { public double pidGet() {
                    return Robot.driveTrain.gyroValue();
                }},
                new PIDOutput() { public void pidWrite(double d) {
                    Robot.driveTrain.MecanumDrive(0, 0, d);;
                    pid.setOutputRange(-0.25, 0.25);
                    /*if(Robot.driveTrain.gyroValue()!= 0){
                    	if(Robot.driveTrain.gyroValue() > 90){
                    		Robot.driveTrain.MecanumDrive(0, d * 0.25, -0.3);
                    	}
                    	if(Robot.driveTrain.gyroValue() < 90){
                    		Robot.driveTrain.MecanumDrive(0, d * 0.25, 0.3);
                    	}
                    }*/
                }});
        pid.setPercentTolerance(1);
        
        pid.setSetpoint(angle);
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.gyroReset();
		Robot.driveTrain.encoderReset();
		
	}
	
	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return pid.onTarget();
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}

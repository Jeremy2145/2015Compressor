package org.usfirst.frc.team2145.robot.commands;

import org.usfirst.frc.team2145.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Strafe extends Command{
	private double distance;
	//private PIDController pid;
	public Strafe(double carp){
		this.distance = carp;
		requires(Robot.driveTrain);
		/*pid = new PIDController(0, 0, 0,
                new PIDSource() { public double pidGet() {
                    return Robot.driveTrain.leftEncoderValue();
                }},
                new PIDOutput() { public void pidWrite(double d) {
                    Robot.driveTrain.MecanumDrive(d, 0, 0);;
                    
                    
                }});
        pid.setAbsoluteTolerance(1);
        
        pid.setSetpoint(distance);
	*/
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.encoderReset();
		Robot.driveTrain.gyroReset();
		//pid.reset();
        //pid.enable();
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Target Distance", distance);
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.rightEncoderValue());
		SmartDashboard.putNumber("Gyro", Robot.driveTrain.gyroValue());
		
		while( Robot.driveTrain.rightEncoderValue()< (distance - 3) || Robot.driveTrain.rightEncoderValue() > (distance + 3) && Robot.driveTrain.gyroValue() != 0){
			
			if( Robot.driveTrain.rightEncoderValue() > distance && Robot.driveTrain.gyroValue() > 0 ){
				Robot.driveTrain.MecanumDrive(0.4, -0.06, 0.12);	
			}
			if(Robot.driveTrain.rightEncoderValue() < distance && Robot.driveTrain.gyroValue() < 0){
				Robot.driveTrain.MecanumDrive(-0.4, -0.06, -0.12);
			}
			if( Robot.driveTrain.rightEncoderValue() > distance && Robot.driveTrain.gyroValue() < 0 ){
				Robot.driveTrain.MecanumDrive(0.4, -0.06, -0.12);	
			}
			if( Robot.driveTrain.rightEncoderValue() < distance && Robot.driveTrain.gyroValue() > 0 ){
				Robot.driveTrain.MecanumDrive(-0.4, -0.06, 0.12);	
			}
		
		}
		if(Robot.driveTrain.gyroValue() != 0){
				
				if(Robot.driveTrain.gyroValue() < 0){
					Robot.driveTrain.MecanumDrive(0, 0, -0.3);
				}
				
				if(Robot.driveTrain.gyroValue() > 0){
					Robot.driveTrain.MecanumDrive(0, 0, 0.3);
				}
				
			}
			else{
				Robot.driveTrain.MecanumDrive(0, 0, 0);
			}
		}
		
			
			
		
		
	
	
	@Override
	protected boolean isFinished() {	
		return false; //pid.onTarget();
	}

	@Override
	protected void end() {
		//pid.disable();
		
	}

	@Override
	protected void interrupted() {
		
	}

}

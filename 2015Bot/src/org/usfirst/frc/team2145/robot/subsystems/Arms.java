package org.usfirst.frc.team2145.robot.subsystems;

import org.usfirst.frc.team2145.robot.RobotMap;
import org.usfirst.frc.team2145.robot.commands.ArmWithController;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arms extends Subsystem{
	TalonSRX armMotor = new TalonSRX(RobotMap.armMotor);
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmWithController());
	}
	public void setMotor(double x){
		armMotor.set(x);
	}

}

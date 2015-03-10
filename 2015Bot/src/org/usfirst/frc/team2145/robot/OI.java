package org.usfirst.frc.team2145.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick stick = new Joystick(0);
	Joystick stick2 = new Joystick(1);
	Button button = new JoystickButton(stick, 1);
	
	
	
	
	
	
	public double StickY () {
		return stick.getRawAxis(1);
	}
	public double Stick2Y () {
		return stick2.getRawAxis(1);
	}
	public double Stick2Y2 () {
		return stick2.getRawAxis(5);
	}
	
	public double StickX () {
		return -(stick.getRawAxis(0));
	} 
	
	public double StickZ () {
		return stick.getRawAxis(2) - stick.getRawAxis(3);
	} 
	public double StickY2(){
		return stick.getRawAxis(5);
	}
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}


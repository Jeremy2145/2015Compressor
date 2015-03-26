package org.usfirst.frc.team2145.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
		//PWN Inputs
		public static int liftMotor = 1;
	    public static int slideMotor = 0;
	    public static int frontLeftWheel = 20;
	    public static int frontRightWheel = 21;
	    public static int backLeftWheel = 22;
	    public static int backRightWheel = 23;
	    public static int armMotor = 6;
	    //public static int armSolenoid1 = 7;
	    //public static int armSolenoid2 = 8;
	    //public static int  = 6;
	    //public static int  = 7;
	    //public static int  = 8;
	    //public static int  = 9;
	    
	    //DIO Inputs
	    public static int backLeftEncoder1 = 0;
	    public static int backLeftEncoder2 = 1;
	    public static int backRightEncoder1 = 2;
	    public static int backRightEncoder2 = 3;
	    public static int liftEncoder1 = 4;
	    public static int liftEncoder2 = 5;
	    public static int liftHomeSwitch1 = 9;
	    
	    //public static int rightBackEncoder2 = 10;
	    //public static int rightBackEncoder2 = 11;
	    
	    //Analog
	    public static int driveGyro = 1;
	    //public static int  = 1;
	    //public static int  = 2;
	    //public static int  = 3;

	    //PCM
	    public static int compressor = 0;

	    // If you are using multiple modules, make sure to define both the port
	    // number and the module. For example you with a rangefinder:
	    // public static int rangefinderPort = 1;
	    // public static int rangefinderModule = 1;
}

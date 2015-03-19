
package org.usfirst.frc.team2145.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2145.robot.commands.Autonomous;
import org.usfirst.frc.team2145.robot.subsystems.Arms;
import org.usfirst.frc.team2145.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2145.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2145.robot.subsystems.Lift;
import org.usfirst.frc.team2145.robot.subsystems.Slide;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;




/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static DriveTrain driveTrain;
	public static OI oi;
	public static Lift lift;
	public static Slide slide;
	public static Arms arm;
	
	int session;
    Image frame;
	
	
    Command autonomousCommand;
    
    public Robot(){
    	
        
    }
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	driveTrain = new DriveTrain();
    	lift = new Lift();
    	slide = new Slide();
		oi = new OI();
        // instantiate the command used for the autonomous period
        autonomousCommand = new Autonomous();
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera("cam1",
        NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        
        
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		log();
		NIVision.IMAQdxStartAcquisition(session);
		NIVision.IMAQdxGrab(session, frame, 1);
        CameraServer.getInstance().setImage(frame);
        
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        log();
        NIVision.IMAQdxStartAcquisition(session);
		NIVision.IMAQdxGrab(session, frame, 1);
		
        CameraServer.getInstance().setImage(frame);
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
        NIVision.IMAQdxStartAcquisition(session);
		NIVision.IMAQdxGrab(session, frame, 1);
		
        CameraServer.getInstance().setImage(frame);
        Robot.slide.startCompressor();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
        log();
        NIVision.IMAQdxStartAcquisition(session);
		NIVision.IMAQdxGrab(session, frame, 1);
        CameraServer.getInstance().setImage(frame);
    }
    private void log() {
        driveTrain.log();
    }
        
}

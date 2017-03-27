package org.usfirst.frc.team6070.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6070.robot.*;

/**
 *
 */
public class AutoDrive extends Command {
	
	Timer mytimer;
	double timeout;
	
    public AutoDrive(double timeout) {
    	//requires (Robot.DriveBase);
    	this.timeout = timeout;
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DriveBase.driveStraight();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DriveBase.stop();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
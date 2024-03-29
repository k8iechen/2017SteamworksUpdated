package org.usfirst.frc.team6070.robot.commands;

import org.usfirst.frc.team6070.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	@author Nafeh Shoaib
 */
public class AutoDriveWithGyro extends Command {

	double timeout;
	double angle;
	boolean reverse;
    public AutoDriveWithGyro(boolean reverse, double angle, double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DriveBase);
    	this.timeout = timeout;
    	this.angle = angle;
    	this.reverse = reverse;
    }
    
    public AutoDriveWithGyro() {
    	requires(Robot.DriveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.DriveBase.driveStraightWithGyro(reverse, angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

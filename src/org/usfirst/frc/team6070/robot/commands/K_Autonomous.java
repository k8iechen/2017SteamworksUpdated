package org.usfirst.frc.team6070.robot.commands;

import org.usfirst.frc.team6070.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Right Side Autonomous for Blue
 *	@author Kshitij Vaditya
 */
public class K_Autonomous extends CommandGroup {
    
	int driver = 1;
    public  K_Autonomous() {
        
    	if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Blue) {
    		driver = -1;
    	}
    	
    	// move initial distance
    	//addSequential(new AutoDrive(RobotMap.forwardval)); // <--- wtf
    	addSequential(new AutoDrive(104.0, RobotMap.forwardval, 0.0, false));
    	// turn to 60 degrees (left on red, right on blue)
    	//to line up with airship
		addSequential(new AutoTurn(-RobotMap.turnangle, 2));
		
    	addSequential (new AutoDrive(1)); // drive into the lift
    	//Gear
    	
    	addSequential(new AutoGearing());
    	
    	addParallel(new AutoGearingBackSlow(3.25)); // Nafeh added this. TIGER CHECK THIS.
    	addSequential (new AutoDrive(1, true)); // back away
    	addSequential(new AutoTurn(0, 2)); // turn parallel to the airship, facing the neutral zone
    	addSequential(new AutoDrive(5.5)); // clear the airship
    	//addSequential(new AutoTurn(0, 2)); // turn towards the retrieval zone
    	//addSequential (new AutoDrive(3.5)); // drive
        	
    	// On red side (starting on the right), go straight, angle into gear, back out, go forward
    	//Then align with retreval zone, drive as far in the netural zone
    	//On blue side (starting on the left, because the map if mirrored) and same steps^
    	
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}

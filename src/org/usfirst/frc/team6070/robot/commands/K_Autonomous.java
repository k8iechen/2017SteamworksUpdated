package org.usfirst.frc.team6070.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class K_Autonomous extends CommandGroup {
    
	boolean driver = false;
    public  K_Autonomous() {
        
    	if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Blue) {
    		driver = true;
    	}
    	
    	addSequential (new AutoDrive (2.4));
    
    	
    	if (driver){
    		addSequential (new AutoTurn(-28, 1)); 
    		addSequential ((new AutoDrive(1.5)));
    		// Gear Here
    		//addSequential (new AutoGearing());
    		addSequential (new AutoDrive(0.6));
    		addSequential (new AutoTurn(62, 2));
    		addSequential ((new AutoDrive(3)));
    		addSequential (new AutoTurn(-41.92, 2));
    		addSequential ((new AutoDrive(10)));
    		
    	}
    	else {
    		addSequential (new AutoTurn(28, 1)); 
    		addSequential ((new AutoDrive(1.5)));
    		// Gear Here
    		//addSequential (new AutoGearing());
    		addSequential (new AutoDrive(0.6));
    		addSequential (new AutoTurn(-62, 2));
    		addSequential ((new AutoDrive(3)));
    		addSequential (new AutoTurn(41.92, 2));
    		addSequential ((new AutoDrive(10)));
    		
    		
    		}
    	
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

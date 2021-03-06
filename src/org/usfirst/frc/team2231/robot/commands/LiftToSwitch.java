package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftToSwitch extends Command {
    // Called just before this Command runs the first time

    // Called repeatedly when this Command is scheduled to run
	
	public LiftToSwitch() {
        requires(Robot.m_elevator);
    }
	
	@Override
	protected void initialize() {
    	Robot.m_elevator.setHeight(Robot.m_robotMap.switchHeight);
		Robot.m_elevator.enablePIDController();
	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println(Robot.m_elevator.isLiftOnTarget());
        return Robot.m_elevator.isLiftOnTarget();
    }
    
    @Override
    protected void end() {
    	Robot.m_elevator.disablePIDController();
    }
    
    @Override
    protected void interrupted() {
    	end();
    }
}

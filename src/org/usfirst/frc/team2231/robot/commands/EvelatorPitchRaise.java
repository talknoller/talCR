package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class EvelatorPitchRaise extends Command {
	private static final double SPEED = -0.8;

    public EvelatorPitchRaise() {
    	requires(Robot.m_elevatorPitch);
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_elevatorPitch.setSpeed(SPEED);    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_elevatorPitch.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}

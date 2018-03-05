package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Potentiometer;
import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LifToSwitch extends Command {
	double voltage;
	double switchHeight = Robot.m_robotMap.switchHeight;

    public LifToSwitch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	voltage = Potentiometer.getFixedVoltage(switchHeight);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_elevator.setHeight(switchHeight);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
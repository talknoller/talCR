package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class RotateByNavX extends Command {
	double m_setpoint;

    public RotateByNavX(double setpoint) {
    	this.m_setpoint = setpoint;
    	requires(Robot.m_driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.m_driveTrain.setRotationSetpoint(Robot.m_driveTrain.getAngle() + m_setpoint);
    	Robot.m_driveTrain.setOutputRange();
    	Robot.m_driveTrain.setRotationTolerance();
    	Robot.m_driveTrain.enableRotationPIDControllers();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.m_driveTrain.isRotationPIDOnPoint();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_driveTrain.disableRotationPIDControllers();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

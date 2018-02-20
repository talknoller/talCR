// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team2231.robot.subsystems;

import org.usfirst.frc.team2231.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Elevator extends Subsystem {
    private final SpeedControllerGroup elevatorWheels = Robot.m_robotMap.elevatorWheels;
    private final WPI_TalonSRX firstMotor = Robot.m_robotMap.elevatorFirstMotor;
    private final WPI_VictorSPX secondMotor = Robot.m_robotMap.elevatorSecondMotor;
    private final WPI_VictorSPX thirdMotor = Robot.m_robotMap.elevatorThirdMotor;
    private final WPI_VictorSPX fourthMotor = Robot.m_robotMap.elevatorFourthMotor;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    @Override
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void setSpeed(double speed) {
    	if (firstMotor.getSensorCollection().isFwdLimitSwitchClosed() && speed < 0) {
    		firstMotor.set(0);
        	secondMotor.set(ControlMode.Follower, firstMotor.getDeviceID());
        	thirdMotor.set(ControlMode.Follower, firstMotor.getDeviceID());
        	fourthMotor.set(ControlMode.Follower, firstMotor.getDeviceID());
    	}
    	else if (firstMotor.getSensorCollection().isRevLimitSwitchClosed() && speed > 0) {
    		firstMotor.set(0);
    		secondMotor.set(ControlMode.Follower, firstMotor.getDeviceID());
    		thirdMotor.set(ControlMode.Follower, firstMotor.getDeviceID());
    		fourthMotor.set(ControlMode.Follower, firstMotor.getDeviceID());
    	}
    	else {
    		firstMotor.set(speed);
        	secondMotor.set(ControlMode.Follower, firstMotor.getDeviceID());
        	thirdMotor.set(ControlMode.Follower, firstMotor.getDeviceID());
        	fourthMotor.set(ControlMode.Follower, firstMotor.getDeviceID());
    	}
}
    
    public void stop() {
    	elevatorWheels.set(0);
    }
    
}

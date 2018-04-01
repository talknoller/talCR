package org.usfirst.frc.team2231.robot.subsystems;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.commands.KeepPitchInPlace;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorPitch extends Subsystem {
    public final WPI_TalonSRX pitchMotor = Robot.m_robotMap.elevatorPitchMotor;
    private final DigitalInput bumperSwitch = Robot.m_robotMap.collectorBumperSwitch;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new KeepPitchInPlace());
    }
    
    public void setSpeed(final double speed){
    	pitchMotor.set(speed);
    }
    
    public void stop() {
    	pitchMotor.set(0);
    }
    
    public boolean isPressed() {
    	return bumperSwitch.get();
    }
}


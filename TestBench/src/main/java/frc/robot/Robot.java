// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   * 
   * 
   */
  CANSparkMax lt = new CANSparkMax(1, MotorType.kBrushless); // Left Tank
  CANSparkMax rt = new CANSparkMax(2, MotorType.kBrushless); // Right Tank
  CANSparkMax lw = new CANSparkMax(3, MotorType.kBrushless); // Left Weapon
  CANSparkMax rw = new CANSparkMax(4, MotorType.kBrushless); // Right Weapon

  // Hopefully

  XboxController controller = new XboxController(0);
  DifferentialDrive driveTrain = new DifferentialDrive(lt, rt);

  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {

    driveTrain.tankDrive(0.7, 0.7);
    driveTrain.tankDrive(0.7, -0.7);
    


  }

  @Override
  public void teleopInit() {



  }

  @Override
  public void teleopPeriodic() {
    
    driveTrain.tankDrive(Math.pow(controller.getLeftY(), 3), Math.pow(-controller.getRightY(), 3));

    lw.set(controller.getRightTriggerAxis());


    // Weapons
    if (controller.getXButtonPressed()) {

      lw.set(0.8);   
      rw.set(0.8);
      lw.set(0);   
      rw.set(0);
      
    }

    if (controller.getXButtonReleased()) {

      lw.set(-0.8);   
      rw.set(-0.8);
      lw.set(0);   
      rw.set(0);  
  
   }




  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {

  }

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}

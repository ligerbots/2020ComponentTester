/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.RunWinch;

//import edu.wpi.first.wpilibj.XboxController; will need later
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.GenericHID.Hand;

@SuppressWarnings("all")
/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final DriveTrain robotDrive = new DriveTrain();
  private final Throttle throttle = new Throttle();
  private final Turn turn = new Turn();
  private final Climb climb = new Climb();
  XboxController xbox = new XboxController(0);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  public class Throttle implements DoubleSupplier{

    @Override
    public double getAsDouble() {
      return -xbox.getY(Hand.kLeft);
    }
  }

  public class Turn implements DoubleSupplier{

    @Override
    public double getAsDouble() {
      return xbox.getX(Hand.kRight);
    }
  }

  public class Climb implements DoubleSupplier{

    @Override
    public double getAsDouble() {
      
      return xbox.getTriggerAxis(Hand.kRight) - xbox.getTriggerAxis(Hand.kLeft);
    }
  }



  // foo foo
  private void configureButtonBindings() {
    JoystickButton xboxA = new JoystickButton(xbox, 1);
    JoystickButton xboxB = new JoystickButton(xbox, 2);
    xboxA.whenPressed(new RunWinch()); //run winch
    JoystickButton xboxLine = new JoystickButton(xbox, 8);
    //xboxA.whenPressed(new ClimberCommand()); //shootercomand
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;




/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  public static TalonSRX wheel1;
  public static TalonSRX wheel2;
  public static TalonSRX wheel3;
  
  public static TalonSRX feeder1;
  public static TalonSRX feeder2;
  public static TalonSRX feeder3;

  public static CANSparkMax shoulder;
  public static CANSparkMax winch;

  public static CANSparkMax shooter1;
  public static CANSparkMax shooter2;
  public static CANSparkMax shooter3;

  public static RunShooter shooterCommand;
  public static RunIntake intakeCommand;
  public static RunShoulder runShoulder;
  public static RunWinch runWinch;
  XboxController xbox = new XboxController(0);
  

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);


    shoulder = new CANSparkMax(9,MotorType.kBrushless);
    winch = new CANSparkMax(10,MotorType.kBrushless);

    // wheel1 = new TalonSRX(6);
    // wheel2 = new TalonSRX(14);
    // wheel3 = new TalonSRX(13);

    // feeder1 = new TalonSRX(2);
    // feeder2 = new TalonSRX(4);
    // feeder3 = new TalonSRX(10);

    // shooter1 = new CANSparkMax();
    // shooter2 = new CANSparkMax();
    // shooter3 = new CANSparkMax();

    //shooterCommand = new RunShooter();
    //intakeCommand = new RunIntake();
    runShoulder = new RunShoulder();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  public static void spinWheel1 (final double speed) {
    wheel1.set(ControlMode.PercentOutput, speed);
  }

  public static void spinWheel2(final double speed) {
    wheel2.set(ControlMode.PercentOutput, speed);
  }

  public static void spinWheel3(final double speed) {
    wheel3.set(ControlMode.PercentOutput, speed);
  }

  public static void spinFeeder1(final double speed) {
    feeder1.set(ControlMode.PercentOutput, speed);
  }

  public static void spinFeeder2(final double speed) {
    feeder2.set(ControlMode.PercentOutput, speed);
  }

  public static void spinFeeder3(final double speed) {
    feeder3.set(ControlMode.PercentOutput, speed);
  }

  public static void spinShooter1(final double speed) {
    shooter1.set(speed);
  }

  public static void runShoulder(final double speed) {
    shoulder.set(speed);
  }

  public static void runWinch(final double speed) {
    winch.set(speed);
  }
  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  @Override
  public void teleopInit() {
    // TODO Auto-generated method stub
    super.teleopInit();
    //shooterCommand.schedule();
    runShoulder.schedule();
    runWinch.schedule();
  }
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

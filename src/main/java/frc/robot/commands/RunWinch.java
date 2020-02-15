/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Robot;

import java.util.function.DoubleSupplier;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class RunWinch extends CommandBase {

  private DoubleSupplier winch;
  public static CANSparkMax winchMotor;

  /**
   * Creates a new RunWinch.
   */
  public RunWinch(DoubleSupplier winch) {
    this.winch = winch;
    winchMotor = new CANSparkMax(9,MotorType.kBrushless);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      SmartDashboard.putNumber("Winch speed", winch.getAsDouble());
      System.out.println("Winch button pressed");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    winchMotor.set(winch.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

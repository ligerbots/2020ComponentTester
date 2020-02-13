package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class RunIntake extends CommandBase {
  
  /**
   * Creates a new RunIntake.
   */
  public RunIntake() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("feeder 1 speed", 0.25);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.spinFeeder1(SmartDashboard.getNumber("feeder 1 speed", 0.5));
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

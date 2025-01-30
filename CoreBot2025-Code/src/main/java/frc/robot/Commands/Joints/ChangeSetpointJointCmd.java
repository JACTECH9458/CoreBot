package frc.robot.Commands.Joints;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.JointConstants;

public class ChangeSetpointJointCmd extends Command {

  public double jointSetpoint;

  public ChangeSetpointJointCmd(double kJointPosition) {
    jointSetpoint = kJointPosition;
  }

  @Override
  public void execute() {
    JointConstants.kJointMotorSetPoint = jointSetpoint;
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}

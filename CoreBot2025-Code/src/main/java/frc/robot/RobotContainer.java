package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.Drive.TankDriveCmd;
import frc.robot.Commands.Joints.ChangeSetpointJointCmd;
import frc.robot.Commands.Rollers.BackpackCmd;
import frc.robot.Commands.Rollers.OuttakeCmd;
import frc.robot.Constants.JoystickConstants;
import frc.robot.Subsystems.Drive.TankDriveSubsystem;
import frc.robot.Subsystems.Rollers.BackpackSubsystem;
import frc.robot.Subsystems.Rollers.OuttakeSubsystems;

/**
 * Classe principal para a configuração do robô.
 * Esta classe inicializa e gerencia os subsistemas, controladores e comandos do robô.
 */
public class RobotContainer {

  /** Subsistema responsável pelo controle do drivetrain. */
  private final TankDriveSubsystem driveTrain = new TankDriveSubsystem();
  
  /** Subsistema responsável pelo outtake. */
  private final OuttakeSubsystems outtake = new OuttakeSubsystems();
  
  /** Subsistema responsável pela backpack. */
  private final BackpackSubsystem backpack = new BackpackSubsystem();
  
  /** Controlador principal do robô baseado no Xbox. */
  private final CommandXboxController driverJoystick = new CommandXboxController(JoystickConstants.driveJoystickId);
  
  /**
   * Construtor da classe RobotContainer.
   * Inicializa os componentes do robô e configura as associações de comandos aos controles.
   */
  public RobotContainer() {
    configureBindings();
  }

  /**
   * Configura os botões do controle para executar comandos específicos quando pressionados.
   */
  private void configureBindings() {
    // Definição dos botões do controle
    Trigger l1Trigger = driverJoystick.a();
    Trigger l2Trigger = driverJoystick.b();
    Trigger l3Trigger = driverJoystick.y();
    Trigger backpackIntake = driverJoystick.rightTrigger();
    Trigger outtakeIntake = driverJoystick.leftTrigger();
    Trigger home = driverJoystick.start();


    // Define o comando padrão do drivetrain
    driveTrain.setDefaultCommand(
      new TankDriveCmd(driveTrain, driverJoystick.getLeftY(), driverJoystick.getRightX())
    );

      
    l1Trigger
      .and(DriverStation::isEnabled)
      .whileTrue(
        new BackpackCmd(backpack, 1)
      );

    l2Trigger
      .and(DriverStation::isEnabled)
      .whileTrue(
        new ChangeSetpointJointCmd(45)
          .andThen(
          new OuttakeCmd(outtake, 1)
        )
        
      );

    l3Trigger
      .and(DriverStation::isEnabled)
      .whileTrue(
        new ChangeSetpointJointCmd(65)
          .andThen(
          new OuttakeCmd(outtake, 1)
        )
      );

    backpackIntake
      .and(DriverStation::isEnabled)
      .whileTrue(
          new BackpackCmd(backpack, -1)
      );

    outtakeIntake
      .and(DriverStation::isEnabled)
      .whileTrue(
        new OuttakeCmd(outtake, -1)
      );

    home
      .and(DriverStation::isEnabled)
      .whileTrue(
        new ChangeSetpointJointCmd(0)
      );
  }

  /**
   * Obtém o comando autônomo do robô.
   * 
   * @return Comando a ser executado durante o modo autônomo.
   */
  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}

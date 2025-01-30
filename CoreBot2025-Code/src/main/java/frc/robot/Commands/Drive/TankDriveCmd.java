package frc.robot.Commands.Drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Drive.TankDriveSubsystem;

/**
 * Comando responsável por controlar o movimento do robô utilizando o método de drive tank.
 * Esse comando usa dois valores para controlar o movimento do robô.
 */
public class TankDriveCmd extends Command {

  /** Subsystem responsável pelo controle do drivetrain*/
  private final TankDriveSubsystem m_drivetrain;

  /** Valor do joystick esquerdo*/
  private final Double m_leftStick;

  /** Valor do joystick direito*/
  private final Double m_rightStick;

  /**
   * Construtor do comando.
   * 
   * @param drivetrain O {@link TankDriveSubsystem} que será controlado por este comando.
   * @param leftStick Valor do joystick esquerdo.
   * @param rightStick Valor do joystick direito.
   */
  public TankDriveCmd(TankDriveSubsystem drivetrain, Double leftStick, Double rightStick) {
    m_drivetrain = drivetrain;
    m_leftStick = leftStick;
    m_rightStick = rightStick;
    addRequirements(drivetrain);  // Define as dependências do comando
  }

  /**
   * Método chamado periodicamente enquanto o comando está sendo executado.
   * Usa os valores dos joysticks para controlar os motores do robô.
   */
  @Override
  public void execute() {
    m_drivetrain.tankDrive(m_leftStick, m_rightStick);
  }

  /**
   * Método que define se o comando foi finalizado.
   * Esse comando é contínuo e não termina até ser explicitamente interrompido.
   * 
   * @return false, indicando que o comando continua a ser executado.
   */
  @Override
  public boolean isFinished() {
    return false;
  }
}

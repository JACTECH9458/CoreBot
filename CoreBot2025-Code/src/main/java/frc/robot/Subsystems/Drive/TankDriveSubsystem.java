// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Drive;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs;
import frc.robot.Constants.DriveConstants;

/**
 * Subsystema responsável pelo controle do movimento de direção do robô, utilizando um sistema de direção tipo Tank Drive.
 * Controla os motores esquerdo e direito do robô e exibe dados de corrente no SmartDashboard.
 */
public class TankDriveSubsystem extends SubsystemBase {

  /** Motor esquerdo do robô */
  private static final SparkMax leftMotor = new SparkMax(DriveConstants.leftMotorId, MotorType.kBrushed);

  /** Motor direito do robô */
  private static final SparkMax rightMotor = new SparkMax(DriveConstants.rightMotorId, MotorType.kBrushed);

  /** Sistema de Tank Drive */
  private final DifferentialDrive myRobot = new DifferentialDrive(leftMotor, rightMotor);

  /**
   * Construtor da classe. Configura os motores do robô utilizando as configurações definidas em {@link Configs}.
   */
  public TankDriveSubsystem() {
    leftMotor.configure(Configs.leftMotorTank, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    rightMotor.configure(Configs.rightMotorTank, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  /**
   * Método chamado periodicamente para atualizar o estado do sistema.
   */
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Drive/LeftMotor/Corrente", leftMotor.getAppliedOutput());
    SmartDashboard.putNumber("Drive/RightMotor/Corrente", rightMotor.getAppliedOutput());
  }

  /**
   * Controla a velocidade dos motores esquerdo e direito do robô utilizando o sistema de direção tipo Tank Drive.
   * 
   * @param leftSpeed A velocidade do motor esquerdo. Variando de -1 a 1.
   * @param rightSpeed A velocidade do motor direito. Variando de -1 a 1.
   */
  public void tankDrive(double leftSpeed, double rightSpeed) {
    myRobot.tankDrive(leftSpeed, rightSpeed);
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Joints;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.JointConstants;
import frc.robot.Configs;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

/**
 * Subsystema responsável pelo controle do motor do Joint.
 */
public class JointSubsystem extends SubsystemBase {

  /** Motor do Joint */
  private final SparkMax jointMotor = new SparkMax(JointConstants.jointMotorId, MotorType.kBrushless);
  
  /** Encoder do Joint */
  private final RelativeEncoder jointEncoder = jointMotor.getEncoder();

  /**
   * Construtor da classe. Configura o motor do Joint usando as configurações definidas em {@link Configs}.
   */
  public JointSubsystem() {
    jointMotor.configure(Configs.jointConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  /**
   * Retorna a posição atual do motor do Joint, em unidades do encoder.
   * 
   * @return A posição do motor.
   */
  public double getMotorPosition() {
    return jointEncoder.getPosition();
  }

  /**
   * Define a velocidade do motor do Joint.
   * 
   * @param speed A velocidade do motor. Valores positivos giram o motor em uma direção, valores negativos na direção oposta.
   */
  public void setMotor(double speed) {
    jointMotor.set(speed);
  }

  /**
   * Verifica se o motor do Joint está na posição desejada.
   * 
   * @param pos A posição alvo que o motor deve atingir.
   * @return true se o motor estiver próximo da posição desejada, dentro de um erro de 1 unidade, caso contrário false.
   */
  public boolean atPosition(double pos) {
    return Math.abs(getMotorPosition() - pos) < 1;
  }

  /**
   * Reseta a posição do motor do Joint para 0.
   */
  public void definePosition() {
    jointEncoder.setPosition(0);
  }

  /**
   * Método chamado periodicamente para atualizar o estado do sistema.
   */
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Joint Position", getMotorPosition());
  }
}

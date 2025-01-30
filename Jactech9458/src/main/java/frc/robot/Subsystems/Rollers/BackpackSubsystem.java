// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Rollers;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs;
import frc.robot.Constants.BackpackConstants;

/**
 * Subsystema responsável pelo controle do motor do Backpack.
 * Permite controlar a direção do motor e exibir dados sobre o seu estado no SmartDashboard.
 */
public class BackpackSubsystem extends SubsystemBase {
  
  /** Motor do Backpack */
  private final SparkMax backpackMotor = new SparkMax(BackpackConstants.backpackMotorId, MotorType.kBrushed);

  /**
   * Construtor da classe. Configura o motor do Backpack usando as configurações definidas em {@link Configs}.
   */
  public BackpackSubsystem() {
    backpackMotor.configure(Configs.backpackCongig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  /**
   * Método chamado periodicamente para atualizar o estado do sistema.
   */
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Backpack/Corrente", backpackMotor.getOutputCurrent());
  }

  /**
   * Define o estado do Backpack, controlando se ele deve girar para frente ou parar.
  @param state O estado desejado do motor. Use:
   *              | 1 para girar para frente.
   *              | 0 para parar o motor.
   */
  public void setBackpack(int state) {
    switch (state) {
      case 1: 
        backpackMotor.set(1); // Aciona o Backpack para girar para frente
        break;
      case 0: 
        backpackMotor.set(0); // Para o Backpack
        break;
    }
  }
}
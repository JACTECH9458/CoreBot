// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands.Rollers;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Rollers.OuttakeSubsystems;

/**
 * Comando responsável por controlar o estado do Outtake.
 * Esse comando interage com o {@link OuttakeSubsystems} para definir o estado desejado do Outtake.
 */
public class OuttakeCmd extends Command {

  /** Subsystem do Outtake utilizado para realizar as ações */
  private final OuttakeSubsystems outtakeSubsystem;

  /** Estado desejado do Outtake (1 para girar para frente, 0 para parar) */
  private Integer state;

  /**
   * Construtor do comando.
   * 
   * @param outtakeSubsystem O {@link OuttakeSubsystems} que será controlado por este comando.
   * @param state O estado desejado do Outtake. Use 1 para girar para frente, -1 para girar para trás e 0 para parar.
   */
  public OuttakeCmd(OuttakeSubsystems outtakeSubsystem, Integer state) {
    this.outtakeSubsystem = outtakeSubsystem;
    this.state = state;
  }

  /**
   * Método chamado periodicamente enquanto o comando está sendo executado.
   * Define o estado do Outtake de acordo com o valor de {@link #state}.
   */
  @Override
  public void execute() {
    outtakeSubsystem.setOuttake(state);
  }


  /**
   * Define se o comando foi finalizado.
   * Esse comando termina imediatamente após ser executado uma vez, portanto, sempre retorna true.
   * 
   * @return true, indicando que o comando foi concluído.
   */
  @Override
  public boolean isFinished() {
    return true;
  }
}

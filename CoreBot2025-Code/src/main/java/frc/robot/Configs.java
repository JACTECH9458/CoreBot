// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

/**
 * Contém as configurações para os motores do robô.
 */
public final class Configs {
    
    /** Configuração para o motor esquerdo do robô. */
    public static final SparkMaxConfig leftMotorTank = new SparkMaxConfig();
    
    /** Configuração para o motor direito do robô. */
    public static final SparkMaxConfig rightMotorTank = new SparkMaxConfig();
    
    /** Configuração para o motor de outtake. */
    public static final SparkMaxConfig outtakeConfig = new SparkMaxConfig();
    
    /** Configuração para o motor de backpack. */
    public static final SparkMaxConfig backpackCongig = new SparkMaxConfig();
    
    /** Configuração para o motor de joint. */
    public static final SparkMaxConfig jointConfig = new SparkMaxConfig();

    static {
        // Configuração do motor de outtake
        outtakeConfig
            .idleMode(IdleMode.kBrake)  // Modo de inatividade: Brake
            .smartCurrentLimit(80);     // Limite de corrente inteligente: 80A

        // Configuração do motor esquerdo
        leftMotorTank
            .idleMode(IdleMode.kBrake)  // Modo de inatividade: Brake
            .smartCurrentLimit(100);    // Limite de corrente inteligente: 100A

        // Configuração do motor direito
        rightMotorTank
            .idleMode(IdleMode.kBrake)  // Modo de inatividade: Brake
            .smartCurrentLimit(100);    // Limite de corrente inteligente: 100A
    }
}

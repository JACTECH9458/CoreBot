// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * Contém as constantes utilizadas pelo robô para configurações.
 */
public class Constants {

    /**
     * Constantes relacionadas ao joystick de controle do robô.
     */
    public static class JoystickConstants {
        /** ID do joystick de controle do robô */
        public static int driveJoystickId = 0;
    }

    /**
     * Constantes relacionadas aos motores de movimentação do robô.
     */
    public static class DriveConstants {
        /** ID do motor do lado esquerdo */
        public static int leftMotorId = 1;
        /** ID do motor do lado direito */
        public static int rightMotorId = 2;
    }

    /**
     * Constantes relacionadas ao motor de outtake.
     */
    public static class OuttakeConstants {
        /** ID do motor de outtake */
        public static int outtakeMotorId = 3;
    }

    /**
     * Constantes relacionadas ao motor de joint.
     */
    public static class JointConstants {
        /** ID do motor de joint */
        public static int jointMotorId = 4;
    
        /** Constantes PID para controle de angulação */
        public static final double kPIDAngulationMotorKp = 0.1;
        public static final double kPIDAngulationMotorKi = 0;
        public static final double kPIDAngulationMotorKd = 0;
        /** Posição de referência para o motor de joint */
        public static double kJointMotorSetPoint = 0;

        /** Velocidade máxima do motor para mover o joint para cima */
        public static final double kJointUpMotorMaxSpeed = 0.3;
        /** Velocidade máxima do motor para mover o joint para baixo */
        public static final double kJointDownMotorMaxSpeed = 0.3;
    }

    /**
     * Constantes relacionadas ao motor da backpack.
     */
    public static class BackpackConstants {
        /** ID do motor da backpack */
        public static int backpackMotorId = 5;
    }
}

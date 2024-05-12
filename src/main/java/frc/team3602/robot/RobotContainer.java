/*
 * Copyright (C) 2024, FRC Team 3602. All rights reserved. This work
 * is licensed under the terms of the MIT license which can be found
 * in the root directory of this project.
 */

package frc.team3602.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.team3602.robot.subsystems.Drivetrain;
import static frc.team3602.robot.Constants.OperatorInterfaceConstants.*;

public class RobotContainer {
  /* Operator interfaces */
  private final CommandXboxController xboxController = new CommandXboxController(kXboxControllerPort);

  /* Subsystems */
  private final Drivetrain drivetrainSubsys = new Drivetrain();

  /* Autonomous */
  private final SendableChooser<Command> sendableChooser = new SendableChooser<>();

  public RobotContainer() {
    configDefaultCommands();
    configButtonBindings();
    configAutonomous();
  }

  /**
   * Function that returns the currently selected autonomous routine in the
   * SendableChooser.
   * 
   * @return Currently selected autonomous routine.
   */
  public Command getAutonomousCommand() {
    return sendableChooser.getSelected();
  }

  /**
   * Function that is called in the constructor where we configure default
   * commands for the subsytems.
   */
  private void configDefaultCommands() {
    drivetrainSubsys.setDefaultCommand(
        drivetrainSubsys.arcadeDrive(() -> -xboxController.getLeftY(), () -> -xboxController.getRightX()));
  }

  /**
   * Function that is called in the constructor where we configure operator
   * interface button bindings.
   */
  private void configButtonBindings() {

  }

  /**
   * Function that is called in the constructor where we configure anything
   * relating to autonomous.
   */
  private void configAutonomous() {
    SmartDashboard.putData(sendableChooser);
  }
}

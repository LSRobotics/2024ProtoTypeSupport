// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //Solenoid adddresses positions

    public static final int kGrabber_out_port = 0;
    public static final int kGrabber_in_port  = 1;
    public static final int kArm_up_port      = 3;
    public static final int kArm_Down_port    = 2;
    
    public static final int kUSBPort0 = 0;
    public static final int kUSBPort1 = 1;

    public static final int kCanID10 = 10;
    public static final int kCanID11 = 11;
    public static final double kleftSpeed = 0.5;
    public static final double krightSpeed = 0.5;
    public static final double km_speed = 0.5;
    public static int kCanID15 = 15;


}

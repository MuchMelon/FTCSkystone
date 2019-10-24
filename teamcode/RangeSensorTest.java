package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * Created by xylanmoon on 10/5/2018.
 */

@Autonomous
@Disabled
public class RangeSensorTest extends LinearOpMode {
    DcMotor armLift;
    DcMotor armLift2;
    DcMotor leftDrive;
    DcMotor rightDrive;
    Servo markerDrop;
    ModernRoboticsI2cRangeSensor rangeFinder;


    @Override
    public void runOpMode() throws InterruptedException {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");

        armLift = hardwareMap.dcMotor.get ("armLift");
        armLift2 = hardwareMap.dcMotor.get ("armLift2");

        markerDrop = hardwareMap.servo.get("markerDrop");

        rangeFinder = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "rangeFinder");


        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        //double armLiftPower = -0.2;




        ;

        waitForStart();
        //Go Forward set amount (change based on centimeter)


        if (rangeFinder.getDistance(DistanceUnit.CM) > 15)
        {
            leftDrive.setPower(0.5);
            rightDrive.setPower(0.5);
        } else {
            leftDrive.setPower(0);
            rightDrive.setPower(0);
        }








    }

}
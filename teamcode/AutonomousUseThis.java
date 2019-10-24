package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by xylanmoon on 10/5/2018.
 */

@Autonomous
@Disabled
public class  AutonomousUseThis extends LinearOpMode {
    DcMotor armLift;
    DcMotor armLift2;
    DcMotor leftDrive;
    DcMotor rightDrive;
    Servo markerDrop;


    @Override
    public void runOpMode() throws InterruptedException {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");

        armLift = hardwareMap.dcMotor.get ("armLift");
        armLift2 = hardwareMap.dcMotor.get ("armLift2");

        markerDrop = hardwareMap.servo.get("markerDrop");

        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        //double armLiftPower = -0.2;




     ;

        waitForStart();
        //Go Forward set amount (change based on meters)

        armLift.setPower(-0.1);
        armLift2.setPower(0.1);
        sleep(1600);

        armLift.setPower(0);
        armLift2.setPower(0);
        sleep(1000);

        leftDrive.setPower(-0.2);
        rightDrive.setPower(0.2);
        sleep(1290);


        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(500);

        armLift.setPower(0.1);
        armLift2.setPower(-0.1);
        sleep(100);


        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(500);



        leftDrive.setPower(0.2);
        rightDrive.setPower(-0.2);
        sleep(1355);


        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(500);


        leftDrive.setPower(0.5);
        rightDrive.setPower(0.5);
        sleep(1830);
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(1000);



        markerDrop.setPosition(1);
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(1000);
        markerDrop.setPosition(0);
        sleep(1000);



        leftDrive.setPower(-0.1);
        rightDrive.setPower(-0.1);
        sleep(1600);

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(500);
        leftDrive.setPower(-0.5);
        rightDrive.setPower(0.5);
        sleep(375); //Change back to 350 if it does not work
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(1000);




       /* leftDrive.setPower(1);
        rightDrive.setPower(1);
        sleep(5050);



        /*hey zylan **/



    }

}
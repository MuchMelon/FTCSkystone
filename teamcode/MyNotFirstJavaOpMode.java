package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by xylanmoon on 10/2/2018.
 */

@TeleOp(name = "MyNotFirstJavaOpMode")
@Disabled
public class MyNotFirstJavaOpMode extends OpMode {

    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor armLift;
    DcMotor armLift2;
    Servo markerDrop;
    double leftDrivePower = 0.5;
    double rightDrivePower =0.5;
    double armLiftPower = -0.2;

    @Override
    public void init(){
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get ("rightDrive");

        armLift = hardwareMap.dcMotor.get ("armLift");
        armLift2 = hardwareMap.dcMotor.get ("armLift2");

        markerDrop = hardwareMap.servo.get ("markerDrop");

        rightDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void start(){

    }

    @Override
    public void loop() {
        leftDrivePower= -gamepad1.left_stick_y;
        rightDrivePower= -gamepad1.right_stick_y;

        armLiftPower = gamepad2.right_stick_y;
        //armLift


        leftDrive.setPower(leftDrivePower);
        rightDrive.setPower(rightDrivePower);

        armLift.setPower(armLiftPower);
        armLift2.setPower(-armLiftPower);


        if (gamepad1.x){
        markerDrop.setPosition(1);
        } else {
           markerDrop.setPosition(0);
        }





    }

    @Override
    public void stop() {

    }
}
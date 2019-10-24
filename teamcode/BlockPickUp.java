package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


/**
 * Created by xylanmoon on 10/17/2018.
 */
@TeleOp
@Disabled
public class BlockPickUp extends OpMode {
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor armLift;
    DcMotor armLift2;


    Servo blockGrab;
    Servo servoDrop;

    double leftDrivePower = 0.2;
    double rightDrivePower = 0.2;
    double armLiftPower = -0.1;


    @Override
    public void init() {
        //driving motors
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");

        //Arm control
        armLift = hardwareMap.dcMotor.get("armLift");
        armLift2 = hardwareMap.dcMotor.get("armLift2");

        //Block Drop

        blockGrab = hardwareMap.servo.get("blockGrab");
        servoDrop = hardwareMap.servo.get("servoDrop");


        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        leftDrivePower    = Range.clip(drive + turn, -0.5, 0.5) ;
        rightDrivePower   = Range.clip(drive - turn, -0.5, 0.5) ;


        armLiftPower = -gamepad2.right_stick_y;


        leftDrive.setPower(leftDrivePower);
        rightDrive.setPower(rightDrivePower);

        armLift.setPower(armLiftPower);
        armLift2.setPower(-armLiftPower);







        if (gamepad2.dpad_up) servoDrop.setPosition(1);

        if (gamepad2.dpad_down) servoDrop.setPosition(0.5);
        if (gamepad2.dpad_left) servoDrop.setPosition(0);



        if (gamepad2.right_bumper) blockGrab.setPosition(0.55);
        if (gamepad2.left_bumper) blockGrab.setPosition(0);




    }








}

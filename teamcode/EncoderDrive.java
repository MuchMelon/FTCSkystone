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
public class EncoderDrive extends LinearOpMode {
    DcMotor armLift;
    DcMotor armLift2;
    DcMotor leftDrive;
    DcMotor rightDrive;
    Servo markerDrop;

    static final int Motor_Tick_Counts = 1120;
    int leftDrivePos;
    int rightDrivePos;

    @Override
    public void runOpMode() throws InterruptedException {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");

        armLift = hardwareMap.dcMotor.get ("armLift");
        armLift2 = hardwareMap.dcMotor.get ("armLift2");

        markerDrop = hardwareMap.servo.get("markerDrop");



        armLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armLift2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        //double armLiftPower = -0.2;






        waitForStart();
        //Go Forward set amount (change based on meters)
        armLift.setPower(-0.1);
        armLift2.setPower(0.1);
        sleep(1530);

        armLift.setPower(0);
        armLift2.setPower(0);
        sleep(1000);

        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitOneFullHardwareCycle();

        leftDrive.setTargetPosition(-280);
        rightDrive.setTargetPosition(280);

        leftDrivePos = leftDrive.getCurrentPosition();
        rightDrivePos = rightDrive.getCurrentPosition();

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);



        while (leftDrivePos > -280 && rightDrivePos < 280 && leftDrive.isBusy() && rightDrive.isBusy()) {
            leftDrive.setPower(0.2);
            rightDrive.setPower(0.2);
        }



        armLift.setPower(0.1);
        armLift2.setPower(-0.1);
        sleep(20);








        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitOneFullHardwareCycle();

        leftDrive.setTargetPosition(400);//change back to 360
        rightDrive.setTargetPosition(-400);//change back to 360

        leftDrivePos = leftDrive.getCurrentPosition();
        rightDrivePos = rightDrive.getCurrentPosition();

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);



        while (leftDrivePos < 400 && rightDrivePos > -400 && leftDrive.isBusy() && rightDrive.isBusy()) {
            leftDrive.setPower(0.2);
            rightDrive.setPower(0.2);
        }






        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitOneFullHardwareCycle();

        leftDrive.setTargetPosition(4656);
        rightDrive.setTargetPosition(4656);

        leftDrivePos = leftDrive.getCurrentPosition();
        rightDrivePos = rightDrive.getCurrentPosition();

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);



        while (leftDrivePos < 4656 && rightDrivePos < 4656 && leftDrive.isBusy() && rightDrive.isBusy()) {
            leftDrive.setPower(0.3);
            rightDrive.setPower(0.3);
        }



        markerDrop.setPosition(1);
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(1000);
        markerDrop.setPosition(0);
        sleep(1000);







        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitOneFullHardwareCycle();

        leftDrive.setTargetPosition(-1530);
        rightDrive.setTargetPosition(1530);

        leftDrivePos = leftDrive.getCurrentPosition();
        rightDrivePos = rightDrive.getCurrentPosition();

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);



        while (leftDrivePos > -1560 && rightDrivePos < 1560 && leftDrive.isBusy() && rightDrive.isBusy()) {
            leftDrive.setPower(-0.2);
            rightDrive.setPower(0.2);

        }









        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitOneFullHardwareCycle();

        leftDrive.setTargetPosition(5120);//change back to 6000
        rightDrive.setTargetPosition(5120);//change back to 6000

        leftDrivePos = leftDrive.getCurrentPosition();
        rightDrivePos = rightDrive.getCurrentPosition();

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);



        while (leftDrivePos < 5120 && rightDrivePos < 5120 && leftDrive.isBusy() && rightDrive.isBusy()) {
            leftDrive.setPower(0.5);
            rightDrive.setPower(0.5);
            idle();
        }
















    }

}

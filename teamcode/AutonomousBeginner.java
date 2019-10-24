package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.Hardware;

@Autonomous
@Disabled
public class  AutonomousBeginner extends LinearOpMode {
    MaximusHardwareMap robot = new MaximusHardwareMap();

    @Override
    public void runOpMode() throws InterruptedException{

        robot.init(hardwareMap);

        /*
        *
        * */

        telemetry.addData("Status:", "Waiting, Sir");
        telemetry.update();

        waitForStart();


        driveForward(0.5, 5);
        STOP();

        turnRight(0.4);
        sleep(1500);
        STOP();

        driveForward(0.5, 5);
        STOP();
        
        turnLeft(0.4);
        sleep(1000);
        STOP();

        arcTurnLeft(0.5);
        sleep(1500);
        STOP();

        arcTurnRight(0.5);
        sleep(1500);
        STOP();


    }

    //Driving Methods
    public void driveForward(double forwardPower, long secondsTaken){
        robot.leftDrive.setPower(forwardPower);
        robot.rightDrive.setPower(forwardPower);
        sleep(secondsTaken *1000);
    }

    public void turnLeft(double turnLeftPower){
        robot.leftDrive.setPower(-turnLeftPower);
        robot.rightDrive.setPower(turnLeftPower);
    }

    public void turnRight (double turnRightPower){
        robot.leftDrive.setPower(turnRightPower);
        robot.rightDrive.setPower(-turnRightPower);
    }

    public void arcTurnLeft (double leftArcPower){
        robot.leftDrive.setPower(leftArcPower * 0.5);
        robot.rightDrive.setPower(leftArcPower);
    }

    public void arcTurnRight (double rightArcPower){
        robot.leftDrive.setPower(rightArcPower);
        robot.rightDrive.setPower(rightArcPower * 0.5);
    }

    public void clawGrip (double pos){
        robot.leftGrip.setPosition(pos);
        robot.rightGrip.setPosition(pos);
    }


    public void STOP (){
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }
    /*
    //Arm Movement
    public void armMoveForward(double armPower){
        armLeft.setPower(armPower);
        armRight.setPower(armPower);
    }

    public void armMoveBackward(double armBackPower){
        armLeft.setPower(-armBackPower);
        armRight.setPower(-armBackPower);
    }

    **/
}

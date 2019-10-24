package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import android.speech.tts.TextToSpeech;


@TeleOp
@Disabled
public class BeginnersCode extends OpMode {
    MaximusHardwareMap robot = new MaximusHardwareMap();

    @Override
    public void init(){
        robot.init(hardwareMap);

    }



    @Override
    public void start(){

    }



    @Override
    public void loop(){
        double leftPower;
        double rightPower;




        double drive = -gamepad1.left_stick_y;
        double turn  =  gamepad1.right_stick_x;
        leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

        // Send calculated power to wheels
        robot.leftDrive.setPower(leftPower);
        robot.rightDrive.setPower(rightPower);
        /*
        if (gamepad1.x ){
            testServo.setPosition(180);
        } else {
            testServo.setPosition(0.55);
        }
        */


    }


    @Override
    public void stop(){


    }

}

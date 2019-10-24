package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
/**
 * Created by xylanmoon on 10/2/2018.
 */

@TeleOp(name = "TesterCode")
public class TesterCode extends OpMode {
    MaximusHardwareMap robot = new MaximusHardwareMap();
    @Override
    public void init(){



        robot.init(hardwareMap);


    }

    @Override
    public void start(){

    }

    @Override
    public void loop() {
        double armPower = - gamepad1.left_stick_y;
        robot.armLift.setPower(armPower);

        if (gamepad1.dpad_up){
            robot.leftGrip.setPosition(180);
        } else if (gamepad1.dpad_down){
            robot.leftGrip.setPosition(0);
        } else if (gamepad1.dpad_left){
            robot.leftGrip.setPosition(45);
        } else if (gamepad1.dpad_right){
            robot.leftGrip.setPosition(90);
        }








    }

    @Override
    public void stop() {

    }
}
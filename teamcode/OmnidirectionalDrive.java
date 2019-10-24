package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.lang.Math.*;
public class OmnidirectionalDrive extends OpMode {

    private DcMotor m1Front;
    private DcMotor m2Right;
    private DcMotor m3Back;
    private DcMotor m4Left;




    @Override
    public void init(){
        m1Front = hardwareMap.get(DcMotor.class, "m1");
        m2Right = hardwareMap.get(DcMotor.class, "m2");
        m3Back = hardwareMap.get(DcMotor.class, "m3");
        m4Left = hardwareMap.get(DcMotor.class, "m4");


    }

    @Override
    public void start(){

    }

    @Override
    public void loop(){

        double spinPower = gamepad1.right_stick_x;


        if (Math.abs(spinPower)> .1) {

            m1Front.setPower(spinPower);
            m2Right.setPower(spinPower);
            m3Back.setPower(spinPower);
            m4Left.setPower(spinPower);

        } else {
            double frontBackPower = -gamepad1.left_stick_y;
            double leftRightPower = -gamepad1.left_stick_x;

            m1Front.setPower(leftRightPower);
            m2Right.setPower(frontBackPower);
            m3Back.setPower(-leftRightPower);
            m4Left.setPower(-frontBackPower);
        }
    }

    @Override
    public void stop(){

    }



}

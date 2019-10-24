package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Hardware;

public class MaximusHardwareMap {

    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public DcMotor armLift = null;

    public Servo leftGrip = null;
    public Servo rightGrip = null;



    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();


    public MaximusHardwareMap(){

    }


    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        leftDrive = hwMap.get(DcMotor.class, "leftMotor");
        rightDrive = hwMap.get(DcMotor.class, "rightMotor");
        armLift = hwMap.get(DcMotor.class, "armMotor");

        leftGrip = hwMap.get(Servo.class, "LeftServo");

        





        leftDrive.setPower(0);
        rightDrive.setPower(0);
        armLift.setPower(0);

        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

}

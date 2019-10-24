package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

public class MecanumHardwareMap {

    public DcMotor FL = null;
    public DcMotor FR = null;
    public DcMotor BL = null;
    public DcMotor BR = null;
    public DcMotor armLift= null;
    public DcMotor armLift2= null;

    public WebcamName webcamName = null;
    public CRServo extendArm = null;
    public Servo leftServo = null;
    public Servo rightServo =null;


    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();





    public MecanumHardwareMap(){

    }
    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;

        FL = hwMap.get(DcMotor.class, "FrontLeft");
        FR = hwMap.get(DcMotor.class, "FrontRight");
        BL = hwMap.get(DcMotor.class, "BackLeft");
        BR = hwMap.get(DcMotor.class, "BackRight");
        armLift = hwMap.get(DcMotor.class, "armMotor");
        armLift2 = hwMap.get(DcMotor.class, "armMotor2");

        leftServo = hwMap.get(Servo.class, "leftServo");
        rightServo = hwMap.get(Servo.class, "rightServo");
        extendArm = hwMap.get(CRServo.class, "extendArm");



        webcamName = hwMap.get(WebcamName.class, "Webcam 1");


        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armLift2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armLift2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        armLift2.setDirection(DcMotorSimple.Direction.REVERSE);
    }



}
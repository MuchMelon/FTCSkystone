package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

@Autonomous
public class BlueMoveToStones extends LinearOpMode {
    MecanumHardwareMap robot = new MecanumHardwareMap();
    private ElapsedTime runtime = new ElapsedTime();
    static final double TICKS = 1440;
    static final double WHEELS_DIAMETER_INCHES = 3.86;
    static final double COUNTS_PER_ROTATION = (TICKS/(WHEELS_DIAMETER_INCHES *3.14));


    @Override
    public void runOpMode() throws InterruptedException{
        robot.init(hardwareMap);


        waitForStart();

        driveForward(0.2, 1);
        strafeLeft(-0.5, 4);
        driveForward(0.2, 2);

        


        STOP();


    }

    public void encoderDrive(double leftInches, double rightInches, double speed, double timeOut){
        int newFLPos;
        int newFRPos;
        int newBLPos;
        int newBRPos;

        newFLPos = robot.FL.getCurrentPosition() +(int)(leftInches * COUNTS_PER_ROTATION);
        newFRPos = robot.FR.getCurrentPosition() +(int)(rightInches * COUNTS_PER_ROTATION);
        newBLPos = robot.BL.getCurrentPosition() +(int)(leftInches * COUNTS_PER_ROTATION);
        newBRPos = robot.BR.getCurrentPosition() +(int)(rightInches * COUNTS_PER_ROTATION);

        robot.FL.setTargetPosition(newFLPos);
        robot.FR.setTargetPosition(newFRPos);
        robot.BL.setTargetPosition(newBLPos);
        robot.BR.setTargetPosition(newBRPos);

        robot.FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        runtime.reset();

        robot.FL.setPower(Math.abs(speed));
        robot.FR.setPower(Math.abs(speed));
        robot.BL.setPower(Math.abs(speed));
        robot.BR.setPower(Math.abs(speed));

        while (opModeIsActive() && (runtime.seconds() <timeOut) && (robot.FL.isBusy() && robot.FR.isBusy())){
            telemetry.addData("Path1", "Running to %7d : %7d : %7d : %7d", newFLPos,newFRPos, newBLPos, newBRPos );
            telemetry.addData("Path2", "Running to %7d : %7d : %7d : %7d,", robot.FL.getCurrentPosition(),
                                                                                        robot.FR.getCurrentPosition(),
                                                                                        robot.BL.getCurrentPosition(),
                                                                                        robot.BR.getCurrentPosition());
            telemetry.update();

        }

        robot.FL.setPower(0);
        robot.FR.setPower(0);
        robot.BL.setPower(0);
        robot.BR.setPower(0);

        robot.FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);




    }

    public void driveForward(double power, long seconds){
        robot.FL.setPower(power);
        robot.FR.setPower(power);
        robot.BL.setPower(power);
        robot.BR.setPower(power);
        sleep(seconds *1000);

    }

    public void accelerationForward(double targetPower, int targetSeconds) {
        double motorPower =0;
        double seconds = 0;
            for (motorPower = 0, seconds =0; (motorPower < targetPower && seconds < targetSeconds); motorPower += 0.2, seconds +=1) {
                robot.FL.setPower(motorPower);
                robot.FR.setPower(motorPower);
                robot.BL.setPower(motorPower);
                robot.BR.setPower(motorPower);
                sleep(100);
            }

    }

    public void turnLeft(double powerTurn, long seconds){
        robot.FL.setPower(-powerTurn);
        robot.FR.setPower(powerTurn);
        robot.BL.setPower(-powerTurn);
        robot.BR.setPower(powerTurn);
        sleep(seconds * 1000);
    }

    public void turnRight(double powerTurn, long seconds){
        robot.FL.setPower(powerTurn);
        robot.FR.setPower(-powerTurn);
        robot.BL.setPower(powerTurn);
        robot.BR.setPower(-powerTurn);
        sleep(seconds * 1000);
    }
    public void strafeLeft(double powerStrafe, long seconds){
        robot.FL.setPower(-powerStrafe);
        robot.FR.setPower(powerStrafe);
        robot.BL.setPower(powerStrafe);
        robot.BR.setPower(-powerStrafe);
        sleep(seconds * 1000);
    }

    public void strafeRight(double powerStrafe, long seconds){
        robot.FL.setPower(powerStrafe);
        robot.FR.setPower(-powerStrafe);
        robot.BL.setPower(-powerStrafe);
        robot.BR.setPower(powerStrafe);
        sleep(seconds * 1000);
    }

    public void vuforiaDrive(){
        final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;
        final boolean PHONE_IS_PORTRAIT = false  ;

    }

    public void STOP(){
        robot.FL.setPower(0);
        robot.FR.setPower(0);
        robot.BL.setPower(0);
        robot.BR.setPower(0);
    }


}

package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class MecanumDriveTele extends OpMode {
    MecanumHardwareMap robot = new MecanumHardwareMap();

    private double DRIVE;
    private double TURN;
    private double STRAFE;
    private double POWER_REDUCTION = 0.3;
    double armPower;



    public void init(){

        robot.init(hardwareMap);


    }

    public void start(){

    }

    public void loop(){
        DRIVE = -gamepad1.left_stick_y;
        TURN = gamepad1.right_stick_x;
        STRAFE = -gamepad1.left_stick_x;
        armPower = -gamepad2.right_stick_y;
        double servoJoystick = gamepad2.left_stick_y*0.5;

        double FLPower = (DRIVE + TURN - STRAFE);
        double FRPower = (DRIVE - TURN + STRAFE);
        double BLPower = (DRIVE + TURN + STRAFE);
        double BRPower = (DRIVE - TURN - STRAFE);

        robot.extendArm.setPower(servoJoystick);



        robot.armLift.setPower(armPower*0.3);
        robot.armLift2.setPower(armPower*0.3);

        robot.FL.setPower(FLPower * POWER_REDUCTION);
        robot.FR.setPower(FRPower * POWER_REDUCTION);
        robot.BL.setPower(BLPower * POWER_REDUCTION);
        robot.BR.setPower(BRPower * POWER_REDUCTION);

        if (gamepad1.a) {
            POWER_REDUCTION =0.1;
        }
        else if (gamepad1.b){
            POWER_REDUCTION =0.5;
        }
    }

    public void stop(){


    }

}
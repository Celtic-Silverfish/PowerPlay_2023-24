package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "EncoderTest")
public class EncoderTest extends LinearOpMode {

    DcMotor leftDrive = null;
    ElapsedTime runtime;

    {
        runtime = new ElapsedTime;
    }

    final double Speed = 0.75;

    @Override
    public void runOpMode() throws InterruptedException {

        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftDrive = hardwareMap.get(DcMotor.class, "LD");

        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        double position = leftDrive.getCurrentPosition();
        telemetry.addData("Encoder Position", position);
        telemetry.update();

        waitForStart();

        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftDrive.setTargetPosition(1120);
        leftDrive.setPower(Speed);
        telemetry.update();

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}

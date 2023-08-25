/*
motors go forward when holding up left stick
motors go backward when pulling back left stick
left motor goes forward right motor goes backwards when pushing right stick right
right motor goes forward left motor goes backwards when pushing right stick left

steps to execute it:
TeleOp/Autonomous + name & group
Declare variables (Dcmotors and doubles)
initialization
1. hardwaremap
2. set direction
3. telemetry update
after play
1. Declare drive = -leftstick(y)
2. Declare turn = rightstick(x)
3. assign drive to left and right motors
4. Update telemetry
 */
package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name = "TeleOpforBlockParty")
public class TeleOpforBlockParty extends OpMode {

    DcMotor leftMotor = null;
    DcMotor rightMotor = null;


    @Override
    public void init() {

        leftMotor = hardwareMap.get(DcMotor.class, "LD");
        rightMotor = hardwareMap.get(DcMotor.class, "RD");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

    }

    @Override
    public void loop() {

        double y = -gamepad1.left_stick_y;
        double x = gamepad1.right_stick_x;

        leftMotor.setPower(y + x);
        rightMotor.setPower(y - x);

        telemetry.addData("y", "%.2f", y);
        telemetry.addData("x", "%.2f", x);
        telemetry.update();

        }

    }

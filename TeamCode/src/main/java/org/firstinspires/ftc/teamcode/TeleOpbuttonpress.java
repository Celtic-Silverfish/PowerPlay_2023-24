/*
when y pressed both motors run forward
when a pressed both motors run backwards

steps:
initialization
1. Declare variables
2. Hardwaremap
3. Set direction
4. telemetry data
play
1. if statements declaring speed
2. button that plays motor speed
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "TeleOpbuttonpress", group = "Practice")
public class TeleOpbuttonpress extends OpMode {

    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;

    public double motorSpeed = 0.5;

    @Override
    public void init() {

        leftDrive = hardwareMap.get(DcMotor.class, "LD");
        rightDrive = hardwareMap.get(DcMotor.class, "RD");

        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    @Override
    public void loop() {

        if(gamepad1.y) {
            motorSpeed += 0.05;

        }
        if(gamepad1.a) {
            motorSpeed -= 0.05;

        }
        if(gamepad1.x) {

            leftDrive.setPower(motorSpeed);
            rightDrive.setPower(motorSpeed);

        }
        telemetry.addData("motorSpeed", "%.2f", motorSpeed);
        telemetry.update();

    }
}

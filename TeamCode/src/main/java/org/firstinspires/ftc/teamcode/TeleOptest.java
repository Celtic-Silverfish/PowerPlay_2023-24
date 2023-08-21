/*
run motor forward with controller after pressing a

what needs to be done:
Initialization
1. Declare and Initialize variables
2. Hardewaremap
3. Set direction
4.update telemetry
Run
1.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "TeleOptest", group = "Practice")
public class TeleOptest extends OpMode {
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;

    public void init() {

        leftDrive = hardwareMap.get(DcMotor.class, "LD");
        rightDrive = hardwareMap.get(DcMotor.class, "RD");

        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

    }

    @Override
    public void loop() {
        double right;
        double left;

        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;

        leftDrive.setPower(left);
        rightDrive.setPower(right);

        telemetry.addData("left", "%.2f", left);
        telemetry.addData("right", "%.2f", right);
        telemetry.update();

    }

}

/*
motor goes forward for 5 seconds
stops
motor goes backwards for 5 seconds

what needs to be made
Initialization
1. Declare and initialize variables (doubles + DCMotor)
2. Hardwaremap
3. Set Direction
4. Update Telemetry
Run
1. Set Power using final double variable
2. While loop with time constraint
3. Turn off power
4. Set Power and reverse
5. Update Telemetry
 */


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "robot owo", group = "Practice")
public class test extends LinearOpMode {

    // Declaring variables
    private DcMotor drive = null;
    private ElapsedTime runtime = null;

    final double Speed = 0.5;

    @Override
    public void runOpMode() throws InterruptedException {

        // link variable name with device named within driver hub configuration
        drive = hardwareMap.get(DcMotor.class, "motorgobrr" );

        // set direction and update initialization to telemetry
        drive.setDirection(DcMotor.Direction.FORWARD);
        telemetry.addData("Status", "Ready to go brr");
        telemetry.update();

        // run program
        waitForStart();

        // set power & move forward while initialized and runtime is less than 5 (runtime was previously reset))
        drive.setPower(Speed);
        runtime.reset();
        while(opModeIsActive() && (runtime.seconds() < 5)) {

            //
            telemetry.addData("Path", "Leg 1: %4 1f S Elapsed", runtime.seconds());
            telemetry.update();

        }

        // set power to 0 for less than 1 second
        drive.setPower(0);
        runtime.reset();
        while(opModeIsActive() && (runtime.seconds() < 1)) {

            //
            telemetry.addData("Path", "Leg 2: %4 1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // set power & move backwards while initialized and runtime is less than 5 (runtime was previously reset))
        drive.setPower(-Speed);
        runtime.reset();
        while(opModeIsActive() && (runtime.seconds() < 5)) {

            //
            telemetry.addData("Path", "Leg 3: %4 1f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // set power to 0 & telemetry plays path: finished
        drive.setPower(0);
        telemetry.addData("Path", "Finished ;)");
        telemetry.update();

    }
}

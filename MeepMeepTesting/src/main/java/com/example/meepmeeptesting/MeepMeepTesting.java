package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        // Declare a MeepMeep instance
        // With a field size of 800 pixels
        MeepMeep meepMeep = new MeepMeep(800);
        Pose2d startPose = new Pose2d(16.0, 62.0, Math.toRadians(0));
        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Required: Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(360), Math.toRadians(360), 15)
                // Option: Set theme. Default = ColorSchemeRedDark()
                .setColorScheme(new ColorSchemeRedDark())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(startPose)
                                .lineToConstantHeading(new Vector2d(16, 36))
                                .lineToConstantHeading(new Vector2d(3, 36))
                                .lineToConstantHeading(new Vector2d(3, 38.5))
                                .lineToConstantHeading(new Vector2d(45, 38.5))
                                .lineToConstantHeading(new Vector2d(45, 28))
                                .turn(Math.toRadians(180))
                                .waitSeconds(1)
                                .lineToConstantHeading(new Vector2d(52.5, 28))
                                .waitSeconds(1.5)
                                .lineToConstantHeading(new Vector2d(48, 28))
                                .lineToConstantHeading(new Vector2d(50, 60))
                                .build()
                );

        // Set field image
        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_OFFICIAL)
                .setDarkMode(true)
                // Background opacity from 0-1
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
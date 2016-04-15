package org.jointheleague.iaroc;

import android.os.SystemClock;

import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.jointheleague.iaroc.sensors.UltraSonicSensors;

public class Brain extends IRobotCreateAdapter {
    private final Dashboard dashboard;
    public UltraSonicSensors sonar;
    int distance = 0;
    public Brain(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard)
            throws ConnectionLostException {
        super(create);
        sonar = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
    }

    /* This method is executed when the robot first starts up. */
    public void initialize() throws ConnectionLostException {
        dashboard.log("Hello! I'm a Clever Robot!");
        //what would you like me to do, Clever Human?




    }
    /* This method is called repeatedly. */
    public void loop() throws ConnectionLostException {
        for (int i = 1; i < 66666; i++){
            this.driveDirect(i/9, 500);
            SystemClock.sleep(1000);
            this.driveDirect(i * 9, 500);
            SystemClock.sleep(1000);
        }
        readSensors(0);

        readSensors(0);
        distance = getDistance();
        if (isBumpRight()==true||isBumpLeft()==true){
            dashboard.speak("Screw that!");
            this.driveDirect(200, -200);
            SystemClock.sleep(3000);
        }

        dashboard.log(""+distance);

    }
}
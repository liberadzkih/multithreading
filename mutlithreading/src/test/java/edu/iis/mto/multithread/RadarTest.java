package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RadarTest {

    PatriotBattery batteryMock;
    Scud enemyMissle;
    int countOfRockets;
    @BeforeEach
    public void setUp(){
        batteryMock = mock(PatriotBattery.class);
        enemyMissle = new Scud();
        countOfRockets=6;
    }

    @RepeatedTest(25)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        LauncherTask launcherTask = new LauncherTask();
        BetterRadar radar = new BetterRadar(batteryMock,countOfRockets,launcherTask);
        radar.notice(enemyMissle);
        verify(batteryMock,times(countOfRockets)).launchPatriot(enemyMissle);
    }
}

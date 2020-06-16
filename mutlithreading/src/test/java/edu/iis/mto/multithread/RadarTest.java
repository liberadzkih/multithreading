package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {

    PatriotBattery batteryMock;
    Scud enemyMissle;
    int countOfRockets;
    LauncherTask launcherTask;
    @BeforeEach
    public void setUp(){
        batteryMock = mock(PatriotBattery.class);
        launcherTask = mock(LauncherTask.class);
        doAnswer(invocationOnMock ->{
            ((Runnable) invocationOnMock.getArgument(0)).run();
            return null;
        }).when(launcherTask).launch(any());

        enemyMissle = new Scud();
        countOfRockets=6;
    }

    @RepeatedTest(25)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        BetterRadar radar = new BetterRadar(batteryMock,countOfRockets,launcherTask);
        radar.notice(enemyMissle);
        verify(batteryMock,times(countOfRockets)).launchPatriot(enemyMissle);
    }
}

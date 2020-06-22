package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class BetterRadarTest {
    PatriotBattery batteryMock;
    LaunchPatriotTaskHandler launchPatriotTaskHandler;
    Scud enemyMissile;

    @BeforeEach
    public void prepare() {
        batteryMock = mock(PatriotBattery.class);
        launchPatriotTaskHandler = new SameThreadLaunchHandler();
        enemyMissile = new Scud();
    }

    @RepeatedTest(1000)
    public void missileShouldBeLaunchedZeroTimesOnZeroMissiles() {
        int numOfMissiles = 0;
        BetterRadar radar = new BetterRadar(batteryMock, launchPatriotTaskHandler, numOfMissiles);
        radar.notice(enemyMissile);

        verify(batteryMock, times(numOfMissiles)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(1000)
    public void missileShouldBeLaunchedZeroTimeOnNegativeMissiles() {
        int numOfMissiles = -1;
        BetterRadar radar = new BetterRadar(batteryMock, launchPatriotTaskHandler, numOfMissiles);
        radar.notice(enemyMissile);

        verify(batteryMock, times(0)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(1000)
    public void missileShouldBeLaunchedFiftyFiveTimesOnFiftyFiveMissiles() {
        int numOfMissiles = 55;
        BetterRadar radar = new BetterRadar(batteryMock, launchPatriotTaskHandler, numOfMissiles);
        radar.notice(enemyMissile);

        verify(batteryMock, times(numOfMissiles)).launchPatriot(enemyMissile);
    }

}

package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    PatriotBattery batteryMock;
    Scud enemyMissile;
    MissileLaunchHandler missileLaunchHandler;

    @BeforeEach
    public void setUp() {
        batteryMock = mock(PatriotBattery.class);
        enemyMissile = new Scud();
        missileLaunchHandler = mock(MissileLaunchHandler.class);
        doAnswer(invocation -> {
            ((Runnable) invocation.getArgument(0)).run();
            return null;
        }).when(missileLaunchHandler).launch(any());
    }

    @RepeatedTest(30)
    public void launchPatriotTenTimesWhenNoticesAScudMissle() {
        BetterRadar betterRadar = new BetterRadar(batteryMock, missileLaunchHandler, 10);
        betterRadar.notice(enemyMissile);
        verify(batteryMock, timeout(100).times(10)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(30)
    public void launchPatriotZeroTimesWhenNoticesAScudMissle() {
        BetterRadar betterRadar = new BetterRadar(batteryMock, missileLaunchHandler, 0);
        betterRadar.notice(enemyMissile);
        verify(batteryMock, never()).launchPatriot(enemyMissile);
    }

}

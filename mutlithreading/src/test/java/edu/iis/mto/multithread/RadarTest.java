package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {

    PatriotBattery batteryMock;
    Scud enemyMissile;

    @BeforeEach
    public void setUp() {
        batteryMock = mock(PatriotBattery.class);
        enemyMissile = new Scud();
    }

    @RepeatedTest(30)
    public void launchPatriotAtleastOnceWhenNoticesAScudMissle() {
        Radar radar = new Radar(batteryMock);
        radar.notice(enemyMissile);
        verify(batteryMock, timeout(100).atLeast(1)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(30)
    public void launchPatriotTenTimesWhenNoticesAScudMissle_withBetterRadar() {
        BetterRadar betterRadar = new BetterRadar(batteryMock, 10);
        betterRadar.notice(enemyMissile);
        verify(batteryMock, timeout(100).times(10)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(30)
    public void launchPatriotZeroTimesWhenNoticesAScudMissle_withBetterRadar() {
        BetterRadar betterRadar = new BetterRadar(batteryMock, 0);
        betterRadar.notice(enemyMissile);
        verify(batteryMock, never()).launchPatriot(enemyMissile);
    }

}

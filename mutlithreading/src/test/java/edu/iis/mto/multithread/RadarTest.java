package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {
    PatriotBattery batteryMock;
    Scud enemyMissile;

    @BeforeEach
    void setUp() {
        batteryMock = mock(PatriotBattery.class);
        enemyMissile = new Scud();
    }

    @RepeatedTest(20)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        Radar radar = new Radar(batteryMock);
        radar.notice(enemyMissile);
        verify(batteryMock, timeout(100).times(10)).launchPatriot(enemyMissile);
    }


    @RepeatedTest(15)
    public void launchPatriotOnceWhenNoticesAScudMissleXTimesUsingBetterRadar() {
        int howManyMissiles = 100;
        BetterRadar radar = new BetterRadar(batteryMock);
        radar.notice(enemyMissile, howManyMissiles);
        verify(batteryMock, timeout(10 * howManyMissiles).times(howManyMissiles))
                .launchPatriot(enemyMissile);
    }

}

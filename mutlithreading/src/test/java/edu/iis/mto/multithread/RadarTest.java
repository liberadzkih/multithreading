package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {

    @RepeatedTest(100)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        int howManyMissiles = 10;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock,new MissileLauncher(),howManyMissiles);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, timeout(20*howManyMissiles).times(howManyMissiles)).launchPatriot(enemyMissle);
    }

}

package edu.iis.mto.multithread;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RadarTest {

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }

    @RepeatedTest(10000)
    public void betterRadarTest() {
        int numOfMissiles = 100;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock, numOfMissiles);
        Scud enemyMissle = new Scud();
        try {
            radar.notice(enemyMissle);
        } catch (InterruptedException e) {
            fail("This shouldn't happen: " + e.getMessage());
        }
        verify(batteryMock, times(numOfMissiles)).launchPatriot(enemyMissle);
    }

}

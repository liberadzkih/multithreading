package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RadarTest {

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock,timeout(100)).launchPatriot(enemyMissle);
    }


    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle10TimesUsingBetterRadar() {
        int howManyMissiles = 10;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle,howManyMissiles);
        verify(batteryMock,timeout(100).times(howManyMissiles)).launchPatriot(enemyMissle);

    }

}

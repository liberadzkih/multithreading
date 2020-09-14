package edu.iis.mto.multithread;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RadarTest {

    @Test
    public void launchPatriotAtleastOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, timeout(100).atLeast(1)).launchPatriot(enemyMissle);
    }

    @Test
    public void launchPatriotTenTimesWhenNoticesAScudMissle_withBetterRadar() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(batteryMock);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock, timeout(100).times(10)).launchPatriot(enemyMissle);
    }

}

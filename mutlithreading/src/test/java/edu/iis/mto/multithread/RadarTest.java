package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {
    private final int MISSILES_AMOUNT = 50;

    @RepeatedTest(50)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(batteryMock, MISSILES_AMOUNT);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock, timeout(10 * MISSILES_AMOUNT).times(MISSILES_AMOUNT)).launchPatriot(enemyMissle);
    }

}

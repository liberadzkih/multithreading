package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {
    private final int staticMisslesAmount = 50;

    @RepeatedTest(50)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(batteryMock, staticMisslesAmount);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock, timeout(20 * staticMisslesAmount).times(staticMisslesAmount)).launchPatriot(enemyMissle);
    }

}

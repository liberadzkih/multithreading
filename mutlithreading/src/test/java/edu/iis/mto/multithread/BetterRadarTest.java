package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {

    @RepeatedTest(10)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        PatriotLauncher patriotLauncher = new PatriotLauncher();
        BetterRadar betterRadar = new BetterRadar(batteryMock, patriotLauncher, 1);
        Scud enemyMissile = new Scud();
        betterRadar.notice(enemyMissile);
        verify(batteryMock).launchPatriot(enemyMissile);
    }
}

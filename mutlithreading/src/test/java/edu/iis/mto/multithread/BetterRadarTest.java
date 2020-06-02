package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {
    private PatriotBattery batteryMock;
    private LaunchPatriot patriotLauncher;
    private Scud enemyMissile;

    @BeforeEach
    public void setUp() {
        batteryMock = mock(PatriotBattery.class);
        patriotLauncher = new LaunchPatriot();
        enemyMissile = new Scud();
    }

    @RepeatedTest(100)
    public void launchPatriotOnceWhenNoticesAScudMissile() throws InterruptedException {
        int numberOfMissiles = 1;
        BetterRadar betterRadar = new BetterRadar(batteryMock, numberOfMissiles, patriotLauncher);
        betterRadar.notice(enemyMissile);
        verify(batteryMock).launchPatriot(enemyMissile);
    }
}

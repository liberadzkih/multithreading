package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class BetterRadarTest {
    private PatriotBattery batteryMock;
    private LaunchPatriot patriotLauncher;
    private Scud enemyMissile;

    @BeforeEach
    public void setUp() {
        batteryMock = mock(PatriotBattery.class);
        enemyMissile = new Scud();
        patriotLauncher = mock(LaunchPatriot.class);
        doAnswer(invocation -> {
            ((Runnable) invocation.getArgument(0)).run();
            return null;
        }).when(patriotLauncher).launch(any(Runnable.class));
    }

    @RepeatedTest(100)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        int numberOfMissiles = 1;
        BetterRadar betterRadar = new BetterRadar(batteryMock, numberOfMissiles, patriotLauncher);
        betterRadar.notice(enemyMissile);
        verify(batteryMock).launchPatriot(enemyMissile);
    }
}

package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {
    private PatriotBattery batteryMock;
    private Scud enemyMissile;
    private PatriotLauncher patriotLauncher;
    private int howManyMissiles;

    @BeforeEach
    void setUp() {
        batteryMock = mock(PatriotBattery.class);
        enemyMissile = new Scud();
        patriotLauncher = mock(PatriotLauncher.class);
    }

    @RepeatedTest(15)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        makeCommandHandlerInvokesCommand(patriotLauncher);
        BetterRadar radar = new BetterRadar(batteryMock, patriotLauncher, 1);
        radar.notice(enemyMissile);
        verify(batteryMock).launchPatriot(enemyMissile);
    }


    @RepeatedTest(15)
    public void launchPatriotOnceWhenNoticesAScudMissleXTimesUsingBetterRadar() {
        howManyMissiles = 100;
        makeCommandHandlerInvokesCommand(patriotLauncher);
        BetterRadar radar = new BetterRadar(batteryMock, patriotLauncher, howManyMissiles);
        radar.notice(enemyMissile);
        verify(batteryMock, times(howManyMissiles)).launchPatriot(enemyMissile);
    }

    void makeCommandHandlerInvokesCommand(PatriotLauncher patriotLauncher) {
        doAnswer(invocationOnMock -> {
            Runnable runnable = invocationOnMock.getArgument(0);
            runnable.run();
            return null;
        }).when(patriotLauncher).launchHandler(any());
    }

}

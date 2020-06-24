package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {

    private static final PatriotLauncher patriotLauncher = mock(PatriotLauncher.class);
    private final PatriotBattery batteryMock = mock(PatriotBattery.class);
    private Scud enemyMissle;

    @BeforeAll
    public static void setUpBeforeAll() {
        doAnswer(invocation -> {
            ((Runnable) invocation.getArgument(0)).run();
            return null;

        }).when(patriotLauncher)
          .launchPatriot(any(Runnable.class));
    }

    @BeforeEach
    public void setUpBeforeEach() {
        enemyMissle = new Scud();
    }

    @RepeatedTest(value = 100)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        final int numberOfPatriots = 1;
        BetterRadar radar = new BetterRadar(batteryMock, numberOfPatriots, patriotLauncher);
        radar.notice(enemyMissle);
        verify(batteryMock, times(numberOfPatriots)).launchPatriot(enemyMissle);
    }

    @RepeatedTest(value = 100)
    public void launchTenPatriotsWhenNoticesAScudMissile() {
        final int numberOfPatriots = 1;
        BetterRadar radar = new BetterRadar(batteryMock, numberOfPatriots, patriotLauncher);
        radar.notice(enemyMissle);
        verify(batteryMock, times(numberOfPatriots)).launchPatriot(enemyMissle);
    }
}

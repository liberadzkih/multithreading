package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {

    private PatriotBattery batteryMock;
    private Scud enemyMissile;
    private PatriotSystem patriotSystem;

    @BeforeEach void setUp() {
        batteryMock = mock(PatriotBattery.class);
        enemyMissile = new Scud();
        patriotSystem = mock(PatriotSystem.class);
        doAnswer(invocation -> {
            ((Runnable) invocation.getArgument(0)).run();
            return null;
        }).when(patriotSystem).launchRocket(any(Runnable.class));
    }

    @RepeatedTest(15) void launchPatriotOnceWhenNoticesAScudMissileUseBetterRadar_10missiles() {
        BetterRadar radar = new BetterRadar(batteryMock, patriotSystem, 10);
        radar.notice(enemyMissile);
        verify(batteryMock, times(10)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(15) void launchPatriotOnceWhenNoticesAScudMissileUseBetterRadar_0missiles() {
        BetterRadar radar = new BetterRadar(batteryMock, patriotSystem, 0);
        radar.notice(enemyMissile);
        verify(batteryMock, times(0)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(15) void launchPatriotOnceWhenNoticesAScudMissileUseBetterRadar_1missile() {
        BetterRadar radar = new BetterRadar(batteryMock, patriotSystem, 1);
        radar.notice(enemyMissile);
        verify(batteryMock, times(1)).launchPatriot(enemyMissile);
    }
}

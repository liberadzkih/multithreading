package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {

    private PatriotBattery batteryMock;
    private Scud enemyMissile;

    @BeforeEach void setUp() {
        batteryMock = mock(PatriotBattery.class);
        enemyMissile = new Scud();
    }

    @RepeatedTest(15) void launchPatriotOnceWhenNoticesAScudMissile() {
        Radar radar = new Radar(batteryMock);
        radar.notice(enemyMissile);
        verify(batteryMock, timeout(100).times(10)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(15) void launchPatriotOnceWhenNoticesAScudMissileUseBetterRadar_10missiles() {
        BetterRadar radar = new BetterRadar(batteryMock, 10);
        radar.notice(enemyMissile);
        verify(batteryMock, timeout(100).times(10)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(15) void launchPatriotOnceWhenNoticesAScudMissileUseBetterRadar_0missiles() {
        BetterRadar radar = new BetterRadar(batteryMock, 0);
        radar.notice(enemyMissile);
        verify(batteryMock, timeout(100).times(0)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(15) void launchPatriotOnceWhenNoticesAScudMissileUseBetterRadar_1missile() {
        BetterRadar radar = new BetterRadar(batteryMock, 1);
        radar.notice(enemyMissile);
        verify(batteryMock, timeout(100).times(1)).launchPatriot(enemyMissile);
    }
}

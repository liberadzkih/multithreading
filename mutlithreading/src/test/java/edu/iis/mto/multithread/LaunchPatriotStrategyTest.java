package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LaunchPatriotStrategyTest {

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }
}

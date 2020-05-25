package edu.iis.mto.multithread;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RadarTest {

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }

    @RepeatedTest(1000)
    public void betterRadarTest() {
        int numOfMissiles = 100;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        AntiMissileLaunchProtocol antiMissileLaunchProtocol = mock(AntiMissileLaunchProtocol.class);
        BetterRadar radar = new BetterRadar(batteryMock, antiMissileLaunchProtocol, numOfMissiles);
        Scud enemyMissile = new Scud();
        radar.notice(enemyMissile);

        verify(antiMissileLaunchProtocol).getAntiMissileLaunchProtocolTask(batteryMock, enemyMissile, numOfMissiles);
    }

    @RepeatedTest(1000)
    public void antiMissileLaunchProtocolTest() {
        int numOfMissiles = 100;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        AntiMissileLaunchProtocol antiMissileLaunchProtocol = new AntiMissileLaunchProtocol();
        Scud enemyMissile = new Scud();
        Thread thread = new Thread(antiMissileLaunchProtocol.getAntiMissileLaunchProtocolTask(batteryMock, enemyMissile, numOfMissiles));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            fail("Failed to join AntiMissileLaunchProtocol thread!");
        }

        verify(batteryMock, times(numOfMissiles)).launchPatriot(enemyMissile);
    }

}

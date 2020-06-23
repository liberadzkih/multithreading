package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RadarTest {

    @Mock
    PatriotBattery batteryMock;

    @RepeatedTest(10)
    void launchPatriotRepetetiveTest() {
        int staticNumberOfMisslesToLaunch = 10;

        BetterRadar betterRadar = new BetterRadar(batteryMock, staticNumberOfMisslesToLaunch);
        Scud scud = new Scud();

        betterRadar.notice(scud);
        verify(batteryMock, timeout(30*staticNumberOfMisslesToLaunch).times(staticNumberOfMisslesToLaunch)).launchPatriot(scud);
    }

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }


}

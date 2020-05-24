package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class RadarTest {

    //test zachowania
    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock); //radar podłączony do baterii
        Scud enemyMissle = new Scud(); //wrogi pocisk jest dostrzezony prez baterie
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }
    //watki zewnetrzna zaleznosc

}

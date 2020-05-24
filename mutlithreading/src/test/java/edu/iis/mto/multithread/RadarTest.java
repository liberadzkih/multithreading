package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RadarTest {

    PatriotBattery batteryMock;
    Scud enemyMissle;
    int countOfRockets;
    @BeforeEach
    public void setUp(){
        batteryMock = mock(PatriotBattery.class);
        enemyMissle = new Scud();
        countOfRockets=15;
    }

    public void launchPatriotOnceWhenNoticesAScudMissle() {
        Radar radar = new Radar(batteryMock);
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }


}

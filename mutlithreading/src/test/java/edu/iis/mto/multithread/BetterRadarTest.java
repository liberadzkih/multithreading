package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    PatriotBattery batteryMock;

    @Before
    public void setup(){
        batteryMock = mock(PatriotBattery.class);
    }

    @Test
    public void patriotsShouldBeLaunchedGivenAmountTimes(){

        BetterRadar betterRadar = new BetterRadar(batteryMock,5,new RadarExecutor("diff"));
        betterRadar.notice(new Scud());
        verify(batteryMock, times(5)).launchPatriot();

    }
}
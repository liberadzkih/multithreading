package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    private static PatriotBattery batteryMock;

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @RepeatedTest(1000)
    public void patriotsShouldBeLaunchedGivenAmountTimes() {
        batteryMock = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(batteryMock, 5, new RadarExecutor("same"));
        betterRadar.notice(new Scud());
        verify(batteryMock, times(5)).launchPatriot();

    }
}

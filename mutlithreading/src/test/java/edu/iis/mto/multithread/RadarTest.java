package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class RadarTest {

    private static PatriotBattery batteryMock;

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @RepeatedTest(1000)
    public void patriotsShouldBeLaunchedGivenAmountTimes() {
        batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock, 5, new RadarExecutor("same"));
        radar.notice(new Scud());
        verify(batteryMock, times(5)).launchPatriot();

    }
}

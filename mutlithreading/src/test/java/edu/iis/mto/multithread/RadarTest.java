package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class RadarTest {

    private PatriotBattery batteryMock = mock(PatriotBattery.class);
    private Scud enemyMissle;

    @BeforeEach
    public void setUp() {
        enemyMissle = new Scud();
    }

    @RepeatedTest(value = 100)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        final int numberOfPatriots = 1;
        BetterRadar radar = new BetterRadar(batteryMock, numberOfPatriots);
        radar.notice(enemyMissle);
        verify(batteryMock, times(numberOfPatriots)).launchPatriot(enemyMissle);
    }

    @RepeatedTest(value = 100)
    public void launchTenPatriotsWhenNoticesAScudMissle() {
        final int numberOfPatriots = 1;
        BetterRadar radar = new BetterRadar(batteryMock, numberOfPatriots);
        radar.notice(enemyMissle);
        verify(batteryMock, times(numberOfPatriots)).launchPatriot(enemyMissle);
    }

}

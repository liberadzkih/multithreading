package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LaunchPatriotStrategyTest {

    @RepeatedTest(100)
    public void launch_should_call_patriot_battery_given_numbers_of_times() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        LaunchPatriotStrategy launchPatriotStrategy=new LaunchPatriotStrategy(batteryMock);
        Scud enemyMissle = new Scud();
        launchPatriotStrategy.launch(1,enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }

}

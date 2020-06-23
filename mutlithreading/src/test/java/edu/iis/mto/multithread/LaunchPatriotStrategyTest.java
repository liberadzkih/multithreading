package edu.iis.mto.multithread;
import org.junit.jupiter.api.RepeatedTest;
import static org.mockito.Mockito.*;

class LaunchPatriotStrategyTest {

    @RepeatedTest(100)
    public void launch_should_call_patriot_battery_given_numbers_of_times() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Launcher launcher = mock(Launcher.class);
        doAnswer(forMock -> {
            Runnable runnable = forMock.getArgument(0);
            runnable.run();
            return 0;
        }).when(launcher).startLauncher(any());

        BetterRadar radar = new BetterRadar(batteryMock,launcher,10);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock,times(10)).launchPatriot(enemyMissle);
    }

}

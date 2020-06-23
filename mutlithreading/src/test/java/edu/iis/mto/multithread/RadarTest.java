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
    private PatriotBattery batteryMock;
    @Mock
    private PatriotTaskLauncher launcher;

    @RepeatedTest(10)
    void launchPatriotRepetetiveTest() {
        int staticNumberOfMisslesToLaunch = 10;

        doAnswer(invocation -> {
            Runnable runnable = (Runnable) invocation.getArguments()[0];
            runnable.run();
            return null;

        }).when(launcher).launch(any());

        BetterRadar betterRadar = new BetterRadar(batteryMock, staticNumberOfMisslesToLaunch, launcher);
        Scud scud = new Scud();

        betterRadar.notice(scud);
        verify(batteryMock, times(staticNumberOfMisslesToLaunch)).launchPatriot(scud);
    }

}

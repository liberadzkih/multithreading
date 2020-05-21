package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BetterRadarTest {

    @Mock
    PatriotBattery batteryMock;

    @Mock
    CommandHandler commandHandler;

    @RepeatedTest(10)
    void shouldSendOneMissleWhenScudNoticed() {
        makeCommandHandlerInvokesCommand(commandHandler);

        BetterRadar radar = new BetterRadar(batteryMock, commandHandler, 1);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }

    @RepeatedTest(10)
    void shouldSendTenMissleWhenScudNoticed() {
        makeCommandHandlerInvokesCommand(commandHandler);

        BetterRadar radar = new BetterRadar(batteryMock, commandHandler, 10);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, times(10)).launchPatriot(enemyMissle);
    }

    void makeCommandHandlerInvokesCommand(CommandHandler commandHandler) {
        doAnswer(invocationOnMock -> {
            Runnable runnable = invocationOnMock.getArgument(0);
            runnable.run();
            return null;
        }).when(commandHandler).handleCommand(any());
    }
}

package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    private PatriotBattery batteryMock = mock(PatriotBattery.class);
    private static CommandLauncher commandLauncher = mock(CommandLauncher.class);
    private PatriotTaskGenerator patriotTaskGenerator = new PatriotTaskGenerator();

    @BeforeAll
    public static void init() {
        doAnswer(trigger -> {
            Runnable runnable = (Runnable) trigger.getArguments()[0];
            runnable.run();
            return null;
        }).when(commandLauncher).launchCommand(any(Runnable.class));
    }

    @RepeatedTest(100)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        BetterRadar betterRadar = new BetterRadar(batteryMock, patriotTaskGenerator, commandLauncher, 1);
        Scud enemyMissile = new Scud();
        betterRadar.notice(enemyMissile);
        verify(batteryMock).launchPatriot(enemyMissile);
    }
}

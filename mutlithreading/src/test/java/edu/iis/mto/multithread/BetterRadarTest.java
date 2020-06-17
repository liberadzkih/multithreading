package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;
import static org.mockito.Mockito.*;

public class BetterRadarTest {
	private PatriotBattery battery = mock(PatriotBattery.class);
	private MissleLauncher launcher = mock(MissleLauncher.class);
	
	private void launchNPatriotsWhenNoticeScudMissle(int misslesCount) {
		when(launcher.getNumberOfMisslesToLaunch()).thenReturn(misslesCount);
		
		doAnswer(invocation -> {
			Runnable runnable = (Runnable) invocation.getArguments()[0];
			runnable.run();
			return null;
			
		}).when(launcher).launchMissles(any());
		
		BetterRadar betterRadar = new BetterRadar(battery, launcher);
		Scud scud = new Scud();
		
		betterRadar.notice(scud);
		verify(battery, times(misslesCount)).launchPatriot(scud);
	}
	
	@RepeatedTest(10)
	public void launchZeroPatriotsWhenNoticeScudMissle() {
		launchNPatriotsWhenNoticeScudMissle(0);
	}
	
	@RepeatedTest(10)
	public void launchOnePatriotWhenNoticeScudMissle() {
		launchNPatriotsWhenNoticeScudMissle(1);
	}
	
	@RepeatedTest(10)
	public void launchFivePatriotsWhenNoticeScudMissle() {
		launchNPatriotsWhenNoticeScudMissle(5);
	}
}

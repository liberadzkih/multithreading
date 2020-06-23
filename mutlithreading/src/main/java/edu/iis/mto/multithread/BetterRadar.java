package edu.iis.mto.multithread;

public class BetterRadar {
	private PatriotBattery battery;
	private MissleLauncher launcher;
	
	public BetterRadar(PatriotBattery battery, MissleLauncher launcher) {
		this.battery = battery;
		this.launcher = launcher;
	}
	
	public void notice(Scud enemyMissle) {
		launchPatriot(enemyMissle);
	}
	
	private void launchPatriot(Scud enemyMissle) {
		Runnable launchPatriotTask = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < launcher.getNumberOfMisslesToLaunch(); i++) {
					battery.launchPatriot(enemyMissle);
				}
			}
		};
		
		launcher.launchMissles(launchPatriotTask);
	}
}

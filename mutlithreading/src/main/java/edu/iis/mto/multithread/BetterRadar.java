package edu.iis.mto.multithread;

public class BetterRadar {
	private PatriotBattery battery;
	private int numberOfMisslesToLaunch;
	private PatriotTaskLauncher launcher;

	public BetterRadar(PatriotBattery battery, int numberOfMissiles, PatriotTaskLauncher launcher) {
		this.launcher = launcher;
		this.battery = battery;
		this.numberOfMisslesToLaunch = numberOfMissiles;
	}

	public void notice(Scud enemyMissle) {
		launchPatriot(enemyMissle);
	}

	private void launchPatriot(Scud enemyMissle) {
		Runnable launchPatriotTask = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < numberOfMisslesToLaunch; i++) {
					battery.launchPatriot(enemyMissle);
				}
			}
		};

		launcher.launch(launchPatriotTask);
	}
}

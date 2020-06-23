package edu.iis.mto.multithread;

public class BetterRadar {
	private PatriotBattery battery;
	private int numberOfMisslesToLaunch;

	public BetterRadar(PatriotBattery battery, int numberOfMissiles) {
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

		new Thread(launchPatriotTask).start();
	}
}

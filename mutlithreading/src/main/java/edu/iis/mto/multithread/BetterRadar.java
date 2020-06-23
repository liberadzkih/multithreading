package edu.iis.mto.multithread;

public class BetterRadar {
	PatriotBattery patriotBattery;
	PatriotLauncher patriotLauncher;
	private int howManyMissilesToFire;

	public BetterRadar(PatriotBattery patriotBattery, PatriotLauncher patriotLauncher, int howManyMissilesToFire) {
		this.patriotBattery = patriotBattery;
		this.patriotLauncher = patriotLauncher;
		this.howManyMissilesToFire = howManyMissilesToFire;
	}

	public void notice(Scud enemyMissile) {
		patriotLauncher.launchHandler(() -> {
			for (int i = 0; i < howManyMissilesToFire; i++) patriotBattery.launchPatriot(enemyMissile);
		});
	}
}

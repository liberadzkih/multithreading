package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private int howManyMissiles;
    private MissileLauncher missileLauncher;

    public BetterRadar(PatriotBattery battery, MissileLauncher missileLauncher, int numberOfMissiles) {
        this.battery = battery;
        this.missileLauncher = missileLauncher;
        this.howManyMissiles = numberOfMissiles;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < howManyMissiles; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };

        missileLauncher.launchMissiles(launchPatriotTask);
    }

}

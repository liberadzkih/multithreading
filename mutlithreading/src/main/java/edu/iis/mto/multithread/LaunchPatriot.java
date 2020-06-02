package edu.iis.mto.multithread;

public class LaunchPatriot {

    public void launch(PatriotBattery patriotBattery, int numberOfMissile, Scud enemyMissile) {
        for (int i = 0; i < numberOfMissile; i++) {
            patriotBattery.launchPatriot(enemyMissile);
        }
    }
}

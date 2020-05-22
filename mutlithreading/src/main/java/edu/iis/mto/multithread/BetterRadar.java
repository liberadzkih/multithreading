package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private PatriotLauncher patriotLauncher;
    private int numberOfRockets;

    public BetterRadar(PatriotBattery battery, PatriotLauncher patriotLauncher, int numberOfRockets) {
        this.battery = battery;
        this.patriotLauncher = patriotLauncher;
        this.numberOfRockets = numberOfRockets;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) {
        patriotLauncher.launch(battery, numberOfRockets, enemyMissile);
    }
}

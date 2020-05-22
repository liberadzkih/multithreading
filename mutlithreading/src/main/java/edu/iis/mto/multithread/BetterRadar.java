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
        Runnable launchPatriotTask = patriotLauncher.launch(battery, numberOfRockets, enemyMissile);
        Thread patriot = new Thread(launchPatriotTask);
        patriot.start();
        try {
            patriot.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

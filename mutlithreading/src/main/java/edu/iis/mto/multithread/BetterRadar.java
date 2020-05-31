package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private int rocketsToLaunch;

    public BetterRadar(PatriotBattery battery, int rocketsToLaunch) {
        this.battery = battery;
        this.rocketsToLaunch = rocketsToLaunch;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < rocketsToLaunch; i++) {
                    battery.launchPatriot(enemyMissle);
                }
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}

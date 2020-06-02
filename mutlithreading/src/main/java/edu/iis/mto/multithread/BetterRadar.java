package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery patriotBattery;
    private int numberOfMissiles;
    private LaunchPatriot launchPatriot;

    public BetterRadar(PatriotBattery patriotBattery, int numberOfMissiles, LaunchPatriot launchPatriot) {
        this.patriotBattery = patriotBattery;
        this.numberOfMissiles = numberOfMissiles;
        this.launchPatriot = launchPatriot;
    }

    public void notice(Scud enemyMissile) throws InterruptedException {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) throws InterruptedException {
        Runnable launchPatriotTask = new Runnable() {
            @Override
            public void run() {
                launchPatriot.launch(patriotBattery, numberOfMissiles, enemyMissile);
            }
        };
        Thread thread = new Thread(launchPatriotTask);
        thread.start();
        thread.join();
    }
}

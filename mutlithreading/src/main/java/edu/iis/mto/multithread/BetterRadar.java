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

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) {
        Runnable launchPatriotTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numberOfMissiles; i++)
                    patriotBattery.launchPatriot(enemyMissile);
            }
        };
        launchPatriot.launch(launchPatriotTask);
    }
}

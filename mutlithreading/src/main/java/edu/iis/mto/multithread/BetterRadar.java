package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private Launcher launcher;
    private int number;

    public BetterRadar(PatriotBattery battery, Launcher launcher, int number) {
        this.battery = battery;
        this.launcher = launcher;
        this.number = number;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < number; i++) {
                    battery.launchPatriot(enemyMissle);
                }
            }
        };

        launcher.startLauncher(launchPatriotTask);
    }
}

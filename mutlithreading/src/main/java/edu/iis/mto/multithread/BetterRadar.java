package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private int countOfRockets;
    private Launcher launcher;

    public BetterRadar(PatriotBattery battery, int countOfRockets, Launcher launcher ) {
        this.battery = battery;
        this.countOfRockets = countOfRockets;
        this.launcher = launcher;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask =() -> {
            for (int i = 0; i < countOfRockets; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };
      launcher.launch(launchPatriotTask);
    }
}

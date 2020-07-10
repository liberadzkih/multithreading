package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery battery;
    private int missilesCount;

    public BetterRadar(PatriotBattery battery, int missilesCount) {
        this.battery = battery;
        this.missilesCount = missilesCount;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < missilesCount; i++) {
                battery.launchPatriot(enemyMissile);
            }
        };

        new Thread(launchPatriotTask).start();
    }
}

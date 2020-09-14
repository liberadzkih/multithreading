package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private final int MISSILES_TO_FIRE_AMOUNT = 10;

    public BetterRadar(PatriotBattery battery) {
        this.battery = battery;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < MISSILES_TO_FIRE_AMOUNT; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }

}

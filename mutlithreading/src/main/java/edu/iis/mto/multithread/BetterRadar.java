package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private MissileLaunchHandler missileLaunchHandler;
    private final int MISSILES_TO_FIRE_AMOUNT;

    public BetterRadar(PatriotBattery battery, MissileLaunchHandler missileLaunchHandler, int missiles) {
        this.battery = battery;
        this.missileLaunchHandler = missileLaunchHandler;
        this.MISSILES_TO_FIRE_AMOUNT = missiles;
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
        missileLaunchHandler.launch(launchPatriotTask);
    }

}

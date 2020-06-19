package edu.iis.mto.multithread;

class BetterRadar {

    private PatriotBattery battery;
    private int rocketsToLaunch;
    private PatriotSystem patriotSystem;

    BetterRadar(PatriotBattery battery, PatriotSystem patriotSystem, int rocketsToLaunch) {
        this.battery = battery;
        this.patriotSystem = patriotSystem;
        this.rocketsToLaunch = rocketsToLaunch;
    }

    void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < rocketsToLaunch; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };
        patriotSystem.launchRocket(launchPatriotTask);
    }
}

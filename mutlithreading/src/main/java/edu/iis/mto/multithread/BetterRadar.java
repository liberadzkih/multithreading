package edu.iis.mto.multithread;

class BetterRadar {

    private PatriotBattery battery;
    private int rocketsToLaunch;
    private PatriotSystem patriotSystem = new PatriotSystem();

    BetterRadar(PatriotBattery battery, int rocketsToLaunch) {
        this.battery = battery;
        this.rocketsToLaunch = rocketsToLaunch;
    }

    void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        patriotSystem.launchRocket(rocketsToLaunch, battery, enemyMissle);
    }
}

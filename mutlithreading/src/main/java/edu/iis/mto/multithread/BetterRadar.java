package edu.iis.mto.multithread;

public class BetterRadar {
    PatriotBattery patriotBattery;

    public BetterRadar(PatriotBattery patriotBattery) {
        this.patriotBattery = patriotBattery;
    }

    public void notice(Scud enemyMissile, int howManyMissilesToFire) {
        for (int i = 0; i < howManyMissilesToFire; i++) {
            new Thread(() -> patriotBattery.launchPatriot(enemyMissile)).start();
        }
    }
}

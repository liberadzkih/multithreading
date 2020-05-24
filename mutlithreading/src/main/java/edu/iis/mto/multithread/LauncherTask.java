package edu.iis.mto.multithread;

public class LauncherTask implements Launcher {

    @Override public void launch(Scud enemyMissle, int howManyRockets, PatriotBattery patriotBattery) {
        for (int i = 0; i < howManyRockets; i++) {
            patriotBattery.launchPatriot(enemyMissle);
        }
    }
}

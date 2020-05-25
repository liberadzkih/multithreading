package edu.iis.mto.multithread;

public class AntiMissileLaunchProtocol {
    public Runnable getAntiMissileLaunchProtocolTask(PatriotBattery battery, Scud enemyMissile, int missilesToLaunch) {
        return () -> {
            for (int i = 0; i < missilesToLaunch; i++) {
                battery.launchPatriot(enemyMissile);
            }
        };
    }
}

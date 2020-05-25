package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery battery;
    private AntiMissileLaunchProtocol antiMissileLaunchProtocol;
    private int missilesToShootOnNotice;

    public BetterRadar(PatriotBattery battery, AntiMissileLaunchProtocol antiMissileLaunchProtocol, int missilesToShootOnNotice) {
        this.battery = battery;
        this.antiMissileLaunchProtocol = antiMissileLaunchProtocol;
        this.missilesToShootOnNotice = missilesToShootOnNotice;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) {
        Runnable launchPatriotTask = antiMissileLaunchProtocol.getAntiMissileLaunchProtocolTask(battery, enemyMissile, missilesToShootOnNotice);
        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
        try {
            launchingThread.join();
        } catch (InterruptedException e) {
            System.out.println("Failed to join thread: " + e.getCause());
        }
    }
}

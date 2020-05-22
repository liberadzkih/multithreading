package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private PatriotTaskGenerator patriotTaskGenerator;
    private int numberOfRockets;

    public BetterRadar(PatriotBattery battery, PatriotTaskGenerator patriotTaskGenerator, int numberOfRockets) {
        this.battery = battery;
        this.patriotTaskGenerator = patriotTaskGenerator;
        this.numberOfRockets = numberOfRockets;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) {
        Runnable launchPatriotTask = patriotTaskGenerator.generateTask(battery, numberOfRockets, enemyMissile);
        Thread patriot = new Thread(launchPatriotTask);
        patriot.start();
        try {
            patriot.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package edu.iis.mto.multithread;

public class PatriotLauncher {

    private PatriotBattery battery;
    private int numberOfPatriots;
    private Scud enemyMissle;

    public PatriotLauncher(PatriotBattery battery, int numberOfPatriots, Scud enemyMissle) {
        this.battery = battery;
        this.numberOfPatriots = numberOfPatriots;
        this.enemyMissle = enemyMissle;
    }

    public void launchPatriot() {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < numberOfPatriots; i++) {
                    battery.launchPatriot(enemyMissle);
                }
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
        try {
            launchingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package edu.iis.mto.multithread;

public class BetterRadar {
    
    private PatriotBattery battery;
    private int misslesAmount;

    public BetterRadar(PatriotBattery battery, int misslesAmount) {
        this.battery = battery;
        this.misslesAmount = misslesAmount;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < misslesAmount; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}

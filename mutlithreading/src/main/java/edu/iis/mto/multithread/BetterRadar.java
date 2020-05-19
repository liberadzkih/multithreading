package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar implements Runnable {

    private PatriotBattery battery;
    private int count;
    private Executor executor;

    public BetterRadar(PatriotBattery battery, int count, Executor executor) {
        this.battery = battery;
        this.count = count;
        this.executor = executor;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        executor.execute(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            battery.launchPatriot();
        }
    }
}

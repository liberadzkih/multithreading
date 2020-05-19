package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {

    private PatriotBattery battery;
    private int count;
    private Executor executor;

    public BetterRadar(PatriotBattery battery, int count, Executor executor) {
        this.battery = battery;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {

    }

}
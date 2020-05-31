package edu.iis.mto.multithread;

class PatriotSystem {

    void launchRocket(int rocketsToLaunch, PatriotBattery battery, Scud enemyMissle) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < rocketsToLaunch; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}

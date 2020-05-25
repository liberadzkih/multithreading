package edu.iis.mto.multithread;

public class BetterRadar {

    private final int timesLaunch;
    private LaunchPatriotStrategy launchPatriotStrategy;

    public BetterRadar(int timesLaunch, LaunchPatriotStrategy launchPatriotStrategy) {
        this.timesLaunch = timesLaunch;
        this.launchPatriotStrategy=launchPatriotStrategy;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                launchPatriotStrategy.launch(timesLaunch,enemyMissle);
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}

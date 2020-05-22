package edu.iis.mto.multithread;

public class PatriotLauncher {

    public void launch(PatriotBattery patriotBattery, int numberOfRockets, Scud scud) {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < numberOfRockets; i++) {
                    patriotBattery.launchPatriot(scud);
                }
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}

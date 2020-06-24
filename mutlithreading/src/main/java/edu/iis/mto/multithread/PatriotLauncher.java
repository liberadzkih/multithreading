package edu.iis.mto.multithread;

public class PatriotLauncher {

    public void launchPatriot(Runnable launchPatriotTask) {
        new Thread(launchPatriotTask).start();
    }

}

package edu.iis.mto.multithread;

public class LaunchPatriot {

    public void launch(Runnable launchTask) {
        new Thread(launchTask).start();
    }
}

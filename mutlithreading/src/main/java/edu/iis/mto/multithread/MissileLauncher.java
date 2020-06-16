package edu.iis.mto.multithread;

public class MissileLauncher {

    public void launchMissiles(Runnable task) {
        new Thread(task).start();
    }
}

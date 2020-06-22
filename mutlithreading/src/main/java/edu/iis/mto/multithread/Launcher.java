package edu.iis.mto.multithread;

public class Launcher {

    public void startLauncher(Runnable task) {
        new Thread(task).start();
    }
}

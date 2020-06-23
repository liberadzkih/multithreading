package edu.iis.mto.multithread;

public class LauncherTask implements Launcher {

    @Override public void launch(Runnable task) {
        new Thread(task).start();
    }
}

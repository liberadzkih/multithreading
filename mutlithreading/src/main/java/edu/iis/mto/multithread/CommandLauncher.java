package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommandLauncher {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void launchCommand(Runnable command) {
        executorService.execute(command);
    }
}

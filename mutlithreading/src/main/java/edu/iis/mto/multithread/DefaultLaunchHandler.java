package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DefaultLaunchHandler implements LaunchPatriotTaskHandler {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void launch(Runnable launchCommand) {
        executorService.submit(launchCommand);
    }
}

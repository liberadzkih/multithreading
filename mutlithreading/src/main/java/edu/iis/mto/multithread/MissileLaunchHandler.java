package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MissileLaunchHandler {

    ExecutorService executorService = Executors.newFixedThreadPool(1);

    void launch(Runnable command) {
        executorService.submit(command);
    }
}

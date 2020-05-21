package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommandHandler {
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    void handleCommand(Runnable command){
        executorService.submit(command);
    }
}

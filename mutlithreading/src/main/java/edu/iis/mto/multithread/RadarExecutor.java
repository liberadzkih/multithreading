package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class RadarExecutor implements Executor {

    String threadType = null;

    public RadarExecutor(String threadType) {
        this.threadType = threadType;
    }

    @Override
    public void execute(Runnable command) {
        if (threadType.equals("same")) {
            command.run();
        } else if (threadType.equals("diff")) {
            new Thread(command).run();
        }
    }
}
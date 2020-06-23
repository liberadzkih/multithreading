package edu.iis.mto.multithread;

public class SameThreadLaunchHandler implements LaunchPatriotTaskHandler {
    @Override
    public void launch(Runnable launchCommand) {
        launchCommand.run();
    }
}

package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private PatriotTaskGenerator patriotTaskGenerator;
    private CommandLauncher commandLauncher;
    private int numberOfRockets;

    public BetterRadar(PatriotBattery battery, PatriotTaskGenerator patriotTaskGenerator, CommandLauncher commandLauncher,
            int numberOfRockets) {
        this.battery = battery;
        this.patriotTaskGenerator = patriotTaskGenerator;
        this.commandLauncher = commandLauncher;
        this.numberOfRockets = numberOfRockets;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) {
        Runnable launchPatriotTask = patriotTaskGenerator.generateTask(battery, numberOfRockets, enemyMissile);
        commandLauncher.launchCommand(launchPatriotTask);
    }
}

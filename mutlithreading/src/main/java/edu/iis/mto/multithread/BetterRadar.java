package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery battery;
    private CommandHandler commandHandler;
    private final int missleAmount;

    public BetterRadar(PatriotBattery battery, CommandHandler commandHandler, int missleAmount) {
        this.battery = battery;
        this.commandHandler = commandHandler;
        this.missleAmount = missleAmount;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {

        Runnable command = () -> {
            for (int i = 0; i < missleAmount; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };
        commandHandler.handleCommand(command);
    }
}

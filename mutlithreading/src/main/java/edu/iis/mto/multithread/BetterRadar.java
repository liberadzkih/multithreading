package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery battery;
    private CommandHandler commandHandler;

    public BetterRadar(PatriotBattery battery, CommandHandler commandHandler) {
        this.battery = battery;
        this.commandHandler = commandHandler;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {

        Runnable command = () -> {
            for (int i = 0; i < 10; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };
        commandHandler.handleCommand(command);
    }
}

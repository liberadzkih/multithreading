package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery battery;
    private LaunchPatriotTaskHandler launchPatriotTaskHandler;
    private int missilesToShootOnNotice;

    public BetterRadar(PatriotBattery battery, LaunchPatriotTaskHandler launchPatriotTaskHandler, int missilesToShootOnNotice) {
        this.battery = battery;
        this.launchPatriotTaskHandler = launchPatriotTaskHandler;
        this.missilesToShootOnNotice = missilesToShootOnNotice;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < missilesToShootOnNotice; i++) {
                battery.launchPatriot(enemyMissile);
            }
        };
        launchPatriotTaskHandler.launch(launchPatriotTask);
    }
}

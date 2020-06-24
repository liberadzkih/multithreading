package edu.iis.mto.multithread;

public class BetterRadar {

    private final PatriotBattery battery;
    private final int numberOfPatriots;
    private final PatriotLauncher patriotLauncher;
    private Scud enemyMissile;

    public BetterRadar(PatriotBattery battery, int numberOfPatriots, PatriotLauncher patriotLauncher) {
        this.battery = battery;
        this.numberOfPatriots = numberOfPatriots;
        this.patriotLauncher = patriotLauncher;
    }

    public void notice(Scud enemyMissle) {
        this.enemyMissile = enemyMissle;
        launchPatriot();
    }

    private void launchPatriot() {
        Runnable launchPatriot = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < numberOfPatriots; i++) {
                    battery.launchPatriot(enemyMissile);
                }
            }
        };
        patriotLauncher.launchPatriot(launchPatriot);
    }

}

package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private int numberOfPatriots;
    private Scud enemyMissle;

    public BetterRadar(PatriotBattery battery, int numberOfPatriots) {
        this.battery = battery;
        this.numberOfPatriots = numberOfPatriots;
    }

    public void notice(Scud enemyMissle) {
        this.enemyMissle = enemyMissle;
        launchPatriot();
    }

    private void launchPatriot() {
        new PatriotLauncher(battery, numberOfPatriots, enemyMissle).launchPatriot();
    }

}

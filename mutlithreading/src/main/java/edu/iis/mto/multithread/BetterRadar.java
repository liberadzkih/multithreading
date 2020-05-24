package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private int countOfRockets;
    //zewnetrzna zaleznosc -> sposob wystrzelenia Patriota
    private Launcher launcher;
    public BetterRadar(PatriotBattery battery, int countOfRockets, Launcher launcher ) {
        this.battery = battery;
        this.countOfRockets = countOfRockets;
    }

    public void notice(Scud enemyMissle) {

    }
}

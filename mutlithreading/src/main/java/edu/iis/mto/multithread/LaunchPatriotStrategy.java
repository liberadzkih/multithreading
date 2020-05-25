package edu.iis.mto.multithread;

public class LaunchPatriotStrategy {

    private PatriotBattery battery;

    public LaunchPatriotStrategy(PatriotBattery battery) {
        this.battery = battery;
    }

    public void launch(int timesLaunch, Scud enemyMissle){
        for(int i=0;i<timesLaunch;i++){
            battery.launchPatriot(enemyMissle);
        }
    }

}

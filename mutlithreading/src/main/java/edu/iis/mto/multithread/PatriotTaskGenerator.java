package edu.iis.mto.multithread;

public class PatriotTaskGenerator {

    public Runnable generateTask(PatriotBattery patriotBattery, int numberOfRockets, Scud scud) {
        return () -> {
            for (int i = 0; i < numberOfRockets; i++) {
                patriotBattery.launchPatriot(scud);
            }
        };
    }
}

package edu.iis.mto.multithread;

public class PatriotLauncher {

    public static Runnable launch(PatriotBattery patriotBattery, int numberOfRockets, Scud scud) {
        return () -> {
            for (int i = 0; i < numberOfRockets; i++) {
                patriotBattery.launchPatriot(scud);
            }
        };
    }
}

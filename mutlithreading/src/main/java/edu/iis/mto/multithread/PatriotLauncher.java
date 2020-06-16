package edu.iis.mto.multithread;

import java.util.concurrent.Executors;

public class PatriotLauncher {
	void launchHandler(Runnable launch) {
		Executors.newFixedThreadPool(1).submit(launch);
	}
}

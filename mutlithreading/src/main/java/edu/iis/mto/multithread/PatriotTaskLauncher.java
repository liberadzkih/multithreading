package edu.iis.mto.multithread;

public class PatriotTaskLauncher {
	private int howManyMissles;
	public PatriotTaskLauncher(int howManyMissles) {
		this.howManyMissles = howManyMissles;
	}

	public void launch(Runnable launchThread) {
		new Thread(launchThread).start();
	}
}

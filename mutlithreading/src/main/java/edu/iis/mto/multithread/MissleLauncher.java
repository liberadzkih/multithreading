package edu.iis.mto.multithread;

public class MissleLauncher {
	private int numberOfMisslesToLaunch;
	
	public MissleLauncher(int numberOfMisslesToLaunch) {
		this.numberOfMisslesToLaunch = numberOfMisslesToLaunch;
	}
	
	public int getNumberOfMisslesToLaunch() {
		return numberOfMisslesToLaunch;
	}
	
	public void launchMissles(Runnable launchingThread) {
		new Thread(launchingThread).start();
	}
}

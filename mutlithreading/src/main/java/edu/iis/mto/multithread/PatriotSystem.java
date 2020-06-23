package edu.iis.mto.multithread;

class PatriotSystem {

    void launchRocket(Runnable launchPatriotTask) {
        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}

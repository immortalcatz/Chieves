package me.mrkirby153.chieves.updater;

public class ThreadUpdateChecker extends Thread {

    private UpdateChecker.Channel channel = UpdateChecker.Channel.STABLE;
    public ThreadUpdateChecker(UpdateChecker.Channel channel) {
        this.channel = channel;
        setName("Chieves update checker thread");
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        // Get the last successful build
        try {
        } catch (Exception e) {
            UpdateChecker.updateFailure = true;
            e.printStackTrace();
        }
        UpdateChecker.updateDone = true;
    }
}

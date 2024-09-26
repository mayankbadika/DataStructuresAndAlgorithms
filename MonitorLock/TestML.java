package myclass.MonitorLock;

public class TestML {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);

        Thread producerThread = new Thread(() -> {
            for(int i = 1; i<=1000;i++) {
                buffer.add(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for(int i = 1; i<=1000;i++) {
                buffer.remove();
            }
        });

        producerThread.start();
        consumerThread.start();
    }

}

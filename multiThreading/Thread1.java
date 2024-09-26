package myclass.multiThreading;

public class Thread1 implements Runnable {

    @Override
    public void run() {
        for (int i=0;i<5;i++) {
            System.out.println("Thread1 is running "+i);
        }
    }
}

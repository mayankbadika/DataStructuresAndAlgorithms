package myclass.multiThreading;

public class Thread2 extends Thread {

    @Override
    public void run() {
        for (int i=0;i<5;i++) {
            System.out.println("Thread2 is running "+i);
        }
    }

}

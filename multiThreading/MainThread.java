package myclass.multiThreading;

public class MainThread {

    public static void main(String[] args) {
        System.out.println("Main thread is starting");

        // When implementing Runnable, the Runnable interface does not have a start method
        // We create an instance of the Thread class and then pass the Runnable instance (thread1) to it
        Thread1 thread1 = new Thread1(); // runnable instance
        Thread thread = new Thread(thread1, "Thread1");
        thread.start();

        // Now the Thread2 class extends the Thread class. Thread class by default has a start method
        // So Thread2 class will inherit that method as it is extending the Thread class
        Thread2 thread2 = new Thread2();
        thread2.start();

        System.out.println("Main thread is stopping");
    }
}

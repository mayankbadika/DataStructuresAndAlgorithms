package myclass.multiThreading;

public class FixedDeadLock {

    public static void main(String[] args) {

        // Two objects used as locks
        String lock1 = "mayank";
        String lock2 = "badika";

        /*
         * Fixing the Deadlock Issue:
         *
         * To avoid deadlock, we need to ensure that threads acquire locks in a consistent order.
         * One way to achieve this is to make sure that all threads acquire locks in the same order.
         *
         * In our case, both Thread 1 and Thread 2 attempt to acquire lock1 and lock2, but in different orders,
         * leading to a potential deadlock scenario.
         *
         * To fix this, we can ensure that both threads acquire locks in the same order:
         *
         * 1. Modify Thread 1 to acquire lock1 first and then lock2.
         * 2. Modify Thread 2 to acquire lock1 first and then lock2.
         *
         * This way, regardless of the order in which threads start or execute, deadlock cannot occur,
         * as all threads will follow the same lock acquisition order.
         *
         * Here's how to modify the code:
         */

        // Thread 1 now acquires lock1 first, then lock2
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {  // Acquire lock1
                try {
                    Thread.sleep(1);  // Simulate some work
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock2) {  // Then acquire lock2
                    System.out.println("Lock acquired by Thread 1");
                }
            }
        }, "Thread 1");

        // Thread 2 now also acquires lock1 first, then lock2
        Thread thread2 = new Thread(() -> {
            synchronized (lock1) {  // Acquire lock1
                try {
                    Thread.sleep(1);  // Simulate some work
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock2) {  // Then acquire lock2
                    System.out.println("Lock acquired by Thread 2");
                }
            }
        }, "Thread 2");

        /*
         * With this modification, regardless of the order in which Thread 1 and Thread 2 start or execute,
         * deadlock cannot occur, as both threads will always acquire locks in the same order.
         *
         * This ensures consistency in lock acquisition and prevents the possibility of deadlock.
         */

    }
}

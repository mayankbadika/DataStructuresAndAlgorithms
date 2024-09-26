package myclass.multiThreading;

/*
 * Explanation of Deadlock:
 *
 * 1. Two threads, Thread 1 and Thread 2, are attempting to acquire two locks, lock1 and lock2, in different orders.
 *
 * 2. Thread 1 starts by acquiring lock1 and then attempts to acquire lock2.
 *    Thread 2 starts by acquiring lock2 and then attempts to acquire lock1.
 *
 * 3. If both threads start almost simultaneously, it's possible for Thread 1 to acquire lock1
 *    and Thread 2 to acquire lock2, creating a situation where each thread is waiting for the lock
 *    the other thread holds.
 *
 * 4. As a result, Thread 1 is waiting for Thread 2 to release lock2, and Thread 2 is waiting for
 *    Thread 1 to release lock1, leading to a deadlock situation where both threads are blocked indefinitely.
 *
 * 5. This demonstrates the importance of carefully managing the order in which locks are acquired to
 *    avoid potential deadlocks.
 */


public class DeadLock {
    public static void main(String[] args) {

        // Two objects used as locks
        String lock1 = "mayank";
        String lock2 = "badika";

        System.out.println("Main thread is starting");

        // Thread 1 tries to acquire lock1 then lock2
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {  // Acquire lock1
                try {
                    Thread.sleep(1);  // Simulate some work
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock2) {  // Try to acquire lock2
                    System.out.println("Lock acquired by Thread 1");
                }
            }
        }, "Thread 1");

        // Thread 2 tries to acquire lock2 then lock1
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {  // Acquire lock2
                try {
                    Thread.sleep(1);  // Simulate some work
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock1) {  // Try to acquire lock1
                    System.out.println("Lock acquired by Thread 2");
                }
            }
        }, "Thread 2");

        // Start both threads
        thread1.start();
        thread2.start();

        System.out.println("Main thread is stopping");
    }
}

/*
 * Output:
 *
 * Main thread is starting
 * Main thread is stopping
 *
 * Explanation:
 *
 * The output indicates that only the messages from the main thread are being printed. This suggests that neither Thread 1 nor Thread 2 managed to acquire both locks before the main thread completed.
 *
 * Here's a possible explanation:
 *
 * 1. The main thread starts and initializes Thread 1 and Thread 2.
 * 2. Both Thread 1 and Thread 2 start, but before either can acquire both locks, the main thread continues execution.
 * 3. The main thread prints "Main thread is stopping" and terminates.
 * 4. Since neither Thread 1 nor Thread 2 acquired both locks, they don't print their messages or complete execution.
 *
 * This scenario occurs when the main thread completes before the deadlock situation between Thread 1 and Thread 2 occurs. It's one of the possible outcomes due to the nondeterministic nature of thread scheduling and timing.
 */


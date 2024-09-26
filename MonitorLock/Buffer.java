package myclass.MonitorLock;

import java.util.LinkedList;
import java.util.Queue;
/**
 * notify() vs notifyAll():
 *
 * - notify():
 *   - Wakes up one thread that is waiting on the monitor (i.e., the object's lock).
 *   - The specific thread that is woken up is chosen by the JVM, not the programmer.
 *   - If multiple threads are waiting, only one will be woken up; the others will continue waiting.
 *   - Best used when you're sure that only one waiting thread can make progress.
 *
 * - notifyAll():
 *   - Wakes up all threads that are waiting on the monitor.
 *   - Only one thread will acquire the lock and proceed, while others will recheck the condition
 *     (and go back to waiting if they cannot proceed).
 *   - Useful when multiple threads could be waiting on different conditions, or when multiple
 *     threads are waiting for different resources.
 *   - Ensures all threads get a chance to check if they can proceed, making it safer in complex
 *     scenarios like multiple producers and consumers.
 *
 * In a single producer-consumer situation:
 * - notify() can be more efficient since only one thread needs to be woken up.
 *
 * In a multiple producer-consumer situation:
 * - notifyAll() is generally safer because you need to ensure that the correct thread is woken up
 *   to make progress.
 */
public class Buffer {
    int size;
    Queue<Integer> queue;

    public Buffer(int size) {
        this.size = size;  // Corrected assignment
        queue = new LinkedList<>();
    }

    public synchronized void add(int x) {
        while(queue.size() == size) {  // Changed to 'while' to handle spurious wakeups
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(x);
        notify();
        System.out.println("Added elem = " + x);
    }

    public synchronized void remove() {
        while(queue.isEmpty()) {  // Changed to 'while' to handle spurious wakeups
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int elem = queue.poll();
        notify();
        System.out.println("Removed elem = " + elem);
    }
}

package myclass.multiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
    // Explanation:
    // BlockingQueue Class: This class manages a queue with a specified capacity.
    // It uses a LinkedList to store the elements.
    private final Queue<T> queue;
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    // Add Method:
    // If the queue is full (i.e., its size equals its capacity), the thread waits until there is space available.
    // Once space is available, the item is added to the queue, and notifyAll() is called to wake up any waiting threads.
    public synchronized void add(T item) {
        while (queue.size() == capacity) {
            try {
                queue.wait();  // Wait until space is available
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(item);
        queue.notifyAll();  // Notify any waiting threads that an item has been added
    }

    // Remove Method:
    // If the queue is empty, the thread waits until an item is available.
    // Once an item is available, it is removed from the queue, and notifyAll() is called to wake up any waiting threads.
    public synchronized T remove() {
        while (queue.isEmpty()) {
            try {
                queue.wait();  // Wait until an item is available
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        T item = queue.remove();
        queue.notifyAll();  // Notify any waiting threads that an item has been removed
        return item;
    }
}
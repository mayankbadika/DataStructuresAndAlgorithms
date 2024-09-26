package myclass.multiThreading;

public class Stack {
    private int top;
    private int[] array;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return(top == array.length - 1);
    }

    // Synchronize the push method to ensure thread safety when adding elements to the stack
    // When a thread enters a synchronized method, it acquires a lock associated with the object instance
    // Once the lock is acquired, the thread gains exclusive access to the synchronized method
    // This prevents other threads from concurrently modifying shared data until the lock is released

    public synchronized boolean push(int elem) {
        if(isFull()) return false;
        ++ top;
        try {
            Thread.sleep(50); // Sleep to simulate some delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        array[top] = elem;

        return true;
    }

    /*
     * The Thread.sleep() method can be interrupted by another thread
     * calling the interrupt() method on the sleeping thread.
     * When the sleeping thread is interrupted, it will throw an
     * InterruptedException. Here's how it works:
     *
     * Another thread (let's call it Thread B) calls the interrupt()
     * method on the sleeping thread (let's call it Thread A).
     * If Thread A is in the sleeping state due to the Thread.sleep()
     * call, it will wake up immediately.
     * Upon waking up, Thread A's sleep is interrupted, and it throws
     * an InterruptedException.
     */


    public synchronized int pop() {
        if(isEmpty()) return Integer.MIN_VALUE;

        int topValue = array[top];
        array[top] = Integer.MIN_VALUE;
        try {
            Thread.sleep(50); // Sleep to simulate some delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        top--;

        return topValue;
    }
}

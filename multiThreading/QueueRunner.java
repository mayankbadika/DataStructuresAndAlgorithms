package myclass.multiThreading;

public class QueueRunner {
    public static void main(String[] args) {
        // Instantiating a generic class:
        // BlockingQueue<Integer> queue = new BlockingQueue<>(5);
        // Here, BlockingQueue is a generic class, and Integer is the type parameter.
        // This means the queue will hold Integer objects.
        // The capacity of the queue is set to 5.
        BlockingQueue<Integer> queue = new BlockingQueue<>(5);
    }
}

package myclass.singleton;

public class TVSet {
    // Ensure visibility of tvSet across threads by making it volatile
    //volatile adds it to the main memory so that every thread can read the updated value
    private static volatile TVSet tvSet = null;

    private TVSet() {
        System.out.println("TV set instantiated");
    }

    // Make getInstance method public and static to allow external access
    // Using synchronized method for simplicity
    public synchronized static TVSet getInstanceUsingMethod() {
        // If the instance is null, create a new one
        if(tvSet == null) {
            tvSet = new TVSet();
        }
        // Return the singleton instance
        return tvSet;
    }

    // Make getInstance method public and static to allow external access
    // Using synchronized block for fine-grained control
    public static TVSet getInstanceUsingBlock() {
        // Check if the instance is null (double-checked locking)
        if(tvSet == null) {
            // Synchronize the creation of the instance to ensure thread safety
            synchronized (TVSet.class) {
                // Double-check the instance inside the synchronized block
                if(tvSet == null) {
                    // If the instance is still null, create a new one
                    tvSet = new TVSet();
                }
            }
        }
        // Return the singleton instance
        return tvSet;
    }
}

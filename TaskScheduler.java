package myclass;
/*
    Tasks with memory required to process are given which should be run in a processor.
    Tasks : [1,4,5,2,3] (the numbers represent memory needed)
    Type of tasks are given in another array
    Task Type : [1,2,1,3,4]
    Another input is given which is the max memory the processor can run at a time.
    Max_memory : 6
    Now only two tasks with same task type can run in parallel. Assume each tasks take 1 unit of time. Find out the time taken to complete all the tasks.
    Sample output : 4 units. Because there are two tasks of type 1 and adding their memory is 6 which is eq to max_memory. So they ll run in parallel. All other tasks are of different types and their memories are less than max_memory. So they ll each take 1 unit of time.
 */

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        int[] tasks = {1, 4, 5, 2, 3};
        int[] taskTypes = {1, 2, 1, 3, 4};
        int maxMemory = 6;

        int result = calculateTime(tasks, taskTypes, maxMemory);
        System.out.println("Total time units: " + result); // Output: 4
    }

    public static int calculateTime(int[] tasks, int[] type, int maxMemory) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int time =0;

        // Group same tasks together
        for( int i =0;i<tasks.length;i++) {
            List<Integer> list = map.getOrDefault(type[i], new ArrayList<>());
            list.add(tasks[i]);
            map.put(type[i], list);
        }

        for(int elem : map.keySet()) {
            List<Integer> similarTasks = map.get(elem);
            // Greedily sorting in descending order to group two task together to take advantage of parallel processing
            Collections.sort(similarTasks, Collections.reverseOrder());

            int i =0;
            while(i < similarTasks.size()) {
                // since two tasks can be grouped together
                if(i+1 < similarTasks.size() && ( similarTasks.get(i) + similarTasks.get(i+1) <= maxMemory)) {
                    time ++;
                    i += 2;
                } else {
                    // If can't be grouped then it will take a single unit time to process
                    time++;
                    i++;
                }
            }
        }

        return time;
    }
}

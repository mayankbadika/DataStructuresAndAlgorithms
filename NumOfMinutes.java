package myclass;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumOfMinutes {
    public static void main(String[] args) {
        int n = 7;
        int headID = 6;
        int[] manager = {1,2,3,4,5,6,-1};
        int[] informTime = {0,6,5,4,3,2,1};
        NumOfMinutes obj = new NumOfMinutes();

        System.out.println(obj.numOfMinutes(n, headID, manager, informTime));
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Build the tree representation using adjacency list
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                tree.get(manager[i]).add(i);
            }
        }

        // Perform BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { headID, 0 }); // {employeeID, time to reach this employee}
        int maxTime = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currID = current[0];
            int currTime = current[1];
            maxTime = Math.max(maxTime, currTime);

            for (int subordinate : tree.get(currID)) {
                queue.add(new int[] { subordinate, currTime + informTime[currID] });
            }
        }

        return maxTime;
    }
}

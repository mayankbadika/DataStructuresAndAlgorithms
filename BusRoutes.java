package myclass;


import java.util.*;

public class BusRoutes {
    public static void main(String[] args) {
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        int source = 1;
        int target = 6;

        BusRoutes obj = new BusRoutes();

        System.out.println(obj.numBusesToDestination(routes, source, target));
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        // Map to store each stop and the list of buses that pass through it
        HashMap<Integer, List<Integer>> stopMap = new HashMap<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBus = new HashSet<>();

        // Build stopMap
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopMap.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        // If source is not in stopMap, the journey is impossible
        if (!stopMap.containsKey(source)) return -1;

        // BFS initialization
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{source, 0}); // {current stop, buses taken so far}
        visitedStops.add(source);

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int stop = curr[0];
            int busesTaken = curr[1];

            if (stop == target) return busesTaken;

            // Get all buses passing through the current stop
            for (int bus : stopMap.get(stop)) {
                if (visitedBus.contains(bus)) continue; // Skip already visited buses
                visitedBus.add(bus);

                // Explore all stops covered by this bus
                for (int nextStop : routes[bus]) {
                    if (!visitedStops.contains(nextStop)) {
                        visitedStops.add(nextStop);
                        queue.add(new int[]{nextStop, busesTaken + 1});
                    }
                }
            }
        }

        return -1; // Target not reachable
    }
}

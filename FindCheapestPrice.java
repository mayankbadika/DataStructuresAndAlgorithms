package myclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindCheapestPrice {
    public static  void main (String[] args) {
        FindCheapestPrice obj = new FindCheapestPrice();

        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int src = 0; int dst = 2; int k = 2; int n = 5;

        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create a map to store adjacency list representation of the graph
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Array to store the minimum distance (price) to each city
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Matrix to store the fare between two cities
        int[][] fare = new int[n][n];

        // Populate the adjacency list and fare matrix
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            // Add the destination city to the adjacency list of the source city
            List<Integer> list = map.getOrDefault(from, new ArrayList<>());
            list.add(to);
            map.put(from, list);

            // Store the fare for this route
            fare[from][to] = price;
        }

        // Each element in the queue is an array: [currentCity, currentPrice, stopsUsed]
        Queue<int[]> pq = new LinkedList<>();

        // Add the source city to the queue with initial cost 0 and 0 stops
        pq.add(new int[]{src, 0, 0});

        // Process the priority queue
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int city = node[0]; // Current city
            int price = node[1]; // Cost to reach this city
            int stops = node[2]; // Number of stops made so far

            // Get all neighboring cities of the current city
            List<Integer> list = map.get(city);
            if (list == null) continue;

            for (int neighbor : list) {
                // Calculate the new price to reach the neighbor
                int newPrice = fare[city][neighbor] + price;

                // If the number of stops is within the allowed limit (k)
                // and the new price is better than the previously known price, update it
                if (stops <= k && distance[neighbor] > newPrice) {
                    int newStop = stops + 1;
                    distance[neighbor] = newPrice;

                    // Add the neighbor to the priority queue with updated price and stops
                    pq.add(new int[]{neighbor, newPrice, newStop});
                }
            }
        }

        // If the destination city is reachable, return the minimum price; otherwise, return -1
        return distance[dst] != Integer.MAX_VALUE ? distance[dst] : -1;
    }
}

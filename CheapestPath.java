/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

                0
               /  \
              /    \
             1      2

Example 1:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.


Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
*/

import java.util.*;
class CheapestPath {


    HashMap<Integer,List<TripInfo>> map;


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        populatemap(flights);

        PriorityQueue<TripInfo> q = new PriorityQueue<>((a,b) -> a.cost-b.cost);

        // Start with Source
        q.addAll(map.getOrDefault(src,Collections.emptyList()));

        //BFS
        while(!q.isEmpty()){
            TripInfo lowest = q.poll(); System.out.println(lowest);
            if(lowest.dst == dst){
                return lowest.cost;
            }

            if(lowest.stops == k) continue;

            for(TripInfo trip : map.getOrDefault(lowest.dst,Collections.emptyList())){
                q.add(new TripInfo(trip.dst,lowest.cost+trip.cost,lowest.stops+1));
            }


        }

        return -1;

    }

    public void populatemap(int[][] flights){
        map = new HashMap<>();
        for(int[] flight : flights){
            List<TripInfo> trip = map.getOrDefault(flight[0],new ArrayList());
            trip.add(new TripInfo(flight[1],flight[2],0));
            map.put(flight[0],trip);
        }
    }


}

class TripInfo{
    int dst;
    int cost;
    int stops;
    public TripInfo(int dst,int cost,int stops){
        this.dst=dst;
        this.cost = cost;
        this.stops = stops;
    }
}
package myclass;

import java.util.PriorityQueue;

public class MinimumObstacles {
    public static  void main (String[] args) {
        MinimumObstacles obj = new MinimumObstacles();

        int[][] grid = {{0,1,1}, {1,1,0}, {1,1,0}};

        System.out.println(obj.minimumObstacles(grid));
    }

    public int minimumObstacles(int[][] grid) {
        //row, col, dist
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]- b[2]);

        int m = grid.length;
        int n = grid[0].length;
        //See detailed comment below
        boolean[][] visited = new boolean[m][n];

        pq.add(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;

        int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int row = node[0];
            int col = node[1];
            int cost = node[2];

            if(row == m-1 && col == n-1) return cost;

            for(int[] d : directions) {
                int r = row + d[0];
                int c = col + d[1];

                if(r >= 0 && r <= m-1 && c >= 0 && c <= n-1) {
                    if(visited[r][c]) continue;

                    int newCost = cost + (grid[r][c] == 1 ? 1 : 0);
                    pq.add(new int[]{r, c, newCost});
                    visited[r][c] = true;
                }
            }
        }

        return -1;
    }

    /*
     * The `visited` grid ensures that each cell in the grid is processed only once.
     * This prevents redundant additions to the priority queue and avoids revisiting
     * cells unnecessarily. Without the `visited` grid, it is possible for a cell
     * to be added to the priority queue multiple times as a neighbor of different
     * cells.
     *
     * For example, consider the following grid:
     * grid = [
     *   [0, 1, 0],
     *   [0, 1, 0],
     *   [0, 0, 0]
     * ]
     *
     * - Starting from (0, 0), the algorithm explores its neighbors (1, 0) and (0, 1).
     * - If (1, 0) is processed and adds its neighbors, it could re-add (0, 0) to the queue
     *   if we do not mark (0, 0) as visited.
     * - Similarly, when processing (0, 1), it could re-add (0, 0) or (1, 0) again, even though
     *   these cells have already been processed.
     *
     * By marking cells as visited immediately after adding them to the queue, we ensure that:
     * 1. No cell is added to the queue more than once.
     * 2. The algorithm avoids revisiting cells unnecessarily, improving efficiency.
     * 3. The solution remains correct, as each cell is processed with the minimum cost once.
     */
}

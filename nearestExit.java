package myclass;

import java.util.LinkedList;
import java.util.Queue;

public class nearestExit {
    int m;
    int n;

    public static void main(String[] args) {
        char[][] maze = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        int[] entrance = {1, 0};
        nearestExit obj = new nearestExit();

        int result = obj.nearestExit(maze, entrance);

        System.out.println(result);
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        m = maze.length;
        n = maze[0].length;
        Queue<Node1> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.add(new Node1(entrance[0], entrance[1], 0));
        int exit = Integer.MAX_VALUE;


        while (!q.isEmpty()) {
            Node1 current = q.poll();
            int row = current.row;
            int col = current.col;
            int dist = current.dist;

            if (visited[row][col]) continue;
            visited[row][col] = true;

            if((row == 0 || row == m -1 || col == 0 || col == n-1) && dist !=0) {
                exit = Math.min(dist, exit);
            }

            for (int[] dir : direction) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (isSafe(r, c, maze) && !visited[r][c]) {
                    q.add(new Node1(r, c, dist + 1));
                }
            }
        }

        return exit == Integer.MAX_VALUE ? -1 : exit;
    }

    public boolean isSafe(int row, int col, char[][] maze) {
        return (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == '.');
    }
}

class Node1 {
    int row;
    int col;
    int dist;

    public Node1(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
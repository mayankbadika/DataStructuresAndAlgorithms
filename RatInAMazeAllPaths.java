package myclass;

import java.util.*;

public class RatInAMazeAllPaths {
    public static void main(String args[]) {

        RatInAMazeAllPathsHelper obj = new RatInAMazeAllPathsHelper();
        int[][] maze ={{1,0,1}, {1,1,1},{1,1,1}};
        System.out.println(obj.ratInAMaze(maze, 3).toString());

    }
}

class RatInAMazeAllPathsHelper {
     ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public  ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        // Write your code here.
        helper(maze, 0, 0, n, new int[n][n]);

        return result;
    }

    public  void helper(int[][] maze, int row, int col, int n, int[][] visited) {
        if(row == n-1 && col == n-1) {
            visited[row][col] = 1;
            for (int[] row1 : visited) {
                ArrayList<Integer> listRow = new ArrayList<>();
                for (int element : row1) {
                    listRow.add(element);
                }
                result.add(listRow);
            }

            return;
        }

        if(isSafe(maze, row, col, n) && visited[row][col]!=1) {
            visited[row][col] = 1;

            helper(maze, row+1, col, n, visited);
            helper(maze, row-1, col, n, visited);
            helper(maze, row, col+1, n, visited);
            helper(maze, row, col-1, n, visited);

            visited[row][col] = 0;
        }
    }

    public  boolean isSafe(int[][] maze, int row, int col, int n) {
        return (row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1);
    }
}

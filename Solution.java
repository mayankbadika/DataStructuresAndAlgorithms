/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

/**
 *
 * @author mbadika
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

class Solution {

	/**
	 * Take a rectangular grid of numbers and find the length
	 * of the longest sub-sequence.
	 * @return the length as an integer.
	 */
	
    public static int longestSequence(int[][] grid) { 
        int[] max = new int[1];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                boolean[][] visited=new boolean[grid.length][grid[0].length];;
                visited[i][j]=true;
                dfs(grid,visited, i, j, max, 1);
            }
        }
        return max[0];
    }

    public static void dfs(int[][] matrix,boolean[][] visited, int i, int j, int[] max, int len) {
        max[0] = Math.max(max[0], len);

        int m = matrix.length;
        int n = matrix[i].length;

        int[] dx = {-1,1,-1,1,0,1,0,-1};
        int[] dy = {0,-1,-1,0,1,1,-1,1};

        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < m && y >= 0 && y < n && Math.abs(matrix[x][y]-matrix[i][j])>3 && !visited[x][y]) {
                visited[x][y]=true;
                dfs(matrix,visited, x, y, max, len + 1);
            }
        }
    }



	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int numRows = 0;
		int numCols = 0;
		String[] firstLine = reader.readLine().split("\\s+");
		numRows = Integer.parseInt(firstLine[0]);
		numCols = Integer.parseInt(firstLine[1]);

		int[][] grid = new int[numRows][numCols];

		for (int row = 0; row < numRows; row++) {
		    String[] inputRow = reader.readLine().split("\\s+");

		    for (int col = 0; col < numCols; col++) {
		        grid[row][col] = Integer.parseInt(inputRow[col]);
		    }
		}
		int length = longestSequence(grid);
		System.out.println(length);
	}
}


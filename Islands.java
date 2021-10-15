/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

/**
 * @author mayank
 */
public class Islands {
    public static void main(String args[]) {
        char maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};


        Islands obj = new Islands();
        obj.numIslands(maze);

    }

    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid.length];
        int count = 0;int i;
        for ( i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[0].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] ==1) {
                    isisland(grid, i, j, visited); count++;
                }
            }
            
        }
        System.out.println(count);
        /*for( i=0;i<visited.length;i++){
                for(int j=0;j<visited.length;j++){
                    System.out.print(visited[i][j]);
                }
                System.out.println();
            }
*/
        return count;
    }

    int[][] dir = {{0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}};

    public void isisland(char[][] grid, int r, int c, int[][] visited) {
         //System.out.println(r+ " "+c);
        visited[r][c]=1;
            for (int i = 0; i < dir.length; i++) {
                int x = r + dir[i][0];
                int y = c + dir[i][1];
                if (issafe(grid, x, y, visited) && grid[x][y] == 1) {
                    //visited[x][y] = 1;
                    isisland(grid, x, y, visited);
                       
                }
            }

        
        
    }


    public boolean issafe(char[][] grid, int r, int c, int[][] visited) {
        return (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && visited[r][c] != 1);
    }


}
/*
leetcode 200. Number of islands
class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                 if(grid[i][j]=='1'&&visited[i][j]==0){
                    explore(grid,i,j,visited);
                    count++;
                 }
            }
        }

        return count;
    }


    public boolean isisland(char[][] grid,int r,int c,int[][] visited){
        return(r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&grid[r][c]=='1'&&visited[r][c]==0);
    }

    // DFS

    public void explore(char[][] grid,int r,int c,int[][]visited){
        if (isisland(grid,r,c,visited) == false) return;

        visited[r][c]=1;

        int[][] neighbor = {{r-1,c},{r,c-1},{r+1,c},{r,c+1}};

        for(int[] i : neighbor){
            explore(grid,i[0],i[1],visited);
        }

    }

}


 */

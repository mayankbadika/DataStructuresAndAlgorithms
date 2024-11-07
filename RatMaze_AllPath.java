/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

/**
 *
 * @author mayank
 */
public class RatMaze_AllPath {
    final int N = 4;

    /* A utility function to print solution matrix 
       sol[N][N] */
    int[][] sol;
    public RatMaze_AllPath(int[][] sol){
        this.sol = sol;

    }

    void printSolution(int sol[][]) 
    { 
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + sol[i][j] + 
                                 " "); 
            System.out.println(); 
        } 
    }

    boolean isSafe(int[][]mat,int x,int y){
        //return(x>=0&&x<N&&y>=0&&y<N&&mat[x][y]==1);

        if(x<0||x>=N||y<0||y>=N||sol[x][y]==1||mat[x][y]==0){
            return false;
        }
        return true;
    }
    
     void solveMaze(int maze[][])
    {
        
        //printSolution(sol);
         solveMazeUtil(maze,0,0,sol);
    }
     
    void solveMazeUtil(int[][]maze,int x,int y,int[][] sol){
        if(x==N-1 && y==N-1){
            sol[x][y]=1;
            printSolution(sol);
            return;
        }
        
        if(isSafe(maze,x,y)){
            sol[x][y]=1;
            //Now check if moving hozrizontally lead to a solution

            //if not then check if moving down leads to a solution
            solveMazeUtil(maze,x+1,y,sol);
            solveMazeUtil(maze,x-1,y,sol);
            solveMazeUtil(maze,x,y-1,sol);
            solveMazeUtil(maze,x,y+1,sol);
            // if nothing works mark the cell as 0
            sol[x][y]=0;
        }
    } 
     
     
    
    public static void main(String args[]) 
    {
        int sol[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        RatMaze_AllPath rat = new RatMaze_AllPath(sol);
        int maze[][] = {{1, 0, 0, 0}, 
                        {1, 1, 0, 1}, 
                        {0, 1, 1, 0},
                        {1, 1, 1, 1} 
        };



        rat.solveMaze(maze);
    } 
    
}

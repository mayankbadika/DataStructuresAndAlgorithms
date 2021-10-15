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
public class RatinaMaze2 {
    final int N = 4; 
  
    /* A utility function to print solution matrix 
       sol[N][N] */
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
        if(x>=0&&x<N&&y>=0&&y<N){
            if(mat[x][y]==1) return true;
        }
        return false;
    }
    
     boolean solveMaze(int maze[][]) 
    { 
        int sol[][] = {{0, 0, 0, 0}, 
            {0, 0, 0, 0}, 
            {0, 0, 0, 0}, 
            {0, 0, 0, 0} 
        }; 
        
        if(solveMazeUtil(maze,0,0,sol)==false){ 
            System.out.print("Solution doesn't exist"); 
            return false; 
        } 
        
        printSolution(sol);
        return solveMazeUtil(maze,0,0,sol);
    }
     
    boolean solveMazeUtil(int[][]maze,int x,int y,int[][] sol){
        if(x==N-1 && y==N-1){
            sol[x][y]=1;

            return true;
        }
        
        if(isSafe(maze,x,y)){
            sol[x][y]=1;
            //Now check if moving hozrizontally lead to a solution
            if(solveMazeUtil(maze,x,y+1,sol)) return true;// right
            //if(solveMazeUtil(maze,x,y-1,sol)) return true; // left
            //if not then check if moving down leads to a solution
            if(solveMazeUtil(maze,x+1,y,sol)) return true;//up
            //if(solveMazeUtil(maze,x-1,y,sol)) return true;//down
            // if nothing works mark the cell as 0
            sol[x][y]=0;
            return false;
        }
        return false;
    } 
     
     
    
    public static void main(String args[]) 
    {
        RatinaMaze2 rat = new RatinaMaze2();
        int maze[][] = {{1, 0, 0, 0}, 
                        {1, 1, 0, 1}, 
                        {1, 1, 0, 0},
                        {1, 1, 1, 1} 
        }; 
       System.out.println(rat.solveMaze(maze)); 
    } 
    
}

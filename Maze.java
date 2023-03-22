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
public class Maze {
    static int N; 
    
    public boolean isSafe(int[][] maze,int x,int y){
        return(x>=0 &&  x<N && y>=0&& y<N && maze[x][y]==1);
    }
    
    public void printsol(int[][] sol){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(" "+sol[i][j]+" ");
            }
            System.out.println();
        }
    }
    
   public boolean solvemaze(int[][] maze){
       int[][] sol = new int[N][N];
       if(solveMazeUtil(maze,0,0,sol)==false){
           System.out.println("No Solution");
           return false;
       }
       return true;
   }
    
    public boolean solveMazeUtil(int[][] maze,int x,int y,int[][] sol){
        if(x==N-1&y==N-1){ // if reached the end point of the matrix we are done
            sol[x][y]=1;
            printsol(sol);
            return true;
        }
        
        if(isSafe(maze,x,y)){
            sol[x][y]=1;
            
            // Move in the x direction
            solveMazeUtil(maze,x+1,y,sol);

            //Move in the y direction
            solveMazeUtil(maze,x,y+1,sol);
            
            sol[x][y]=0;
            return false;
        }
        return false;
    }
    
    public static void main(String[] args){
        Maze maze = new Maze();
        int maze1[][] = { { 1, 0, 0, 0 }, 
                         { 1, 0, 0, 1 }, 
                         { 1, 1, 0, 0 }, 
                         { 1, 1, 1, 1 } }; 
  
        N = maze1.length; 
        maze.solvemaze(maze1);
    }
    
}

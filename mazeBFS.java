package myclass;

import java.util.LinkedList;
import java.util.Queue;
class nodemat{
    int row;
    int col;
    int dist;

    public nodemat(int row,int col, int dist){
        this.row = row;
        this.col = col;
        this.dist= dist;
    }

    public int getDist(){
        return dist;
    }

    public int getCol() {
        return col;
    }

    public int getRow(){
        return row;
    }
}
public class mazeBFS {
    static int N;
    public static void main (String[] args){
        mazeBFS maze = new mazeBFS();
        int maze1[][] = { { 1, 0, 0, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 1, 0, 0 },
                        { 1, 1, 1, 1 } };

        N = maze1.length;
        System.out.println( maze.solveMazeUtil(maze1,0,0));

    }
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
    public int solveMazeUtil(int[][] maze,int x, int y){
        int[][] sol = new int[N][N];
        Queue<nodemat> q = new LinkedList<>();
        q.add(new nodemat(x,y,0));
        while(!q.isEmpty()){
            nodemat curr = q.poll();
            int row = curr.getRow();
            int col = curr.getCol();
            int dist = curr.getDist();
            if( row == N-1 && col == N-1){
                dist++;
                return dist;
            }

            if (isSafe(maze,row,col) && sol[row][col] != 1){
                q.add(new nodemat(row+1,col,dist+1));
                q.add(new nodemat(row,col+1,dist+1));
                sol[row][col] = 1;
            }

        }

        return -1;
    }
}
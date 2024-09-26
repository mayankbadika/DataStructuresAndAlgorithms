package myclass;

public class RatMaze {
    int maze[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 1, 1, 1}
    };
    int[][] sol = new int[maze.length][maze[0].length];
    final int N = 4;
    int[][] mem = new int[maze.length][maze[0].length];
    int pathCount =0;

    public static void main(String args[]) {
        RatMaze rm = new RatMaze();
        System.out.println("Path exists ="+rm.PathExists());
        rm.printSolution();
        System.out.println("All paths that exists = "+ rm.pathCount);
        rm.findPathsCount(0,0);
    }

    boolean isSafe(int x,int y){
        return (x >= 0 && x < N && y>= 0 && y < N && sol[x][y] == 0 && maze[x][y] == 1);
    }
    void resetSolution() {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                sol[i][j] = 0;
            }
        }
    }
    void printSolution()
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] +
                        " ");
            System.out.println();
        }
    }

    boolean PathExists() {


        //printSolution(sol);
        return PathExists(0,0);
    }
    public boolean PathExists(int row, int col) {
        if (!isSafe(row,col)) return false;

        sol[row][col] = 1;

        if(row == N-1 && col == N-1) {
            return true;
        }

        if (PathExists(row+1, col) ||
            PathExists(row-1, col) ||
            PathExists(row, col-1) ||
            PathExists(row, col+1)) {

            return true;
        }

        sol[row][col] = 0;

        return false;
    }

    void findPathsCount(int row, int col) {
        resetSolution();  // Reset the solution matrix before each run
        pathCount = 0;    // Reset the path count before each run
        findPaths(row, col);
    }

    public void findPaths(int row, int col) {
        if (!isSafe(row, col)) return;

        sol[row][col] = 1;

        if (row == N - 1 && col == N - 1) {
            pathCount++;
            printSolution();
            System.out.println();
        }

        findPaths(row + 1, col);
        findPaths(row - 1, col);
        findPaths(row, col - 1);
        findPaths(row, col + 1);

        sol[row][col] = 0;
    }
}

package myclass;

public class mincost {
    /*int n;int m;
    public mincost(int m,int n){
        this.m=m;
        this.n=n;
    }
    int[][] mat = new int[m+1][n+1];
    */
    public void print(int[][] mat,int m,int n){
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    public int costcal(int[][] cost ,int m,int n ){
        int[][] mat = new int[m+1][n+1];
        int sum =0;
        for(int j=0;j<=n;j++){
            mat[0][j] = sum +cost[0][j];
            sum = mat[0][j];
        }
        sum =0;
        for(int i=0;i<=m;i++){
            mat[i][0] = sum +cost[i][0];
            sum = mat[i][0];
        }


        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                mat[i][j] = cost[i][j]+Math.min(mat[i-1][j],mat[i][j-1]);
            }
        }

        System.out.println(path(m,n,mat,cost));
        return mat[m][n];
    }

    public String path(int m,int n,int[][] mat,int[][]cost){
        //System.out.println(m+""+n); // Prints the matrix path for the shortest path
        if(m==0&& n==0) return String.valueOf(cost[m][n])+" "+("("+m+""+n+")");
        int sub =0;
        sub = mat[m][n]-cost[m][n];
        if(m>=1&&sub== mat[m-1][n]){
            return String.valueOf(cost[m][n])+" "+("("+m+""+n+")")+" "+path(m-1,n,mat,cost);
        }else return String.valueOf(cost[m][n])+" "+("("+m+""+n+")")+" "+path(m,n-1,mat,cost);
    }


    public static void main(String args[]) {

        int cost[][] = {{1, 3, 5, 8},
                {4, 2, 1, 7},
                {4, 3, 2, 3}};
        mincost obj = new mincost();
        System.out.println(obj.costcal(cost,2,3));
    }
}
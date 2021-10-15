public class Queen_prac1 {
    int n;
    int[][] mat;
    Queen_prac1(int n){
        this.n = n;
        mat = new int[n][n];
        nqueen(mat,0);
        print();
    }

    public boolean check(int[][] mat,int row, int col){

        int i,j;
        for(i=col;i>=0;i--) if (mat[row][i] ==1) return false;

        // Upper Diagonal
        for(i=row,j=col;i>=0&&j>=0;i--,j--)
            if(mat[i][j]==1) return false;

        // check lower diagonal
        for(i=row,j=col;i<n&&j>=0;j--,i++) if (mat[i][j]==1) return false;

        return true;

    }

    public boolean nqueen(int[][] mat,int col) // we place each queen by row
    {
        if(col>=n) return true; // all queens have been placed

        for(int i=0;i<n;i++){ // column
            if(check(mat,i,col)) {
                mat[i][col] = 1; // Mark the position of queen
                if (nqueen(mat, col + 1)) return true; // check next column for next queen
                mat[i][col] = 0; // if the above did not work
            }
        }
        return false;
    }

    public void print(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    public static  void main(String [] args){
        Queen_prac1 obj = new Queen_prac1(4);

    }

}

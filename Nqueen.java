package myclass;

public class Nqueen {
    static int N = 4;
    int[][] mat = new int[N][N];
    public static void main(String[] args) {
        Nqueen queen = new Nqueen();
        System.out.println("NQueen "+ queen.NQueen(0));
        queen.print();
    }

    public void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    public boolean isSafe(int row, int col) {
        //check row(left) till then given col
        for(int i=0;i<col;i++){
            if(mat[row][i] == 1) return false;
        }

        //check upper diagonal
        for(int i = row, j = col; i>=0 && j>=0;i--,j--){
            if(mat[i][j] == 1) return false;
        }

        //Check lower diagonal
        for(int i = row, j = col; i < N && j >= 0;i++,j--){
            if(mat[i][j] == 1) return false;
        }

        return true;
    }

    public boolean NQueen(int col) {
        if(col >= N) return true;

        for(int i=0;i < N; i++) {
            if(isSafe(i,col)){
                mat[i][col] =1;
                if(NQueen(col+1)) return true;
                mat[i][col] =0;
            }
        }

        return false;
    }
}

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
/*
N-Queens Problem: Given a chess board having N X N  cells, we need to place N queens in such a way that no queen is attacked by any other queen.
A queen can attack horizontally, vertically and diagonally.
*/
public class Queen {
    
    int n;
    int[][] mat;
    Queen(int n){
        this.n = n;
        mat = new int[n][n];
        Nqueen(mat,0);
        print();
    }
    
    public boolean issafe(int[][] mat,int row, int col){
        // Left
        int i,j;
        for(i=0;i<col;i++)
        if (mat[row][i]==1) return false;
        
        
        // Upper Diagonal
        for(i=row,j=col;i>=0&&j>=0;i--,j--)
        if(mat[i][j]==1) return false;
        
        
        //Lower Diagonal
        for(i=row,j=col;j>=0&&i<n;i++,j--)
        if(mat[i][j]==1) return false;
        
        
        return true;
    }
    
    public boolean Nqueen(int[][] mat,int col){ // initially col =0;
        if (col>=n) return true;
        
        for(int i=0;i<n;i++){ // row
            if(issafe(mat,i,col)){
                mat[i][col]=1;
                if(Nqueen(mat,col+1)) return true;
                mat[i][col]=0;
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
    
    public static void main(String[] args){
        Queen q = new Queen(4);
    }
    
}

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
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package myclass;

/**
 *
 * @author mayank
 */
/*
N-Queens Problem: Given a chess board having N X N  cells, we need to place N queens in such a way that no queen is attacked by any other queen.
A queen can attack horizontally, vertically and diagonally.
*/
public class Queen_rowBased {
    
    int n;
    int[][] mat;
    int[][] mat2;
    Queen_rowBased(int n){
        this.n = n;
        mat = new int[n][n];
        mat2 = new int[n][n];
        System.out.println("First Solution :");
        Nqueen(mat,0);
        System.out.println("All Solutions :");
        Nqueen_AllSol(mat2,0);
        //print();
    }
    
    public boolean issafe(int[][] mat,int row, int col){
        // Left
        int i,j;
        for(i=row;i>=0;i--)
        if (mat[i][col]==1) return false;
        
        
        // Upper Diagonal
        for(i=row,j=col;i>=0&&j>=0;i--,j--)
        if(mat[i][j]==1) return false;
        
        
        //Lower Diagonal
        for(i=row,j=col;j<n&&i>=0;i--,j++)
        if(mat[i][j]==1) return false;
        
        
        return true;
    }
    
    public boolean Nqueen(int[][] mat,int row){ // initially row =0;
        if (row==n) {
            print(mat);
            return true;
        }
        for(int col=0;col<n;col++){ //col
            if(issafe(mat,row,col)){
                mat[row][col]=1;
                if(Nqueen(mat,row+1)) return true;
                mat[row][col]=0;
            }
        }
      return false;  
    }

    public boolean Nqueen_AllSol(int[][] mat,int row){ // initially row =0;
        if (row==n) {
            print(mat);
            return true;
        }
        for(int col=0;col<n;col++){ //col
            if(issafe(mat,row,col)){
                mat[row][col]=1;
                Nqueen(mat,row+1);
                mat[row][col]=0;
            }
        }
        return false;
    }

    
    public void print(int[][] mat){
        int k=1;
        System.out.printf("%d-\n", k++);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){

        Queen_rowBased q = new Queen_rowBased(4);
    }
    
}


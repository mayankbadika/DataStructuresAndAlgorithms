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
public class Matrix {
    
    int a[][];
    Matrix(int d[][]){
        this.a =d;
    }
    
    void transpose(int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=temp;
            }
        }
        printmatrix(n); 
    }
    
    void rotationby90(int n){
        // step 1 .Mirror image of the matrix
        int i,j,k;
        for( i=0;i<n;i++){
            for( j=0,k=n-1;j<k;j++,k--)  //j< n/2
            { // j=0,k=n-1; j<n/2;j++,k--
            int temp =a[i][j];
            a[i][j] =a[i][k];
            a[i][k] = temp; 
            }
        }
        
        // Step 2 . Transposing the matrix
        for( i=0;i<n;i++){
            for( j=i+1;j<n;j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        
        printmatrix(n);
    }
    
    void printmatrix(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
  public static void main (String[] args) {
     int a[][] =    { {1, 2, 3, 4}, 
                      {5, 6, 7, 8}, 
                      {9, 10, 11, 12},
                      {13 ,14 ,15, 16}};  
     
     Matrix m= new Matrix(a);
     m.printmatrix(4);
     /*System.out.println("transpose=");
     m.transpose(4);*/
     System.out.println("Rotation by 90 anticlock wise is");
     m.rotationby90(4);
  }  
    
}

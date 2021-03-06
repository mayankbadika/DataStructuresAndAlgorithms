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
class GFG  
{ 
    public static int n = 3; 
      
    // Function that returns length of the longest path  
    // beginning with mat[i][j] 
    // This function mainly uses lookup table dp[n][n] 
    static int findLongestFromACell(int i, int j, int mat[][], int dp[][]) 
    { 
        // Base case 
        if (i<0 || i>=n || j<0 || j>=n) 
            return 0; 
   
        // If this subproblem is already solved 
        if (dp[i][j] != -1) 
            return dp[i][j]; 
   
        // Since all numbers are unique and in range from 1 to n*n, 
        // there is atmost one possible direction from any cell 
        if (j>0 &&j<n&& Math.abs(mat[i][j] -mat[i][j+1])>3) 
            return dp[i][j] = 1 + findLongestFromACell(i,j+1,mat,dp); 
   
        if (j>0 && Math.abs(mat[i][j] -mat[i][j-1])>3) 
            return dp[i][j] = 1 + findLongestFromACell(i,j-1,mat,dp); 
   
        /*if (i>0 && Math.abs(mat[i][j]-mat[i-1][j])>3) 
            return dp[i][j] = 1 + findLongestFromACell(i-1,j,mat,dp); 
   
        if (i<n-1 && Math.abs(mat[i][j] -mat[i+1][j])>3) 
            return dp[i][j] = 1 + findLongestFromACell(i+1,j,mat,dp); 
            */
        // If none of the adjacent fours is one greater 
        return dp[i][j] = 1; 
    } 
      
    // Function that returns length of the longest path 
    // beginning with any cell 
    static int finLongestOverAll(int mat[][]) 
    { 
        // Initialize result 
        int result = 1;   
   
        // Create a lookup table and fill all entries in it as -1 
        int[][] dp = new int[n][n]; 
        for(int i=0;i<n;i++) 
            for(int j=0;j<n;j++) 
                dp[i][j] = -1; 
   
        // Compute longest path beginning from all cells 
        for (int i=0; i<n; i++) 
        { 
            for (int j=0; j<n; j++) 
            { 
                if (dp[i][j] == -1) 
                    findLongestFromACell(i, j, mat, dp); 
   
                //  Update result if needed 
                result = Math.max(result, dp[i][j]); 
            } 
        } 
   
        return result; 
    } 
      
    // driver program 
    public static void main (String[] args)  
    { 
        int  mat[][] = { {8, 2, 4}, 
                         {0, 6, 1}, 
                         {3, 7, 9} }; 
        System.out.println("Length of the longest path is " +  
                            finLongestOverAll(mat)); 
    } 
} 
  

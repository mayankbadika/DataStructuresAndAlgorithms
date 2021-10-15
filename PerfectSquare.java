/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;
import java.lang.Math;

/**
 *
 * @author mayank
 */
public class PerfectSquare { //Given an array of n integers. The task is to find the largest number which is a perfect square. Print -1 if there is no number that is perfect square.
    int a[];
    
    PerfectSquare(int arr[]){
        a=arr;
    }
    
    boolean checkperfectsquare(double n){
        double d = Math.sqrt(n);
        if(d*d == n){
            return true;
        }
        return false;
    }
    
    int findlargestsquare(){
        int max =-1;
        for(int i=0;i<a.length;i++){
            if(checkperfectsquare(a[i])){
                max = Math.max(a[i], max);
            }
        }
        return max;
    }
    
    public static void main (String[] args){
        int a[]={36, 64, 10, 16, 29, 25};
        PerfectSquare ps = new PerfectSquare(a);
        int result;
        result = ps.findlargestsquare();
        if(result == -1){
            System.out.println("No max");
        }
        else{
            System.out.println("Max is = "+result);
        }
    }
}

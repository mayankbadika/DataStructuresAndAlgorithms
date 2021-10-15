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
public class MergeArray {
    
    public void push(int[] arr){
        for(int i=arr.length-1;i>2;i--){
            arr[i]=arr[i-1];
        }
        
        System.out.println("New Array");
        for(int a=0;a<arr.length;a++){
            System.out.print(arr[a]);
        }
    }
    
    public static void main(String[] args){
        int[] a1 ={5,8,9};
        int[] a2 ={4,7,8};
        int n = a1.length;
        int m = a2.length;
        
        int[] arr = new int[n+m];
        
        int i=0,j=0,k=0;
        
        while(i<n&&j<m){
            if(a1[i]<a2[j]){
                arr[k]=a1[i];
                k++;i++;
            }
            else{
                arr[k]=a2[j];
                k++;j++;
            }
        }
        
        while(j<m){
            arr[k]=a2[j];
            k++;j++;
        }
        
        while(i<n){
            arr[k]=a1[i];
            k++;i++;
        }
        
        System.out.println("Merged Array");
        for(int a=0;a<arr.length;a++){
            System.out.print(arr[a]);
        }
        
        MergeArray obj = new MergeArray();
        int[] a3 = {1,2,3,0,0,0};
        obj.push(a3);
    }
    
}

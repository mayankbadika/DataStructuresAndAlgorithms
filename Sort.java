
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
public class Sort {
    static int arr[];
    Sort(int arr[]){this.arr =arr;};
    public void arrange(){ // Simple Sort algorithm
        int max;
        for(int i =0;i<arr.length;i++)
        {
            for(int j=i;j<arr.length-1;j++)
            {
                if (arr[i]>arr[j]){
                    max = arr[i];
                    arr[i] = arr[j];
                    arr[j] = max;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public void buble(){ // buble Sort algorithm
        int max;
        for(int i =0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr.length-i-1;j++)
            {
                if (arr[j]>arr[j+1]){
                    max = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = max;
                }
               /*for(int k=0;k<arr.length;k++){ // this loop shows step by step sorting
                        System.out.print(arr[k]);
                    }
                     System.out.println();
                */
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    
    public void selection(){
        int min;
        for(int i=0;i<arr.length;i++){
            min =i;
            for(int j= i+1;j<arr.length;j++)
            {
                if (arr[j]<arr[min]){
                    min =j;
                }
            }
            int temp = arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    
    void merge(int[] a,int[] l,int []r,int left,int right){  // Merge Sort method 1
        int i=0,j=0,k=0;
        while(i<left&&j<right){
            if(l[i]<=r[j]){
                a[k++]=l[i++];
            }
            else{
                a[k++]=r[j++];
            }
        }
        while(i<left){
            a[k++]=l[i++];
        }
        while(j<right){
            a[k++]=r[j++];
        }   
        
    }
    
    void mergesort(int []a,int n){
        if(n<2) {return;}
        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int [n-mid];
        
        for(int i=0;i<mid;i++){
            l[i]=a[i];
        }
        
        for(int i= mid ;i<n;i++){
            r[i-mid]=a[i];
        }
        
        mergesort(l,mid);
        mergesort(r,n-mid);
        merge(a,l,r,mid,n-mid);
        
    }
     void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    
    
    
    
    public static void main(String[] args){
        int[] arr = {7,3,4,2,6,8};
        Sort srt = new Sort(arr);
        
       // srt.arrange();
        //srt.buble();
        //srt.selection();
        srt.mergesort(arr, arr.length);
        srt.printArray(arr);
    }
    
    
}

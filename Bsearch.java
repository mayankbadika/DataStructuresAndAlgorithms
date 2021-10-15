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
public class Bsearch {
    int a[];
    Bsearch(int[] arr){
        a=arr;
    }
    
    void selectionsort(){
        int min;
        for(int i=0;i<a.length;i++){
            min =i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[min]){
                    min =j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
    
    int BinarySearch(int d,int l,int r){
        // Sort the array first using quick sort
        int mid;
        selectionsort();
        for(int i=l;i<=r;i++){
            mid = l+(r-1)/2;
            if(a[mid]== d){
                return mid;
            }
            else if(a[mid]>d)
            {
               return BinarySearch(d,l,mid-1);
            }
            else if(a[mid]<d){
             return BinarySearch(d,mid+1,r);   
            }    
        }
        return -1;
        }    
    
    void printarray()
    {
        selectionsort();
        for(int i =0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
    
    public static void main(String[] args)
    {
        int a[] ={5,3,6,7,9,2};
        Bsearch obj = new Bsearch(a);
        int n = a.length-1;
        System.out.println("Sorted array");
        obj.printarray();
        int result = obj.BinarySearch(2, 0, n);
        if(result==-1){
            System.out.println("No match");
        }
        else{
            System.out.println("Match found at "+result);
        }
    }
}
    


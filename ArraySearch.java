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
public class ArraySearch {
    int arr[]; int elem;int capacity;
    ArraySearch(int a[],int b,int capacity){
        this.arr=new int[capacity];
        arr=a;
        this.elem = b;
        
    }
    void linearsearch(){
        int pos;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==elem){
                pos=i;
                System.out.println(elem+" was found at index "+pos);
            }
        }
    }
    
    void insert(int index,int d){
        int[] a = new int[arr.length+1];
       /* 
        for(int i=0;i<index;i++){//copying values before the index to the new array
            a[i]=arr[i];
        }
        for(int i = index;i<arr.length;i++){
            a[index]=d;
            a[i+1]=arr[i];
        }
        */
        for(int i=0;i<a.length;i++){
            if(i<index){
                a[i]=arr[i];
            }
            else if(i==index){
                a[index]=d;
            }
            else{
                a[i]=arr[i-1];
            }
        }
        arr=a.clone();
        print();    
    }
    
    void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    void print(){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

class Search{
    public static void main (String[] args){
        int[] a={1,2,3,4};//{3,5,2,6,7,4,1};
        ArraySearch obj = new ArraySearch(a,1,8);
        //obj.linearsearch();
        obj.print();
        
        System.out.println("New Array");
        obj.insert(3,11);
    }
}

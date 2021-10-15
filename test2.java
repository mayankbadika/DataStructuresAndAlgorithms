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
public class test2 {
    void Sort(int d){
        String num = Integer.toString(d);
        int a[] = new int[num.length()];
        for(int i=0;i<a.length;i++){ // forming an array
            a[i]=num.charAt(i)-'0';
            //System.out.println(num.charAt(i));
        }
        //Sorting array
        int min;
        for(int i=0;i<a.length;i++){
            min =i;
            for(int j =i+1;j<a.length;j++){
                if(a[j]<a[min]){
                    min = j;
                } 
            }
            int temp =a[i];
            a[i]= a[min];
            a[min]= temp;
        }
       
        for(int i=a.length-1;i>=0;i--){
            System.out.print(a[i]);
        }

    }
    
    public static void main(String[] args){
        test2 t2 = new test2();
        t2.Sort(2314674);
    }
    
}

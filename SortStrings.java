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
public class SortStrings {
    
    public static void main (String[] Args){
        //String str = "C";
        //System.out.println(str.compareToIgnoreCase("A"));
        String[] words = { "Peach", "Orange", "Mango", "Cherry", "Apple" };
        int n = 5;
        System.out.println("The original order of the words is: ");
        for(int i = 0; i < n; i++) {
           System.out.println(words[i]);
        }
        
        // Sorting
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(words[i].compareTo(words[j])>0){
                    String temp = words[i];
                    words[i]= words[j];
                    words[j] = temp;
                }
            }
        }
        
        System.out.println("The Sorted order of the words is: ");
        for(int i = 0; i < n; i++) {
           System.out.println(words[i]);
        }
        
        
    }
   
    
}

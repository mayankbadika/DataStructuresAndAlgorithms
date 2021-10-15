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
public class SortString_1 { // Program to sort elements of an array alphabeticaly(ignore the starting numbers) and ignore elements that start with *
    
     public static void main (String[] Args){
        //String str = "C";
        //System.out.println(str.compareToIgnoreCase("A"));
        String[] words = { "* Peach", "* Orange", "3 Mango", "4 Cherry", "5 Apple","6 Banana" };
        int n = words.length;
        System.out.println("The original order of the words is: ");
        for(int i = 0; i < n; i++) {
           System.out.println(words[i]);
        } 
        
        //Pushing * elements at back of the array
        int k=n-1;
        for(int i = 0; i < n; i++) {
           String[] split1 = words[i].split(" ");
          if (split1[0].equals("*")){
             while(k>i){
                 String[] splitn = words[k].split(" ");
                 if(splitn[0].equals("*")== false){
                     String temp = words[i];
                     words[i]=words[k];
                     words[k]=temp;
                     k--; break;
                 }
                 k--;
             }
          }
        }
        
        System.out.println("Pushing back * ");
        for(int i = 0; i < n; i++) {
           System.out.println(words[i]);
        } 
        
        //Sorting
        for(int i=0;i<=k;i++){
            for(int j=i+1;j<=k;j++){
                String[] split1 = words[i].split(" ");
                String[] split2 = words[j].split(" ");
                
                if(split1[1].compareTo(split2[1])>0){
                    String temp =words[i];
                    words[i]= words[j];
                    words[j]=temp;
                }
            }
        }
        
        System.out.println("The Sorted order of the words is: ");
        for(int i = 0; i < n; i++) {
           System.out.println(words[i]);
        } 
       
     }
     
}

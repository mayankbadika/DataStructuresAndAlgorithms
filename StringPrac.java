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
public class StringPrac {
    
    public static void main(String[] args){
        String str = "Mayank";
        String str2 = "kayanM";
        int[] arr = new int[256];
    
        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)]++;
        }
        
        for(int i=0;i<str2.length();i++){
            arr[str2.charAt(i)]--;
        }

        for(int i=0;i<3;i++){
            str = str.substring(0,str.length()-1);
        }
        
        System.out.println(str);
    }
    
    
}

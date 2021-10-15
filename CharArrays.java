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
public class CharArrays {
    public static void main(String[] args){
        String s1="mayank";
        String s2 = "yaamnka";
        char[] alpha= new char[26];
        char[] beta = new char[26];
        for(int i=0;i<s1.length();i++){
            alpha[s1.charAt(i) - 'a']++;
        }
        
        for(int i=0;i<s2.length();i++){
            beta[s2.charAt(i) - 'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(alpha[i]!=beta[i]){
                System.out.println("Not Equal");
            }
        }
        
    }
    
    
    
}

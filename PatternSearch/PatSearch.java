/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 */
package myclass.PatternSearch;

/**
 *
 * @author mbadika
 */
public class PatSearch {
    
    public void Search(String txt,String pat){
        int n =txt.length();
        int m = pat.length();
        
        for(int i=0;i<=n-m;i++){
            int j;
            for(j=0;j<m;j++){
                if(txt.charAt(i+j)!=pat.charAt(j)) break;
            }
            if(j==m) System.out.println("Pattern found at "+i);
            
        }
    }
    
    public static void main(String[] args){
        String txt ="THIS IS A TEST TEXT";
        String pat ="TEXT";
        
        PatSearch obj = new PatSearch();
        obj.Search(txt, pat);
    }
    
}

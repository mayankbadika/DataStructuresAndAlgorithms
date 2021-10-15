/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

import java.util.HashMap;

/**
 *
 * @author mayank
 */
class Solution1 {
    public static void main(String[] args){
        Solution1 sol = new Solution1();
        System.out.println(sol.minWindow("ADOBECODEBANC","ABC"));
    }
    
    public String minWindow(String s, String t) {
        
        HashMap <Character,Integer> pmap = new HashMap<>();
         String result="";
        int minWindow = Integer.MAX_VALUE;
        for(int i=0;i<t.length();i++){
            if(pmap.containsKey(t.charAt(i))){
                pmap.put(t.charAt(i),pmap.get(t.charAt(i))+1);
            }else{
                pmap.put(t.charAt(i),1);
            }
        }
        int count =0; int start =0; boolean flag = true; int k =0;String min ="";
        HashMap <Character,Integer> smap = new HashMap<>();
        
        for(int j=start;j<s.length();j++){
            if(flag) k = j; flag = false; 
            
                     if (smap.containsKey(s.charAt(j)) && pmap.containsKey(s.charAt(j)) && pmap.get(s.charAt(j))>smap.get(s.charAt(j)))
                         smap.put(s.charAt(j),smap.get(s.charAt(j))+1);
                     else if(!smap.containsKey(s.charAt(j)) && pmap.containsKey(s.charAt(j))){
                         smap.put(s.charAt(j),1);
                     }
                   
                    min = min + s.charAt(j); count++;
                    //System.out.println(min);
                    if(pmap.equals(smap)) {
                        int minW = count-start+1;
                        if(minW<minWindow){
                            minWindow=minW;
                            result = min;   
                        }
                        start = k+1;
                        flag = true; min="";smap = new HashMap<>();
                        
                    }   
            }
            return result;
        }   
    }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

import java.util.*;
import java.util.function.Predicate;

/**
 *
 * @author mayank
 */
public class ArrayListExample {
    
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        List<String> phrase = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        list.add("Mayank is a nice guy");
        list.add("He likes to do kickboxing and is a nice guy");
        list.add("People need to know that Mayank is a nice guy");
        list.add("is a nice guy");
        
        //Phrases
        phrase.add("Mayank");
        phrase.add("is a bad guy");
        
        Map<Integer,String> map = new HashMap<Integer,String>();
        
        for(Map.Entry<Integer,String> entry: map.entrySet()){
          //entry.getValue() == N-1)
        
        }
        
        
        /*Iterator<String> it2 = list.iterator();
        while(it2.hasNext()){
            if (it2.next().contains("Mayank")){
                System.out.println(it2.next());
            }
        }
        */
        
        for (String temp : list) {
            for(String temp2 : phrase){
                if(temp.contains(temp2)){
                    if (result.contains(temp)==false)result.add(temp);
                }
            }
        }
        
        //result = list.stream().anyMatch();
        
       System.out.println(result);
       
        
        
    }
    
}

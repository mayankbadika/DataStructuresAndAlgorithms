/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;
import java.util.*;
/**
 *
 * @author mayank
 */
public class testbasics {
    
    public static void main(String[] args)
    {
        ArrayList<Integer> object = new ArrayList<Integer>();
        object.add(1);
        object.add(2);
        object.add(3);
        object.forEach((n)-> System.out.println(n));
        for(Integer n : object){
            System.out.println(n.intValue());
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        
        
    }
}

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
public class HMap {
    public static void main (String[] args){
        HashMap<String,String> hmap = new HashMap<>();
        hmap.put("CODE","mbadika");
        hmap.put("DESC", "Mayank Badika");
        hmap.put("CODE","mbad");
        System.out.println(hmap.containsValue("mbadika"));
    }
    
}

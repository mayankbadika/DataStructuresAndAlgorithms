/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mayank
 */
public class stringlist1 {
    
    public List<String> search(ArrayList<String> str,String a){
        ArrayList<String> result = new ArrayList<String>();
        int count =0;int i=0;
        while(i<str.size()){
            if(str.contains(a.toUpperCase())){
                count++;
                result.add(a);    
            }
            i++;
        }
        
        return result;
    }
    
    public void display(List<String> str){
        for(int i=0;i<str.size();i++){
            System.out.println(str.get(i));
        }
    }
    
    public static void main(String[] args){
        ArrayList<String> str = new ArrayList<String>();
        str.add("M");
        str.add("A");
        str.add("Y");
        str.add("A");
        str.add("N");
        str.add("K");
        
        stringlist1 sl1 = new stringlist1();
        List<String> result = sl1.search(str, "a");
        sl1.display(result);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package myclass;
import java.util.*;
/**
 *
 * @author mayank
 */
public class testllist { // Using some basic opeartions of java 's linked list class
    
    public static void main (String[] args)
    {
        LinkedList<String> object = new LinkedList<String>();
        object.add("M");
        object.add("B");
        object.add("Badika");
        System.out.println(object);
        object.addLast("MayanK");
        System.out.println(object);
        object.removeLast();
        System.out.println(object);
    }
}

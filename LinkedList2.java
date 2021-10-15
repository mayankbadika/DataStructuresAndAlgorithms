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
public class LinkedList2 {
    
    static class Node
    {
        int data;
        Node next;
        Node(int d){
            this.data = d;
            this.next = null;
        }
    }
    Node head;
    
    public void pushtofirst(int d){
        Node oldnode = head;
        head = new Node(d);
        head.next = oldnode;
    }
    
    public void pushtolast(int d){
        Node newnode = new Node(d);
        
        int last = 0;
        Node n = head;
        while(n.next!=null){ // if a node is a last node then next element is null
            n = n.next;
        }
        n.next = newnode;
    }
    
    public void printlist(){
        Node n;
        n= head;
        while(n!=null){
            System.out.println(n.data +" ");
            n = n.next;
        }
    }
    
    public double todigit(Node n,int i,double digit){ // Using Recursion
        if (n== null){
            return digit;
        }  
        digit = digit + (n.data *Math.pow(10,i));
        
       return todigit(n.next,i+1,digit);
       
    }
    
    public double todigit(){
        return todigit(head,0,0.0);
    }
}

class Driver{
    public static void main (String[] args)
    {
        LinkedList2 lst = new LinkedList2();
        lst.pushtofirst(1);
        lst.pushtolast(2);
        lst.pushtolast(3);
        lst.pushtolast(4);
        lst.pushtolast(5);
        //lst.pushtolast(5);
        lst.printlist();
        System.out.println(lst.todigit());
    }
    
}
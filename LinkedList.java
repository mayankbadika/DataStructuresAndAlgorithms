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
public class LinkedList {
    Node head;
    int length;
    static class Node{
        int data;
        Node next;
        Node(int d){data = d; /*next = null;*/}
    }
    
    public void printlist() 
    { 
     Node n = head; length = 0;
     while(n != null){
         System.out.println(n.data+" ");
         n =n.next;
     }
    } 
    
    public void printmiddle(){
        Node fast = head; //1
        Node Slow = head;  //1
        if (head != null){
            while(fast != null && fast.next!= null){
                fast = fast.next.next;
                Slow = Slow.next;
            }
            System.out.println("Middle = "+Slow.data);
        }
    }
    
    public void push(int number){
        Node newnode = new Node(number);
        newnode.next = head;
        head = newnode;
    }
    
    public void pushtomiddle(int number){
        Node newnode = new Node(number);
        Node fast = head;
        Node slow = head;
        if (head != null){
            while(fast!=null &fast.next!=null){
                fast =fast.next.next;
                slow = slow.next;
            }
            newnode.next = slow.next;
            slow.next = newnode;
        } 
    }
    
    public void pushtolast(int number){
        Node newnode = new Node(number);
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = newnode;
        newnode.next = null;
    }
    
    
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        
        llist.head = new Node(1);
        Node second = new Node(2);
        Node third  = new Node(3);
        
        llist.head.next = second;
        second.next = third;
        //llist.push(4);
        llist.pushtomiddle(4);
        //llist.pushtolast(5);
        llist.printlist();
        
        llist.printmiddle();
        
    }
    
    
}

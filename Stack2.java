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
public class Stack2 { // Stack implementation using linked list
    
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null; // as the end linkedlist should point to null . The head is the last llist in this case so point to null
        } 
        
    }
    Node head;
    Stack2(){
        this.head = null;
    }
    
    boolean isempty()
    {
        if(head == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    void push(int x){
        Node oldnode = head; // the new element becomes the head node and the old head node is pushed down
        head = new Node(x);
        head.next = oldnode;
        
        /*Node temp = new Node(x);
        
        temp.next = head;
        head = temp;
        */
        
        System.out.println("Added Element "+x);
    }
    public void printlist(){
        Node n = head;
        while(n != null){
            System.out.println(n.data+" ");
            n= n.next;
        }
    }
    boolean pop(){
        if(head == null){
            System.out.println("Underflow Condition");
            return false;
        }
        else
        {
            if(head.next == null){
                System.out.println(head.data+" "+ "was poped out");
                head = null;
                return true;
            }
            else{
                Node secondnode = head.next;
                System.out.println(head.data+" "+ "was removed");
                head = secondnode;
             return true;   
            }
        }
    }
    
}

class main{
    public static void main (String[] args){
        Stack2 stk = new Stack2();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        stk.push(50);
        stk.printlist();
        stk.pop();
        System.out.println("New List");stk.printlist();
    }
}

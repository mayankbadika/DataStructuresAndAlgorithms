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
public class DoublyLinkedList {
    
    static class node{
        int data;
        node prev;
        node next;
        
        node(int d){
            this.data = d;
        }
    }
    node head;
    
    void pushtofirst(int d){
        if(head == null){
            head = new node(d);
            return;
        }
        node oldnode = head;
        head = new node(d);
        head.next = oldnode;
        head.prev = null;
        oldnode.prev = head;
    }
    
    void printlist(){
        node n = head;
        while(n!=null){
            System.out.println(n.data+" ");
            n=n.next;
        }
    }
    
    void printlistinrev()
    {
        System.out.println("List in reverse order");
        node n = getlastnode();
        while(n!=null){
            System.out.println(n.data+" ");
            n = n.prev;
        }
    }
    
    void pushatlast(int d){
        node n = getlastnode();
        node oldnode = n;
        if(n == null) {
            System.out.println("List is empty");
            return;
        }
        node newnode = new node(d);
        n.next = newnode;
        newnode.prev = n;    
    }
    
    node getlastnode(){
        if (head == null) return null; 
        node n = head;
        node last = null;
        while(n.next!=null){
            n = n.next;
            last = n;
        }
        return last;
    }
}

class Main1
{
    public static void main (String[] args)
    {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.pushtofirst(10);
        dll.pushtofirst(20);
        dll.pushtofirst(30);
        dll.pushtofirst(40);
        dll.pushtofirst(50);
        dll.pushatlast(5);
        System.out.println("Last node is "+dll.getlastnode().data);
        System.out.println("First node is "+dll.head.data);
        dll.printlist();
        dll.printlistinrev();
    }
}


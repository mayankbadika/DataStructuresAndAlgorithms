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
public class Queue2 { 
// Implementing Queue using Linked List
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
        int size =0 ;
        void enqueue(int d){
            Node oldnode = head;
            head = new Node(d);
            head.next = oldnode;
            size++;
        }
        
        void dequeue(){
            
            Node n = head;
           while(n.next!=null && n.next.next!=null){
               n=n.next;
            }  
            if(n!=null){
                n.next = null;
            }
            else{
                head = null;
            }
            
           //System.out.println("Second last "+n.data);
        }
        int lastnode(){
            if (size!=0){
                Node n = head;
                while(n.next!=null){
                    n=n.next;
                }
                return (n.data);
            }
            return 0;
        }
        
        void printlist(){
            Node n = head;
            System.out.println("Queue:");
            while(n!=null){
                System.out.println(n.data+" ");
                n= n.next;
            }
            //System.out.println("Rear is ="+head.data);
            //System.out.println("Front ="+lastnode());
        }
    }

class Driver3{
    public static void main (String[] args){
        Queue2 que = new Queue2();
        //que.enqueue(1);
        //que.enqueue(2);
        //que.enqueue(3);
        //que.enqueue(4);
        //que.enqueue(5);
        que.printlist();
       
        que.dequeue();
        que.printlist();
        que.dequeue();
        que.printlist();
        
    }
}

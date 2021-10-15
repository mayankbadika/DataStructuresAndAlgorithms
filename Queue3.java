//
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
public class Queue3 { // Implemnting queue using arrays
    static class node{
        int data;
        node next;
        node(int d){
            data = d;
            next = null;
        }
    }
    
    node front;
    node rear;
    
    Queue3(){
        front=rear=null;
    }
    void add(int d){
        node newnode = new node(d);
        if (rear == null){
            front = rear = newnode; 
            return;
        }
        rear.next=newnode;
        rear=newnode;
    }
    
    void pop(){
        if(front == null){
            System.out.println("Queue is empty");
            return;
        }
        node oldnode = front;
        front = oldnode.next;
    }
    
    public void printlist() 
    { 
     node n = front;
     while(n != null){
         System.out.println(n.data+" ");
         n =n.next;
     }
    } 
    

}    
class QueueDriver2{
    public static void main(String[] args)
    {
        Queue3 que = new Queue3();
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        
        que.printlist();
        
        que.pop();
        System.out.println("After Deletion");
        que.printlist();
        
      System.out.println("Rear is ="+que.rear.data);
      System.out.println("Front ="+que.front.data);
    }
}
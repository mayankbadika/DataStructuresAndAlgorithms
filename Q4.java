/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;


public class Q4 { // Implemnting queue using arrays
    int rear; int front;int size;
    int arr[];
    
    Q4(){
        rear=front=-1;
        arr = new int[10];
        size=0;
    }
    
    void add(int d){
        if(rear == -1){
            front=rear=0;
            arr[front]=d;
            size++;
            return;
        }
        rear++;
        arr[rear]=d;size++;
    }
    void print(){
        for(int i=0;i<size;i++){
            System.out.println(arr[i]);
        }
    }
    
    void printfront(){
        System.out.println("Front = "+arr[front]);
    }
    
    void printrear(){
        System.out.println("Rear = "+arr[rear]);
    }
    
    void pop(){
        if(front == -1){
            System.out.println("Queue is empty");
            return;
        }
        
    }
    
}    
class QueueDriver4{
    public static void main(String[] args)
    {
        Q4 que = new Q4();
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        que.print();
        que.printfront();
        que.printrear();
        que.pop();
        que.print();
        que.printfront();
        que.printrear();
        
    }
}

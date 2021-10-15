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
public class Queue1 { // Implemnting queue using arrays
    int size;
    int front;
    int rear;
    int arr[]; int capacity;
    
    Queue1(int capacity){
        this.capacity = capacity;
        front=0;size=0;
        rear=-1;
        // rear = capacity -1;
        arr = new int[capacity];
    }
    
    boolean isempty(Queue1 queue){
        return (queue.size ==0);
    }
    
    boolean isfull(Queue1 queue){
        return(queue.size==queue.capacity);
    }
    
    void enqueue(int d)
    {
        if (isfull(this)){ // this referes to the Queue1 class 
           return; 
        }
        rear=rear+1;
        arr[rear]=d;
        size++;
    }
    
    void dequeue(){ // removing element from the top;
        if (isempty(this)){
            return;
        }
        //front = front+1;
        System.out.println("Dequeued "+arr[front]);
        for(int i =0;i<size-1;i++){
            arr[i]=arr[i+1];
        }
        size--;
        
    }
    void printqueue(){
        for(int i=0;i<size;i++){
            System.out.println(arr[i]);
        }
    }
}

class QueueDriver1{
    public static void main(String[] args)
    {
        Queue1 que = new Queue1(5);
        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);
        que.enqueue(4);
        que.enqueue(5);
        que.printqueue();
        que.dequeue();
        que.printqueue();
    }    
}
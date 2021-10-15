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
public class Stack { // Stack implementation using arrays
    static final int max = 1000;
    int top;
    int a[] = new int[max];
    
    boolean isempty(){
        return(top<0);
    }
    
    Stack(){
     top = -1;   
    }
    
    boolean push(int x){
        if (top >= (max-1) )
        {
            System.out.println("Overflow");
            return false;
        }
        else
        {
            top = top +1;
            a[top]=x;
            System.out.println("Added Element "+x);
            return true;
        }
    }
    
    int pop(){
        if (top<0){
            System.out.println("Underflow Condition");
            return 0;
        }
        else{
            int x = a[top];
            top= top-1;
            return x;
        }
    }   
}

class Main{
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop()+" "+"Element was removed from the stack");   
    }
}

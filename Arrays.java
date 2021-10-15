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

class Student{
    public int rollno;
    public String name;
    Student(int rollno,String name){
        this.rollno = rollno;
        this.name = name;
    }
}


public class Arrays {
    
    public static void main(String[] args){
        
        Student[] arr = new Student[1];
        arr[0]=new Student(1,"Mayank");
        
        /*for(int i=0;i<arr.length;i++){
            System.out.println(arr[i].name +" "+arr[i].rollno);
        }
        */
        for(Student var : arr){
            System.out.println(var.name+" "+var.rollno);
        }
    }
    
}

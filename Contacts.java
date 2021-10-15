/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;
import java.io.*;
import java.util.*;
/**
 *
 * @author mayank
 */

class Person{
    private String name; // private variables to implement the principle of encapsulation
    private String number;
    
    Person(String name,String number){
     this.name = name;
     this.number = number;
    }
    
    String getname(){
        return this.name;
    }
    
    String getnumber(){
        return this.number;
    } 
}

public class Contacts {
    ArrayList<Person> person = new ArrayList<>();
    
    void addnew(String name,String number){
        Person newperson = new Person(name,number);
        person.add(newperson);
    }
    
    void  displaycontactlist(){
        for(Person per : person){
            System.out.println(per.getname()+" "+per.getnumber());
        }
    }
    
    void testiterator(){
        Iterator it = person.iterator();
        while(it.hasNext()){
            Person per = (Person)it.next();
            System.out.println(per.getname()+" "+per.getnumber());
            if(per.getname()=="testxyz") it.remove(); // this removes this contact from the list
        }
    }
    
    Person findnumber(String name){ // For finding one suggestion based on input
        for(Person per : person){
            if(per.getname().contains(name)){
                return per;
            }
        }
        return null;
    }
    
    ArrayList findperson(String name){ // for finding multiple suggestion based on input
        ArrayList<Person> result = new ArrayList<>();
        
        for(Person per : person){
            if(per.getname().contains(name)){
                result.add(per);
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        Contacts obj = new Contacts();
        obj.addnew("Mayank","3855288295");
        obj.addnew("testxyz","3453454354");
        obj.addnew("test2", "543654563474");
        
        //obj.testiterator();
        obj.displaycontactlist();
        
        /*Person find = obj.findnumber("Mayank"); 
        if(find != null){
            System.out.println("Found "+find.getname()+"'s number "+find.getnumber());
        }
        else{
            System.out.println("Not found");
        }
        */
        
        ArrayList<Person> result = obj.findperson("test");
        if  (result.isEmpty() ==false){
            System.out.println("Suggestions");
            for(Person per : result){
                System.out.println(per.getname()+" "+per.getnumber());
            }
        }
        else{
            System.out.println("No Suggestions");
        } 
        
    }
}

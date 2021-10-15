/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

import java.util.HashMap;

/**
 *
 * @author mayank
 */
class node{
    int key;
    int value;
    node prev;
    node next;
    
    node(int key,int value){
        this.key = key;
        this.value = value;
    }
}


public class LRUCache {
    int capacity;
    HashMap<Integer,node> map = new HashMap<>();
    node head;
    node end;
    
    LRUCache(int capacity){
        this.capacity = capacity;
    }
    
    /*int get(int key){
        if(map.containsKey(key)){
            node n = map.get(key);
            
            
            return n.value;
        }
        return -1;
    }
    */
    // This method adds node to the head
    void sethead(node n){
        n.next = head;
        n.prev = null;
         if(head!=null) head.prev = n;
         head = n;
         if(end==null) end=head;
    }
    
    
    void put(int key,int value){
        
    }
    
    
    
    
    
}

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
public class BinaryTree2 {
    
    class node{
        int data;
        node left,right;
        node(int data){this.data = data;}
    }
    
    node root;
    BinaryTree2(){root = null;}
    
    void insert(int data){
        root = insert(root,data);
        System.out.println(root.data);
    }
    
    node insert(node root,int data){
        if (root == null){
            root = new node(data);
            return root;
        }
        
        if(root.left == null){
            root.left = new node(data);
            return root.left;
        }else
        {
            root.left = insert(root.left,data); 
        }
        
        if(root.right == null){
            root.right = new node(data);
            return root.right;
        }
        else{
            root.right = insert(root.right,data);
        }
        
        return root;
    }
    
    static void inorder(node temp) 
    { 
        if (temp == null) 
            return; 
       
        inorder(temp.left); 
        System.out.print(temp.data+" "); 
        inorder(temp.right); 
    } 
    
    void inorder(){inorder(root);}
    
    public static void main(String[] args){
        BinaryTree2 bst = new BinaryTree2();
        bst.insert(10);
         bst.insert(11);
         bst.insert(7);
         bst.insert(9);
         bst.insert(15);
         bst.insert(8);
         
         //bst.inorder();
        
    }
    
    
    
    
}

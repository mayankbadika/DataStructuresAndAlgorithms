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
public class BinarySearchTree { // Binary Search tree
    
    class node{
        int data;
        node leftchild;
        node rightchild;
        
        node(int data){
            this.data = data;
        }
    }
    node root;
    
    void search(int data){
        node result = search(root,data);
        if(result == null){
            System.out.println("No Match");
        
        }
        else{
            System.out.println("Match found");
        }
    }
    
    
    public node search(node root,int data){
        if(root ==null|| root.data==data)
            return root;
        if(root.data > data)
            return search(root.leftchild,data);
   
            return search(root.rightchild,data);   
    }
    
    void insert(int data){
        
        root = insertrec(root,data);
        //System.out.println(root.data+" "+data);
    }
    
    node insertrec(node root,int data){
        //root is just a variable in this method not the root element of the tree declared at the top of the class
        if(root == null){
            root = new node(data);
            return root;
        }
        
        if(root.data > data){
            root.leftchild = insertrec(root.leftchild,data);
        }
        else if(root.data<data){
            root.rightchild = insertrec(root.rightchild,data);
        }
        //System.out.println(root.data);
        return root;
        
    }
    
    
    
    
    
    void printinorder(node root){ // Sorted tree nodes
        if(root == null){
            return;
        }
        
        printinorder(root.leftchild);
        System.out.print(root.data+" ");
        printinorder(root.rightchild);
    }
    
    void printdescending(node root){
        if(root == null){
            return;
        }
        
        
        printdescending(root.rightchild);
        System.out.print(root.data+" ");
        printdescending(root.leftchild);
    }
    
    void printdescending(){printdescending(root);}
    void printinorder(){ printinorder(root);}
    
    void addtotree(int d){
        
    }
     public static void main(String[] args){
         BinarySearchTree bst = new BinarySearchTree();
         bst.insert(8);
         bst.insert(3);
         bst.insert(1);
         bst.insert(10);
         bst.insert(6);
         bst.insert(14);
         bst.insert(4);
         bst.insert(7);
         bst.insert(13);
         
         bst.search(99);
         System.out.println("Acending order of tree nodes is =");
         bst.printinorder();
         System.out.println("");
        System.out.println("Descending order of the tree nodes is =");
         bst.printdescending();
         
         
         
     }
    
}

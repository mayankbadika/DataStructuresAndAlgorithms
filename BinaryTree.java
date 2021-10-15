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
class Node{
    int data;
    Node left,right;
    Node(int d){
        this.data = d;
        right=left=null;
    }
}

public class BinaryTree {
    Node root;
    
    BinaryTree(int d){
        root = new Node(d);
    }
    
    BinaryTree(){
        root = null;
    }
    
    void printpostorder(Node node){
        if(node == null){
            return;
        }
        printpostorder(node.left);
        printpostorder(node.right);
        System.out.print(node.data+" ");
    }
    
    void printpreorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data);
        printpreorder(node.left);
        printpreorder(node.right);
    }
    
    void printinorder(Node node){
        if(node == null){
            return;
        }
        printinorder(node.left);
        System.out.print(node.data);
        printinorder(node.right);
    }
    
    void printlevel(Node node){
        if(node ==null){
            return;
        }
    }
    
    void level(int x){
        System.out.println(level(root,x,1));
    }
    
    int level( Node root,int x,int l){
       
       if(root == null) return 0;
        if(root.data == x) return l;
      
        int lvl = level(root.left,x,l+1);
        if(lvl!=0) return lvl;
       
        lvl = level(root.right,x,l+1);
        return lvl;
    }
    
    
    
    
    int height(Node root){
            int lheight =0;
            int rheight=0;
            if(root == null){
                return 0;
            } 
            else{
                lheight = height(root.left);
                rheight = height(root.right);
                
                
                if (lheight>rheight)
                    return (lheight+1);
                else
                    return (rheight+1);
                
            }
        }
    
    
    void printpostorder()  {     printpostorder(root);  } 
    void printinorder()    {     printinorder(root);   } 
    void printpreorder()   {     printpreorder(root);  }
    void printlevel()      {    printlevel(root);      }
    
}

class BTDriver{
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        /*System.out.println("printpostorder");
        bt.printpostorder();
        System.out.println("printpreorder");
        bt.printpreorder();
        System.out.println("printinorder");
        bt.printinorder();
        */
        //System.out.println("Level traversal");
        //bt.printlevel();
        //System.out.println(bt.height(bt.root));
        
        bt.level(7);
    }
}


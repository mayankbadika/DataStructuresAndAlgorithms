import com.sun.source.tree.Tree;

class Node{ // Defining the Node of the tree
    public int key;
    public Node left,right;
    public Node(int val){
        key = val;
        left = right = null;
    }
}

public class TreeBasic1 {
    Node root;
    TreeBasic1(int key){
        root = new Node(key);
    }
    TreeBasic1(){
        root = null;
    }
    void printinorder(Node node){
        if(node == null) return;
        printinorder(node.left);
        System.out.print(node.key+" ");
        printinorder(node.right);
    }
    void printinorder() { printinorder(root); }
    public static void main(String[] args){
        TreeBasic1 tree = new TreeBasic1();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Inorder Traversal") ;
        tree.printinorder();
    }
}

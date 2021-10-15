
import java.io.*;
import java.util.*;
//package myclass;

/**
 *
 * @author mbadika
 */

class Graph{
    private int V;
    private LinkedList<Integer> adj[];
    
    Graph(int v){ // Definig the structure of a graph . Each node will have it's value V and adj[] adjaceny list
        V=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) 
            adj[i]= new LinkedList();
    }
    
    void addEdge(int v,int w){
        adj[v].add(w);
    }
    
    void BFS(int s){
        boolean[] visited = new boolean[V];
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        visited[s]=true;
        queue.add(s);
        
        while(!queue.isEmpty()){
             
            s = queue.poll();
            System.out.println(s+" ");
            
            Iterator<Integer> i = adj[s].iterator();
            while(i.hasNext()){
                int n = i.next();
                
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }  
            }  
        } 
    }
    
    void DFS(int a){
        boolean[] visited = new boolean[V];
        
        DFSUtil(a,visited); // using recursive function as a stack for DFS Algorithm
        
        List<Integer> path = new ArrayList<>();
        DFSPaths(2, visited, 3, path);
        
    }
    
    void DFSP(int a){
        boolean[] visited = new boolean[V];
        
        ArrayList<Integer> path = new ArrayList<>();
        path.add(a);
        DFSPaths(a, visited, 3, path);
        
    }
    
    void DFSUtil(int a,boolean[] visited){
        
        visited[a] = true;
        System.out.println(a+" ");
        
        Iterator<Integer> i = adj[a].iterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                visited[n]=true;
                DFSUtil(n,visited); // Adding node to the stack
            }
        }
    }
    
    void DFSPaths(int start,boolean[] visited,int end,List<Integer> path){
        visited[start]=true;
        if(start == end){
            System.out.println(path);
            visited[start] =false;
            return;
        }
        
        Iterator<Integer> i = adj[start].iterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                path.add(n);
                DFSPaths(n,visited,end,path); // Adding node to the stack
                path.remove(n);
            }
        }
       visited[start]=false;
    }
    
    
    
    void DFSStack(int a){
        
        boolean[] visited = new boolean[V];
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(a); 
        
        while(!stack.isEmpty()){
         a = stack.pop();
         
         if(!visited[a]){
            visited[a]= true;
            System.out.println(a+" ");
            }
         
         Iterator<Integer> i = adj[a].iterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                stack.push(n); // Adding node to the stack
            }
            
        }    
        }
        
    }
}

public class GraphTraversal {
    public static void main(String[] args){
        Graph g = new Graph(4);
        
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.BFS(2); 
        
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.DFS(2); 
        
        Graph g1 = new Graph(5); 
          
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(1, 4); 
        System.out.println("Following is the Depth First Traversal"); 
        g1.DFSStack(0);
        
        
        Graph g2 = new Graph(4); 
        g2.addEdge(0, 1); 
        g2.addEdge(0, 2); 
        g2.addEdge(0, 3); 
        g2.addEdge(2, 0); 
        g2.addEdge(2, 1); 
        g2.addEdge(1, 3); 
       
        System.out.println("All Path between node 2 and node 3 are :");
        
        g2.DFSP(2);
    }
}

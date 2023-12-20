package myclass;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphConcepts {

    public static void main(String[] args){
        HashMap<Character, List<Character>> graph = new HashMap<>();
        char[][] nodes = {{'a','b'},{'a','c'},{'b','d'},{'c','e'},{'d','f'}};

        for(int i=0;i<nodes.length;i++){
            char source = nodes[i][0];
            char dest = nodes[i][1];
            addEdge(source,dest,graph);
        }

        System.out.println(graph);

        GraphConcepts obj = new GraphConcepts();
        System.out.println("DFS");
        System.out.println(obj.DFS('a','e',graph));
        System.out.println("BFS");
        System.out.println(obj.BFS('a','e',graph));
    }

    // creating adjacency matrix of the graph
    public static void addEdge(char source, char dest, HashMap<Character, List<Character>> graph){
        List<Character> list = graph.get(source) == null ? new ArrayList<>() : graph.get(source);
        list.add(dest);
        graph.put(source,list);
        graph.put(dest,new ArrayList<>());
    }

    public boolean DFS(char source, char dest ,HashMap<Character, List<Character>> graph){
        System.out.println(source); // stack trace
        if(source == dest) return true;
        List<Character> list = graph.get(source);
        for(Character neighbour : list){
            // maybe the neighbour has path to dest . if so then we can say source also has path to dest hence return true
            if(DFS(neighbour,dest,graph)) return true;
            // if this neighbour does not have a path still let's check for other neighbour of the current source therefore we don't return 'else return false;'
        }
        return false;
    }

    public boolean BFS(char source, char dest ,HashMap<Character, List<Character>> graph){
        Queue<Character> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()){
            char curr = q.poll();
            System.out.println(curr);
            if(curr == dest) return true;

            for(char neighbour : graph.get(curr)){
                q.add(neighbour);
            }
        }

        return true;
    }


}

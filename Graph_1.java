import java.util.*;

public class Graph_1 {

    //Implement Graph
    static HashMap<Integer,ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
    HashSet<Integer> visited = new HashSet();

    public void addgraph(int[][] arr){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int[] elem : arr) {
            if (graph.get(elem[0]) == null) {
                graph.put(elem[0], new ArrayList<Integer>());
                list = graph.get(elem[0]);
                list.add(elem[1]);
                graph.put(elem[0], list);
            } else {
                list = graph.get(elem[0]);
                list.add(elem[1]);
                graph.put(elem[0], list);
            }
        }

        //DFS(graph,1,visited);
        System.out.println(componentcount(graph));
    }

    public void DFS(HashMap<Integer,ArrayList<Integer>> graph, int source, HashSet Visited){
        if(Visited.contains(source)) return;
        Visited.add(source);
        System.out.println(source);
        ArrayList<Integer> list;
        list = graph.get(source);
        if  (list == null ) return;
        for(int neighbor : list){
            DFS(graph,neighbor,Visited);
        }

    }

    public int componentcount(HashMap<Integer,ArrayList<Integer>> graph){
        int count=0;
        for(int i : graph.keySet()){
            if(visited.contains(i)==false){
                DFS(graph,i,visited);
                count = count +1;
            }

           //
        }
        return count;
    }


    public static void main(String[] args){
        int[][] trust ={{1,2},{1,3},{3,4},{2,5},{7,8},{3,8}};
        Graph_1 obj = new Graph_1();
        obj.addgraph(trust);
        System.out.println(graph);

    }

}

import java.util.*;



public class pqueue {


    public static void main(String[] args){
        //Queue<Integer> queue = new PriorityQueue<>(new CompareInt());
        Queue<Integer> queue = new PriorityQueue<>((o1,o2)->o1>o2?1:-1);
        queue.add(2);
        queue.add(55);
        queue.add(32);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }


}



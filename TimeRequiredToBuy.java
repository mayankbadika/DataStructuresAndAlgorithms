package myclass;
import java.util.LinkedList;
import java.util.Queue;

public class TimeRequiredToBuy {
    public static void main(String[] args) {
        String s = "1-1+1";
        TimeRequiredToBuy obj = new TimeRequiredToBuy();

        System.out.println(obj.timeRequiredToBuy(new int[]{2,3,2},2));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q = new LinkedList<>();

        for(int i =0; i< tickets.length; i++) {
            //Number of tickets, index
            q.add(new int[]{tickets[i], i});
        }

        int time =0 ;
        while(!q.isEmpty()) {
            int[] elem = q.poll();
            int ticket = elem[0];
            int index = elem[1];

            ticket = ticket -1;
            time++;
            if(ticket == 0 && index == k) return time;
            elem[0] = ticket;
            if(elem[0] == 0) continue;

            q.add(elem);
        }

        return time;
    }
}

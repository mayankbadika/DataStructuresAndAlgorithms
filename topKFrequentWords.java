import java.io.*;
public class topKFrequentWords {
    /*public List<String> topKFrequent(String[] words, int k) {
        HashMap <String,Integer> map = new HashMap<>();

        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        ArrayList<HashMap <String,Integer>> result = new ArrayList<HashMap <String,Integer>>();
        Collections.sort(result,new sort());
        for(Map.Entry m :result){
            System.out.println(m);
        }

        return result;

    }

    class sort implements Comparator<Map.Entry<String,Integer>> {
        public int compare(HashMap <String,Integer> a,HashMap <String,Integer> b){
            int r = (a.getValue()>b.getValue())?-1:1;
            if (r==0){
                r=(a.getKey().compareTo(b.getKey()))?1:-1;
            }
        }
    }

     */
}

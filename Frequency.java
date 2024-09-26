package myclass;

import java.util.*;

public class Frequency {

    public static void main(String[] args){
        String str = "helloworld";
        Frequency obj = new Frequency();
        System.out.println(obj.getFrequency(str));
    }

    public List<Character> getFrequency(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        List<Character> sortedMap = new ArrayList<>(map.keySet());

        Collections.sort(sortedMap, (a,b) -> map.get(b) - map.get(a));

        int freq = map.get(sortedMap.get(0));

        for(Character c : sortedMap) {
            if(freq == map.get(c)) {
                list.add(c);
                freq = map.get(c);
            }
        }

        return list;
    }
}

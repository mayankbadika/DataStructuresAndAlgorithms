package myclass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Prac {

    public static void main(String[] args) {
        Prac obj = new Prac();

        obj.playGround("helloworld");
    }

    public void playGround(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        Comparator<Character> comparator = new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        };

        List<Character> list = new ArrayList<>(map.keySet());

        list.sort(comparator);

        list.forEach(elem -> System.out.println(elem));
    }
}

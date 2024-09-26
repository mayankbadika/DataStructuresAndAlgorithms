package myclass.Stream;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(1, (n -> n+1))
                .limit(10)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        Integer sum = list.stream().reduce(0, Integer::sum);

        System.out.println(list);
        System.out.println(sum);

        // Flatmap use

        /*
            flatMap is a method in Java Streams that is used to transform each element
            of the stream into another stream, and then flatten the resulting streams
            into a single stream. This is particularly useful when dealing with nested
            collections or when you want to transform and merge multiple streams into one.
        */

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9),
                Arrays.asList(4, 2, 9)
        );
        System.out.println(listOfLists);

        List<Integer> flatList = listOfLists.stream()
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(flatList);


        // String example
        List<Player> players = Arrays.asList(
                new Player(18, "Mayank", 10),
                new Player(19, "Ronaldo", 11),
                new Player(21, "Kohli", 18)
        );

        //players

        // Sorted by age
        List<Player> sortedList = players.stream().sorted((a, b) -> b.age - a. age).collect(Collectors.toList());
        System.out.println(sortedList);

        //Find numbers starting with 1
        //Input : [1, 12,34, 56, 78,90,11,15,14,34]

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 12,34, 56, 78,90,11,15,14,34));

        List<Integer> numbersStartWith1 = numbers.stream().filter(x -> x.toString().startsWith("1")).collect(Collectors.toList());

        System.out.println(numbersStartWith1);

        streamQuestions();
    }

    public static void streamQuestions() {
        //Write a Java program to calculate the average of a list of integers using streams.
        List<Integer> q1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        int a1 = q1.stream().reduce(0, (sum, n) -> sum + n);

        System.out.println("q1 answer = "+ a1);

        //Write a Java program to convert a list of strings to uppercase or lowercase using streams.
        List<String> q2 = new ArrayList<>(Arrays.asList("mayank", "is","a", "nice", "guy"));

        List<String> a2 = q2.stream()
                            .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
                            .collect(Collectors.toList());

        System.out.println("q2 answer = "+ a2);

        //Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
        List<Integer> q3 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        int a3EvenSum = q3.stream().filter( n -> n%2 == 0).reduce(0, Integer::sum);
        int a3OddSum = q3.stream().filter(n ->n % 2 != 0).reduce(0, Integer::sum);

        System.out.println("q3 even answer = "+ a3EvenSum + " q3 odd answer = "+a3OddSum);

        //Write a Java program to remove all duplicate elements from a list using streams.
        List<String> q4 = new ArrayList<>(Arrays.asList("Java", "Python", "Java", "Ruby","Python","SQL"));

        List<String> a4 = q4.stream().distinct().collect(Collectors.toList());
        System.out.println("q4 answer = "+ a4);

        //Write a Java program to count the number of strings in a list that start with a specific letter "P" using streams.
        List<String> q5 = new ArrayList<>(Arrays.asList("Java", "Python", "Java", "Ruby","Python","SQL"));

        int a5 = (int) q5.stream().filter( str -> str.startsWith("P")).count();
        System.out.println("q5 answer = "+ a5);

        //Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
        List<String> q6 = new ArrayList<>(Arrays.asList("mayank", "is","a", "nice", "guy"));

        List<String> a6Ascending = q6.stream().sorted().collect(Collectors.toList());
        System.out.println("q6 answer ascending = "+ a6Ascending);

        List<String> a6Descending = q6.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("q6 answer ascending = "+ a6Descending);

        //Write a Java program to find the maximum and minimum values in a list of integers using streams.
        List<Integer> q7 = new ArrayList<>(Arrays.asList(2,1,4,3,6,22,78,98,43,23,46,67,54,48));

        int a7Max = q7.stream().reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("q7 answer max = "+ a7Max);

        int a7MIn = q7.stream().reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println("q7 answer min = "+ a7MIn);

        //Write a Java program to find the second smallest and largest elements in a list of integers using streams.
        List<Integer> q8 = new ArrayList<>(Arrays.asList(2,1,4,3,6,22,78,98,43,23,46,67,54,48));

        int a8SecondLargest = q8.stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .collect(Collectors.toList())
                .get(1);

        Optional<Integer> a8SecondLargestApproach2 = q8.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        System.out.println("a8 Second Largest = "+ a8SecondLargest);
        System.out.println("a8 Second Largest Approach 2 = "+ a8SecondLargestApproach2.get());

        //Write a Java program to print the largest word using stream.
        List<String> q9 = new ArrayList<>(Arrays.asList("Java", "Python", "Java", "Ruby","Python","SQL", "fsdlfjldkfjd", "sdhasdhjaskldds"));

        String a9 = q9.stream().max((w1, w2) -> w1.length() - w2.length()).orElse("");
        System.out.println("a9 Largest word = "+ a9);
    }
}

class Player {
    int age;
    String name;
    int rank;

    public Player(int age, String name, int rank) {
        this.age = age;
        this.name = name;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Player{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}

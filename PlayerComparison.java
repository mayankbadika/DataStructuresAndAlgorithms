/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * This was asked in shopify interview
 */
/*
 * https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
 * when adding comparable to the class we get a compareto function this gives us one chance to define the sorting of the objects of that class
 * we will have to use collects.sort(<listname>) to use that sorting that we defined for the class using compareto
 * but if we need more than one way of sorting things we can use external classes such as comparators
 */
package myclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Player implements Comparable<Player>
{
    private int ranking;
    private String name;
    private int age;

     public int getAge() {
         return age;
     }

     public int getRanking() {
         return ranking;
     }

     public String getName() {
         return name;
     }

     public void setAge(int age) {
         this.age = age;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setRanking(int ranking) {
         this.ranking = ranking;
     }

     public Player(int ranking, String name, int age){
         setRanking(ranking);
         setAge(age);
         setName(name);
     }

    @Override
    public int compareTo(Player o) { // this will naturally set the sorting by age
        return this.age - o.age;
    }
}

class sortByRanking implements Comparator<Player>{
    public int compare(Player a, Player b){
        int rankCompare = a.getRanking() - b.getRanking();
        if(rankCompare == 0){ // if ranking is same then sort by name
            return a.getName().compareTo(b.getName());
        }
        return rankCompare;
    }

    public int sortByName(Player a, Player b){
        return a.getName().compareTo(b.getName());
    }
}

class sortByAge implements Comparator<Player> {
    public int compare(Player o1, Player o2) {
        return o1.getAge() - o2.getAge();
    }
}

class sortByName implements Comparator<Player> {
    public int compare(Player o1, Player o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


public class PlayerComparison {
    public void displayList(List<Player> players){

        for(Player player : players){
            System.out.println(player.getRanking()+" "+player.getName()+" "+player.getAge());
        }
    }
    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        footballTeam.add(new Player(59, "John", 56));
        footballTeam.add(new Player(67, "Roger", 22));
        footballTeam.add(new Player(45, "Steven", 24));
        footballTeam.add(new Player(45, "Adam", 28));
        footballTeam.add(new Player(48, "Brian", 29));

        PlayerComparison obj = new PlayerComparison();
        System.out.println("Before Sorting : " );
        obj.displayList(footballTeam);

        //using the compareto method that we added as the class implements a comparable
        Collections.sort(footballTeam);

        //using external comparator method
        footballTeam.sort(new sortByAge());

        System.out.println("After Sorting : ");
        obj.displayList(footballTeam);

        System.out.println("After Sorting by ranking : ");
        footballTeam.sort(new sortByRanking());
        obj.displayList(footballTeam);

        System.out.println("After Sorting by name : ");
        footballTeam.sort(new sortByName());
        obj.displayList(footballTeam);
    }

    public void play(){
        List<Player> list = new ArrayList<>();
    }
}

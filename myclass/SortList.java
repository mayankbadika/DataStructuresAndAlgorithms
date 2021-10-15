
// Sort a comma seprated list based on two parameter
package myclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortList {

    public static void main(String[] args){
        String[] data ={"Iphone,20,1000","Samsung,24,900","Sony,20,800","LG,18,900"};
        SortList obj = new SortList();
        obj.sortlist(data);

    }

    public void sortlist(String[] data){
        ArrayList<list> result = new ArrayList<>();
        for(String s : data){
            String[] str = s.split(",");
            String desc = str[0];
            int sold = Integer.parseInt(str[1]);
            int price = Integer.parseInt(str[2]);
            result.add(new list(desc,sold,price));
        }

        Collections.sort(result,new listcomparator());
        printResult(result);
    }

    public void printResult(ArrayList<list> result){
        for(list l : result){
            String desc = l.desc;
            System.out.println(desc);
        }
    }

}

class listcomparator implements Comparator<list>{

    public int compare(list a, list b){
            int r = (a.sold <b.sold)?1:-1;
            if(r==0){
                r=(a.price>b.price)?1:-1;
            }
            return r;
        }

}

class list{
    String desc;
    int sold;
    int price;
    public list(String desc,int sold,int price){
        this.desc = desc;
        this.sold = sold;
        this.price = price;
    }
}

package myclass;

public class RecPrac {
    public static void main(String[] args) {
        RecPrac obj = new RecPrac();
        System.out.println(obj.count11("1111"));
        System.out.println(obj.count11("11abc11"));
        System.out.println(obj.count11("abc11x11x11"));
        System.out.println(obj.count11("111"));
    }

    public int count11(String str) {
        if(str.length() <=1) return 0;

        if(str.length()>=2 && str.substring(0,2).equals("11")) {
            return 1 + count11(str.substring(2));
        }

        return count11(str.substring(1));
    }
}

package myclass;

public class consecutiveNumbersSum {
    public static void main(String[] args){
        String s ="1122355";
        consecutiveNumbersSum obj = new consecutiveNumbersSum();

        System.out.println(obj.consSum(s));
        System.out.println(obj.sumofNumbersInString("1abc23"));
    }

    public int consSum(String s){
        String[] str = s.split("");
        int sum = 0;
        String prev = "" ;

        for(int i=0;i<str.length;i++){
            if(!prev.equals(str[i])){
                sum+=Integer.parseInt(str[i]);
                prev = str[i];
            }
        }
        return sum;
    }

    public int sumofNumbersInString(String s){
        String temp = "0";
        int sum = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                temp+=ch;
            }else{
                sum += Integer.parseInt(temp);
                temp="0";
            }
        }
        return sum+Integer.parseInt(temp);
    }


}

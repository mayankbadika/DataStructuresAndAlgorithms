package myclass;

public class numberToWordsConversion {
    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static void main(String[] args) {
        numberToWordsConversion obj = new numberToWordsConversion();
        //System.out.println(obj.numberToWords(123));
        System.out.println(obj.numberToWords(0));
    }

    public String numberToWords(int num) {
        int thousandCounter = 0;
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            if(num %1000 !=0) {
                sb.insert(0, helper(num%1000)+ " "+ THOUSANDS[thousandCounter]+" ");
            }
            num/= 1000;
            thousandCounter++;
        }

        helper(num);
        return sb.toString().trim();
    }

    private static String helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return "Zero";
        } else if (num < 20) {
            sb.append(LESS_THAN_20[num]).append(" ");
        } else if (num < 100) {
            sb.append(TENS[num / 10]).append(" ").append(helper(num % 10));
        } else {
            sb.append(LESS_THAN_20[num / 100]).append(" Hundred ").append(helper(num % 100));
        }
        return sb.toString().trim();
    }
}

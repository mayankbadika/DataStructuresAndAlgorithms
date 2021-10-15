public class fibonacii {

    public int fib(int n){

        if(n<=2) return 1;

        return fib(n-1)+fib(n-2);

    }

    public long fibdp(int n){
        long[] memo = new long[n+1];
        return fibdp(n,memo);
    }

    public long fibdp(int n,long[] memo){
        if(n<=2) return 1;
        if(memo[n]!=0) return memo[n];
        memo[n]=fibdp(n-1,memo)+fibdp(n-2,memo);
        //System.out.println(memo[n]);
        return memo[n];
    }

    public static void  main(String[] args){
        fibonacii fib = new fibonacii();
        //System.out.println(fib.fib(50));
        System.out.println(fib.fibdp(50));
    }
}

public class Fibonacci {

    //Memoization
    public static int fibo(int n, int dp[]){
        if(n == 0 || n ==1){
            return n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
        return dp[n];
    }

    //Tabulation
    public static int fibTabulation(int n){
        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n = 5;
        int dp[] = new int[n+1];
        System.out.println(fibo(n, dp));
        System.out.println(fibTabulation(n));
    }
}

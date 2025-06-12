
import java.util.Arrays;

public class ClimbingSteps {
    public static int countWays(int n){
        if(n == 0){
            return 1; //If persion is on ground and he want to go on ground then he simply do nothing
        }
        if( n < 0){
            return 0; //going underground- no ways
        }

        return countWays(n-1)+ countWays(n-2);
    }

    public static int countTablur(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            if(i == 1){
                dp[i] = dp[i-1] + 0;
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(countWays(5)); //step 3 -> 3, step 4 -> 5
        System.out.println(countTablur(5));
    }


}


// memoization

// public class ClimbingSteps {
//     public static int countWays(int n, int ways[]){
//         if(n == 0){
//             return 1; //If persion is on ground and he want to go on ground then he simply do nothing
//         }
//         if( n < 0){
//             return 0; //going underground- no ways
//         }

//         if(ways[n] != -1){
//             return ways[n];
//         }
        
//         ways[n] = countWays(n-1, ways)+ countWays(n-2,ways);
//         return ways[n];
//     }
//     public static void main(String[] args) {
//         int n = 5;
//         int ways[] = new int[n+1];
//         Arrays.fill(ways,-1);
//         System.out.println(countWays(n,ways)); //step 3 -> 3, step 4 -> 5 ways
//     }
// }
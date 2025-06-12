public class KnapsackTabulation {
    public static int findKnapsack(int wt[],int val[], int W){
        int dp[][] = new int[val.length+1][W+1];
        int n = val.length;

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 0; //first col = 0
        }

        for(int j = 0 ;j < dp[0].length; j++){
            dp[0][j] = 0; // first row = 0
        }
        
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < W+1; j++){
                int v = val[i-1]; // -1 as in dp we initialize first value as 0
                int w = wt[i-1]; // actual weight of item
                if(w <= j){ //valid -If actual weight is <= capacity if knapsack
                    int includeProfit = v + dp[i-1][j-w]; //if item include in knapsack
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit,excludeProfit);
                } else { // invalid
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
        printDp(dp); //function to print entire dp
       return dp[n][W]; // last cell of dp
    }

    public static void printDp(int dp[][]){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7; //capacity of bag is 7
        System.out.println(findKnapsack(wt, val, W));
    }
}

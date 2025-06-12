public class KnapsackMemoization {
    public static int findKnapsack(int wt[],int val[], int W,int n, int dp[][]){
        if(n == 0 || W == 0){ // n = 0 means no items left, W = 0 means no capacity left
            return 0; 
        }
        
        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if( wt[n-1] <= W){ //validated
            int ans1 = val[n-1]+ findKnapsack(wt, val, W-wt[n-1], n-1,dp); //include the item
            int ans2 = findKnapsack(wt, val, W, n-1,dp); //item not included
            dp[n][W] = Math.max(ans1,ans2);
            return dp[n][W];

        } else{ //not validate to add in bag
            dp[n][W] = findKnapsack(wt, val, W, n-1, dp);
            return dp[n][W]; 
        }
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7; //capacity of bag is 7

        int dp[][] = new int[val.length+1][W+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length;j++){
                dp[i][j] = -1; //initializing with -1
            }
        }

        System.out.println(findKnapsack(wt, val, W, val.length,dp));
    }
}
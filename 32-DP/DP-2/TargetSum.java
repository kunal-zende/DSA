public class TargetSum{
    public static boolean targetSumSubset(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1]; 
        // i = items, j = targeted sum
        //Initialize
        for(int i = 0; i < n+1; i++){
            dp[i][0] = true;
        }

        //Logic
        for(int i = 1; i <n+1; i++){
            for(int j= 1; j < sum+1; j++){
                int v = arr[i-1];
                //validation and include
                if(v <= j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }//exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }printdp(dp);
        return dp[n][sum];
    }
    
    //To print the dp array
     public static void printdp(boolean dp[][]){
            for(int i = 0; i < dp.length; i++){
                for(int j = 0; j < dp[0].length; j++){
                    System.out.print(dp[i][j]+ " ");
                }
                System.out.println();
            }
            System.out.println();
        }

    public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 3};
        int sum = 10;
        System.out.println(targetSumSubset(arr, sum));

    }
}
public class Knapsack {
    public static int findKnapsack(int wt[],int val[], int W,int n){
        if(n == 0 || W == 0){ // n = 0 means no items left, W = 0 means no capacity left
            return 0; 
        }

        if( wt[n-1] <= W){ //validated
            int ans1 = val[n-1]+ findKnapsack(wt, val, W-wt[n-1], n-1); //include the item
            int ans2 = findKnapsack(wt, val, W, n-1); //item not included
            return Math.max(ans1,ans2);
        } else{ //not validate to add in bag
            return findKnapsack(wt, val, W, n-1); 
        }
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7; //capacity of bag is 7

        System.out.println(findKnapsack(wt, val, W, val.length));
    }
}
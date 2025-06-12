public class arr2 {
    public static void main(String args[]){
        // int arr[] = {1, 2, 3, 4};
        // prefixsub(arr);

        // int arr2[] = {1, -2, 4, -3, 5};
        // kadans(arr2);

        // int arr3[] = {2,3,0,2,1};
        // System.out.println(trappingwater(arr3));

        int arr4[] = {7, 1, 5, 3, 6, 4};
        shares(arr4);
    }

    //prefix array to calculate maximum in subarray
    public static void prefixsub(int arr[]){
        int maxsum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];
        int currsum = 0;

        //calculating the prefix
        prefix[0] = arr[0];
        for(int i=1; i< arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
       for(int i = 0; i< arr.length; i++){
        int start = i;
        for(int j = 0; j < arr.length; j++){
            int end = j;
            currsum = start == 0 ? prefix[end] : prefix[end] -prefix[start-1];
            if(maxsum < currsum){
                maxsum = currsum;
            }
        }
       }
       System.out.println(maxsum);
    }

    //Kadan's Algorithm to calculate maximum in subarray
    public static void kadans(int arr[]){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            currentSum += arr[i];
            if(currentSum < 0) {
                currentSum = 0;   
            }
            if(currentSum > maxSum){
                maxSum = currentSum ;
            }
        }
        System.out.println("Max sum is "+ maxSum);
    }

    //Trapping rainwater
    public static int trappingwater(int height[]){
        int trappedwater = 0;
        //left arr
        int leftarr[] = new int[height.length];
        leftarr[0] = height[0];

        for(int i=1; i<height.length; i++){
            leftarr[i] = Math.max(height[i], leftarr[i-1]);
        }

        //right arr
        int rightarr[] = new int[height.length];
        rightarr[height.length-1] = height[height.length-1];
        for(int i = height.length-2 ; i>=0; i--){
            rightarr[i] = Math.max(height[i], rightarr[i+1]);
        }

        //loop for trapped water
        for(int i = 0; i< height.length; i++){
            int waterlevel = Math.min(rightarr[i], leftarr[i]);
             trappedwater += waterlevel - height[i];
        }
        return trappedwater;
    }

    //Best time to buy and sell the share    O(n)
    public static void shares(int arr[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int currentProfit = 0;
        for(int i = 0; i < arr.length; i++){     
            if( arr[i] > buyPrice){
                currentProfit = arr[i] - buyPrice;
                if(currentProfit > maxProfit){
                    maxProfit = Math.max(maxProfit, currentProfit);
                }
            } else{
                buyPrice = arr[i];
            }
        }
        System.out.println(maxProfit);
    }
}

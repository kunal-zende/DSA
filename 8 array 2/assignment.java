public class assignment {
   
    public static void main(String args[]){
         // Given an integer array nums, return true if any value appears at least twice in the array, 
         // and return false if every element is distinct
        //  Solution
        // int arr[] = {1, 1, 3, 3, 4, 3, 2, 4, 2};
        // System.out.println(calDoublicate(arr));

        // There is an integer array nums sorted in ascending order (with distinct values).
        // Prior to being passed to your function, nums is possibly rotated at an unknown pivot 
        //  index k (1  <=  k  <  nums.length)  such  that  the  resulting  array  is [nums[k], 
        //  nums[k+1],   ...,   nums[n-1], nums[0],   nums[1],   ...,   nums[k-1]] (0-indexed).   
        //  For   example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
        //  Given the array nums after the possible rotation and an integer target, returnthe index
        //   oftarget if it is in nums, or -1   if it is not in nums.You must write an algorithm with
        //    O(log n) runtime complexity
        // solution
        // int arr[] = {0,1,2,4,5,6,7};
        // rotateArr(arr, 3, 3);

        // You  are  given  an  array prices where prices[i] is  the  price  of  a  given  stock  on 
        //  the ith day.Return the maximum profit you can achieve from this transaction. 
        //  If you cannot achieve any profit, return 0
        // Input:prices = [7, 1, 5, 3, 6,  4]   
        // Output:   5 
        int arr[] = {7, 6, 4,  3, 1};
        sharePrices(arr);


        // Given an integer array nums, return all the triplets [nums[i], nums[j],  nums[k]] 
        // such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.Notice that 
        // the solution set must not contain duplicate triplets
        int arr2[] = {-1, 0,  1, 2, -1, -4};
        triplet(arr2);
    }
    // question 1
    public static boolean calDoublicate(int arr[]){
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    //question 2
    public static void rotateArr(int arr[],int pivotIndex, int target){
        int arr2[] = new int[arr.length];
        int index = 0;
        int lastindex = 0;
        for(int i = pivotIndex; i < arr.length; i++){
            // for(int j = 0; j <=  arr.length - pivotIndex ; j++){
            //     arr2[j] = arr[i];
            // }
            arr2[index] = arr[i];
            index++;
            lastindex = index;
        }
        for(int i = 0; i < pivotIndex; i++){
            arr2[lastindex] = arr[i];
            lastindex++;
        }
        //finding target element
        index = -1;;
        for(int i = 0; i < arr2.length; i++){
            if(arr2[i] == target){
                index = i;
            }
        }
        System.out.println("Index is : "+ index);
        for(int  i = 0; i < arr2.length; i++){
            System.out.print(arr2[i] + " ");
        }
    }

    // question 3
    public static void sharePrices(int currentPrice[]){
        int MaxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for(int i = 0; i < currentPrice.length; i++){
            if(currentPrice[i] < buyPrice){
                buyPrice = currentPrice[i];
            } else{
                int profit =  currentPrice[i] - buyPrice;
                if(profit > MaxProfit){
                    MaxProfit = profit;
                }
            }
        }
        System.out.println("Maximum profit is : "+MaxProfit);
    }

    public static void triplet(int arr[]){
        for(int i = 0; i < arr.length ; i++){
            for(int j = i+1; j < arr.length; j++){
                for(int k = j+1; k < arr.length ; k++){
                    if( ((arr[i] + arr[j] + arr[k]) == 0) && i != j && j != k && i != k){
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
    }
}

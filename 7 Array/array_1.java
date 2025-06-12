import java.util.*;

public class array_1 {

    public static void main(String args[]){
        System.out.println("Hello world");
        
        //creating array
        // int arr1[] = new int[4]; //array with name arr1 size is 4
        // int arr2[] = {1,2,3};    // array with name arr2 stores value 1,2,3
        // String fruits[] = {"Apple", "mango","Banana"};
    
        //Taking input in array and changing values 
        // Scanner sc = new Scanner(System.in);
        
        // int marks[] = new int[20];
        // marks[0] = sc.nextInt();
        // marks[1] = sc.nextInt();
        // marks[2] = sc.nextInt();

        // System.out.println("Maths : "+ marks[0]);
        // System.out.println("phy : "+ marks[1]);
        // System.out.println("chem : "+ marks[2]);

        // int percent = (marks[0] + marks[1] + marks[2])/3;
        // System.out.println(percent);

        // //updating values  
        // marks[0] = 100;
        // System.out.println(marks[0]);

        // //array length
        // System.out.println(marks.length);


        // //passing array as Arguments
        // int score[] = {6, 7,8};
        // update(score);    //array is passed as call by refrence so once its value 
        //                   //is change in any function it will also change in main function  
        // //printing updated array
        // for(int i = 0; i<score.length; i++){
        //     System.out.println(score[i]);
        // }


        // //linear search
        // int num[] = {1,2,3,4};
        // int key = 5;
        // System.out.println(linearSearch(num, key));

        // //Leargest of array
        // int num[] = {1, 2,3,4,5,7,3,5};
        // System.out.println(Largest(num));

        // //Binary Search
        // int num[] = {1,2,3,4,5,6,7,8};
        // int key = 7;
        // System.out.println(Binary(num,key));

       //Reverse array with swapping(not using another array)
        // int arr[] = {1, 2, 3, 4, 5};
        // Reverse(arr);

        //Pairs in array
        // int arr[] = {1, 2, 3, 4, 5};
        // pairs(arr);

        // subarray
        int arr[] = {1,2, 3, 4, 5, 6};
        subarr(arr); 
    }


    public static void update(int arr[]){
        for(int i = 0; i <arr.length; i++){
            arr[i] = arr[i] + 2;  //updating each value(i.e adding 2 in each value)
        }
    }

    //linear search
    public static int linearSearch(int num[], int key){
        for(int i = 0; i < num.length; i++){
            if(num[i]==key){
                return  i;            
            }
        }
        return -1;
    }

    //Largest nummber
    public static int Largest(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    //Binary Search
    public static int Binary(int arr[], int key){
         int start = 0;
         int end = arr.length - 1;

         while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid]== key){
                return mid;
            }
            if(arr[mid] < key){
                start = mid +1;
            } else{
                end = mid - 1;
            }
         }
         return -1;
    }

    //Reverse array
    public static void Reverse(int arr[]){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int num = arr[start];
            arr[start] = arr[end];
            arr[end] = num;
            start++;
            end--;
        }
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    //Pairs in array
    public static void pairs(int arr[]){
        int i = 0;
        while(i<arr.length){
            for(int j= i+1; j < arr.length; j++){
                System.out.println(arr[i]+","+arr[j]);
            }
            i++;
        }
    }

    //Sub-arrays & total numbers of subarray & min and max sum
    public static void subarr(int arr[]){
        int maxsum = Integer.MIN_VALUE;
        int minsum = Integer.MAX_VALUE;
        int sum = 0;
        int total = 0;
        for(int i=0; i < arr.length; i++){
            int start = i;
            for(int j = i; j < arr.length; j++){
                int end = j;
                for(int k = start; k <= end ; k++){
                    System.out.print(arr[k]+" ");
                    sum = sum + arr[k];
                    if(sum > maxsum){
                        maxsum = sum;
                    } else if(sum < minsum){
                        minsum = sum;
                    }
                }
                System.out.print(":"+"sum = "+sum);
                System.out.println();
                total++;
                sum = 0;
            }
            System.out.println();
        }
        System.out.println("Total numbers of subarray "+ total);
        System.out.println("Maximum sum of subarray : "+maxsum);
        System.out.println("Minimum sum of subarray : "+minsum);
    }
}

import java.util.Arrays; // inbuild sorting
import java.util.Collections; //descnding the array

public class sorting {
    public static void main(String args[]){
        int arr[] = {4, 5, 1, 2,4,5,2,4};
        Integer arr2[] = {5, 7, 1, 4};
        // bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        // Arrays.sort(arr);  // inbuild sorting
        // Arrays.sort(arr2, Collections.reverseOrder());
        countingSort(arr);
        printArr(arr);
    }
    
    public static void bubbleSort(int arr[]){
        for(int turn = 0; turn < arr.length -1; turn++){
            for(int j=0; j < arr.length -1 -turn; j++){
                if(arr[j] > arr[j+1]){
                    //Swapping array
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

     //Printing sorted array 
     public static void printArr(int arr[]){   
        for(int i = 0; i<arr.length; i++){
         System.out.print(arr[i] + " ");
     }
    }

    public static void selectionSort(int arr[]){
        for(int i = 0; i < arr.length - 1; i++){
            int miniPos = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[miniPos] > arr[j]){
                    miniPos = j;
                }
            }
            //swap 
            int temp = arr[i];
            arr[i] = arr[miniPos];
            arr[miniPos] = temp;
        }
    }

    public static void insertionSort(int arr[]){
        for(int i = 1; i < arr.length; i++){
            int curr = arr[i];
            int prev = i - 1;
            //Finding where to insert current 
            while(prev >= 0 && arr[prev] > curr){
                arr[prev + 1] = arr[prev];
                prev--;
            }
            //Inserting the current to it's right position
            arr[prev+1] = curr;
        }
    }

    public static void countingSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        //finding largest element in array
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > largest){
               largest = arr[i];
            }
        }

        //storing element in counting array depending on it's value
        //crating counting array whose size is maximum number
        int counting[] = new int[largest + 1];  //+1 bcz to store "0" also
        for(int i = 0; i < arr.length; i++){
            counting[arr[i]]++;
        }

        //sorting & storing in main array 
        int j=0;
       for(int i = 0; i < counting.length; i++){
        while(counting[i] > 0){
            arr[j] = i;
            j++;
            counting[i]--;
        }
       }
    }
}

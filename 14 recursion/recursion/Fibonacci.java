public class Fibonacci {
    public static void main(String args[]){
        // System.out.println(fibo(6));
        int arr[] = {1,2,3,5,4};
        // System.out.println(IsSorted(arr,0));
        // System.out.println(firstOccurance(arr, 5, 0));
    }
    public static int fibo(int n){
        if(n==1 || n == 0){
            return n;
        }
        int f1 = fibo(n-1);
        int f2 = fibo(n-2);
        return f1+f2;
    }

    //Sorted array
    public static boolean IsSorted(int arr[],int i){
        if(i == arr.length -1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return IsSorted(arr, i+1);
    }
    //First occurance in array
    public static int firstOccurance(int arr[],int key, int i){
        if(arr[i] == key){
            return i;
        }
        if(i == arr.length){
            return -1;
        }
        return firstOccurance(arr, key, i+1);
    }
}


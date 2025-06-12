public class back{
    public static void backtraking(int arr[],int i,int val){
        if(i == arr.length){
            printArr(arr);
            return;
        }
        arr[i] = val;
        backtraking(arr, i+1, val+1);
        arr[i] = arr[i] - 2; //Backtracking is done after recursion function call is done
    }

    public static void printArr(int arr[]) {
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[]){
        int arr[] = new int[5];
        backtraking(arr, 0, 1);
        System.out.println();
        printArr(arr);
    }
}
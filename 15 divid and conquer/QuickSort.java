public class QuickSort{
    public static void main(String args[]){
        int arr[] = {4,2,1,5,4};
        quicks(arr, 0, arr.length-1);

        //print Array
        for(int i = 0 ; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void quicks(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int pivitIndex = partision(arr,si,ei);  // return pivot index
        quicks(arr, si, pivitIndex-1);   //sort left side of pivit
        quicks(arr, pivitIndex+1,ei );   //sort right side of pivit
    }
    public static int partision(int arr[],int si, int ei) {
       int pivot = arr[ei];
       int i = si-1; //to make places for elements smaller than pivot

       for(int j = si; j < ei; j++){
        if(arr[j] < pivot){
        //swap
            i++;
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
       }
       //Changing the position of pivot
       i++;
       int temp = pivot;
       arr[ei] = arr[i];
       arr[i] = temp;
       return i; //the pivot index
    }
}
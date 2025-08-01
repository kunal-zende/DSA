public class SortedHeap {
    public static void heapSort(int arr[]){  // O(nlogn)
        int n = arr.length;

        //step-1 build max heap
        for(int i = n/2; i >= 0; i--){ //we don't need to check child node of leaf 
            heapify(arr,i,n);         // so we start from n/2 in array that leavs leaf node's chlid node 
        }

        //Now swap the largest at end and create max heap, excluding the largest
        for( int i = n-1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr,0,i);
        }
    }

    public static void heapify(int arr[], int i, int size){ //(logn)
        int left = 2*i+1;
        int right = 2*i + 2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }
        if(maxIdx != i){
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 3};
        heapSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}

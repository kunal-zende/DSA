public class mergeSort{
    public static void main(String args[]){
        int arr[] = {5,4,2,6};
        mergesort(arr, 0, arr.length-1);

        //print array
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void mergesort(int arr[],int si,int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei-si)/2;
        mergesort(arr, si, mid);  //left sorting
        mergesort(arr, mid+1, ei); //right sorting
        merge(arr, si, mid, ei);   // merge array
    }

    public static void merge(int arr[],int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            } else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while( i <= mid){
            temp[k++] = arr[i++];
        }
        while( j <= ei){
            temp[k++] = arr[j++];  //increament after placing value
        }

        //copy temp to original array
        for(int n = 0, x = si; n < temp.length; n++,x++){
            arr[x] = temp[n];
        }
         }
}
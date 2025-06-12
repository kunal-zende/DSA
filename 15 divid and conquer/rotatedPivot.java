public class rotatedPivot {
    public static void main(String args[]){
        int arr[] = {4,5,6,7,0,1,2};
        int taget = 0;
        int tarIdx = targetIndex(arr, taget, 0, arr.length-1);
        System.out.println(tarIdx);
    }

    public static int targetIndex(int arr[], int target, int si, int ei){
        if(si > ei){
            return -1;
        }
        int mid = si + (ei - si)/2;

        if(arr[mid]== target){
            return mid;
        }

        //If mid lies on first line
        if(arr[si] <= arr[mid]){
            //case a: if taget is on left side
            if(arr[si] <= target && target <= arr[ei]){
            return targetIndex(arr, target, si, mid-1);
            } else{
             //case b: if target is on right side
            return targetIndex(arr, target, mid+1, ei);
            }
           
        }
        //mid lies on second line
        else{
            //case c : left side
            if(arr[mid] <= target && target <= arr[ei]){
            return  targetIndex(arr, target,mid+1 , ei);
        } else{
            return targetIndex(arr, target, si, mid-1);
        }
        }
        
    }
}

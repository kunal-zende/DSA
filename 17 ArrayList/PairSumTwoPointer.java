import java.util.ArrayList;

public class PairSumTwoPointer{
    public static boolean pairSum(ArrayList<Integer> list, int target){
        int right = list.size()-1;
        int left = 0;
        while(left != right){
            if(list.get(left)+list.get(right) == target){
                return true;
            } else if(list.get(left)+list.get(right) < target){
                //if value < target then in sorted array we have to increase sum by adding bigger element
                left++;
            }else{
                //if value > target then in sorted array we decrease sum by taking small value
                right--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 5;

        System.out.println(pairSum(list, target));
    }
}
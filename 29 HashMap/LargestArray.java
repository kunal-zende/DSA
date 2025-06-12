import java.util.HashMap;

public class LargestArray {
    public static void main(String[] args) {
        int arr[] = {15, 2, -2, -8, 1, 7, 10, 23};

        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int length = 0;

        for(int j = 0; j < arr.length; j++){
            sum+= arr[j];

            if(map.containsKey(sum)){
                length = Math.max(length, j - map.get(sum)); // j - map.get(sum) -> like (index j - i)
            } else {
                map.put(sum, j);
            }
        }

        System.out.println("max sub array length "+ length);
    }
}

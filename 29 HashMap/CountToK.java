import java.util.HashMap;

public class CountToK{
    public static void main(String[] args) {
        int arr[] = {10,2,-2,-20,10};
        int k = -10; //check how many subarray have sum -10

        HashMap<Integer,Integer> map = new HashMap<>();

        int sum = 0;
        int ans = 0;

        map.put(0,1); //Add 0 as when subarray sum = k then subtracting from it will give 0
        for(int j = 0; j < arr.length; j++){
            sum+=arr[j];
            int sub = sum - k; // sum[i]
            if(map.containsKey(sub)){
                ans += map.get(sub);
            }
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }
}
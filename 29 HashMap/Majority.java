import java.util.HashMap;
import java.util.Set;

public class Majority {
    public static void main(String args[]){
        int arr[] = {1,3,2,5,1,3,1,5,1};

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            // if(map.containsKey(arr[i])){
            //     map.put(arr[i],map.get(arr[i])+1); 
            // } else {
            //     map.put(arr[i], 1);
            // }
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1); //getOrDefault gives value if 
        }                                                        //key exists else give default value set by us

        // Set<Integer> sets = map.keySet();
        for(Integer key: map.keySet()){
            if(map.get(key) > arr.length/3){
                System.out.println(key);
            }
        }
    }
}

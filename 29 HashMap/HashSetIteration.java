import java.util.HashSet;
import java.util.Iterator;

public class HashSetIteration {
    public static void main(String[] args) {
        // HashSet<String> cities = new HashSet<>();

        // cities.add("Pune");
        // cities.add("Mumbai");
        // cities.add("Delhi");


        // for(String city:cities){
        //     System.out.println(city);
        // }

        //Distinct element O(N)
        int arr[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }

        System.out.println(set.size()); //as set only store unique value
    }
}

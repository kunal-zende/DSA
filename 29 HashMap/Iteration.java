import java.util.HashMap;
import java.util.Set;

public class Iteration {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("US", 20);
        hm.put("Australia", 100);

        //We use Set to store all values and then iterate on it
        Set<String> keys = hm.keySet(); //type string is the type of keys

        System.out.println(keys);

        for(String k : keys){
            System.out.println("Key="+ k + " value = "+hm.get(k));
        }

        System.out.println(hm.entrySet());
        // o/p [Australia=100, US=20, India=100]
    }
}
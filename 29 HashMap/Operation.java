import java.util.HashMap;

public class Operation {
public static void main(String[] args) {
    HashMap<String,Integer> hm = new HashMap<>();

    hm.put("India", 100);
    hm.put("US", 20);
    hm.put("Australia", 100);

    System.out.println(hm);

    //get
    int population = hm.get("India");
    System.out.println(population);

    //contain or not
    System.out.println(hm.containsKey("India"));

    // remove
    System.out.println(hm.remove("US"));

    //clear
    hm.clear();

    //size
    System.out.println(hm.size());

    //empty
    System.out.println(hm.isEmpty());
}    
}

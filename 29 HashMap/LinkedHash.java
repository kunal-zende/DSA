import java.util.LinkedHashMap;
public class LinkedHash {
    public static void main(String args[]){
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 100);
        lhm.put("USA", 50);
        lhm.put("Dubai", 12);

        System.out.println(lhm);
    }
}

import java.util.TreeMap;

public class Treemap {
    public static void main(String args[]){
        TreeMap<String,Integer> tm = new TreeMap<>();

        tm.put("India", 100);
        tm.put("USA", 50);
        tm.put("Dubai", 12);

        System.out.println(tm); 
}
}
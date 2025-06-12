import java.util.HashMap;

public class Journey {

    public static String getStarting(HashMap<String,String> map) {
        //Now create reverse map
        HashMap<String,String> revMap = new HashMap<>();

        for(String key: map.keySet()){
            revMap.put(map.get(key),key); // to -> from
        }

        //Now check the keys which does not exists in revMap, so we will get city where
        // we can't reach as we don't have ticket to reach at location but we have ticket 
        //from that location

        for(String key : map.keySet()){
            if(!revMap.containsKey(key)){  //we got val
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>(); //from -> to
        map.put("Chennai","Bengaluru");
        map.put("Mumbai","Delhi");
        map.put("Goa","Chennai");
        map.put("Delhi","Goa");

        String start = getStarting(map);

        System.out.print(start);
        
        for(String key:map.keySet()){
            System.out.print("->"+map.get(start));
            start = map.get(start);
        }
    }
}

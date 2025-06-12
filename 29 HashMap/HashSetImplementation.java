import java.util.HashSet;

public class HashSetImplementation {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(1);
        hs.add(2);
        hs.add(3);

        System.out.println(hs);

        if(hs.contains(2)){
            System.out.println("contain 2");
        }

        boolean remove = hs.remove(2);
        System.out.println(remove);
    }
}

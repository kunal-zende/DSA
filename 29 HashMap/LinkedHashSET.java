import java.util.LinkedHashSet;

public class LinkedHashSET {
    public static void main(String[] args) {
        LinkedHashSet<String> cities = new LinkedHashSet<>();

        cities.add("Pune");
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Kolhapur");

        System.out.println(cities);

        cities.remove("Pune");
        System.out.println(cities);

    }
}

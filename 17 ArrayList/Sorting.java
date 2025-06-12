import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(0);

        System.out.println(list);

        //Sorting using Collections class, it need to import
        Collections.sort(list);

        System.out.println(list);

        //Sorting in reverse orderS
        Collections.sort(list, Collections.reverseOrder());
        //reverseOrder() is comparator  ,
        //Comparators are function that define the logic in java

        System.out.println(list);
    }
}

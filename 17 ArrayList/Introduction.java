import java.util.ArrayList; //import ArrayList

public class Introduction{
    public static void main(String args[]){
        //use classes Float | Boolean | String | Integer insted of primitive data types int,char 
        ArrayList<Integer> list = new ArrayList<>();

        //Add operation
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        // list.add(1,10); // add 10 at index 1 add all othher element will shifted back 
        // System.out.println(list);

        //Get element from index
        int element = list.get(2);
        System.out.println(element);

        //Remove element
        // list.remove(2);
        // System.out.println(list);

        //set element i.e. replace element
        list.set(2,12);
        System.out.println(list);

        //Contains
        System.out.println(list.contains(2));
        System.out.println(list.contains(6));

        //.size for length
        System.out.println(list.size());

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+" ");
        }

        for(int i = list.size()-1; i >=0; i--){
            System.out.print(list.get(i)+" ");
        }
    }
}
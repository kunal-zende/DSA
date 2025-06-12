import java.util.LinkedList;

public class collectionFramework{
    public static void main(String args[]){
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addFirst(1);
        ll.addLast(2);
        ll.add(0,0);
        System.out.println(ll);

        ll.remove(1);  //give the index 
        System.out.println(ll);
        
        ll.removeFirst();
        System.out.println(ll);

        ll.removeLast();
        System.out.println(ll);

    }
}
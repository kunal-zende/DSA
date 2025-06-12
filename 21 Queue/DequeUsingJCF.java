import java.util.*;

public class DequeUsingJCF {
    public static void main(String args[]){
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        System.out.println(deque);

        deque.removeFirst();
        System.out.println(deque);

        deque.removeLast();
        System.out.println(deque);

        System.out.println("1st el = "+ deque.getFirst());
        System.out.println("last el = "+ deque.getLast());
    }
}

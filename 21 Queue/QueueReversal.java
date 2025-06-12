import java.util.*;

public class QueueReversal {
    public static void reverseOrder(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
            }
            
            while(!s.isEmpty()){
                q.add(s.pop());
            }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q);
        reverseOrder(q);
        System.out.println(q);
    }
}

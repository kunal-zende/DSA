import java.util.*;

public class QueueUsingDeque {
    static class Queue{
         Deque<Integer> deque = new LinkedList<>();

        public  void add(int data){
            deque.addLast(data);
        }

        public  int remove(){
            if(deque.isEmpty()){
                return -1;
            }
            return deque.removeFirst();
        }

        public  int peek(){
            if(deque.isEmpty()){
                return -1;
            }
            return deque.getFirst();
        }
    }

    public static void main(String args[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("Peek is " + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}

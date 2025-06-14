import java.util.*;

public class TwoStack {
    public static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        //Empty
        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //Add 
        public static void add(int data){
            if(isEmpty()){
                s1.push(data);
                return;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        //Remove
        public static int remove(){
            if(isEmpty()){
                return -1;
            }
            return s1.pop();
        }

        //peek
        //Remove
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}

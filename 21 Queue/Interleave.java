import java.util.*;

public class Interleave{
    public static void ChangeInterleave(Queue<Integer> q){
        int size = q.size();
        Queue<Integer> FirstHalf = new LinkedList<>();  
        for(int i = 0; i < size/2 ; i++){ 
            FirstHalf.add(q.remove());     // Store first half elements of q
        }
        while(!FirstHalf.isEmpty()){
            q.add(FirstHalf.remove()); // front element of FirstHalf
            q.add(q.remove());  // front element of q
        }
    }
    public static void main(String args[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        System.out.println(q);
        ChangeInterleave(q);
        System.out.println(q);
    }
}

import java.util.PriorityQueue;

public class ObjectInPQ {
   static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank; //this give ascenting oerder
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("A" , 4)); //O(logn)
        pq.add(new Student("B" , 5)); //O(logn)
        pq.add(new Student("C" , 2)); //O(logn)
        pq.add(new Student("D" , 7)); //O(logn)

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+ "->"+ pq.peek().rank); // O(1)
            pq.remove(); //O(1)
        }
    }
}

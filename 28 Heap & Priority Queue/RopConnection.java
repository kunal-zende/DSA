import java.util.PriorityQueue;

public class RopConnection {
    public static void main(String[] args) {
        int arr[] = {4,3,2,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //add element in pq
        for(int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }

        int cost = 0;
        //connect rope until sigle rope form
        while(pq.size() > 1){
            int min1 = pq.remove();
            int min2 = pq.remove();

            cost+= min1 + min2;
            pq.add(min1+min2); //join rope put back so to join with other
        }

        System.out.println("Minimum Cost "+ cost);
    }
}

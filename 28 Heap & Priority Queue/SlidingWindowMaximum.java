import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    static class Pair  implements Comparable<Pair>{
    int val;
    int idx;

    public Pair(int val, int idx){
        this.idx = idx;
        this.val = val;
    }
    @Override
    public int compareTo(Pair p2){
        return p2.val - this.val; // retuen in descending order
    }
}  
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int res[] = new int[arr.length-k+1];// this will store maximum of each window

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //for first window add window element and take maximum from pq
        for(int i = 0; i < k; i++){
            pq.add(new Pair(arr[i],i)); 
        }

        res[0] = pq.peek().val; //add maximum from first window

        //now for entire remaining window
        for(int i = k; i < arr.length; i++){ 
            while(pq.size() > 0 && pq.peek().idx <= i-k){ //if element at max is not part of 
                pq.remove(); //current window then remove it from pq
            }
            
            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;     
        }

        //print
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i]+ " ");
        }
    }

}

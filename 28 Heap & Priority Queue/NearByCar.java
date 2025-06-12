import java.util.PriorityQueue;

public class NearByCar {
    static class Point implements Comparable<Point> {
    int x;
    int y;
    int dist;
    int idx;
    public  Point(int x, int y, int dist, int idx){
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.idx = idx;
    }
    @Override
    public int compareTo(Point p2){
        return this.dist - p2.dist; //arrange in ascending order
    }    
}
    public static void main(String[] args) {
        int arr[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            int dist = arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1];
            pq.add(new Point(arr[i][0],arr[i][1],dist, i));
        }

        for(int i = 1; i <= k; i++){
            System.out.println("C" + pq.remove().idx);
        }
    }   
}

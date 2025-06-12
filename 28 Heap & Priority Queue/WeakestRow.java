import java.util.PriorityQueue;

public class WeakestRow {
    static class RowData implements Comparable<RowData>{
        int solider;
        int idx;

        public RowData(int solider,int idx){
            this.solider = solider;
            this.idx = idx;
        }

        @Override
        public int compareTo(RowData r2){
            if(this.solider == r2.solider){ //if solider value equal then compare in bais of index
                return this.idx - r2.idx;
            } else {
                return this.solider - r2.solider;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};

        int k = 2;
    PriorityQueue<RowData> pq = new PriorityQueue<>();
    for(int i = 0; i < army.length; i++){
        int solider = 0;
        for(int j = 0; j < army[0].length; j++){
            if(army[i][j] == 1){
                solider++;
            }
        }
        pq.add(new RowData(solider, i));
    }

    //Now the k weakest row are
    for(int i=0; i<k;i++){
        System.out.println("R"+pq.remove().idx);
    }
     }
}

import java.util.*;

public class DisjoinSet {
    static int n = 7;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

   public static void init(){
    for(int i = 0; i < parent.length; i++){
        parent[i] = i; // initially each element is parent of itself
    }
   }

    public static int find(int x){
        if(parent[x] == x){ //the parent is who has it's value as parent in parent array
            return x; 
        }

        // return find(parent[x]); // we will make recursive call until we get the parent of whole group 
        return parent[x] = find(parent[x]); //path compression, i.e instead of call find fun lots of time
    }   //once we call find fun store , group leader value directly to redume multiple calling and we
    // can get our parent in 1-2 calls
    public static void union(int A, int B){
        int parA = find(A);
        int parB = find(B);

        if(rank[parA] == rank[parB]){
            parent[parB] = parA; //A become Parent of B
            rank[parA]++;
        } else if(rank[parB] > rank[parA]){
            parent[parA] = parB;
        } else{
            parent[parB] = parA;
        }
    }
    public static void main(String args[]){
        init();
        System.out.println(find(3));
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);
        System.out.println(find(5));
    }
}

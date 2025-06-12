import java.util.*;

public class MSTPrims {
    static class Edge{
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(0, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 3, 40));
        graph[3].add(new Edge(3, 1, 50));
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost; //return ascending order
        }
    }
    //Prim's algorithm
    public static void prims(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0,0)); //add source and cost to reach there
        int finalCost = 0; // this is MST

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.node]){ //if node is not visitedd then only perform this
                visited[curr.node] = true;
                finalCost+= curr.cost;  

                for(int i = 0; i < graph[curr.node].size(); i++){ //take all neighbour
                    Edge e = graph[curr.node].get(i);
                    pq.add(new Pair(e.destination,e.weight));
                }
            }
        }
        System.out.println("Final(min) cost of MST "+ finalCost);
    }

    public static void main(String[] args) {
        int v= 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        prims(graph);
    }
}

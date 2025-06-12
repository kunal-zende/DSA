import java.util.*;

public class Dijkstras {
static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int s, int d, int w) {
            this.source = s;
            this.destination = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // First assign value so null will remove in array list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        //0-vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
    
        // 2-vertex
        graph[2].add(new Edge(2, 4, 3));

        // 3-vertex
        graph[3].add(new Edge(3, 5, 1));
   
        // 4-vertex
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    //pair of node and it's disttance for priority queue
    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.path - this.path; //it will sort and give lowest path first
        }
    }

    //Dijkstra's algorithm
    public static void dijk(ArrayList<Edge> graph[],int src){
        int distance[] = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(i != src){
                distance[i] = Integer.MAX_VALUE;//store infinity for all distance,except source
            }
        }

        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0)); //add souce, the distance from source to source is 0

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.n]){ //If node is not visited then only perform this fun
                for(int i = 0; i < graph[curr.n].size();i++){ //neighbour
                    Edge e = graph[curr.n].get(i);
                    int  u = e.source;
                    int v = e.destination;
                    int wt = e.weight;

                    if(distance[u] + wt < distance[v]){ //update distance from src to v
                        distance[v] = distance[u] + wt;
                        pq.add(new Pair(v, distance[v]));
                    }
                }
            }
        }
        for(int i = 0; i < distance.length; i++){
            System.out.print(distance[i] + " ");
        }
    }
    public static void main(String[] args) {
        int vertex = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertex]; // created array of arraylist, arraylist of eddes
        createGraph(graph);
        dijk(graph, 0);
    }
}

import java.util.*;

public class BellmanFord {
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

        graph[1].add(new Edge(1, 2, -4));
    
        // 2-vertex
        graph[2].add(new Edge(2, 3, 2));

        // 3-vertex
        graph[3].add(new Edge(3, 4, 4));
   
        // 4-vertex
        graph[4].add(new Edge(4, 1, -1));
    }

   public static void bellman(ArrayList<Edge> graph[], int src){
    int distance[] = new int[graph.length]; //Store distance from source
    for(int i = 0; i < distance.length; i++){
        if(i != src){
        distance[i] = Integer.MAX_VALUE; //store infinity
        }
    }

    int V = graph.length;
    //algorithm -> we have to use it for V-1 times O(V*E)
    for(int i = 0; i < V-1; i++){
        //find all edges O(E) and not O(N^2)
        for(int j = 0; j < graph.length; j++){
            for(int k = 0; k < graph[j].size(); k++){
                Edge e = graph[j].get(k);
                int u = e.source;
                int v = e.destination;
                int wt = e.weight;
                //relaxation
                if(distance[u] != Integer.MAX_VALUE && distance[u]+ wt < distance[v]){
                    distance[v] = distance[u] + wt;
                }
            }
        }
    }

    for(int i = 0; i < distance.length;i++){
        System.out.print(distance[i] + " ");
    }

   }
    public static void main(String[] args) {
        int vertex = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertex]; // created array of arraylist, arraylist of eddes
        createGraph(graph);
        bellman(graph, 0);
    }
}

import java.util.*;

public class BridgeInGraph {
    static class Edge {
        int source;
        int destination;

        public Edge(int s, int d) {
            this.source = s;
            this.destination = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // First assign value so null will remove in array list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        //0-vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
    
        // 2-vertex
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // 3-vertex
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));
   
        // 4-vertex
        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int parent, int discoveryTime[], 
    int lowestDisTime[],boolean visited[], int time){
        visited[curr] = true;
        discoveryTime[curr] = lowestDisTime[curr] = ++time;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            int neighbour = e.destination;
            if(neighbour == parent){
                continue; // don't do anything
            } else if(!visited[neighbour]){
                dfs(graph, neighbour, curr, discoveryTime, lowestDisTime, visited, time);
                lowestDisTime[curr] = Math.min(lowestDisTime[curr],lowestDisTime[neighbour]);
                if(discoveryTime[curr] < lowestDisTime[neighbour]){
                    System.out.println("Bridge "+ curr + "----" + neighbour);
                }
            } else{
                lowestDisTime[curr] = Math.min(lowestDisTime[curr], discoveryTime[neighbour]);
            }
        }
    }

    public static void tarjanBridgeFinding(ArrayList<Edge> graph[], int V){
        int discoveryTime[] = new int[V];
        int lowestDisTime[] = new int[V];
        int time = 0; 
        boolean visited[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(graph, i, -1, discoveryTime, lowestDisTime, visited, time);
            }
        }
     }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        tarjanBridgeFinding(graph, V);
    }
}

import java.util.*;
import java.util.LinkedList;

public class DFS {
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
        // 0- vertex
        graph[0].add(new Edge(0, 1, 1)); // from 0 -> 1 with weight 5
        graph[0].add(new Edge(0, 2, 1));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2-vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3-vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4-vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5-vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6-vertex
        graph[6].add(new Edge(6, 5, 1));
    }

    // DFS
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        // first print the current element
        System.out.print(curr + " ");
        visited[curr] = true;
        
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.destination]) {
                dfs(graph, e.destination, visited);
            }
        }
    }

    public static void main(String[] args) {
        int vertex = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertex]; // created array of arraylist, arraylist of eddes
        createGraph(graph);
        dfs(graph,0,new boolean[vertex]);
    }
}

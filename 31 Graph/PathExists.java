import java.util.*;

public class PathExists {
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


        // 2-vertex
        graph[2].add(new Edge(2, 3, 1));

        // 3-vertex
        graph[3].add(new Edge(3, 1, 1));
   

        // 4-vertex
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        // 5-vertex
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

    }

    //Find Topological order
    public static void topologicalSort(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                topologicalSortUtil(graph, i, visited,s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
    
    public static void topologicalSortUtil(ArrayList<Edge> graph[],int curr, boolean visited[],Stack<Integer> s){
    visited[curr] = true;
    for(int i = 0; i < graph[curr].size(); i++){
        Edge e = graph[curr].get(i);
        if(!visited[e.destination]){
            topologicalSortUtil(graph, e.destination, visited, s);
        }
    }
    s.push(curr);
}
    public static void main(String[] args) {
        int vertex = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertex]; // created array of arraylist, arraylist of eddes
        createGraph(graph);
        topologicalSort(graph);
    }
}

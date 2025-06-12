import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponent {
    static class Edge { // we don't need to store source as we can get it from array
        int source;
        int destination;
  

        public Edge(int s,int d) {
            this.source = s;
            this.destination = d;
        }
    }

 public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    //topological sort
    public static void topSort(ArrayList<Edge> graph[],int curr, boolean visited[],Stack<Integer> s){
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!visited[e.destination]) {
                topSort(graph, e.destination, visited, s);
            }
        }
        s.push(curr);
    }

    //dfs
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean visited[]){
        visited[curr] = true;
        System.out.print(curr+ " ");

        for(int i = 0; i < graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.destination]){
                dfs(graph, e.destination, visited);
            }
        }
    }
    //Kosraju algorithm
    public static void kosaraju(ArrayList<Edge> graph[],int V){
        //step 1 - topological sort
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[V]; // V - no. of vertex
        for(int i = 0; i < V; i++){
           if(!visited[i]){
            topSort(graph, i, visited, s);
           }
        }

        //Step-2 transpose of graph
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i = 0; i < graph.length; i++){
            transpose[i] = new ArrayList<Edge>();
            visited[i] = false; // to reuse visit
        }

        for(int i = 0; i < V; i++){
            for(int j = 0; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transpose[e.destination].add(new Edge(e.destination, e.source)); //reverse edge
            }
        }

        //step 3 dfs
        while (!s.isEmpty()) {
            int curr = s.pop();
            if(!visited[curr]){
                System.out.print("SCC->");
                dfs(transpose,curr,visited);
                System.out.println();
            }
        }
    } 
    
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}

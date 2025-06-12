import java.util.*;

public class CycleDetectionInDirect {


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
        graph[0].add(new Edge(0, 2, 1));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));

        // 2-vertex
        graph[2].add(new Edge(2, 3, 1)); 

        // 3-vertex
        graph[3].add(new Edge(3, 0, 1));
    }

    public static boolean isCyclic(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                if(isCyclicUtil(graph, i, visited, stack)){
                    return true;
                }
            }
        }
        return false;
    } 
    
    public static boolean isCyclicUtil(ArrayList<Edge> graph[], int curr, boolean visited[], boolean stack[]){
        visited[curr] = true;
        stack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.destination]){ //cycle exists
                return true;
            }
            if(!visited[e.destination] && isCyclicUtil(graph, e.destination, visited, stack)){
                return true;
            }
        }
        stack[curr] = false; //from this node no cycle exists so remove this neighbour
        return false;
    }

    public static void main(String[] args) {
        int vertex = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertex]; // created array of arraylist, arraylist of eddes
        createGraph(graph);
        System.out.println(isCyclic(graph));
    }
}


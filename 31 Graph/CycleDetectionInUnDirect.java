import java.util.*;

public class CycleDetectionInUnDirect {

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
        graph[0].add(new Edge(0, 3, 1));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // 2-vertex
        graph[2].add(new Edge(2, 0, 1)); 
        graph[2].add(new Edge(2, 1, 1));

        // 3-vertex
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        // 4-vertex
        graph[4].add(new Edge(4, 3, 1));
    }

    //Cycle detection function
    public static boolean cycleDetect(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                if(cycleDetectUtil(graph,visited,i,-1)){ //-1 for initial parent
                    return true; 
                    // cycle exists in one of component of graph
                }
            }
        }
        return false;
    }

    public static boolean cycleDetectUtil(ArrayList<Edge> graph[], boolean visited[], int curr, int parent){
        visited[curr] = true;
        for(int i =0; i < graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.destination]){
                if(cycleDetectUtil(graph,visited,e.destination,curr)){
                    return true;
                }
            }
            else if(visited[e.destination] && e.destination != parent){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int vertex = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertex]; // created array of arraylist, arraylist of eddes
        createGraph(graph);
        System.out.println(cycleDetect(graph));
    }
}

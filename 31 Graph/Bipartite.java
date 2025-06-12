    import java.util.*;

public class Bipartite {


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

        // 4-vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
    }

    //Bipartite or not
    public static boolean bipartite(ArrayList<Edge> graph[]){
        int color[] = new int[graph.length]; //array of equal nodes
        for(int i =0; i< color.length; i++){
            color[i] = -1; //no-colour assign
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){ //BFS
                q.add(i);
                color[i] = 0; //yellow
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j = 0; j < graph[curr].size(); j++){
                        Edge e = graph[curr].get(j); //e.dest = neighbour
                        if(color[e.destination] == -1){
                            int nextColor = color[curr] == 0 ? 1: 0;
                            color[e.destination] = nextColor;
                            q.add(e.destination);
                        } else if(color[e.destination] == color[curr]){
                            return false; //Not bipartit
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int vertex = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertex]; // created array of arraylist, arraylist of eddes
        createGraph(graph);
        System.out.println(bipartite(graph));
    }
}

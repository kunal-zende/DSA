import java.util.*;

public class AllPossiblePath {
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
        graph[0].add(new Edge(0, 3, 1));


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

    public static void allPath(ArrayList<Edge> graph[], int src, int dest, String path){
        if(src == dest){
            System.out.println(path + dest); //dest bcz to add last node in path
        }

            for(int j = 0; j < graph[src].size(); j++){
                Edge e = graph[src].get(j);
                allPath(graph, e.destination, dest, path+src);
            }

    }
    
    public static void main(String[] args) {
        int vertex = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertex]; // created array of arraylist, arraylist of eddes
        createGraph(graph);
        allPath(graph, 5, 1, "");
    }
}

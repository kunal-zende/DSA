import java.util.*;

public class TopologicalSortByBFS {
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

    //Topological sort

    //Calculate indegree
    public static void calIndegree(ArrayList<Edge> graph[],int indegree[]){
        for(int i =0; i < graph.length; i++){
            for(int j = 0; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indegree[e.destination]++; //calculate neighbour and increase their indrgee
            }
        }
    }

    //Actual function
    public static void topologicalSort(ArrayList<Edge> graph[]){
        int indegree[] = new int[graph.length];
        calIndegree(graph, indegree); //calculate indegree
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){ //add all nodes having indegree 0 in queue
                q.add(i); 
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " "); //print topologically sorted one-by-one

            for(int i = 0; i < graph[curr].size(); i++){ //all neighbour
                Edge e = graph[curr].get(i);
                indegree[e.destination]--; // reduce in degree of neighbour

                if(indegree[e.destination] == 0){
                    q.add(e.destination);
                }
            }

        }
    }
    
    public static void main(String[] args) {
        int vertex = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertex]; // created array of arraylist, arraylist of eddes
        createGraph(graph);
        topologicalSort(graph);
    }
}

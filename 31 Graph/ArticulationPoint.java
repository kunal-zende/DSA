import java.util.ArrayList;

public class ArticulationPoint {
    static class Edge {
        int source;
        int destination;

        public Edge(int s, int d) {
            this.source = s;
            this.destination = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
    }

    //following is tarjan's algo
    public static void dfs(ArrayList<Edge> graph[], int curr, int parent, int discoveryTime[],
        int lowestDisTime[], boolean visited[],boolean Ap[], int time){
            visited[curr] = true;
            discoveryTime[curr] = lowestDisTime[curr] = ++time;
            int children = 0;

            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                int neighbour = e.destination;

                if(parent == neighbour){
                    continue; //don't do anything
                } else if(visited[neighbour]){
                    lowestDisTime[curr] = Math.min(lowestDisTime[curr], discoveryTime[neighbour]);
                } else {
                    dfs(graph, neighbour, curr, discoveryTime, lowestDisTime, visited,Ap, time);
                    lowestDisTime[curr] = Math.min(lowestDisTime[curr],lowestDisTime[neighbour]);

                    //condition for articulation point
                    if(parent != -1 && discoveryTime[curr] <= lowestDisTime[neighbour]){
                        Ap[curr] = true;
                    }
                    children++;
                }
            }
            //after for loop
            if(parent == -1 && children > 1){
                Ap[curr] = true;
            }
        }
    public static void getArticulationPoint(ArrayList<Edge> graph[], int V){
        int discoveryTime[] = new int[V];
        int lowestDisTime[] = new int[V];
        int time = 0;
        boolean visited[] = new boolean[V];
        boolean Ap[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(graph,i,-1,discoveryTime,lowestDisTime,visited,Ap,0);
            }
        }

        //printing articulation point
        for(int i = 0 ; i < Ap.length; i++){
            if(Ap[i]){
                System.out.println("Articulation point : "+ i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getArticulationPoint(graph, V);
    }
}

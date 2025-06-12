import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlight {
     static class Edge{
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void createGraph(int flight[][],ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < flight.length; i++){
            int src = flight[i][0];
            int dest = flight[i][1];
            int weight = flight[i][2];
            Edge e = new Edge(src, dest, weight);
            
            graph[src].add(e);
        }
    }
    
    //We use this class to store vertex, cost to reach, number of stops it take
    static class Info{
        int vertex;
        int cost;
        int stop;
        public Info(int v, int c, int s){
            this.vertex = v;
            this.cost = c;
            this.stop = s;
        }
    }

    //cheapest flight
    public static int cheapestFlight(int flight[][],int n, int src, int des,int k){
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        createGraph(flight, graph); //graph is created
        int distances[] = new int[n]; //n - number of nodes
        
        for(int i = 0; i < distances.length; i++){
            if( i != src){
            distances[i] = Integer.MAX_VALUE; //assign infinity at first
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stop > k){
                break; //If it take more that required stop then break
            }
            
            for(int i = 0; i < graph[curr.vertex].size();i++){ //add all neighbour
                Edge e = graph[curr.vertex].get(i);
                int u = e.source;
                int v = e.destination;
                int wt = e.weight;

                if(curr.cost + wt < distances[v] && curr.stop <= k){
                    distances[v] = curr.cost + wt;
                    q.add(new Info(v, distances[v], curr.stop+1));        
                }
            }
        }
        if(distances[des] == Integer.MAX_VALUE){ //if we haven't reach ddestination
            return -1;
        } else{
            return distances[des];
        }
    }

    public static void main(String[] args) {
        int flight[][] = {{0,1,100}, {1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dest = 3, k = 1;
        int n= 5;
        System.out.println(cheapestFlight(flight, n, src, dest, k));
    }
}

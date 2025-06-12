import java.util.*;

public class KruskalsAlgorithm {
    static class Edge implements Comparable<Edge>{
    int source;
    int destination;
    int weight;
    public Edge(int src, int dest, int wt){
        this.source = src;
        this.destination = dest;
        this.weight = wt;
    } 
    @Override
    public int compareTo(Edge e2){
        return this.weight - e2.weight;
    }
    }

    public static void createedge(ArrayList<Edge> edge){
        edge.add(new Edge(0,1,10));
        edge.add(new Edge(0,2,15));
        edge.add(new Edge(0,3,30));
        edge.add(new Edge(1,3,40));
        edge.add(new Edge(2,3,50));
        
    }

    //for union and finding cycle
    static int vertex = 4;
    static int rank[] = new int[vertex];
    static int parent[] = new int[vertex];

    public static void init(){
        for(int i = 0; i < parent.length; i++){
            parent[i] = i; //initially all are the parent of them self
        }
    }

    public static int find(int vertex){
       if(parent[vertex] == vertex){
        return parent[vertex];
       }
       return find(parent[vertex]);
    }

    public static void union(int v1, int v2){
        int parA = find(v1);
        int parB = find(v2);

        if(rank[parA] == rank[parB]){
            parent[parB] = parA;
        } else if(rank[parA] < rank[parB]){
            parent[parA] = parB;
        } else {
            parent[parB] = parA;
        }
    } 

    public static void kruskal(ArrayList<Edge> edge, int V){
        Collections.sort(edge);
        int totalCost = 0;
        int count = 0;

        for(int i = 0; count < V-1; i++){ //V=number of nodes, number of edges = number of nodes - 1
            Edge e = edge.get(i);

            int parA = find(e.source);
            int parB = find(e.destination);
            if(parA != parB){
                union(e.source,e.destination); //connect node with lowest weight
                totalCost+= e.weight;
                count++;
            }
        }
        System.out.println("Cost : "+ totalCost);
    }

    public static void main(String args[]){
        ArrayList<Edge> edge = new ArrayList<>();
        createedge(edge);
        init();
        int V= 4;
        kruskal(edge, V);
    }
}

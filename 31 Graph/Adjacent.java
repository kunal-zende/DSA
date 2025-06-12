import java.util.*;

public class Adjacent {

    //Store info of weight
    static class Edge {
    int source;
    int destination;
    int weight;
        
    public Edge(int s, int d, int w){
        this.source = s;
        this.destination = d;
        this.weight = w;
    }
    }

    public static void main(String[] args) {
        int vertex= 5;
        ArrayList<Edge>[] graph = new ArrayList[vertex]; //created array of arraylist, arraylist of eddes

        //First assign value so null will remove in array list
        for(int i = 0; i < vertex; i++){
            graph[i] = new ArrayList<>();
        }
        //0- vertex
        graph[0].add(new Edge(0,1,5)); //from 0 -> 1 with weight 5

        //1 - vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        //2-vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        //3-vertex
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        //4-vertex
        graph[4].add(new Edge(4,2,2));


        //Now print all neighbour of vertex 2 with theire weight
        for(int i = 0; i< graph[2].size(); i++){
            System.out.println(graph[2].get(i).source +"->"+ graph[2].get(i).destination +" Weight: "+ graph[2].get(i).weight);
        }
    }
}

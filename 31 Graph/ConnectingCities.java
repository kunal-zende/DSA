import java.util.*;

public class ConnectingCities {
    static class Edge implements Comparable<Edge> { // we don't need to store source as we can get it from array
        int destination;
        int cost;

        public Edge(int d, int c) {
            this.destination = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost; // Arrange in ascending order on basis of cost
        }
    }

    public static int connectCity(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[cities.length];
        int finalCost = 0;
        pq.add(new Edge(0, 0)); //initially destination is 0

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if (!visited[curr.destination]) {
                visited[curr.destination] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.destination].length; i++) {
                    if (cities[curr.destination][i] != 0) {
                        pq.add(new Edge(i, cities[curr.destination][i]));
                    }
                }
            }
        }
        return finalCost;
    }

    public static void main(String args[]) {
        int cities[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };
        System.out.println(connectCity(cities));
    }
}

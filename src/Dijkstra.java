import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {

    static int nodesCount = 0;

    int minDistance(int[] dist, Boolean[] sptSet) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < nodesCount; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    void printSolution(int[] dist, int[] prev, int s) {
        System.out.println("시작점: " + (s + 1));
        for (int i = 0; i < nodesCount; i++) {
            if (i != s) {
                System.out.print("정점 [" + (i + 1) + "]: ");
                printPath(prev, i);
                System.out.println(", 길이: " + dist[i]);
            }
        }
    }

    void printPath(int[] prev, int i) {
        ArrayList<Integer> path = new ArrayList<>();
        while (i != -1) {
            path.add(i + 1);
            i = prev[i];
        }
        Collections.reverse(path);
        for (int j = 0; j < path.size(); j++) {
            if (j > 0) System.out.print(" - ");
            System.out.print(path.get(j));
        }
    }

    public void dijkstra(int[][] weighted_matrix, int s) {
        nodesCount = weighted_matrix.length;

        int[] dist = new int[nodesCount];
        Boolean[] sptSet = new Boolean[nodesCount];
        int[] prev = new int[nodesCount];

        for (int i = 0; i < nodesCount; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
            prev[i] = -1;
        }

        dist[s] = 0;

        for (int cnt = 0; cnt < nodesCount - 1; cnt++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < nodesCount; v++) {
                if (!sptSet[v] && weighted_matrix[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE
                        && dist[u] + weighted_matrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + weighted_matrix[u][v];
                    prev[v] = u;
                }
            }
        }

        printSolution(dist, prev, s);
    }
}

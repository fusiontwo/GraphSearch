import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public void bfs(int[][] matrix, int s) {
        int nodesCount = matrix.length;

        boolean[] visited = new boolean[nodesCount];
        Queue<Integer> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int closedNode = queue.poll();
            result.add(String.valueOf(closedNode + 1));

            for (int i = 0; i < nodesCount; i++) {
                if (matrix[closedNode][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        System.out.print(String.join(" - ", result));
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public void dfs(int[][] matrix, int s) {
        int nodesCount = matrix.length;
        boolean[] visited = new boolean[nodesCount];
        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        stack.push(s);

        while (!stack.isEmpty()) {
            int closedNode = stack.pop();

            if (!visited[closedNode]) {
                visited[closedNode] = true;
                result.add(String.valueOf(closedNode + 1));

                for (int i = nodesCount - 1; i >= 0; i--) {
                    if (matrix[closedNode][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }

        System.out.println(String.join(" - ", result));
    }
}

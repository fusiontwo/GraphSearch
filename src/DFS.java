import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public void dfs(int[][] matrix, int s) {
        int nodesCount = matrix.length;
        boolean[] visited = new boolean[nodesCount];
        List<String> result = new ArrayList<>();

        // 방법 1. Stack 클래스 활용
//        Stack<Integer> stack = new Stack<>();
//
//        stack.push(s);
//
//        while (!stack.isEmpty()) {
//            int closedNode = stack.pop();
//
//            if (!visited[closedNode]) {
//                visited[closedNode] = true;
//                result.add(String.valueOf(closedNode + 1));
//
//                for (int i = nodesCount - 1; i >= 0; i--) {
//                    if (matrix[closedNode][i] == 1 && !visited[i]) {
//                        stack.push(i);
//                    }
//                }
//            }
//        }

        // 방법 2. Stack 직접 구현
        int[] stack = new int[nodesCount];
        int top = -1;  // top: stack 의 맨 위 위치를 표시함.

        stack[++top] = s;  // top 을 1 증가시키고 stack[0]에 시작 정점 s 저장

        while (top >= 0) {  // stack 이 비어있지 않을 때까지
            int closedNode = stack[top--];  // top 위치의 값을 가져오고, top 을 1 감소시킴.

            if (!visited[closedNode]) {
                visited[closedNode] = true;
                result.add(String.valueOf(closedNode + 1));

                for (int i = nodesCount - 1; i >= 0; i--) {
                    if (matrix[closedNode][i] == 1 && !visited[i]) {
                        stack[++top] = i;  // top 을 1 증가시키고, 정점 i를 추가
                    }
                }
            }
        }

        System.out.println(String.join(" - ", result));
    }
}

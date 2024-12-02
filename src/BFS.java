import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public void bfs(int[][] matrix, int s) {
        int nodesCount = matrix.length;
        boolean[] visited = new boolean[nodesCount];
        List<String> result = new ArrayList<>();

        // 방법 1. Queue 클래스 활용
//        Queue<Integer> queue = new LinkedList<>();
//
//        visited[s] = true;
//        queue.add(s);
//
//        while (!queue.isEmpty()) {
//            int closedNode = queue.poll();
//            result.add(String.valueOf(closedNode + 1));
//
//            for (int i = 0; i < nodesCount; i++) {
//                if (matrix[closedNode][i] == 1 && !visited[i]) {
//                    visited[i] = true;
//                    queue.add(i);
//                }
//            }
//        }

        // 방법 2. Queue 직접 구현
//        int[] queue = new int[nodesCount];
//        int head = 0;  // head: 큐의 값을 제거할 위치
//        int tail = -1;  // tail: 큐에 값을 추가할 위치
//
//        queue[++tail] = s;  // tail 을 1 증가시키고, 시작 정점 s를 저장
//        visited[s] = true;
//
//        while (head <= tail) {
//            int closedNode = queue[head++];  // head 위치의 값을 가져오고, head 를 1 증가시킴.
//            result.add(String.valueOf(closedNode + 1));
//
//            for (int i = 0; i < nodesCount; i++) {
//                if (matrix[closedNode][i] == 1 && !visited[i]) {
//                    visited[i] = true;
//                    queue[++tail] = i;  // tail 을 1 증가시키고, 정점 i를 저장
//                }
//            }
//        }

        // 방법 3. CustomQueue 사용
        CustomQueue queue = new CustomQueue(nodesCount);

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

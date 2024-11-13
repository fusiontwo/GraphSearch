import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("***** 그래프 탐방 및 최단거리 알고리즘 프로그램 *****");
        graph_exp("src/test1/input1.txt");
        shortest_path("src/test1/input2.txt");
    }

    public static void graph_exp(String file_path) {
        BFS bfs = new BFS();
        DFS dfs = new DFS();

        System.out.println("\n1. 그래프 탐방 수행 결과");
        List<int[][]> matrices = read_graphs_to_matrices(file_path);

        int graphIndex = 1;
        for (int[][] matrix : matrices) {
            System.out.println("\n그래프 [" + graphIndex + "]");
            System.out.print("-".repeat(30) + "\n");
            System.out.println("깊이 우선 탐색");
            dfs.dfs(matrix, 0);
            System.out.println("너비 우선 탐색");
            bfs.bfs(matrix, 0);
            System.out.print("\n" + "=".repeat(30) + "\n");
            graphIndex++;
        }
    }

    public static void shortest_path(String file_path) {
        Dijkstra dijkstra = new Dijkstra();

        System.out.println("\n2. 최단 경로 구하기 수행 결과");
        List<int[][]> matrices = read_weighted_graphs_to_matrices(file_path);

        int graphIndex = 1;
        for (int[][] weighted_matrix : matrices) {
            System.out.println("\n그래프 [" + graphIndex + "]");
            System.out.print("-".repeat(30) + "\n");
            dijkstra.dijkstra(weighted_matrix, 0);
            System.out.print("=".repeat(30) + "\n");
            graphIndex++;
        }
    }

    public static List<int[][]> read_graphs_to_matrices(String file_path) {
        List<int[][]> matrices = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(file_path));
            while (scanner.hasNextInt()) {
                int matrix_size = scanner.nextInt();
                int[][] matrix = new int[matrix_size][matrix_size];
                scanner.nextLine(); // Move to the next line

                for (int i = 0; i < matrix_size; i++) {
                    if (!scanner.hasNextLine()) break;
                    String line = scanner.nextLine().trim();
                    if (line.isEmpty()) break;

                    String[] tokens = line.split(" ");
                    for (int j = 1; j < tokens.length; j++) {
                        matrix[Integer.parseInt(tokens[0]) - 1][Integer.parseInt(tokens[j]) - 1] = 1;
                    }
                }
                matrices.add(matrix);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("입력하신 파일은 존재하지 않습니다.");
        }
        return matrices;
    }

    public static List<int[][]> read_weighted_graphs_to_matrices(String file_path) {
        List<int[][]> matrices = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(file_path));
            while (scanner.hasNextInt()) {
                int matrix_size = scanner.nextInt();
                int[][] weighted_matrix = new int[matrix_size][matrix_size];
                scanner.nextLine(); // Move to the next line

                for (int i = 0; i < matrix_size; i++) {
                    if (!scanner.hasNextLine()) break;
                    String line = scanner.nextLine().trim();
                    if (line.isEmpty()) break;

                    String[] tokens = line.split(" ");
                    for (int j = 1; j < tokens.length; j += 2) {
                        int to = Integer.parseInt(tokens[j]) - 1;
                        int weight = Integer.parseInt(tokens[j + 1]);
                        weighted_matrix[Integer.parseInt(tokens[0]) - 1][to] = weight;
                    }
                }
                matrices.add(weighted_matrix);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("입력하신 파일은 존재하지 않습니다.");
        }
        return matrices;
    }
}

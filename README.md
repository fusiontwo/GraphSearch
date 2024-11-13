# Graph Search Program with DFS, BFS, Dijkstra Algorithm

### 1. Input Files
- src/test1/input1.txt & test1/input2.txt: only one graph
- src/test2/input1.txt & test2/input2.txt: multiple graphs

### 2. Main Class
- src/Main.java
- Integrate DFS/BFS/Dijkstra Algorithm into one program

### 3. DFS/BFS/Dijkstra Class
- src/DFS.java & src/BFS.java & src/Dijkstra.java
- Each file contains a different algorithm implementation.
- All of these are utilized within the Main class.

### 4. Output Example
1. 그래프 탐방 수행 결과
그래프 [1]
----------------------------
깊이 우선 탐색
1 – 2 – 3
너비 우선 탐색
1 – 2 – 3
============================
그래프 [2]
----------------------------
깊이 우선 탐색
1 – 2
너비 우선 탐색
1 – 2
============================
그래프 [3]
----------------------------
깊이 우선 탐색
1 – 2 – 4 – 3
2024/11/11
4
너비 우선 탐색
1 – 2 – 3 – 4
============================
2. 최단 경로 구하기 수행 결과
그래프 [1]
----------------------------
시작점: 1
정점 [2]: 1 – 2, 길이: 10
정점 [3]: 1 – 4 - 3, 길이: 50
정점 [4]: 1 – 4, 길이: 30
정점 [5]: 1 – 4 – 3 - 5, 길이: 60
=========================
그래프 [2]
----------------------------
시작점: 1
정점 [2]: 1 – 2, 길이: 20
정점 [3]: 1 – 2 - 3, 길이: 40
정점 [4]: 1 – 4, 길이: 30
정점 [5]: 1 – 4 – 5, 길이: 50
정점 [6]: 1 – 4 – 6, 길이: 60
=========================

// 알고리즘 - 최단 경로 알고리즘
// 다익스트라 기본 구현


import java.util.ArrayList;

public class Main {

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dijkstra(int v, int[][] data, int start) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        int[] dist = new int[v + 1];

        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        boolean[] visited = new boolean[v + 1];

        for (int i = 0; i < v; i++) {
            int minDist = Integer.MAX_VALUE;
            int curIdx = 0;
            for (int j = 1; j < v + 1; j++) {
                if (!visited[j] && dist[j] < minDist){
                    minDist = dist[j];
                    curIdx = j;
                }
            }

            visited[curIdx] = true;

            for (int j = 0; j < graph.get(curIdx).size(); j++) { // 연결된 모든 노드 검사 , 크기만큼 반복문 돌림
                Node adjNode = graph.get(curIdx).get(j);
                if (dist[adjNode.to] > dist[curIdx] + adjNode.weight){
                    // dist에 저장된 to 값이
                    // "거쳐 가는 idx + 현재 검사하고있는 data[]의 가중치값" (다른 노드를 거쳐 가는 가중치 값)
                    // 보다 크면 업데이트
                    dist[adjNode.to] = dist[curIdx] + adjNode.weight;
                }

            }
        }

        // 출력
        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE){
                System.out.print(" INF ");
            }else {
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 2}, {1, 3, 3}, {2, 3, 4}, {2, 4, 5}, {3, 4, 6}, {5, 1, 1}};
        // 1 > 2 노드로 가는 비용 : 2 , 1 > 3 노드로 가는 비용 :  3 .....
        dijkstra(5, data, 2);
    }
}

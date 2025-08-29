/**
 * PackageName : week18.이상억.progarmmers;
 * FileName    : 배달
 * Author      : sangeok
 * Date        : 2025. 08. 27.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 27.     sangeok               Initial creation
 */

// n개의 마을로 이루어진 나라
// n 개의 마을에서 k 시간 이하로 배달이 가능한 마을에서만 줌누을 받으려 함


import java.util.*;

class Solution {

    static class Node{
        int v;
        int cost;
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    static final int max = Integer.MAX_VALUE;

    public int solution(int N, int[][] road, int K) {

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];

        for(int i = 1; i<=N; i++){
            graph[i] = new ArrayList<>();
            dist[i] = max;
        }

        for(int[] r : road){
            int node_1 = r[0];
            int node_2 = r[1];
            int node_cost = r[2];

            graph[node_1].add(new Node(node_2,node_cost));
            graph[node_2].add(new Node(node_1,node_cost));
        }


        dijkstra(1);

        int answer = 0;

        for(int i = 1; i<= N; i++){
            if(dist[i] <= K){
                answer ++;
            }
        }
        return answer;
    }
    public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int v = now.v;

            if (visited[v]) continue;
            visited[v] = true;

            for (Node next : graph[v]) {
                if (dist[next.v] > dist[v] + next.cost) {
                    dist[next.v] = dist[v] + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
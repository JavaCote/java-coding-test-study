import java.util.*;

class Solution {

    class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int solution(int n, int[][] costs) {

        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] c : costs) {
            int from = c[0];
            int to = c[1];
            int cost = c[2];

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (a, b) -> a.cost - b.cost
        );

        pq.add(new Edge(0, 0));
        int answer = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            answer += cur.cost;

            for (Edge next : graph[cur.to]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        return answer;
    }
}

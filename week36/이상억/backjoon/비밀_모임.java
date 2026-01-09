import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to;
        int cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Edge>[] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph[a].add(new Edge(b, c));
                graph[b].add(new Edge(a, c));
            }

            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] friends = new int[K];
            for (int i = 0; i < K; i++) {
                friends[i] = Integer.parseInt(st.nextToken());
            }

            int[] sum = new int[N + 1];

            for(int f : friends){
                int[] dist = dijkstra(f);
                for(int i = 1; i <= N; i++){
                    sum[i] += dist[i];
                }
            }

            int answer = 1;
            int min = sum[1];
            for(int i = 2; i <= N; i++){
                if(sum[i] < min ){
                    min = sum[i];
                    answer = i;
                }
            }

            System.out.println(answer);
        }
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue;

            for (Edge e : graph[now]) {
                int next = e.to;
                int nextCost = cost + e.cost;

                if (nextCost < dist[next]) {
                    dist[next] = nextCost;
                    pq.add(new int[]{next, nextCost});
                }
            }
        }
        return dist;
    }
}

import java.util.*;
import java.io.*;

public class Main{

    static class Edge{
        int v; // 나가는 정점
        int w; // 들어오는 정점
        int cost;

        public Edge(int v, int w, int cost){
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        graph = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Edge(a, b, c));
        }



        long[] dist = new long[N+1];

        if(!BellmanFord(N,M,1,dist)){
            System.out.println(-1);
        } else{
            for(int i = 2; i <= N; i++){
                if(dist[i] == INF){
                    System.out.println(-1);
                } else{
                    System.out.println(dist[i]);
                }
            }
        }
    }

    static ArrayList<Edge> graph;
    static final long INF = (long)1e18;

    public static boolean BellmanFord(int n, int m, int start, long[] dist) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = graph.get(j);

                if (dist[edge.v] != INF &&
                        dist[edge.w] > dist[edge.v] + edge.cost) {
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            Edge edge = graph.get(j);
            if (dist[edge.v] != INF &&
                    dist[edge.w] > dist[edge.v] + edge.cost) {
                return false; // 음수 사이클 존재
            }
        }

        return true;
    }

}
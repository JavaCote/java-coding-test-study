import java.io.*;
import java.util.*;

public class Main{

    static class Node {
        int v, cost;
        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }

    static List<List<Node>> graph;
    static int[] dist;
    static boolean[] visit;
    static int N, M;
    static int[] prev;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 도시 수
        M = Integer.parseInt(br.readLine()); // 버스 수

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        visit = new boolean[N+1];
        prev = new int[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(start);


        List<Integer> path = new ArrayList<>();
        int cur = end;
        while(true){
            path.add(cur);
            if(cur == start) break;
            cur = prev[cur];
        }

        Collections.reverse(path);

        System.out.println(dist[end]);
        System.out.println(path.size());
        for(int city : path) System.out.print(city + " ");
    }


    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visit[now.v]) continue;
            visit[now.v] = true;

            for(Node next : graph.get(now.v)){
                if(!visit[next.v] && dist[next.v] > dist[now.v] + next.cost){
                    dist[next.v] = dist[now.v] + next.cost;
                    prev[next.v] = now.v;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
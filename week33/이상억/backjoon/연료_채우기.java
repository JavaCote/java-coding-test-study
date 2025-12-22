import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dist = new int[N];
        int[] fuel = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dist[i] = Integer.parseInt(st.nextToken());
            fuel[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken()); // 마을까지 거리
        int P = Integer.parseInt(st.nextToken()); // 초기 연료

        int[][] stations = new int[N][2];
        for (int i = 0; i < N; i++) {
            stations[i][0] = dist[i];
            stations[i][1] = fuel[i];
        }
        Arrays.sort(stations, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        int answer = 0;

        // 현재 연료 P로 마을에 도착할 수 있을 때까지
        while (P < L) {

            // 현재 연료로 갈 수 있는 주유소 전부 pq에 넣기
            while (idx < N && stations[idx][0] <= P) {
                pq.add(stations[idx][1]);
                idx++;
            }

            if (pq.isEmpty()) {
                System.out.println(-1);
                return;
            }

            P += pq.poll();
            answer++;
        }

        System.out.println(answer);
    }
}

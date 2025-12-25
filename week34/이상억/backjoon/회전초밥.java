import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초밥 종류 ,  해당 초밥을 원하는 손님들 (번호 작은 순)
        Map<Integer, PriorityQueue<Integer>> want = new HashMap<>();

        // 각 손님이 먹은 초밥 개수
        int[] answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                int sushi = Integer.parseInt(st.nextToken());

                if (!want.containsKey(sushi)) {
                    want.put(sushi, new PriorityQueue<>());
                }
                want.get(sushi).add(i);
            }
        }

        // 만들어지는 초밥 처리
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int sushi = Integer.parseInt(st.nextToken());

            if (want.containsKey(sushi)) {
                PriorityQueue<Integer> pq = want.get(sushi);

                if (!pq.isEmpty()) {
                    int who = pq.poll(); // 가장 앞 손님이 먹음
                    answer[who]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

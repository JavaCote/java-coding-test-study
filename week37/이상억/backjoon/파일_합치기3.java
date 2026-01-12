import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            PriorityQueue<Long> pq = new PriorityQueue<>();

            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0;

            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();

                long part = a + b;
                sum += part;
                pq.offer(part);
            }

            System.out.println(sum);
        }
    }
}

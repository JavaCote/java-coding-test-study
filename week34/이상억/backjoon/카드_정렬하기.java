import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            pq.add(x);
        }

        int sum = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int part_sum = a + b;

            sum += part_sum;
            pq.add(part_sum);
        }

        System.out.print(sum);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> tasks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            tasks.add(new int[]{T, S, i + 1}); // 시간 , 벌금 , 순서
        }

        tasks.sort((a, b) -> {
            long comp = (long)b[1] * a[0] - (long)a[1] * b[0]; //
            if (comp != 0) return comp > 0 ? 1 : -1;
            return a[2] - b[2];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] task : tasks) {
            sb.append(task[2]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

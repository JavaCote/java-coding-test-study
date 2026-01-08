import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] sleep = new boolean[N + 3];   // 졸고 있는 학생
        boolean[] attend = new boolean[N + 3];  // 출석한 학생

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sleep[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (sleep[x]) continue; // 졸고 있으면 전파 X

            for (int j = x; j <= N + 2; j += x) {
                if (!sleep[j]) {
                    attend[j] = true;
                }
            }
        }

        int[] prefix = new int[N + 3];
        for (int i = 3; i <= N + 2; i++) {
            prefix[i] = prefix[i - 1] + (attend[i] ? 0 : 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(prefix[E] - prefix[S - 1]).append('\n');
        }

        System.out.print(sb);
    }
}

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] S, B;
    static int answer = Integer.MAX_VALUE;

    static void dfs(int idx, long sour, long bitter, boolean used) {
        if (idx == N) {
            if (used) {
                answer = Math.min(answer, (int)Math.abs(sour - bitter));
            }
            return;
        }

        // 현재 재료 사용
        dfs(idx + 1,
                sour * S[idx],
                bitter + B[idx],
                true);

        // 현재 재료 사용 안 함
        dfs(idx + 1,
                sour,
                bitter,
                used);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, false);
        System.out.println(answer);
    }
}

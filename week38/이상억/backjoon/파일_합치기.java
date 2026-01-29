import java.util.*;
import java.io.*;

public class Main {
    static final long INF = (long)1e18;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            int[] files = new int[K+1];
            long[] prefix = new long[K+1];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                prefix[i] = prefix[i-1] + files[i];
            }

            long[][] dp = new long[K+1][K+1];

            for (int len = 2; len <= K; len++) {
                for (int i = 1; i + len - 1 <= K; i++) {
                    int j = i + len - 1;
                    dp[i][j] = INF;

                    for (int k = i; k < j; k++) {
                        long cost = dp[i][k] + dp[k+1][j]
                                + (prefix[j] - prefix[i-1]);
                        dp[i][j] = Math.min(dp[i][j], cost);
                    }
                }
            }

            System.out.println(dp[1][K]);
        }
    }
}

// 최대 k 무게 만큼 넣을 수 있음
// N 개의 물건을 가지고 있는데 무게 : W , 가치 V를 가짐


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물건 개수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        int[] W = new int[N+1]; // 무게
        int[] V = new int[N+1]; // 가치

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1]; // dp[i][j] = i번째 물건까지 고려했을 때 무게 j 이하로 담을 수 있는 최대 가치

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j < W[i]) {
                    dp[i][j] = dp[i-1][j]; // 현재 물건을 담을 수 없음
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], V[i] + dp[i-1][j - W[i]]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}

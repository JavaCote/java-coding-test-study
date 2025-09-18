/**
 * PackageName : week21.이상억.backjoon;
 * FileName    : 자두나무
 * Author      : sangeok
 * Date        : 2025. 09. 17.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 17.     sangeok               Initial creation
 */


// 매 초마다 두 개의 나무중 하나의 나무에서 열매가 떨어짐
// 자두 1 <= t <= 1000 시간 동안 떨어짐
// 최대 1 <= w <= 30 만큼만 움직이고 싶음

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] drops = new int[t + 1];
        for (int i = 1; i <= t; i++) {
            drops[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[t + 1][w + 1];

        for (int i = 1; i <= t; i++) {
            for (int j = 0; j <= w; j++) {
                int pos = (j % 2 == 0) ? 1 : 2; // 현재 위치

                // 이전 값 기본 복사 (못 잡았다고 가정)
                dp[i][j] = dp[i - 1][j];

                // 현재 위치에 자두가 떨어지면 +1
                if (drops[i] == pos) {
                    dp[i][j] = dp[i - 1][j] + 1;
                }

                // 이전에 이동한 경우도 고려
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + (drops[i] == pos ? 1 : 0));
                }
            }
        }

        int answer = 0;
        for (int j = 0; j <= w; j++) {
            answer = Math.max(answer, dp[t][j]);
        }

        System.out.println(answer);
    }
}

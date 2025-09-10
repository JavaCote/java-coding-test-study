/**
 * PackageName : week20.이상억.backjoon;
 * FileName    : 카드_구매하기
 * Author      : sangeok
 * Date        : 2025. 09. 10.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 10.     sangeok               Initial creation
 */

// ps 카드
// 전설, 레드, 오렌지, 퍼플, 블루, 청록, 그린, 그레이
// 1~n 개가 포함된


import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] p = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[0] = 0;

        // DP 계산
        for (int k = 1; k <= N; k++) {
            int i = 1;
            while (i <= k) {
                dp[k] = Math.max(dp[k], dp[k - i] + p[i]);
                i++;
            }
        }

        System.out.println(dp[N]);
    }
}

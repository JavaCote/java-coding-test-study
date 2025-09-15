/**
 * PackageName : week20.이상억.backjoon;
 * FileName    : 1,2,3_더하기
 * Author      : sangeok
 * Date        : 2025. 09. 10.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 10.     sangeok               Initial creation
 */

// 1 -> 1
// 2 -> 2
// 3 -> 4
// 4 -> 7
// 5 - > 13
// 11111 1112 1121 1211 2111
// 113 131 311
// 221 212 122
// 32 23
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[12]; // n 최대값이 11
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}

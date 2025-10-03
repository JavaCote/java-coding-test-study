package week23.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * PackageName : week23.강성욱.baekjoon
 * FileName    : 가장_긴_증가하는_부분_수열_4
 * Author      : Baekgwa
 * Date        : 2025-10-03
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-10-03     Baekgwa               Initial creation
 */
public class 가장_긴_증가하는_부분_수열_4 {
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];
			int[] dp = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}

			int maxLength = 0;
			for (int len : dp) {
				if (len > maxLength) {
					maxLength = len;
				}
			}
			System.out.println(maxLength);

			Stack<Integer> stack = new Stack<>();
			int currentLength = maxLength;
			for (int i = n - 1; i >= 0; i--) {
				if (dp[i] == currentLength) {
					stack.push(arr[i]);
					currentLength--;
				}
			}

			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
			System.out.println(sb.toString().trim());
		}
	}
}

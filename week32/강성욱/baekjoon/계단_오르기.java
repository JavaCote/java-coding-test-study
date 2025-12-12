package week32.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PackageName : week32.강성욱.baekjoon
 * FileName    : 계단_오르기
 * Author      : Baekgwa
 * Date        : 25. 12. 12.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 12.     Baekgwa               Initial creation
 */
public class 계단_오르기 {
	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int count = Integer.parseInt(br.readLine());
			int[] score = new int[count + 1];

			for (int i = 1; i <= count; i++) {
				score[i] = Integer.parseInt(br.readLine());
			}

			int[] dp = new int[count + 1];
			dp[1] = score[1];

			if (count >= 2) {
				dp[2] = score[1] + score[2];
			}

			for (int i = 3; i <= count; i++) {
				dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
			}

			System.out.println(dp[count]);
		}
	}
}

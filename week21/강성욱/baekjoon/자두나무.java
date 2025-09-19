package week21.강성욱.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * PackageName : week21.강성욱.baekjoon
 * FileName    : 자두나무
 * Author      : Baekgwa
 * Date        : 2025-09-19
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-19     Baekgwa               Initial creation
 */
public class 자두나무 {
	public class Main {

		static int T, W;
		static int[] fruits;
		static int[][][] memo;

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			T = sc.nextInt();
			W = sc.nextInt();
			fruits = new int[T + 1];

			for (int t = 1; t <= T; t++) {
				fruits[t] = sc.nextInt();
			}

			memo = new int[T+1][W+1][2];
			for (int[][] mat : memo) {
				for(int[] row : mat) {
					Arrays.fill(row, -1);
				}
			}

			int result = Math.max(solve(1, 0, 0), solve(1, 1, 1));
			System.out.println(result);
		}

		static int solve(int t, int w, int p) {
			if (t > T || w > W) return 0;
			if (memo[t][w][p] != -1) return memo[t][w][p];

			int currentScore = (fruits[t] == p+1) ? 1 : 0;

			int stay = solve(t+1, w, p);
			int move = solve(t+1, w+1, 1-p);

			memo[t][w][p] = currentScore + Math.max(stay, move);
			return memo[t][w][p];
		}
	}
}

package week19.강성욱.programmers;

import java.util.Arrays;

/**
 * PackageName : week19.강성욱.programmers
 * FileName    : 소수_만들기
 * Author      : Baekgwa
 * Date        : 2025-09-05
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-05     Baekgwa               Initial creation
 */
public class 소수_만들기 {
	class Solution {
		private boolean[] prime = new boolean[3001]; //3가지 더했을때 최대, 1000+999+998 이니깐, 뭐 해봤짜 3000 까지 구해두면 될듯?
		public int solution(int[] nums) {
			makePrime();
			return dfs(nums, 0, 0, 0);
		}

		private int dfs(int[] nums, int nowIdx, int picked, int nowSum) {
			if (picked == 3) {
				return isPrime(nowSum) ? 1 : 0;
			}
			int cnt = 0;
			for (int i = nowIdx; i < nums.length; i++) {
				cnt += dfs(nums, i + 1, picked + 1, nowSum + nums[i]);
			}
			return cnt;
		}


		private void makePrime() {
			Arrays.fill(prime, true);
			prime[0] = prime[1] = false;

			for (int p = 2; p * p <= 3000; p++) {
				if (prime[p]) {
					for (int m = p * p; m <= 3000; m += p) {
						prime[m] = false;
					}
				}
			}
		}

		private boolean isPrime(int num) {
			return prime[num];
		}
	}
}

package week4.김상진.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week4.김상진.programmers
 * FileName    : 소수_찾기
 * Author      : sangxxjin
 * Date        : 2025. 5. 22.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 22.     sangxxjin               Initial creation
 */
public class 소수_찾기 {
	// 아예 감이 안왔음. 생각하다가 모든 경우의 수를 계산하는 건 아닐 것 같아서 구글링 진행
	// dfs쪽 이해하는데 시간이 조금 걸렸음 백트래킹도 같이 있어서 그런듯
	import java.util.*;
	public class Solution {
		Set<Integer> numberSet = new HashSet<>();
		public int solution(String numbers) {
			boolean[] visited = new boolean[numbers.length()];
			dfs("", numbers, visited);
			int count = 0;
			for (int num : numberSet) {
				if (isPrime(num)) count++;
			}
			return count;
		}

		private void dfs(String current, String numbers, boolean[] visited) {
			if (!current.isEmpty()) {
				numberSet.add(Integer.parseInt(current));
			}
			for (int i = 0; i < numbers.length(); i++) {
				if (!visited[i]) {
					// 현재 자리 사용 표시 (방문 처리)
					visited[i] = true;
					// current에 해당 숫자를 붙여서 다음 자리로 재귀 탐색
					// 예: current = "1", numbers.charAt(i) = '7' → dfs("17", ...)
					dfs(current + numbers.charAt(i), numbers, visited);
					// 백트래킹: 사용했던 자리 원상복구
					// (다음 반복에서 이 자리를 다른 조합에 다시 쓰기 위함)
					visited[i] = false;
				}
			}
		}

		private boolean isPrime(int num) {
			if (num < 2) return false;
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) return false;
			}
			return true;
		}
	}

}

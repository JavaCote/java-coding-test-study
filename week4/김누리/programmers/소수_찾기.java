package week4.김누리.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week4.김누리.programmers
 * FileName    : 소수_찾기
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-19
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 19.     김누리(NRKim)               Initial creation
 */

/*
*
* 생각보다 어려운 문제였음.
* numbers = {1,2} 방식으로 오길래, 간단히 큐를 이용해서 넣고 빼고 하면서 하면 될 줄 알았으나 아님.
* 검색 결과 dfs 를 통해 진행 해야함을 파악, 단순 Queue 및 Stack 만으로는 진행 불가
*
*/

public class 소수_찾기 {
	Set<Integer> result = new HashSet<>();
	String[] arr;

	//  main 파트
	public int solution(String numbers) {
		int answer = 0;
		arr = numbers.split("");
		boolean[] visited = new boolean[arr.length];

		//  방문 여부용 함수 재귀
		dfs("",visited);

		for(int num : result) {
			//  Hash <String> result에 적재 된 사이즈 만큼 반복하여 isPrime함수 호출
			if (isPrime(num)) answer++;
		}

		return answer;
	}

	//  예 : {1,7}로 입력 되었을 때, 방문여부 체크용 dfs
	void dfs(String current, boolean[] visited) {
		//  current 문자열이 NULL 및 ""의 경우 문자 추가
		if(!current.isEmpty()) {
			result.add(Integer.parseInt(current));
		}

		//  arr의 길이만큼 반복을 진행하며, 방문 여부 체크
		for(int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(current + arr[i],visited);
				visited[i] = false;
			}
		}
	}

	boolean isPrime(int n) {
		//  n == 1인 경우 소수가 아니므로 false
		if (n < 2) return false;

		//  2부터 n의 루트값 만큼 반복, 루트값(sqrt) 까지 반복하는 이유, 소수는 1과 자신으로만 나눠짐
		//  그러나 예를들어 n이 36인 경우 (1*36) /(2*18) /(3*12) /(4*9) /(6*6) /(9*4) /(12*3) /(18*) /(36*31)
		//  이렇게 총 9건 정도 나옴 만약 이 케이스를 다 검사하게 되면? 최대 건수인 1만이 들어오면 터지기 때문에
		//  n의 제곱근 만큼만 진행
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}

		return true;
	}
}

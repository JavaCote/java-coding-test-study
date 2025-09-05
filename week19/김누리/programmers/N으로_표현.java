package week19.김누리.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week19.김누리.programmers
 * FileName    : N으로_표현
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-01
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 01.     김누리(NRKim)               Initial creation
 */

/*

n의 값을 선택한 갯수 만큼 계속++ 해가며 식을 구현해야 한다...

Set<Integer>[] dp = new HashSet[9]; //  NN N+N N*N N-N N/N으로 구성할 수 있는 중복 값을 배제하기 위함

//
for(int i = 0 ; i < 9; i++) {
    dp 초기화
}

for(int i = 1; i <= 9; i++) {
    계산 로직
}

*/

public class N으로_표현 {
	public int solution(int N, int number) {
		//  1 <= N <= 9
		Set<Integer>[] dp = new HashSet[9];

		for(int i = 0; i < 9; i++) dp[i] = new HashSet<>();

		for(int i = 1; i < 9; i++) {
			String str = "";
			for(int j = 0; j < i; j++) {
				str += N; //  숫자 이어붙이기
			}

			dp[i].add(Integer.parseInt(str));

			//  사칙 연산
			for(int j = 1; j < i; j++) {
				for(int op1 : dp[j]) {
					for(int op2 : dp[i-j]) {
						dp[i].add(op1 + op2);
						dp[i].add(op1 - op2);
						dp[i].add(op1 * op2);
						if(op2 != 0 ) dp[i].add(op1 / op2);
					}
				}
			}

			if(dp[i].contains(number)) return i;
		}

		return -1;
	}
}

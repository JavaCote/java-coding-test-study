package week18.김누리.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week18.김누리.programmers
 * FileName    : 줄_서는_방법
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-26
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 26.     김누리(NRKim)               Initial creation
 */

/*

중고등학생 때, n!( 팩토리얼, 수열 공식 ) 구현하는 문제.

1 ~ n 까지 인원을 나열 하는 방법을 수열 방식으로 정렬 하는게 핵심

*/

public class 줄_서는_방법 {
	public int[] solution(int n, long k) {
		int[] answer = new int [n];

		//  1 ~ n 까지 리스트화
		List<Integer> list = new ArrayList<>(n);
		for(int i = 1; i <= n; i++) list.add(i);

		long[] fact = new long[n + 1];
		fact[0] = 1;

		//  순열 (n!) 계산
		for(int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i;

		k--; //  idx 맞추기


		for(int i = 0; i < n; i++) {
			long block = fact[n - 1 - i];
			int idx = (int)(k/block);
			answer[i] = list.get(idx);
			list.remove(idx);
			k %= block;
		}

		return answer;
	}
}

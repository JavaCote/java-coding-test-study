package week6.김누리.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * PackageName : week6.김누리.programmers
 * FileName    : 요격_시스템
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-03
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 03.     김누리(NRKim)               Initial creation
 */


/*

1,4
3,7
4,5
4,8
5,12
10,14
11,13

1 > {1,4} 범위 가드
4~5 사이 > {3,7}, {4,5}, {4,8} > 범위 가드
11~12 사이 > {5,12}, {10,14}, {11,13} > 범위 가드

x1, x2의 좌표를 기준으로 미사일의 위치를 측정해가며 answer ++

*/
public class 요격_시스템 {
	public int solution(int[][] targets) {
		int answer = 0;
		int last = -1; //  미사일 위치

		//  x1, x2 중 x2 좌표 기준으로 2차원 배열 정렬
		Arrays.sort(targets, Comparator.comparing(o -> o[1]));

		for(int[] target : targets) {
			//  x1 좌표, x2 좌표 추출
			int x1 = target[0];
			int x2 = target[1];

			if( last <= x1 ) {
				answer++;
				last = x2;
			}
		}

		return answer;
	}
}

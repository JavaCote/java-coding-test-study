package week14.김누리.programmers;

import java.util.Arrays;

/**
 * PackageName : week14.김누리.programmers
 * FileName    : 테이블_해시_함수
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-27
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 27.     김누리(NRKim)               Initial creation
 */


/*
col = 기본키
row_begin = 행의 시작값
row_end = 행의 끝값

col = 2
row_begin = 2
row_end = 3

data = [[2,2,6],[1,5,10],[4,2,9],[3,8,3]]

col = 2 를 기준으로 asc , order by row_begin asc, col desc
[2,2,6] 이랑 [4,2,9] ==> row_begin은 동일, 그러나 col이 [4,2,9]가 우선순위이기 때문에

정렬하면
[[4,2,9],[2,2,6],[1,5,10],[3,8,3]]

S_i (여기서 i : row_begin or row_end)


*/


public class 테이블_해시_함수 {
	public int solution(int[][] data, int col, int row_begin, int row_end) {
		int answer = 0;

		//  row_begin 기준 asc, col 기준으로는 desc
		Arrays.sort(data, (a,b) ->{
			if(a[col - 1] == b[col - 1]) return b[0] - a[0];

			return a[col - 1] - b[col - 1];
		});

		//  row_begin ~ row_end 까지 반복
		for(int i = row_begin; i <= row_end; i++) {

			//  array의 idx는 0에서 부터
			int[] r = data[i-1];

			//  S_i
			int s_i = 0;

			for(int a : r) {

				//  (2 mod 2) + (2 mod 2) + (6 mod 2) 처리
				s_i += a % i;
			}

			//  XOR 연산
			answer ^= s_i;
		}

		return answer;
	}
}

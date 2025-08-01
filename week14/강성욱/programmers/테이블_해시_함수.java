package week14.강성욱.programmers;

import java.util.Arrays;

/**
 * PackageName : week14.강성욱.programmers
 * FileName    : 테이블_해시_함수
 * Author      : Baekgwa
 * Date        : 2025-07-28
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-28     Baekgwa               Initial creation
 */
public class 테이블_해시_함수 {

	class Solution {
		public int solution(int[][] data, int col, int row_begin, int row_end) {

			//col 값 기준으로 data 정렬하기
			Arrays.sort(data, (a, b) -> {
				//같으면 키 기준 내림차순
				//그리고 col-1 이 인덱스임
				if(a[col-1] == b[col-1]) {
					return Integer.compare(b[0], a[0]);
				}
				//다르면 col-1 인덱스값 기준 오름차순
				return Integer.compare(a[col-1], b[col-1]);
			});

			//row_begin 부터 S_i 연산해서 누적
			//아 row 값도 -1 처리해야되네
			int result = 0;
			for(int i = row_begin; i <= row_end; i++) {
				int sIResult = 0;
				for(int now : data[i-1]) {
					sIResult += now % i;
				}
				result ^= sIResult;
			}

			return result;
		}
	}
}

package week8.김누리.programmers;

/**
 * PackageName : week8.김누리.programmers
 * FileName    : 땅따먹기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-17
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 17.     김누리(NRKim)               Initial creation
 */

/*
    n = land.length
    m = land[0].length

    before
    1 2 3 5
    5 6 7 8
    4 3 2 1

    after
  1  2  3  5 ==> land[0][j]의 max값
  10 11 12 X ==> (land[0][j] + land[1][j]의 max값) == > 12
  16 15 X 13 ==> (land[0][j] + land[2][j]의 max값) == > 16

으로 해야함

정답 보고 풀이함. dp 알고리즘에 대한 이해 필요
*/

public class 땅따먹기 {
	int solution(int[][] land) {
		int answer = 0;
		int n = land.length; // 열

		for(int i = 1; i < n; i++) {
			//  각 행과 열에서 이전 행의 다른 열 중 최대값을 더해 dp 결과값 구성
			land[i][0] += Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
			land[i][1] += Math.max(land[i-1][0],Math.max(land[i-1][2],land[i-1][3]));
			land[i][2] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][3]));
			land[i][3] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][2]));
		}

		for(int i = 0; i < 4; i++) {
			//  answer 값과 dp 결과값을 비교하며 최종값 정리
			answer = Math.max(answer,land[land.length-1][i]);
		}

		return answer;
	}
}

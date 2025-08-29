package week18.김누리.programmers;

/**
 * PackageName : week18.김누리.programmers
 * FileName    : 완전범죄
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-28
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 28.     김누리(NRKim)               Initial creation
 */

/*

n = A 도둑의 흔적 갯수
m = B 도둑의 흔적 갯수

case 1 :

info = [
    [1,2], >> 1번째 보물 >> A 도둑 흔적 1, B 도둑 흔적 2
    [2,3], >> 2번째 보물 >> A 도둑 흔적 2, B 도둑 흔적 3
    [2,1]  >> 3번째 보물 >> A 도둑 흔적 2, B 도둑 흔적 1
]

n = 4
m = 4

A도둑이 남긴 흔적의 누적 갯수의 최소값을 리턴

그러면... 결국 A 도둑이 가능한 적은 수를 훔쳐야 하니 dp 방식을 쓰면 될 거 같은데..

*/


public class 완전범죄 {
	public int solution(int[][] info, int n, int m) {
		int maxA = 0, maxB = 0;
		boolean[][] dp = new boolean[n][m];
		dp[0][0] = true;

		for(int[] i : info) {
			int addA = i[0], addB = i[1];
			boolean[][] next = new boolean[n][m];

			//  도둑질 작업 개시
			for(int a = 0; a < n; a++) {
				for(int b = 0; b < m; b++) {
					if(!dp[a][b]) continue;  //  0,0은 스킵

					int na = a + addA, nb = b; //  A가 훔칠 경우

					if(na < n) next[na][nb] = true; // a가 훔친 흔적이 n보다 작으면 a가 훔치기

					na = a; // a 초기화
					nb = b + addB; //  b가 훔침

					if(nb < m) next[na][nb] = true;
				}
			}

			dp = next; // dp 배열 최신화
		}

		//  dp 배열 순회하며 a의 최소값 반환
		for(int a = 0; a < n; a++) {
			for(int b = 0; b < m; b++) {
				if (dp[a][b]) return a;
			}
		}

		return -1;
	}
}

package week14.김누리.programmers;

/**
 * PackageName : week14.김누리.programmers
 * FileName    : 삼각_달팽이
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-29
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 29.     김누리(NRKim)               Initial creation
 */


/*

n = 4이라 가정

1.  아래로 내려가면서 1에서 부터 ++  (4까지 내려감)
2.  바닥을 찍으면 오른쪽으로 1.에서 만든 숫자를 ++ (4 ~ 7)
3.  맨 우측 갔으면 다시 위로

*/

public class 삼각_달팽이 {
	public int[] solution(int n) {
		int[] answer = new int [((n*(n+1))/2)];
		int[][] arr = new int [n][n]; // 삼각형 저장 배열

		int num = 1; // 시작 숫자
		int r = -1, c = 0; // 시작 위치
		int size = n; // 남은 위치

		while (size > 0) {
			//  아래로 이동
			for(int i = 0; i < size; i++) {
				r++;
				arr[r][c] = num++;
			}

			//  이동 후 남은 위치 조정
			size--;

			if(size == 0) break;

			//  오른쪽
			for(int i = 0; i < size; i++) {
				c++;
				arr[r][c] = num++;
			}

			size--;

			if(size == 0) break;

			// 대각선 위로
			for(int i = 0; i < size; i++) {
				r--;
				c--;
				arr[r][c] = num++;
			}

			size--;
		}

		int idx = 0;

		for(int[] a : arr) {
			for(int b : a) {
				if(b != 0) answer[idx++] = b;
			}
		}

		return answer;
	}
}

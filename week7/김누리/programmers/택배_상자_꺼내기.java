package week7.김누리.programmers;

/**
 * PackageName : week7.김누리.programmers
 * FileName    : 택배_상자_꺼내기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-10
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 10.     김누리(NRKim)               Initial creation
 */

/*
n = 총 택배 상자 수
w = 가로로 쌓일 택배 상자 수
num = 타겟 박스 상자


1.  박스 쌓기
1 ~ w 까지는 오른쪽
w+1 ~ 2w 까지는 왼쪽
2w+1 ~ 3w는 다시 오른쪽
3w+1 ~ n 까지 왼쪽

2.  num 의 위치 파악 후, num이 위치한 행의 위에 있는 택배 상자 갯수들 cnt

case 1 :
n = 22 / w = 6 / num = 08
      22 21 20 19
13 14 15 16 17 18
12 11 10 09 08 07
01 02 03 04 05 06

1 ~ 22 까지 반복을 하되, 이 때, 순번을 잘 잡아야됨

*/

public class 택배_상자_꺼내기 {
	public int solution(int n, int w, int num) {
		int answer = 0;
		int box = 1; //  박스 번호 1 ~ w 까지

		//  박스 쌓을 배열
		//  행을 n+w-1로 잡은 이유 :n/w으로 했을때 딱 떨어지지 않을 가능성이 있음
		int[][] tmp = new int[(n+w-1)/w][w];

		//  택배 상자 쌓아 올림
		for (int i = 0; i < tmp.length;i++) {
			// 왼 >> 오 로직
			if(i % 2 == 0) {
				for(int j = 0; j < w && box <= n; j++ ) {
					tmp[i][j] = box++;
				}
			} else {
				//  오 >> 왼 로직
				for (int j = w-1; j >=0 && box <= n; j--) {
					tmp[i][j] = box++;
				}
			}
		}

		int targetRow = 0;
		int targetCol = 0;

		//  num의 위치 추적
		for(int i = 0; i < tmp.length; i++) {
			for(int j = 0; j <w; j++) {

				//  대상 박스 상자의 위치를 구했다? 그러면 해당 위치의 i j를 적재
				if(tmp[i][j] == num) {
					targetRow = i;
					targetCol = j;
				}
			}
		}

		//  상자가 쌓여있는 맨 위의 row에서 대상 택배 상자가 쌓인 행 까지 상자 꺼내기
		for(int i = tmp.length -1; i >= targetRow; i--) {
			if(tmp[i][targetCol] != 0) answer++;
		}

		return answer;
	}
}

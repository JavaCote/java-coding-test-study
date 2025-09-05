package week19.김누리.programmers;

/**
 * PackageName : week19.김누리.programmers
 * FileName    : 프렌즈4블록
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-03
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 03.     김누리(NRKim)               Initial creation
 */

/*
    "CCBDE",
    "AAADE",
    "AAABF",
    "CCBBF"

    "CCBDE",
    "   DE",
    "   BF",
    "CCBBF"

answer = 6

    "   DE",
    "   DE",
    "    F",
    "    F"

answer = 14;

    "    E",
    "    E",
    "   DF",
    "   DF"


단순 반복문 돌리면서 터뜨릴수 있는지 보고

터뜨릴 수 있으면? 터뜨린 다음 위치 이동.

*/

public class 프렌즈4블록 {
	public int solution(int m, int n, String[] board) {
		int answer = 0;
		//   board 2차원 배열화
		char[][] b = new char[m][n];

		for(int i = 0; i < board.length; i++) b[i] = board[i].toCharArray();

		int del = 0; //  삭제 대상 변서

		while(true) {
			//  퍼지 위치
			boolean[][] purge = new boolean[m][n];
			int purged = 0;

			//  위에서 아래로 떨어질거니... m,n 그대로 이용하면 NG
			for(int i = 0; i < m-1; i++) {
				for(int j = 0; j < n-1; j++) {
					char c = b[i][j];
					if(c == ' ') continue; //  해당 위치가 공백이면 스킵
					if(c == b[i][j + 1] && c == b[i + 1][j] && c == b[i + 1][j + 1]) {
						//  c의 아래, 우측, 대각선이 다 일치하면 퍼지 가능
						purge[i][j] = purge[i][j+1] = purge[i+1][j] = purge[i+1][j+1] = true;

					}
				}
			}

			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(purge[i][j]) purged++;
				}
			}

			//  더이상 터뜨릴거 없음
			if (purged == 0) break;

			del += purged;

			//  터뜨린 후 중력 적용
			for(int i = 0; i < n; i++) {
				int move = m-1; //  아래에서부터 채워질 위치

				for(int j = m-1; j >= 0; j--) {
					if(!purge[j][i] && b[j][i] != ' ')  {
						b[move--][i] = b[j][i];
					}
				}

				//  이동한 만큼 빈칸으로
				while(move >= 0) b[move--][i] = ' ';
			}
		}

		answer = del;

		return answer;
	}
}

package week7_a.강성욱.programmers;

/**
 * PackageName : week7_a.강성욱.programmers
 * FileName    : 방문길이_배열
 * Author      : Baekgwa
 * Date        : 2025-06-13
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-13     Baekgwa               Initial creation
 */
public class 방문길이_배열 {
	//좌표 평면계, 이동 문제
	//본인 위치를 계속 기억하고 있어야됨.
	//동시에, 이번 길이 이동한 길인지 처음인지 확인해야됨.
	//자료구조를 뭐쓸까
	//point -> point 니깐.. 음
	//ArrayList 이중으로 쓸까? 생각이 안나네
	//그냥 4차원으로 쓰면 공간 얼마나 먹지?
	//visited[fromX][fromY][toX][toY] = 10*10*10*10 = 10000; 이게 제일 간단하네ㅋㅋ

	class Solution {
		public int solution(String dirs) {
			int nowX = 5;
			int nowY = 5;
			int result = 0;

			boolean[][][][] visited = new boolean[11][11][11][11];

			for(char dir : dirs.toCharArray()) {
				//다음 명령으로 갈 좌표 계산
				int nextX = nowX; int nextY = nowY;
				if(dir == 'U') {
					nextY += 1;
				} else if(dir == 'L') {
					nextX -= 1;
				} else if(dir == 'D') {
					nextY -= 1;
				} else if(dir == 'R') {
					nextX += 1;
				}

				if(nextX < 0 || nextY < 0 || nextX > 10 || nextY > 10) continue;

				//처음 가는 길이라면?
				//아 길이니깐? 양방향으로 체크해야됨.
				if(!visited[nowX][nowY][nextX][nextY] &&
					!visited[nextX][nextY][nowX][nowY]) result++;
				visited[nowX][nowY][nextX][nextY] = true;
				visited[nextX][nextY][nowX][nowY] = true;

				nowX = nextX;
				nowY = nextY;
			}

			return result;
		}
	}
}

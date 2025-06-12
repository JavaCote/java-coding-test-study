package week7.김상진.programmers;

/**
 * PackageName : week7.김상진.programmers
 * FileName    : 택배_상자_꺼내기
 * Author      : sangxxjin
 * Date        : 2025. 6. 9.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 9.     sangxxjin               Initial creation
 */
public class 택배_상자_꺼내기 {
	// 알고리즘 분석에 시간을 많이 소모함
	// 처음에 (length - idx) *2 +-1 까지 생각 하지만 2번쨰줄의 값, 3번째줄의 값 고려하면 이 방식은 틀림
	// 이중배열에 실제 값을 넣고 탐색하는 방안으로 구현

	public int solution(int n, int w, int num) {
		int rows = (int) Math.ceil((double) n / w); // 총 층 수
		int[][] map = new int[rows][w]; // 2차원 배열 생성

		// 1. 배열에 지그재그로 번호 채우기
		fillBoxes(map, n, w);

		// 2. num 위치 찾기
		int[] pos = findBoxPosition(map, num);
		int row = pos[0];
		int col = pos[1];

		// 3. 해당 열에서 위로 올라가며 값이 있는지 확인
		int count = 0;
		for (int i = row; i < rows; i++) {
			if (map[i][col] != 0) {
				count++;
			}
		}

		return count;
	}

	// 지그재그로 박스 채우기
	private void fillBoxes(int[][] map, int n, int w) {
		int box = 1;
		int rows = map.length;

		for (int i = 0; i < rows; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < w && box <= n; j++) {
					map[i][j] = box++;
				}
			} else {
				for (int j = w - 1; j >= 0 && box <= n; j--) {
					map[i][j] = box++;
				}
			}
		}
	}

	private int[] findBoxPosition(int[][] map, int num) {
		int rows = map.length;
		int cols = map[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == num) {
					return new int[]{i, j};
				}
			}
		}
		return new int[]{-1, -1};
	}
}

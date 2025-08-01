/**
 * PackageName : week14.이상억.progarmmers;
 * FileName    : 삼각_달팽이
 * Author      : sangeok
 * Date        : 2025. 07. 30.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 30.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n]; // 정삼각형처럼 쓸 2차원 배열
        int[] dx = {1, 0, -1}; // 아래 → 오른쪽 → 왼대각선 위
        int[] dy = {0, 1, -1};

        int x = 0, y = 0, dir = 0;
        int num = 1;
        int max = n * (n + 1) / 2;

        for (int i = 0; i < max; i++) {
            arr[x][y] = num++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 경계 조건 또는 이미 채워진 칸이면 방향 전환
            if (nx >= n || ny >= n || nx < 0 || ny < 0 || arr[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                list.add(arr[i][j]);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

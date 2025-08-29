/**
 * PackageName : week18.이상억.progarmmers;
 * FileName    : 무인도_여행
 * Author      : sangeok
 * Date        : 2025. 08. 25.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 25.     sangeok               Initial creation
 */


// 'X' : 바다 , 숫자는 무인도
// 지도의 각 칸에 적힌 숫자는 식량을 나타냄 , 상,하,좌,우로 연결되는 값 더할 수 있음

// X591X
// X1X5X
// X231X
// 1XXX1

import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    char[][] grid;
    boolean[][] visited;
    int n, m;

    public int[] solution(String[] maps) {
        m = maps.length;
        n = maps[0].length();
        grid = new char[m][n];
        visited = new boolean[m][n];

        // maps -> grid 변환
        for (int i = 0; i < m; i++) {
            grid[i] = maps[i].toCharArray();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 'X' && !visited[i][j]) {
                    int sum = bfs(i, j);
                    result.add(sum);
                }
            }
        }

        if (result.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(result);

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int sum = grid[x][y] - '0';

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int tx = cur[0];
            int ty = cur[1];

            for (int t = 0; t < 4; t++) {
                int nx = tx + dx[t];
                int ny = ty + dy[t];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] == 'X') continue;

                visited[nx][ny] = true;
                sum += grid[nx][ny] - '0';
                queue.add(new int[]{nx, ny});
            }
        }
        return sum;
    }
}
